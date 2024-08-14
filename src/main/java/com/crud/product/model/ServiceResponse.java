package com.crud.product.model;

import lombok.Data;

@Data
public class ServiceResponse {
    private Boolean success; // Trạng thái thành công hoặc thất bại của phản hồi
    private String message;  // Thông điệp phản hồi từ dịch vụ
}
