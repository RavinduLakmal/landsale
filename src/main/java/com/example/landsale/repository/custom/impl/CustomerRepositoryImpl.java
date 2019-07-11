package com.example.landsale.repository.custom.impl;

import com.example.landsale.entit.Broker;
import com.example.landsale.entit.Customer;
import com.example.landsale.repository.custom.CustomerRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Customer> search(String searchText, Integer count, Integer page) {
        Query q = entityManager.createNativeQuery("select b.* from customer b " +
                " where ( b.name like :text ) ", Customer.class);

        q.setParameter("text", "%" + searchText + "%");

        q.setFirstResult(page * count);
        q.setMaxResults(count);

        return q.getResultList();

    }
}
