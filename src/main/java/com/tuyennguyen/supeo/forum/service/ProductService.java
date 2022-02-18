package com.tuyennguyen.supeo.forum.service;

import com.tuyennguyen.supeo.forum.entity.Product;
import com.tuyennguyen.supeo.forum.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    @PersistenceContext
    private javax.persistence.EntityManager entityManager;

    public List<Product> findAll() {
        return productRepo.findAll();
    }

    public Optional<Product> findById(int id) {
        return productRepo.findById(id);
    }

    public Product save(Product obj) {
        return productRepo.save(obj);
    }

    public void deleteById(int id) {
        productRepo.deleteById(id);
    }

}
