package com.example.landsale.repository.custom;

import com.example.landsale.entit.Places;

import java.util.List;

public interface PlacesRepositoryCustom {
    List<Places> search(String searchText, Integer count, Integer page);
}
