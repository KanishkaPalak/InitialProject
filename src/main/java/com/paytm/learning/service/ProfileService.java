package com.paytm.learning.service;

import java.util.Optional;

import com.paytm.learning.model.User;

public interface ProfileService {

	void updateProfileById(User user, Long id);

	Iterable<User> getAll();

	Iterable<User> getByJobrole(String jobrole);

	Optional<User> getById(Long id);

	void deleteProfileById(Long id);

	void addProfile(User user);
	
	User getByUsername(String username);
}
