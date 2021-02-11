package com.graphQL.graphqlPractice.service.dataFetcher;


import com.graphQL.graphqlPractice.constant.Category;
import com.graphQL.graphqlPractice.repository.AuthorRepository;
import com.graphQL.graphqlPractice.repository.BookRepository;
import com.graphQL.graphqlPractice.model.Author;
import com.graphQL.graphqlPractice.model.Book;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;

    public DataFetcher<Book> getBook() {
        return dataFetchingEnvironment -> {
            int bookId = dataFetchingEnvironment.getArgument("id");
            return bookRepository.findById(bookId).get();
        };
    }

    public DataFetcher<List<Book>> getBooks() {
        return dataFetchingEnvironment -> {
            return bookRepository.findAll();
        };

    }

    public DataFetcher<Author> createBook() {
        return dataFetchingEnvironment -> {
            Book book = new Book();
            book.setName(dataFetchingEnvironment.getArgument("bookName"));
            book.setPages(dataFetchingEnvironment.getArgument("pages"));
            book.setCategory(Category.valueOf(dataFetchingEnvironment.getArgument("category")));
            Author author = new Author();
            author.setAuthorName(dataFetchingEnvironment.getArgument("authorName"));
            author.setAge(dataFetchingEnvironment.getArgument("age"));
            author.setBookId(book);
            Book book1 = bookRepository.save(book);
            return authorRepository.save(author);
        };
    }


}
