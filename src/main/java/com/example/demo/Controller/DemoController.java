package com.example.demo.controller;

import com.example.demo.model.ACAEListDoneRQ;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DemoController {
    @Autowired
    private DemoService demoService;
    @CrossOrigin
    @RequestMapping(value ="/getEligibilityForwardACAEBatch", method = RequestMethod.POST)
    public ResponseEntity<String> getEligibilityForwardACAEBatchController(@RequestBody ACAEListDoneRQ acaeListDoneRQ) {

        String forwardACAEBatch = demoService.getEligibilityForwardACAEBatchService(acaeListDoneRQ);

        return new ResponseEntity<>(forwardACAEBatch, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value ="/addItems", method = RequestMethod.POST)
    public ResponseEntity<ACAEListDoneRQ> addItems(@RequestBody ACAEListDoneRQ acaeListDoneRQ) {

        ACAEListDoneRQ forwardACAEBatch = demoService.addItems(acaeListDoneRQ);

        return new ResponseEntity<>(forwardACAEBatch, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value ="/getItems", method = RequestMethod.GET)
    public ResponseEntity<List<ACAEListDoneRQ>> getItems() {

        List<ACAEListDoneRQ> forwardACAEBatch = demoService.getItems();

        return new ResponseEntity<>(forwardACAEBatch, HttpStatus.OK);
    }
}
