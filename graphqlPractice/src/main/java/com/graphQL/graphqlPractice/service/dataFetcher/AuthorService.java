package com.graphQL.graphqlPractice.service.dataFetcher;

import com.graphQL.graphqlPractice.repository.AuthorRepository;
import com.graphQL.graphqlPractice.model.Author;
import com.graphQL.graphqlPractice.model.Book;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public DataFetcher<Author> createAuthor(){
        return dataFetchingEnvironment -> {Author author=new Author();
        author.setAuthorName(dataFetchingEnvironment.getArgument("name"));
        author.setAge(dataFetchingEnvironment.getArgument("age"));
        author.setBookId(dataFetchingEnvironment.getArgument("bookId"));
        return authorRepository.save(author);};
    }
    public DataFetcher<Author> getAuthor() {
        return dataFetchingEnvironment -> {
                return authorRepository.findById(dataFetchingEnvironment.getArgument("id")).get();
        };

    }

    public DataFetcher<Author> getAuthorByBook(){
        return dataFetchingEnvironment -> {
            Book book = dataFetchingEnvironment.getSource();
            authorRepository.findAuthorByBookId_Id(book.getId());
            return authorRepository.findAuthorByBookId_Id(book.getId());
        };
    }
}
