package com.example.test.api.repository;

import com.example.test.api.model.Producer;
import com.example.test.api.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerRepository extends CrudRepository<Producer, Integer> {

}
