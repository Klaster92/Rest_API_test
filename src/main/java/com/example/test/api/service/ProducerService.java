package com.example.test.api.service;

import com.example.test.api.model.Producer;
import com.example.test.api.repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProducerService {

    private final ProducerRepository producerRepository;

    @Autowired
    public ProducerService(ProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
    }

    public Optional<Producer> findById(Integer id) {
        return producerRepository.findById(id);
    }

    public List<Producer> findAll(){
        return (List<Producer>) producerRepository.findAll();
    }

    public Producer save(Producer producer) {
        return producerRepository.save(producer);
    }

    public void delete(Producer producer) {
        producerRepository.delete(producer);
    }

    public void deleteById(Integer id){
        producerRepository.deleteById(id);
    }
}
