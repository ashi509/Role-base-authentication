package com.school.manage;

import com.school.manage.Entity.Users;
import com.school.manage.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ComSchoolManageApplication {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ComSchoolManageApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}

//	@PostConstruct
	public void insertUser(){
		List<Users> users=new ArrayList<>();
		users.add(new Users(0,"Ashish","ashish@gmail.com","SUPER_ADMIN", bCryptPasswordEncoder().encode("Ashish"),new Date()));
		users.add(new Users(0,"Shiv","shiv@gmail.com","ADMIN", bCryptPasswordEncoder().encode("Shiv"),new Date()));
		System.out.println(userRepository.saveAll(users));
	}
}
