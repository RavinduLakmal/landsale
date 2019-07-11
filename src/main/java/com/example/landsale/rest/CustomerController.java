package com.example.landsale.rest;

import com.example.landsale.dto.CustomerDTO;
import com.example.landsale.dto.InterestDTO;
import com.example.landsale.dto.commen.ResponseDTO;
import com.example.landsale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lansale/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseDTO addCustomer(@RequestBody CustomerDTO customerDTO) {
        Long id = null;
        String message = "";
        int status = 0;
        try {
            Long add = customerService.add(customerDTO);
            if (add != null) {
                id = add;
                message = "Customer Is added";
                status = 1;

            }

        } catch (NullPointerException e) {
            message = "Customer save failed";
            status = 400;
            e.printStackTrace();
        }

        return new ResponseDTO(id, status, message);
    }


    @PutMapping
    public ResponseDTO updateCustomer(@RequestBody CustomerDTO customerDTO) {
        Long id = null;
        String message = "";
        int status = 0;
        try {
            Long add = customerService.update(customerDTO);
            if (add != null) {
                id = add;
                message = "Customer Is updated";
                status = 1;

            }

        } catch (NullPointerException e) {
            message = "Customer Updated failed";
            status = 400;
            e.printStackTrace();
        }

        return new ResponseDTO(id, status, message);
    }

    @GetMapping
    public List<CustomerDTO> searchCustomer(
            @RequestParam(value = "text", required = true) String text,
            @RequestParam(value = "count", required = true) Integer count,
            @RequestParam(value = "page", required = true) Integer page) {

        return customerService.searchLike(text, count, page);

    }
    @GetMapping("/{id}")
    public CustomerDTO getCustomer(@PathVariable("id") Long id) {
        return customerService.get(id);
    }



}
