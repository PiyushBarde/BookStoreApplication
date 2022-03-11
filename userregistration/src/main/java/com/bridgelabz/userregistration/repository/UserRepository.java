package com.bridgelabz.userregistration.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bridgelabz.userregistration.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(value = "SELECT * from user WHERE email= :email",nativeQuery = true)
	Optional<User> findByEmail(String email);

	@Query(value = "SELECT * from user WHERE email= :email",nativeQuery = true)
	User findByMail(String email);

}
