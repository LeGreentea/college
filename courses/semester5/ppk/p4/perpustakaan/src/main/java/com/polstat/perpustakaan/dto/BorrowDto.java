package com.polstat.perpustakaan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BorrowDto {
    private Long id;
    private Long memberId;
    private Long bookId;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private String borrowStatus;
    private Integer overdueDays;
}
