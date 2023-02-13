package com.project.pet.entity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberEntityRepo extends JpaRepository<MemberEntity, Long>{

	//email 을 통해 username을 찾을것
	Optional<MemberEntity> findByEmail(String username);
}
