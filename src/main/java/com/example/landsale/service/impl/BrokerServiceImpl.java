package com.example.landsale.service.impl;


import com.example.landsale.builder.DtoBuilders;
import com.example.landsale.builder.EntityBuilder;
import com.example.landsale.dto.BrokerDTO;
import com.example.landsale.entit.Broker;
import com.example.landsale.repository.BrokerRepository;
import com.example.landsale.service.BrokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrokerServiceImpl implements BrokerService {


    @Autowired
    private BrokerRepository brokerRepository;

    @Autowired
    private EntityBuilder entityBuilder;

    @Autowired
    private DtoBuilders dtoBuilders;

    @Override
    public Long add(BrokerDTO brokerDTO) {
        Broker save = brokerRepository.save(entityBuilder.builBroker(new Broker(), brokerDTO));
        return null != save ? save.getId() : null;

    }

    @Override
    public Long update(BrokerDTO brokerDTO) {
        Broker save = brokerRepository.save(entityBuilder.builBroker(new Broker(), brokerDTO));
        return null != save ? save.getId() : null;
    }

    @Override
    public List<BrokerDTO> searchLike(String searchText, Integer count, Integer page) {

        List<BrokerDTO> brokerDTOS = new ArrayList<>();
        for (Broker broker:brokerRepository.search(searchText,count,page) ) {
            brokerDTOS.add(dtoBuilders.buildBrokerDTO(broker));
        }

        return brokerDTOS;
    }

    @Override
    public BrokerDTO get(Long id) {
        return dtoBuilders.buildBrokerDTO(brokerRepository.getOne(id));
    }

    @Override
    public void delete(Long id) {

    }
}
