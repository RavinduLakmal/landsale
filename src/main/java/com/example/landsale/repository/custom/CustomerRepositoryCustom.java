package com.example.landsale.repository.custom;


import com.example.landsale.entit.Customer;

import java.util.List;

public interface CustomerRepositoryCustom {
    List<Customer> search(String searchText, Integer count, Integer page);
}
