package com.example.landsale.repository;

import com.example.landsale.entit.District;
import com.example.landsale.repository.custom.DistrictRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictRepository extends JpaRepository<District,Long> ,DistrictRepositoryCustom {
}
