package com.example.landsale.repository.custom;


import com.example.landsale.entit.User;

import java.util.List;

public interface UserCustom  {
    List<User> search(String searchText, Integer count, Integer page);
}
