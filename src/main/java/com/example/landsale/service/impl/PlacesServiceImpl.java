package com.example.landsale.service.impl;


import com.example.landsale.builder.DtoBuilders;
import com.example.landsale.builder.EntityBuilder;
import com.example.landsale.dto.PlacesDTO;
import com.example.landsale.entit.Owner;
import com.example.landsale.entit.Places;
import com.example.landsale.repository.PlacesRepository;
import com.example.landsale.service.PlacesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlacesServiceImpl implements PlacesService {


    @Autowired
    private PlacesRepository placesRepository;

    @Autowired
    private EntityBuilder entityBuilder;

    @Autowired
    private DtoBuilders dtoBuilders;

    @Override
    public Long add(PlacesDTO placesDTO) {
        Places save = placesRepository.save(entityBuilder.buildPlaces(new Places(), placesDTO));
        return null != save ? save.getId() : null;
    }

    @Override
    public Long update(PlacesDTO placesDTO) {
        Places save = placesRepository.save(entityBuilder.buildPlaces(new Places(), placesDTO));
        return null != save ? save.getId() : null;
    }

    @Override
    public List<PlacesDTO> searchLike(String searchText, Integer count, Integer page) {
        List<PlacesDTO> placesDTOS = new ArrayList<>();

        for (Places places: placesRepository.search(searchText,count,page)) {
            placesDTOS.add(dtoBuilders.buildPlaceDTO(places));

        }

        return placesDTOS;
    }

    @Override
    public PlacesDTO get(Long id) {
        return dtoBuilders.buildPlaceDTO(placesRepository.getOne(id));
    }

    @Override
    public void delete(Long id) {

    }
}
