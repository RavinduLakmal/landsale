package com.example.landsale.service.impl;

import com.example.landsale.builder.DtoBuilders;
import com.example.landsale.builder.EntityBuilder;
import com.example.landsale.dto.DistrictDTO;
import com.example.landsale.entit.District;
import com.example.landsale.repository.DistrictRepository;
import com.example.landsale.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private EntityBuilder entityBuilder;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private DtoBuilders dtoBuilders;

    @Override
    public Long add(DistrictDTO districtDTO) {

        District save = districtRepository.save(entityBuilder.buildDistrict(new District(), districtDTO));
        return null != save ? save.getId() : null;
    }

    @Override
    public Long update(DistrictDTO districtDTO) {
        District save = districtRepository.save(entityBuilder.buildDistrict(new District(), districtDTO));
        return null != save ? save.getId() : null;
    }

    @Override
    public List<DistrictDTO> searchLike(String searchText, Integer count, Integer page) {
        List<DistrictDTO> districtDTOS = new ArrayList<>();

        for (District district: districtRepository.search(searchText,count,page) ) {
            districtDTOS.add(dtoBuilders.buildDistrictDTO(district));
        }

        return districtDTOS;
    }

    @Override
    public DistrictDTO get(Long id) {
        return dtoBuilders.buildDistrictDTO(districtRepository.getOne(id));
    }

    @Override
    public void delete(Long id) {

    }
}
