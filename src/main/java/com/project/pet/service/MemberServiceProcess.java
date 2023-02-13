package com.project.pet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.pet.entity.MemberEntityRepo;
import com.project.pet.entity.MemberRegDTO;
import com.project.pet.security.MyRole;

@Service
public class MemberServiceProcess implements MemberService{
	
	@Autowired
	private MemberEntityRepo repo;

	@Autowired
	private PasswordEncoder pe;
	
	@Override
	public void registration(MemberRegDTO dto) {
		repo.save(dto.ent(pe).addRoles(MyRole.USER));
	}
}
