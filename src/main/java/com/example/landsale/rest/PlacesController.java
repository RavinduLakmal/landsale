package com.example.landsale.rest;

import com.example.landsale.dto.CustomerDTO;
import com.example.landsale.dto.PlacesDTO;
import com.example.landsale.dto.commen.ResponseDTO;

import com.example.landsale.service.PlacesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/landsale/places")
public class PlacesController {

    @Autowired
    private PlacesService placesService;

    @PostMapping
    public ResponseDTO addPlaces(@RequestBody PlacesDTO placesDTO) {
        Long id = null;
        String message = null;
        int status = 0;
        try {
            Long add = placesService.add(placesDTO);
            if (add != null) {
                id = add;
                message = "Place Is added";
                message = "Place Is added";
                status = 1;

            }

        } catch (NullPointerException e) {
            message = "Place save failed";
            status = 400;
            e.printStackTrace();
        }

        return new ResponseDTO(id, status, message);
    }

    @PutMapping
    public ResponseDTO updatePlaces(@RequestBody PlacesDTO placesDTO) {
        Long id = null;
        String message = null;
        int status = 0;
        try {
            Long add = placesService.update(placesDTO);
            if (add != null) {
                id = add;

                message = "Place Is Updated";
                status = 1;

            }

        } catch (NullPointerException e) {
            message = "Place Update failed";
            status = 400;
            e.printStackTrace();
        }

        return new ResponseDTO(id, status, message);
    }


    @GetMapping
    public List<PlacesDTO> searchPlaces(
            @RequestParam(value = "text", required = true) String text,
            @RequestParam(value = "count", required = true) Integer count,
            @RequestParam(value = "page", required = true) Integer page) {

        return placesService.searchLike(text, count, page);

    }
    @GetMapping("/{id}")
    public PlacesDTO getPlaces(@PathVariable("id") Long id) {
        return placesService.get(id);
    }


}
