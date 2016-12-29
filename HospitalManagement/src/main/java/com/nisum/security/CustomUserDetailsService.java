package com.nisum.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nisum.model.User;
import com.nisum.repo.PatientRepository;
import com.nisum.repo.impl.LoginRepositoryImpl;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	PatientRepository patientRepository;

	@Autowired
	LoginRepositoryImpl loginRepo;

	@Override
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// User user = patientRepository.findByUsername(username);
		User user = loginRepo.getUserWithName(username);
		// System.out.println(user.getUsername());

		if (user == null) {
			System.out.println("User not found");
			throw new UsernameNotFoundException("Username not found");
		}
		// user.setRole("ADMIN");
		System.out.println("User : " + user);
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				getGrantedAuthorities(user));
	}

	private List<GrantedAuthority> getGrantedAuthorities(User user) {
		System.out.println("getGrantedAuthorities");
		System.out.println("role=" + user.getRole());
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
		//authorities.add(new SimpleGrantedAuthority("ROLE_"+"ADMIN"));
		System.out.print("authorities :" + authorities);
		return authorities;
		
	}

}
