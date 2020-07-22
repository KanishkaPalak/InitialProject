package com.paytm.learning.dao;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paytm.learning.model.User;

public interface ProfileDao extends JpaRepository<User, Long>{

	User findByUsername(String username);
	Optional<User> findById(Long id);
	List<User> findAllOrderByJobrole(String jobrole);
	void updateById(User user, Long id);
	List<User> findAll();
	void deleteById(Long id);
	
}
