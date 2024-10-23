package com.polstat.perpustakaan.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.polstat.perpustakaan.dto.BookDto;
import com.polstat.perpustakaan.service.BookService;
import generated.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class BookEndpoint {
    private static final Logger logger = LoggerFactory.getLogger(BookEndpoint.class);

    private static final String NAMESPACE_URI = "http://www.polstat.com/perpustakaan";

    @Autowired
    private BookService bookService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBooksRequest")
    @ResponsePayload
    public GetBooksResponse getBooks() {
        GetBooksResponse response = new GetBooksResponse();

        List<BookDto> books = bookService.getBooks();
        for (BookDto book : books) {
            Book it = new Book();
            it.setTitle(book.getTitle());
            it.setAuthor(book.getAuthor());
            it.setDescription(book.getDescription());

            response.getBooks().add(it);
        }

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addBookRequest")
    @ResponsePayload
    public AddBookResponse addBook(@RequestPayload AddBookRequest request) {
        AddBookResponse response = new AddBookResponse();
        BookDto bookDto = new BookDto(null, request.getTitle(), request.getAuthor(), request.getDescription());
        bookService.createBook(bookDto);
        response.setStatus("Book added successfully");
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "searchBooksRequest")
    @ResponsePayload
    public SearchBooksResponse searchBooks(@RequestPayload SearchBooksRequest request) {
        SearchBooksResponse response = new SearchBooksResponse();
        List<BookDto> books = bookService.searchBooks(request.getKeyword());
        for (BookDto bookDto : books) {
            response.getBooks().add(mapToBook(bookDto));
        }
        return response;
    }

    private Book mapToBook(BookDto bookDto) {
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setDescription(bookDto.getDescription());
        return book;
    }
}
