package com.polstat.perpustakaan.service;

import com.polstat.perpustakaan.dto.MemberDto;
import com.polstat.perpustakaan.entity.Member;
import com.polstat.perpustakaan.mapper.MemberMapper;
import com.polstat.perpustakaan.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public MemberDto createMember(MemberDto memberDto) {
        Member member = memberRepository.save(MemberMapper.mapToMember(memberDto));
        return MemberMapper.mapToMemberDto(member);
    }

    @Override
    public List<MemberDto> getMembers() {
        List<Member> members = (List<Member>) memberRepository.findAll();
        return members.stream().map(MemberMapper::mapToMemberDto).collect(Collectors.toList());
    }

    @Override
    public MemberDto getMember(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new RuntimeException("Member not found"));
        return MemberMapper.mapToMemberDto(member);
    }

    @Override
    public MemberDto updateMember(MemberDto memberDto) {
        Member member = memberRepository.save(MemberMapper.mapToMember(memberDto));
        return MemberMapper.mapToMemberDto(member);
    }

    @Override
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}
