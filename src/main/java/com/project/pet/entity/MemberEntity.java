package com.project.pet.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.project.pet.security.MyRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@SequenceGenerator(name = "seq_gen_mem", sequenceName = "seq_mem", allocationSize = 1, initialValue = 1)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Table(name = "member")
@Entity
public class MemberEntity {

	@GeneratedValue(generator = "seq_gen_mem", strategy = GenerationType.SEQUENCE)
	@Id
	private long mno;
	@Column(updatable = false)
	private String name;
	@Column(updatable = false, unique = true)
	private String email;
	@Column(updatable = false, unique = true)
	private String nickName;
	@Column(updatable = false)
	private String pass;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "my_role")
	@Builder.Default
	@Enumerated(EnumType.STRING)
	private Set<MyRole> myRoles = new HashSet<>();
	//set<>을 hashSet으로 바꿔주기
	
	//메서드를 만들어준다
	public MemberEntity addRoles(MyRole roles) {
		myRoles.add(roles); //myRoles 필드에 roles를 추가
		return this;
	}
	
	
}
