package com.project.pet.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "category")
@Entity
public class CategoryEntity {
	
	// 2차 카테까지 구현 할 것
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long cno; //카테고리 번호
	private String cateName; //이름
	private long depth; //차수
	
	@JoinColumn//fk는 자동으로 parent_cno, 셀프조인
	@ManyToOne
	private CategoryEntity parent; // 상위 카테고리
	

}
