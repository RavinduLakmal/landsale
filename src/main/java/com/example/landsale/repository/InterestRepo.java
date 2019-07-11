package com.example.landsale.repository;

import com.example.landsale.entit.Iterest;
import com.example.landsale.repository.custom.InterestRepoCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestRepo extends JpaRepository<Iterest,Long> , InterestRepoCustom {
}
