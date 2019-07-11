package com.example.landsale.rest;


import com.example.landsale.dto.InterestDTO;
import com.example.landsale.dto.commen.ResponseDTO;
import com.example.landsale.service.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/landsale/interrest")
public class InterestController {

    @Autowired
    private InterestService interestService;

    @PostMapping
    public ResponseDTO addInterest(@RequestBody InterestDTO interestDTO) {
        Long id = null;
        String message = "";
        int status = 0;
        try {
            Long add = interestService.add(interestDTO);
            if (add != null) {
                id = add;
                message = "Interest Is added";
                status = 1;

            }

        } catch (NullPointerException e) {
            message = "Interest save failed";
            status = 400;
            e.printStackTrace();
        }

        return new ResponseDTO(id, status, message);
    }


    @PutMapping
    public ResponseDTO updateInterest(@RequestBody InterestDTO interestDTO) {
        Long id = null;
        String message = "";
        int status = 0;
        try {
            Long add = interestService.update(interestDTO);
            if (add != null) {
                id = add;
                message = "Interest Is Updated";
                status = 1;

            }

        } catch (NullPointerException e) {
            message = "Interest Update failed";
            status = 400;
            e.printStackTrace();
        }

        return new ResponseDTO(id, status, message);
    }

    @GetMapping
    public List<InterestDTO> SearchDepartment(
            @RequestParam(value = "text", required = true) String text,
            @RequestParam(value = "count", required = true) Integer count,
            @RequestParam(value = "page", required = true) Integer page) {

        return interestService.searchLike(text, count, page);

    }
    @GetMapping("/{id}")
    public InterestDTO getDepartment(@PathVariable("id") Long id) {
        return interestService.get(id);
    }


}
