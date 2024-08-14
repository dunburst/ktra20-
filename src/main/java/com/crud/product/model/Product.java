package com.crud.product.model;

import lombok.Data;

@Data
public class Product {
    private int id; // Id của sản phẩm
    private String productName; // Tên sản phẩm
    private double price; // Giá sản phẩm
    private Double discountPrice; // Giá khuyến mại, có thể null
    private String image; // Đường dẫn hoặc tên file hình ảnh
    private String description; // Mô tả sản phẩm
    private String category; // Danh mục sản phẩm
    private String status; // Trạng thái của sản phẩm, ví dụ: "Còn hàng", "Hết hàng"
}
