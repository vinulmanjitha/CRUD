package com.example.demo.service;

import com.example.demo.dao.ACAEBaseJdbcDAO;
import com.example.demo.dao.ACAERepository;
import com.example.demo.model.ACAEListDoneRQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {

    @Autowired
    private ACAEBaseJdbcDAO acaeJdbcDao;

    @Autowired
    private ACAERepository acaeRepository;
    public String getEligibilityForwardACAEBatchService(ACAEListDoneRQ acaeListDoneRQ) {
        return acaeJdbcDao.getEligibilityForwardACAEBatchRepository(acaeListDoneRQ);
    }

    public ACAEListDoneRQ addItems(ACAEListDoneRQ acaeListDoneRQ){
        return acaeRepository.save(acaeListDoneRQ);
    }

    public List<ACAEListDoneRQ> getItems(){
        return acaeRepository.findAll();
    }
}
