package com.gft.show.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.show.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
	//CrudRepository<User, Long>

}
