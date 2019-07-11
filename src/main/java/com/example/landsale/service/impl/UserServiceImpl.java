package com.example.landsale.service.impl;

import com.example.landsale.dto.UserDTO;
import com.example.landsale.entit.User;
import com.example.landsale.repository.UserRepository;
import com.example.landsale.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Long add(UserDTO userDTO) {
        User user=new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword( new BCryptPasswordEncoder(8).encode(userDTO.getPassword()));
        user.setName(userDTO.getName());
        user.setNumber(userDTO.getNumber());
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        user.setRoles("ROLE_ADMIN,ROLE_USER");
        this.userRepository.save(user);
        return null != user ? user.getId() : null;
    }

    @Override
    public Long update(UserDTO userDTO) {
        return null;
    }

    @Override
    public List<UserDTO> searchLike(String searchText, Integer count, Integer page) {
        return null;
    }

    @Override
    public UserDTO get(Long id) {
        UserDTO userDTO = new UserDTO();
        User one = userRepository.getOne(id);
        userDTO.setEnabled(one.isEnabled());
        userDTO.setId(one.getId());
        userDTO.setName(one.getName());
        userDTO.setNumber(one.getNumber());
        userDTO.setPassword(one.getPassword());
        userDTO.setUsername(one.getUsername());

        return userDTO;
    }

    @Override
    public void delete(Long id) {

    }
}
