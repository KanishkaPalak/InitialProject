package com.paytm.learning.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.paytm.learning.dao.ProfileDao;
import com.paytm.learning.model.User;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private ProfileDao profileDao;
	 
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = profileDao.findByUsername(username);

        Set < GrantedAuthority > grantedAuthorities = new HashSet < > ();
        grantedAuthorities.add(new SimpleGrantedAuthority("USER"));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
            grantedAuthorities);
	}

}
