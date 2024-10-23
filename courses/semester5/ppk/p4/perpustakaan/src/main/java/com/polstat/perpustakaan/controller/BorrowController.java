package com.polstat.perpustakaan.controller;

import com.polstat.perpustakaan.dto.BorrowDto;
import com.polstat.perpustakaan.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrowing")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @PostMapping("/borrow")
    public ResponseEntity<String> borrowBook(@RequestBody BorrowDto borrowDto) {
        borrowService.borrowBook(borrowDto);
        return ResponseEntity.ok("Book borrowed successfully");
    }

    @PostMapping("/return/{id}")
    public ResponseEntity<String> returnBook(@PathVariable Long id) {
        borrowService.returnBook(id);
        return ResponseEntity.ok("Book returned successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<BorrowDto>> getAllBorrowings() {
        return ResponseEntity.ok(borrowService.getAllBorrowings());
    }
}
