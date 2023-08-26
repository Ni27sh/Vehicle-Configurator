package com.vca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vca.entity.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long>{
	Registration findByEmail(String email);


}
