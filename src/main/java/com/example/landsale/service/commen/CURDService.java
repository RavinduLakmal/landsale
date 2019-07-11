/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.landsale.service.commen;


import java.util.List;

public interface CURDService<T> {

    public Long add(T t);

    public Long update(T t);

    public List<T> searchLike(String searchText, Integer count, Integer page);

    public T get(Long id);



    public void delete(Long id);

}
