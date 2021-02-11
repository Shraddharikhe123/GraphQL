package com.graphQL.graphqlPractice.handler;

import com.graphQL.graphqlPractice.service.dataFetcher.AuthorService;
import com.graphQL.graphqlPractice.service.dataFetcher.BookService;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GraphQLHandler {
    @Autowired
    BookService bookService;

    @Autowired
    AuthorService authorService;

    @Bean
    public GraphQL graphQL() throws IOException {
        SchemaParser schemaParser=new SchemaParser();
        ClassPathResource schema=  new ClassPathResource("schema.graphql");
        TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(schema.getInputStream());
        RuntimeWiring runTimeWiring = RuntimeWiring.newRuntimeWiring().
                type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("getBook", bookService.getBook()))
                .type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("getBooks", bookService.getBooks()))
                .type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("getAuthor",authorService.getAuthor()))
                .type(TypeRuntimeWiring.newTypeWiring("Book").dataFetcher("author",authorService.getAuthorByBook()))
                .type(TypeRuntimeWiring.newTypeWiring("Mutation").dataFetcher("createBook",bookService.createBook()))
                .build();
        SchemaGenerator generator=new SchemaGenerator();
        GraphQLSchema graphQLSchema = generator.makeExecutableSchema(typeDefinitionRegistry, runTimeWiring);
        return GraphQL.newGraphQL(graphQLSchema).build();

    }
}
