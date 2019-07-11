package com.example.landsale.repository.custom;

import com.example.landsale.entit.Broker;

import java.util.List;

public interface BrokerRepositoryCustom {
    List<Broker> search(String searchText, Integer count, Integer page);

}
