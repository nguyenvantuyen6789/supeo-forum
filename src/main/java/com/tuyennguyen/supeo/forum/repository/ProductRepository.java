package com.tuyennguyen.supeo.forum.repository;

import com.tuyennguyen.supeo.forum.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    public List<Product> findAll();

    public List<Product> findProductsByMenuDongId(int menuDongId);

    public int countProductByProductName(String productName);

    public List<Product> findProductsByFavouriteAndIsVisible(int favourite, int isVisible);

    public List<Product> findProductsByFavourite(int favourite);

    public List<Product> findProductsByIsVisible(int isVisible);

}
