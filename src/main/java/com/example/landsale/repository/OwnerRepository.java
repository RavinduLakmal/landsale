package com.example.landsale.repository;

import com.example.landsale.entit.Owner;
import com.example.landsale.repository.custom.OwnerRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner,Long> , OwnerRepositoryCustom {
}
