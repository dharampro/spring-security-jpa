package com.techendear.app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.techendear.app.entities.User;
import com.techendear.app.entities.UserDetailsImpl;
import com.techendear.app.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = this.userRepository.findByUserName(username);
		user.orElseThrow(() -> new UsernameNotFoundException("Not Found" + username));
		return user.map(UserDetailsImpl::new).get();
	}
}
