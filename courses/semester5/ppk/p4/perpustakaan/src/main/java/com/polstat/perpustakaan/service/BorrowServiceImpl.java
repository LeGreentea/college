package com.polstat.perpustakaan.service;

import com.polstat.perpustakaan.dto.BorrowDto;
import com.polstat.perpustakaan.entity.Borrow;
import com.polstat.perpustakaan.entity.Book;
import com.polstat.perpustakaan.entity.Member;
import com.polstat.perpustakaan.mapper.BorrowMapper;
import com.polstat.perpustakaan.repository.BorrowRepository;
import com.polstat.perpustakaan.repository.BookRepository;
import com.polstat.perpustakaan.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void borrowBook(BorrowDto borrowDto) {
        Member member = memberRepository.findById(borrowDto.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("Member tidak ditemukan"));

        Book book = bookRepository.findById(borrowDto.getBookId())
                .orElseThrow(() -> new IllegalArgumentException("Buku tidak ditemukan"));

        Borrow borrow = BorrowMapper.mapToBorrow(borrowDto, member, book);
        borrow.setBorrowDate(LocalDate.now());
        borrow.setBorrowStatus("Borrowed");
        borrowRepository.save(borrow);
    }

    @Override
    public void returnBook(Long borrowId) {
        Borrow borrow = borrowRepository.findById(borrowId).orElseThrow();
        borrow.setReturnDate(LocalDate.now());
        borrow.setBorrowStatus("Returned");

        LocalDate dueDate = borrow.getBorrowDate().plusDays(14);
        if (borrow.getReturnDate().isAfter(dueDate)) {
            borrow.setOverdueDays((int) borrow.getReturnDate().toEpochDay() - (int) dueDate.toEpochDay());
        } else {
            borrow.setOverdueDays(0);
        }

        borrowRepository.save(borrow);
    }

    @Override
    public List<BorrowDto> getAllBorrowings() {
        List<Borrow> borrowings = borrowRepository.findAll();
        return borrowings.stream()
                .map(BorrowMapper::mapToBorrowDto)
                .collect(Collectors.toList());
    }
}
