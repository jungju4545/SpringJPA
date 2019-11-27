package com.cos.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.crud.model.User;
//JpaRepository<User, Integer> 아이디(모델)랑 타입을 넣으면 됨
//JpaRepository : CRUD를 구현해주는 클래스이다 즉 create, read, update, delete가 구현되었다.
//JpaRepository CRUD 외에도 다른 함수들이 있다.
public interface UserRepository extends JpaRepository<User, Integer>{
	User findByEmailAndPassword(String email, String password);
}
