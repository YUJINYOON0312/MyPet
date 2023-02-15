package com.project.pet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.pet.entity.MemberEntity;
import com.project.pet.entity.MemberEntityRepo;
import com.project.pet.security.MyRole;

@SpringBootTest
class MyPetApplicationTests {

	
	@Autowired
	private MemberEntityRepo repo;
	
	@Autowired
	private PasswordEncoder pe;
	
	//@Test
	void contextLoads() {
		//멤버 생성
		repo.save(MemberEntity.builder()
				.mno(8)
				.name("관리자")
				.email("admin@admin.com")
				.pass(pe.encode("1234"))
				.build()
				.addRoles(MyRole.ADMIN)
				);
	}

}
