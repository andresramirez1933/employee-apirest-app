package com.employeeapirest.app;

import com.employeeapirest.app.entity.Role;
import com.employeeapirest.app.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class EmployeeApiRestApplication /*implements CommandLineRunner*/ {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApiRestApplication.class, args);
	}

	@Bean
	ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private RoleRepository roleRepository;

	/*@Override
	public void run(String... args) throws Exception {

		Role adminRole = new Role();
		adminRole.setName("ROLE_ADMIN");
		roleRepository.save(adminRole);

		Role adminUser = new Role();
		adminRole.setName("ROLE_USER");
		roleRepository.save(adminUser);



	}*/
}
