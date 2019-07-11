package com.example.landsale.repository.custom.impl;


import com.example.landsale.entit.District;
import com.example.landsale.repository.custom.DistrictRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class DistrictRepositoryImpl implements DistrictRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<District> search(String searchText, Integer count, Integer page) {
        Query q = entityManager.createNativeQuery("select b.* from district b " +
                " where ( b.name like :text ) ", District.class);

        q.setParameter("text", "%" + searchText + "%");

        q.setFirstResult(page * count);
        q.setMaxResults(count);

        return q.getResultList();

    }
}
