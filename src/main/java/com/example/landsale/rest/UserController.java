package com.example.landsale.rest;


import com.example.landsale.dto.CustomerDTO;
import com.example.landsale.dto.UserDTO;
import com.example.landsale.dto.commen.ResponseDTO;
import com.example.landsale.entit.User;
import com.example.landsale.repository.UserRepository;
import com.example.landsale.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/landsale/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @PostMapping
    public ResponseDTO addUser(@RequestBody UserDTO dto) {

        System.out.println(dto+" Controller");

        Long id = null;
        String message = null;
        int status = 0;
        try {
            User user=userRepository.findByUsername(dto.getUsername());
            if(user==null){
                id = userService.add(dto);
                    message = "User created";
                    status = 200;
            }else {
                status = 408;
                message = "Username is already taken";
            }

        } catch (NullPointerException e) {
            message = "User create failed";
            status = 400;
            e.printStackTrace();
        }

        return new ResponseDTO(id, status, message);
    }


    @GetMapping
    public List<UserDTO> searchUser(
            @RequestParam(value = "text", required = true) String text,
            @RequestParam(value = "count", required = true) Integer count,
            @RequestParam(value = "page", required = true) Integer page) {

        return userService.searchLike(text, count, page);

    }
    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable("id") Long id) {
        return userService.get(id);
    }

}
