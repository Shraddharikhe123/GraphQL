package com.graphQL.graphqlPractice.model;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GraphQLRequestBody {
    private String query;
    private String operation;
    private Map<String,Object> variables;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Map<String, Object> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, Object> variables) {
        this.variables = variables;
    }
}
