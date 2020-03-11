package com.example.test.api.controller;

import com.example.test.api.model.Producer;
import com.example.test.api.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/producer/")
public class ProducerController {

    private ProducerService producerService;

    @Autowired
    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Producer> getProducer(@PathVariable("id") Integer id){
        if(id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Optional<Producer> producer = this.producerService.findById(id);

        if(!producer.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(producer.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Producer> saveProducer(@RequestBody @Valid Producer producer) {
        HttpHeaders headers = new HttpHeaders();

        if (producer == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.producerService.save(producer);
        return new ResponseEntity<>(producer, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Producer> updateProducer(@RequestBody @Valid Producer producer, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (producer == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.producerService.save(producer);

        return new ResponseEntity<>(producer, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Producer> deleteProducer(@PathVariable("id") Integer id) {
        Optional<Producer> producer = this.producerService.findById(id);

        if (!producer.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.producerService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Producer>> getAllCustomers() {
        List<Producer> producers = this.producerService.findAll();

        if (producers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(producers, HttpStatus.OK);
    }

}
