package com.tdtu.midterm.controller;

import com.tdtu.midterm.dto.OrderDTO;
import com.tdtu.midterm.dto.ProductDTO;
import com.tdtu.midterm.model.Category;
import com.tdtu.midterm.model.Order;
import com.tdtu.midterm.model.Product;
import com.tdtu.midterm.service.CategoryService;
import com.tdtu.midterm.service.OrderService;
import com.tdtu.midterm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminController {
    public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/productImages";
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    OrderService orderService;
    @GetMapping("/admin")
    public String adminHome() {
        return "adminHome";
    }
    @GetMapping("/admin/categories")
    public String getCat(Model model) {
        model.addAttribute("categories", categoryService.getAllCategory());
        return "categories";
    }
    @GetMapping("/admin/categories/add")
    public String getCatAdd(Model model) {
        model.addAttribute("category", new Category());
        return "categoriesAdd";
    }
    @PostMapping("/admin/categories/add")
    public String postCatAdd(@ModelAttribute("category") Category category) {
        categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }
    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCat(@PathVariable int id){
        categoryService.removeCategoryById(id);
        return "redirect:/admin/categories";
    }
    @GetMapping("/admin/categories/update/{id}")
    public String updateCat(@PathVariable int id, Model model){
        Optional<Category> category = categoryService.getCategoryById(id);
        if(category.isPresent()){
            model.addAttribute("category", category.get());
            return "categoriesAdd";
        } else {
            return "404";
        }
    }
    // Product Section
    @GetMapping("/admin/products")
    public String getPro(Model model){
        model.addAttribute("products", productService.getAllProduct());
        return "products";
    }
    @GetMapping("/admin/products/add")
    public String getProAdd(Model model){
        model.addAttribute("productDTO", new ProductDTO());
        model.addAttribute("categories", categoryService.getAllCategory());
        return "productsAdd";
    }
    @PostMapping("/admin/products/add")
    public String postProAdd(@ModelAttribute("productDTO") ProductDTO productDTO,
                             @RequestParam("productImage")MultipartFile file,
                             @RequestParam("imgName")String imgName) throws IOException {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()).get());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        String imageUUID;
        if(!file.isEmpty()){
            imageUUID = file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
            Files.write(fileNameAndPath, file.getBytes());
        } else {
            imageUUID = imgName;
        }
        product.setImageName(imageUUID);
        productService.addProduct(product);
        return "redirect:/admin/products";
    }
    @GetMapping("/admin/product/delete/{id}")
    public String deletePro(@PathVariable long id){
        productService.removeProductById(id);
        return "redirect:/admin/products";
    }
    @GetMapping("/admin/product/update/{id}")
    public String updatePro(@PathVariable long id, Model model){
        Product product = productService.getProductById(id).get();
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setDescription(product.getDescription());
        productDTO.setImageName(product.getImageName());
        productDTO.setCategoryId(product.getCategory().getId());

        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("productDTO", productDTO);
        return "productsAdd";
    }

    // Order Session
    @GetMapping("/admin/orders")
    public String getOrder(Model model){
        model.addAttribute("orders", orderService.getAllOrder());
        return "orders";
    }

    @GetMapping("/admin/orders/add")
    public String getOrderAdd(Model model){
        model.addAttribute("productDTO", productService.getAllProduct());
        model.addAttribute("orderDTO", new OrderDTO());
        return "ordersAdd";
    }

    @PostMapping("/admin/orders/add")
    public String postOrderAdd(@ModelAttribute("orderDTO") OrderDTO orderDTO,
                               @RequestParam(name = "checkboxValues", required = false) List<String> checkboxValues) throws IOException {
        if (checkboxValues != null) {
            List<Product> productList = new ArrayList<Product>();
            for (String value : checkboxValues) {
                Optional<Product> product = productService.getProductById(Long.parseLong(value));
                productList.add(product.get());
            }
            Order order = new Order();
            order.setId(orderDTO.getId());
            order.setTotalSellingPrice(productList.stream().mapToDouble(Product::getPrice).sum());
            order.setProducts(productList);
            orderService.addOrder(order);
        }
        return "redirect:/admin/orders";
    }

    @GetMapping("/admin/orders/delete/{id}")
    public String deleteOrder(@PathVariable long id){
        orderService.removeOrderById(id);
        return "redirect:/admin/orders";
    }

    @GetMapping("/admin/orders/update/{id}")
    public String updateOrder(@PathVariable long id, Model model){
        Order order = orderService.getOrderById(id).get();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setProducts(mapProductsToProductDTOs(order.getProducts()));
        model.addAttribute("productDTO", productService.getAllProduct());
        model.addAttribute("orderDTO", orderDTO);
        return "ordersAdd";
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
}
