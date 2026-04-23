package service;

import repository.MemberRepository;

public class MemberServiceImpl implements MemberService {
    private final MemberRepository repository;

    public MemberServiceImpl(MemberRepository repository) {
        this.repository = repository;
    }
}
