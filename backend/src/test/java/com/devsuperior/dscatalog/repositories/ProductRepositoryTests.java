package com.devsuperior.dscatalog.repositories;

import com.devsuperior.dscatalog.entities.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.Instant;
import java.time.LocalDate;

@DataJpaTest
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository repository;

    @Test
    void insertShouldSaveProduct(){
        Product product = new Product(1L, "Teste", "Teste JPATest", 20.00, "", Instant.now());

        repository.save(product);

        Assertions.assertTrue(repository.findById(1L).isPresent());

    }

    @Test
    void deleteShouldObjectWhenIdExist(){
        long existingId = 1L;

        repository.deleteById(existingId);

        Assertions.assertFalse(repository.findById(existingId).isPresent());

    }
}
