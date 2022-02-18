package com.tuyennguyen.supeo.forum.controller;

import com.tuyennguyen.supeo.forum.entity.Product;
import com.tuyennguyen.supeo.forum.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class ProductController {

    Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public String showList(Model model) {
        // log info
        log.debug("Go to: /admin/product");

        try {
            // set title
            model.addAttribute("title", "Danh Sách Product");
            // set page
            model.addAttribute("page", "product");

            //set list
            List<Product> listProduct = productService.findAll();
            model.addAttribute("listProduct", listProduct);
        } catch (Exception e) {

        }

        return "admin/admin";
    }

    @GetMapping("/product/them")
    public String them(Model model) {
        // log info
        log.debug("Go to: /admin/product/them");

        try {
            // set title
            model.addAttribute("title", "Product Thêm");
            // set page
            model.addAttribute("page", "product-edit");
        } catch (Exception e) {

        }

        return "admin/admin";
    }

    @GetMapping("/product/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        // log info
        log.debug("Go to: /admin/product/edit/" + id);

        try {
            // set title
            model.addAttribute("title", "Product Edit");
            // set page
            model.addAttribute("page", "product-edit");

            Product obj = productService.findById(id).get();
            model.addAttribute("product", obj);

        } catch (Exception e) {

        }

        return "admin/admin";
    }

    @PostMapping("/product/update")
    public RedirectView update(@ModelAttribute("obj") Product obj, Model model) {
        // log info
        log.debug("Go to: /admin/product/update/" + obj.getProductId());

        try {
            // set title
            model.addAttribute("title", "Danh Sách Product");
            // set page
            model.addAttribute("page", "product");

            // save obj
            productService.save(obj);

            //set list
            List<Product> listProduct = productService.findAll();
            model.addAttribute("listProduct", listProduct);
        } catch (Exception e) {

        }

        return new RedirectView("/admin/product");
    }

    @GetMapping("/product/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        // log info
        log.debug("Go to: /admin/product/delete/" + id);

        try {
            // set title
            model.addAttribute("title", "Danh Sách Product");
            // set page
            model.addAttribute("page", "product");

            // delete obj
            productService.deleteById(id);

            //set list
            List<Product> listProduct = productService.findAll();
            model.addAttribute("listProduct", listProduct);
        } catch (Exception e) {

        }

        return "admin/admin";
    }

}
