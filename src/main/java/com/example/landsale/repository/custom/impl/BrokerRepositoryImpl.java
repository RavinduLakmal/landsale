package com.example.landsale.repository.custom.impl;

import com.example.landsale.entit.Broker;
import com.example.landsale.repository.custom.BrokerRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class BrokerRepositoryImpl implements BrokerRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Broker> search(String searchText, Integer count, Integer page) {
        Query q = entityManager.createNativeQuery("select b.* from broker b " +
                " where ( b.name like :text ) ", Broker.class);

        q.setParameter("text", "%" + searchText + "%");

        q.setFirstResult(page * count);
        q.setMaxResults(count);

        return q.getResultList();

    }
}
