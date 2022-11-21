package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Dao.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails,Long> {

	

	List<UserDetails> findAll();

	

	Optional<UserDetails> findById(long id);

	

}
