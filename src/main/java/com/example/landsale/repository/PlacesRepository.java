package com.example.landsale.repository;

import com.example.landsale.entit.Places;
import com.example.landsale.repository.custom.PlacesRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlacesRepository extends JpaRepository<Places,Long> , PlacesRepositoryCustom {
}
