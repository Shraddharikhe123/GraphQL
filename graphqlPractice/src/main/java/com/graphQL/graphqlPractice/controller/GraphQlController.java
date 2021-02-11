package com.graphQL.graphqlPractice.controller;

import com.graphQL.graphqlPractice.model.GraphQLRequestBody;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class GraphQlController {

    @Autowired
    private  GraphQL graphQL;


    @PostMapping(value = "graphql",consumes = MediaType.APPLICATION_JSON_VALUE)
    public CompletableFuture<ExecutionResult> execute(@RequestBody GraphQLRequestBody body){
       return graphQL.executeAsync(ExecutionInput.newExecutionInput().query(body.getQuery())
                .operationName(body.getOperation()).variables(body.getVariables()).build());
    }
}
