package com.example.landsale.repository.custom;

import com.example.landsale.entit.Broker;
import com.example.landsale.entit.Owner;

import java.util.List;

public interface OwnerRepositoryCustom {
    List<Owner> search(String searchText, Integer count, Integer page);
}
