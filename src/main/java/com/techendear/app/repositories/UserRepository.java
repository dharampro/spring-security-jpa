package com.techendear.app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techendear.app.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public Optional<User> findByUserName(String userName);
}
