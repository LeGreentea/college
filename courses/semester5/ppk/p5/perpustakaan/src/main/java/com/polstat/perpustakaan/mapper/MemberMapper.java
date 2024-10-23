package com.polstat.perpustakaan.mapper;

import com.polstat.perpustakaan.dto.MemberDto;
import com.polstat.perpustakaan.entity.Member;

public class MemberMapper {

    // Mengubah Member menjadi MemberDto
    public static MemberDto mapToMemberDto(Member member) {
        return MemberDto.builder()
                .id(member.getId())
                .memberID(member.getMemberID())
                .name(member.getName())
                .address(member.getAddress())
                .phoneNumber(member.getPhoneNumber())
                .build();
    }

    // Mengubah MemberDto menjadi Member
    public static Member mapToMember(MemberDto memberDto) {
        Member member = new Member();
        member.setId(memberDto.getId());
        member.setMemberID(memberDto.getMemberID());
        member.setName(memberDto.getName());
        member.setAddress(memberDto.getAddress());
        member.setPhoneNumber(memberDto.getPhoneNumber());
        return member;
    }
}
