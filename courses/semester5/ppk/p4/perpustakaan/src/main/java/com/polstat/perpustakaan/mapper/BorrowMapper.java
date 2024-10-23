package com.polstat.perpustakaan.mapper;

import com.polstat.perpustakaan.dto.BorrowDto;
import com.polstat.perpustakaan.entity.Borrow;
import com.polstat.perpustakaan.entity.Book;
import com.polstat.perpustakaan.entity.Member;

public class BorrowMapper {

    public static Borrow mapToBorrow(BorrowDto borrowDto, Member member, Book book) {
        return Borrow.builder()
                .id(borrowDto.getId())
                .member(member) // Menyimpan member object
                .book(book) // Menyimpan book object
                .borrowDate(borrowDto.getBorrowDate())
                .returnDate(borrowDto.getReturnDate())
                .borrowStatus(borrowDto.getBorrowStatus())
                .overdueDays(borrowDto.getOverdueDays())
                .build();
    }

    public static BorrowDto mapToBorrowDto(Borrow borrow) {
        return BorrowDto.builder()
                .id(borrow.getId())
                .memberId(borrow.getMember().getId()) // Mengambil ID member
                .bookId(borrow.getBook().getId()) // Mengambil ID book
                .borrowDate(borrow.getBorrowDate())
                .returnDate(borrow.getReturnDate())
                .borrowStatus(borrow.getBorrowStatus())
                .overdueDays(borrow.getOverdueDays())
                .build();
    }
}
