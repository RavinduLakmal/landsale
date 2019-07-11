package com.example.landsale.rest;

import com.example.landsale.dto.CustomerDTO;
import com.example.landsale.dto.OwnerDTO;
import com.example.landsale.dto.commen.ResponseDTO;
import com.example.landsale.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/landsale/owner")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @PostMapping
    public ResponseDTO addOwner(@RequestBody OwnerDTO  ownerDTO){
        Long id = null;
        String message = "";
        int status = 0;
        try {
            Long add = ownerService.add(ownerDTO);
            if (add != null) {
                id = add;
                message="Owner Is Saved";
                status = 1;
            }
        } catch (NullPointerException e) {
            message = "Owner save failed";
            status = 400;
            e.printStackTrace();
        }
        return new ResponseDTO(id,status,message);
    }

    @PutMapping
    public ResponseDTO updateOwner(@RequestBody OwnerDTO ownerDTO){
        Long id = null;
        String message = "";
        int status = 0;
        try {
            Long add = ownerService.update(ownerDTO);
            if (add != null) {
                id = add;
                message="Owner Is Updated";
                status = 1;
            }
        } catch (NullPointerException e) {
            message = "Owner update failed";
            status = 400;
            e.printStackTrace();
        }
        return new ResponseDTO(id,status,message);
    }


    @GetMapping
    public List<OwnerDTO> searchOwner(
            @RequestParam(value = "text", required = true) String text,
            @RequestParam(value = "count", required = true) Integer count,
            @RequestParam(value = "page", required = true) Integer page) {

        return ownerService.searchLike(text, count, page);

    }
    @GetMapping("/{id}")
    public OwnerDTO getOwner(@PathVariable("id") Long id) {
        return ownerService.get(id);
    }


}
