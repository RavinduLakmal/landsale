package com.example.landsale.service.impl;

import com.example.landsale.builder.DtoBuilders;
import com.example.landsale.builder.EntityBuilder;
import com.example.landsale.dto.InterestDTO;
import com.example.landsale.entit.Customer;
import com.example.landsale.entit.Iterest;
import com.example.landsale.repository.InterestRepo;
import com.example.landsale.service.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InterestServiceImpl implements InterestService {

    @Autowired
    private InterestRepo interestRepo;

    @Autowired
    private EntityBuilder entityBuilder;

    @Autowired
    private DtoBuilders dtoBuilders;

    @Override
    public Long add(InterestDTO interestDTO) {
        Iterest save = interestRepo.save(entityBuilder.buildInterest(new Iterest(), interestDTO));
        return null != save ? save.getId() : null;
    }

    @Override
    public Long update(InterestDTO interestDTO) {
        Iterest save = interestRepo.save(entityBuilder.buildInterest(new Iterest(), interestDTO));
        return null != save ? save.getId() : null;
    }

    @Override
    public List<InterestDTO> searchLike(String searchText, Integer count, Integer page) {
        List<InterestDTO> interestDTOS = new ArrayList<>();

        for (Iterest iterest: interestRepo.search(searchText,count,page)  ) {
            interestDTOS.add(dtoBuilders.buildInterestDTO(iterest));
        }

        return interestDTOS;
    }

    @Override
    public InterestDTO get(Long id) {
        return dtoBuilders.buildInterestDTO(interestRepo.getOne(id));
    }

    @Override
    public void delete(Long id) {

    }
}
