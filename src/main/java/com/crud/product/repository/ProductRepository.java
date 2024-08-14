package com.crud.product.repository;

import com.crud.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Product> findAll() {
        String SQL = "SELECT * FROM Products";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Product.class));
    }

    @Override
    public int save(Product product) {
        String SQL = "INSERT INTO Products (productName, price, discountPrice, image, description, category, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(SQL, new Object[]{
                product.getProductName(),
                product.getPrice(),
                product.getDiscountPrice(),
                product.getImage(),
                product.getDescription(),
                product.getCategory(),
                product.getStatus()
        });
    }

    @Override
    public int update(Product product) {
        String SQL = "UPDATE Products SET productName = ?, price = ?, discountPrice = ?, image = ?, description = ?, category = ?, status = ? WHERE id = ?";
        return jdbcTemplate.update(SQL, new Object[]{
                product.getProductName(),
                product.getPrice(),
                product.getDiscountPrice(),
                product.getImage(),
                product.getDescription(),
                product.getCategory(),
                product.getStatus(),
                product.getId()
        });
    }

    @Override
    public int deleteById(int id) {
        String SQL = "DELETE FROM Products WHERE id = ?";
        return jdbcTemplate.update(SQL, id);
    }
}
