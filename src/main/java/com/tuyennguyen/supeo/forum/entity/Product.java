package com.tuyennguyen.supeo.forum.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = true)
    private String price;

    @Column(nullable = true)
    private String description;

    @Column(nullable = true)
    private String imageName;

    @Column(nullable = false, columnDefinition = "SMALLINT UNSIGNED")
    private Integer quantity = 0;

    @Column(nullable = false)
    private Integer isVisible = 1;

    @Column(nullable = true)
    private Integer menuDongId;

    @Column(nullable = false, columnDefinition = "TINYINT(1) UNSIGNED")
    private Integer favourite = 0;

    @Column(nullable = false, columnDefinition = "TINYINT(1) UNSIGNED")
    private Integer sale = 0;

    @Column(nullable = true)
    private String salePercent;

    @Column(nullable = true)
    private String salePrice;

    @Column(nullable = true)
    private String giaConLai;

}
