package com.tdtu.midterm.dto;

import com.tdtu.midterm.model.Product;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
public class OrderDTO {
    private Long id;
    private Double totalSellingPrice;
    private List<ProductDTO> products;
}
