package com.paytm.learning.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.paytm.learning.dao.ProfileDao;
import com.paytm.learning.model.User;

@SpringBootApplication
@AutoConfigurationPackage
public class Application{
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	ProfileDao profileDao;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	
}
	//for once
//	@Override
//    public void run(String...args) throws Exception {
//        profileDao.save(new User("admin", bCryptPasswordEncoder.encode("admin")));
//    }
}
