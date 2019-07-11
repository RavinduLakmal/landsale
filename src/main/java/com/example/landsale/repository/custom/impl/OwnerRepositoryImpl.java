package com.example.landsale.repository.custom.impl;

import com.example.landsale.entit.Broker;
import com.example.landsale.entit.Owner;
import com.example.landsale.repository.custom.OwnerRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class OwnerRepositoryImpl implements OwnerRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Owner> search(String searchText, Integer count, Integer page) {
        Query q = entityManager.createNativeQuery("select b.* from owner b " +
                " where ( b.name like :text ) ", Owner.class);

        q.setParameter("text", "%" + searchText + "%");

        q.setFirstResult(page * count);
        q.setMaxResults(count);

        return q.getResultList();

    }
}
