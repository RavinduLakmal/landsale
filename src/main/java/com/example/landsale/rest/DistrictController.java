package com.example.landsale.rest;

import com.example.landsale.dto.CustomerDTO;
import com.example.landsale.dto.DistrictDTO;
import com.example.landsale.dto.commen.ResponseDTO;
import com.example.landsale.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/landsale/district")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @PostMapping
    public ResponseDTO addDistrict(@RequestBody DistrictDTO districtDTO) {
        Long id = null;
        String message = "";
        int status = 0;
        try {
            Long add = districtService.add(districtDTO);
            if (add!= null) {
                id = add;
                message="District is added";
                status = 1;

            }

        } catch (NullPointerException e) {
            message = "User create failed";
            status = 400;
            e.printStackTrace();
        }

        return new ResponseDTO(id,status,message);
    }

    @PutMapping
    public ResponseDTO updateDistrict(@RequestBody DistrictDTO districtDTO){
        Long id = null;
        String message = "";
        int status = 0;
        try {
            Long add = districtService.update(districtDTO);
            if (add != null) {
                id = add;
                message="District is updated";
                status = 1;

            }

        } catch (NullPointerException e) {
            message = "District update failed";
            status = 400;
            e.printStackTrace();
        }

        return new ResponseDTO(id,status,message);
    }


    @GetMapping
    public List<DistrictDTO> searchDeistrict(
            @RequestParam(value = "text", required = true) String text,
            @RequestParam(value = "count", required = true) Integer count,
            @RequestParam(value = "page", required = true) Integer page) {

        return districtService.searchLike(text, count, page);

    }
    @GetMapping("/{id}")
    public DistrictDTO getDistrict(@PathVariable("id") Long id) {
        return districtService.get(id);
    }


}
