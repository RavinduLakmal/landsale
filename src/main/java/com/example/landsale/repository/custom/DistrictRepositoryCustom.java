package com.example.landsale.repository.custom;

import com.example.landsale.entit.District;

import java.util.List;

public interface DistrictRepositoryCustom {
    List<District> search(String searchText, Integer count, Integer page);
}
