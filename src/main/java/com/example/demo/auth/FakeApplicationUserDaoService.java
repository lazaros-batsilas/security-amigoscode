package com.example.demo.auth;

import static com.example.demo.security.ApplicationUserRole.ADMIN;
import static com.example.demo.security.ApplicationUserRole.ADMIN_TRAINEE;
import static com.example.demo.security.ApplicationUserRole.STUDENT;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao {
	
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
		return getApplicationUsers().stream()
					.filter(applicationUser->applicationUser.getUsername().equals(username))
					.findFirst();
	}
	
	private List<ApplicationUser> getApplicationUsers(){
		List<ApplicationUser> applicationUsers = Lists.newArrayList(
				new ApplicationUser("annasmith",
						passwordEncoder.encode("pass"),
//						"pass",
						STUDENT.getGrantedAuthorities(),
						true,
						true,
						true,
						true),
				
				new ApplicationUser("linda",
						passwordEncoder.encode("pass"),
//						"pass",						
						ADMIN.getGrantedAuthorities(),
						true,
						true,
						true,
						true),
				
				new ApplicationUser("tom",
						passwordEncoder.encode("pass"),
//						"pass",
						ADMIN_TRAINEE.getGrantedAuthorities(),
						true,
						true,
						true,
						true)
		);
		return applicationUsers;
	}

}
