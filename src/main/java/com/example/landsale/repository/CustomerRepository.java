package com.example.landsale.repository;

import com.example.landsale.entit.Customer;
import com.example.landsale.repository.custom.CustomerRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> , CustomerRepositoryCustom {
}
