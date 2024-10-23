package com.polstat.perpustakaan.service;

import com.polstat.perpustakaan.dto.BorrowDto;

import java.util.List;

public interface BorrowService {
    void borrowBook(BorrowDto borrowDto);
    void returnBook(Long borrowId);
    List<BorrowDto> getAllBorrowings();
}
