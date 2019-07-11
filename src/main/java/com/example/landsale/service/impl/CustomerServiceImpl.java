package com.example.landsale.service.impl;


import com.example.landsale.builder.DtoBuilders;
import com.example.landsale.builder.EntityBuilder;
import com.example.landsale.dto.CustomerDTO;
import com.example.landsale.entit.Broker;
import com.example.landsale.entit.Customer;
import com.example.landsale.repository.CustomerRepository;
import com.example.landsale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EntityBuilder entityBuilder;

    @Autowired
    private DtoBuilders dtoBuilders;


    @Override
    public Long add(CustomerDTO customerDTO) {
        Customer save = customerRepository.save(entityBuilder.buildCustomer(new Customer(), customerDTO));
        return null != save ? save.getId() : null;
    }

    @Override
    public Long update(CustomerDTO customerDTO) {
        Customer save = customerRepository.save(entityBuilder.buildCustomer(new Customer(), customerDTO));
        return null != save ? save.getId() : null;
    }

    @Override
    public List<CustomerDTO> searchLike(String searchText, Integer count, Integer page) {
        List<CustomerDTO> customerDTOS = new ArrayList<>();

        for (Customer customer :customerRepository.search(searchText,count,page) ) {
            customerDTOS.add(dtoBuilders.buildCustomerDTO(customer));
        }

        return customerDTOS;
    }

    @Override
    public CustomerDTO get(Long id) {
        return dtoBuilders.buildCustomerDTO(customerRepository.getOne(id));
    }

    @Override
    public void delete(Long id) {

    }
}
