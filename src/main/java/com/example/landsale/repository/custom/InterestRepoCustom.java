package com.example.landsale.repository.custom;

import com.example.landsale.entit.Iterest;

import java.util.List;

public interface InterestRepoCustom {
    List<Iterest> search(String searchText, Integer count, Integer page);
}
