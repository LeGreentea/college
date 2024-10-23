package com.polstat.perpustakaan.repository;

import com.polstat.perpustakaan.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepository extends JpaRepository<Borrow, Long> {
    // interface kosong karena sudah ada method bawaan dari JpaRepository
}
