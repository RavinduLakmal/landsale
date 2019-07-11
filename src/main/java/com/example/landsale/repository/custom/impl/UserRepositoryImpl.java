package com.example.landsale.repository.custom.impl;

import com.example.landsale.entit.User;
import com.example.landsale.repository.custom.UserCustom;

import java.util.List;

public class UserRepositoryImpl implements UserCustom {
    @Override
    public List<User> search(String searchText, Integer count, Integer page) {
        return null;
    }
}
