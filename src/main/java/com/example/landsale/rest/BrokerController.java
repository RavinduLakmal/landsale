package com.example.landsale.rest;

import com.example.landsale.dto.BrokerDTO;
import com.example.landsale.dto.InterestDTO;
import com.example.landsale.dto.commen.ResponseDTO;
import com.example.landsale.service.BrokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/landsale/broker")
public class BrokerController {

    @Autowired
    private BrokerService brokerService;

    @PostMapping
    public ResponseDTO addBroker(@RequestBody BrokerDTO brokerDTO){
        Long id = null;
        String message = "";
        int status = 0;
        try {
            Long add = brokerService.add(brokerDTO);
            if (add != null) {
                id = add;
                message="Broker is added";
                status = 1;
            }

        } catch (NullPointerException e) {
            message = "Broker create failed";
            status = 400;
            e.printStackTrace();
        }

        return new ResponseDTO(id,status,message);
    }

    @PutMapping
    public ResponseDTO updateBroker(@RequestBody BrokerDTO brokerDTO){
        Long id = null;
        String message = "";
        int status = 0;
        try {
            Long add = brokerService.add(brokerDTO);
            if (add != null) {
                id = add;
                message="Broker is updated";
                status = 1;
            }

        } catch (NullPointerException e) {
            message = "Broker create update";
            status = 400;
            e.printStackTrace();
        }

        return new ResponseDTO(id,status,message);
    }


    @GetMapping
    public List<BrokerDTO> searchBroker(
            @RequestParam(value = "text", required = true) String text,
            @RequestParam(value = "count", required = true) Integer count,
            @RequestParam(value = "page", required = true) Integer page) {

        return brokerService.searchLike(text, count, page);

    }
    @GetMapping("/{id}")
    public BrokerDTO getBroker(@PathVariable("id") Long id) {
        return brokerService.get(id);
    }


}
