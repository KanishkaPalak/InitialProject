package com.paytm.learning.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.paytm.learning.dao.ProfileDao;
import com.paytm.learning.model.User;
import com.paytm.learning.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService{

	@Autowired
	private ProfileDao profileDao;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void updateProfileById(User user, Long id) {
		profileDao.updateById(user, id);
	}

	@Override
	public Iterable<User> getAll() {
		return profileDao.findAll();
	}

	@Override
	public Iterable<User> getByJobrole(String jobrole) {
		return profileDao.findAllOrderByJobrole(jobrole);
	}

	@Override
	public void deleteProfileById(Long id) {
		profileDao.deleteById(id);
	}

	@Override
	public void addProfile(User user) {
		try {
			final String encryptedPassword = bCryptPasswordEncoder.encode(user.getPassword());
			user.setPassword(encryptedPassword);
			profileDao.save(user);
		}catch(DuplicateKeyException d)
		{
			System.out.println("Username already exists!");
		}
	}

	@Override
	public Optional<User> getById(Long id) {
		return profileDao.findById(id);
	}

	@Override
	public User getByUsername(String username) {
		return profileDao.findByUsername(username);
	}

}
