package com.crud.product.repository;

import com.crud.product.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();  // Phương thức lấy danh sách tất cả sản phẩm
    int save(Product product);  // Phương thức lưu sản phẩm mới
    int update(Product product);  // Phương thức cập nhật sản phẩm
    int deleteById(int id);  // Phương thức xóa sản phẩm theo Id
}
