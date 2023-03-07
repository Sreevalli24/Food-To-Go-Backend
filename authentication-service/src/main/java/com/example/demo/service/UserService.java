package com.example.demo.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.RoleRepo;
import com.example.demo.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private RoleRepo roleRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public void initRoleAndUser() {

		Role ownerRole = new Role();
		ownerRole.setRoleName("Owner");
		ownerRole.setRoleDescription("Owner role");
		roleRepo.save(ownerRole);

		Role userRole = new Role();
		userRole.setRoleName("User");
		userRole.setRoleDescription("Default role for newly created record");
		roleRepo.save(userRole);

		User ownerUser = new User();
		ownerUser.setUserName("owner123");
		ownerUser.setEmail("owner@gmail.com");
		ownerUser.setUserPassword(getEncodedPassword("owner@pass"));	
		Set<Role> ownerRoles = new HashSet<>();
		ownerRoles.add(ownerRole);
		ownerUser.setRole(ownerRoles);
		userRepo.save(ownerUser);

//        User user = new User();
//        adminUser.setUserName("raj123");
//        adminUser.setUserPassword(getEncodedPassword("raj@123"));
//        adminUser.setUserFirstName("raj");
//        adminUser.setUserLastName("sharma");
//        Set<Role> adminRoles = new HashSet<>();
//        adminRoles.add(adminRoles);
//        adminUser.setRole(adminRoles);
//        userRepo.save(adminUser);
	}

	public User registerNewUser(User user) {
		Role role = roleRepo.findById("User").get();
		Set<Role> userRoles = new HashSet<>();
		userRoles.add(role);
		user.setRole(userRoles);
		user.setUserPassword(getEncodedPassword(user.getUserPassword()));

		return userRepo.save(user);
	}

	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}

	public Optional<User> getUserByUserName(String userName) {
		return userRepo.findByUserName(userName);
	}

	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

}
