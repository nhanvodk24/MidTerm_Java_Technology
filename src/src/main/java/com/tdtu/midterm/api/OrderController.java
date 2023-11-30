package com.tdtu.midterm.api;

import com.tdtu.midterm.dto.OrderDTO;
import com.tdtu.midterm.dto.ProductDTO;
import com.tdtu.midterm.global.GlobalData;
import com.tdtu.midterm.model.Order;

import com.tdtu.midterm.model.Product;
import com.tdtu.midterm.service.CategoryService;
import com.tdtu.midterm.service.OrderService;
import com.tdtu.midterm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping({"/", ""})
    public List<OrderDTO> getAllOrder(){
        List<OrderDTO> orderDTOList = new ArrayList<OrderDTO>();
        for (Order order: orderService.getAllOrder()) {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setId(order.getId());
            orderDTO.setTotalSellingPrice(order.getTotalSellingPrice());
            orderDTO.setProducts(mapProductsToProductDTOs(order.getProducts()));
            orderDTOList.add(orderDTO);
        }
        return orderDTOList;
    }

    @PostMapping("/add")
    public List<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) {
        Order order = new Order();
        order.setId(orderDTO.getId());
        order.setTotalSellingPrice(mapProductDTOsToProducts(orderDTO.getProducts()).stream().mapToDouble(Product::getPrice).sum());
        order.setProducts(mapProductDTOsToProducts(orderDTO.getProducts()));
        orderService.addOrder(order);
        return getAllOrder();
    }

    @DeleteMapping("/{id}")
    public List<OrderDTO> deleteOrder(@PathVariable Long id) {
        orderService.removeOrderById(id);
        return getAllOrder();
    }

    @PutMapping("/{id}")
    public List<OrderDTO> updateOrder(@PathVariable Long id, @RequestBody OrderDTO orderDTO) {
        Order order = orderService.getOrderById(id).get();
        order.setId(orderDTO.getId());
        order.setTotalSellingPrice(mapProductDTOsToProducts(orderDTO.getProducts()).stream().mapToDouble(Product::getPrice).sum());
        order.setProducts(mapProductDTOsToProducts(orderDTO.getProducts()));
        orderService.addOrder(order);
        return getAllOrder();
    }

    private List<ProductDTO> mapProductsToProductDTOs(List<Product> products) {
        List<ProductDTO> productDTOList = new ArrayList<ProductDTO>();
        for (Product product: products) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setName(product.getName());
            productDTO.setPrice(product.getPrice());
            productDTO.setDescription(product.getDescription());
            productDTO.setImageName(product.getImageName());
            productDTO.setCategoryId(product.getCategory().getId());
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }

    private List<Product> mapProductDTOsToProducts(List<ProductDTO> productDTOSs) {
        List<Product> productList = new ArrayList<Product>();
        for (ProductDTO productDTO: productDTOSs) {
            Product product = new Product();
            product.setId(productDTO.getId());
            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            product.setDescription(productDTO.getDescription());
            product.setImageName(productDTO.getImageName());
            product.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()).get());
            productList.add(product);
        }
        return productList;
    }
}
