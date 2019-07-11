package com.example.landsale.service.impl;

import com.example.landsale.builder.DtoBuilders;
import com.example.landsale.builder.EntityBuilder;
import com.example.landsale.dto.OwnerDTO;
import com.example.landsale.entit.Iterest;
import com.example.landsale.entit.Owner;
import com.example.landsale.repository.OwnerRepository;
import com.example.landsale.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private EntityBuilder entityBuilder;

    @Autowired
    private DtoBuilders dtoBuilders;

    @Override
    public Long add(OwnerDTO ownerDTO) {
        Owner save = ownerRepository.save(entityBuilder.buildOwner(new Owner(), ownerDTO));
        return null != save ? save.getId() : null;
    }

    @Override
    public Long update(OwnerDTO ownerDTO) {
        Owner save = ownerRepository.save(entityBuilder.buildOwner(new Owner(), ownerDTO));
        return null != save ? save.getId() : null;
    }

    @Override
    public List<OwnerDTO> searchLike(String searchText, Integer count, Integer page) {
        List<OwnerDTO> ownerDTOS = new ArrayList<>();

        for (Owner owner: ownerRepository.search(searchText,count,page) ) {
            ownerDTOS.add(dtoBuilders.buildOwnerDTO(owner));
        }

        return ownerDTOS;
    }

    @Override
    public OwnerDTO get(Long id) {
        return dtoBuilders.buildOwnerDTO(ownerRepository.getOne(id));
    }

    @Override
    public void delete(Long id) {

    }
}
