package com.example.landsale.repository;

import com.example.landsale.entit.Broker;
import com.example.landsale.repository.custom.BrokerRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrokerRepository extends JpaRepository<Broker,Long> , BrokerRepositoryCustom {
}
