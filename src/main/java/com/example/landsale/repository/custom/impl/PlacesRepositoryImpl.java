package com.example.landsale.repository.custom.impl;

import com.example.landsale.entit.Broker;
import com.example.landsale.entit.Places;
import com.example.landsale.repository.custom.PlacesRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class PlacesRepositoryImpl implements PlacesRepositoryCustom {


    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Places> search(String searchText, Integer count, Integer page) {
        Query q = entityManager.createNativeQuery("select b.* from places b " +
                " where ( b.name like :text ) ", Places.class);

        q.setParameter("text", "%" + searchText + "%");

        q.setFirstResult(page * count);
        q.setMaxResults(count);

        return q.getResultList();

    }
}
