package com.polstat.perpustakaan.service;
import com.polstat.perpustakaan.dto.BookDto;
import java.util.List;
public interface BookService {
    BookDto createBook(BookDto bookDto);
    List<BookDto> getBooks();
    List<BookDto> searchBooks(String keyword);
    BookDto getBook(Long id);
    BookDto updateBook(BookDto bookDto);
    void deleteBook(BookDto bookDto);
}
