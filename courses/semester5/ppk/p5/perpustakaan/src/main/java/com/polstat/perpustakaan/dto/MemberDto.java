package com.polstat.perpustakaan.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberDto {
    private Long id;
    private String memberID;
    private String name;
    private String address;
    private String phoneNumber;
}
