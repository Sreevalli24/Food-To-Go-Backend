package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

	@Query(value = "select * from user_table where user_name = ?1", nativeQuery = true)
	Optional<User> findByUserName(String userName);

}
