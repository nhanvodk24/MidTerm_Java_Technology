# MidTerm_Java_Technology
# Entity-relationship diagram
![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/16e0614c-de70-4767-870b-26f7b1c4fb44)
# Giải thích cấu trúc code
![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/11529be2-e043-4c95-b5f4-0bd8d1955fe6)

- package api: chứa 2 controller để triển khai API để thực hiện các thao tác CRUD trên dữ liệu của sản phẩm, đơn đặt hàng trong ứng dụng.

- package configuration: chứa config của spring security

- package controller: chứa các controller để render và thực hiện các thao tác trên trang web chính và admin

- package dto: dùng để chuyển đổi đối tượng có liên kết với Hibernate (Hibernate proxy) và không có Serializer nào được tìm thấy để tạo thành JSON thành một đối tượng đơn giản hơn.

- package global: chứa cart hiện tại gồm một danh sách sản phẩm

- package model: chứa các model

- package mysql: file mysql tạo database trước khi chạy ứng dụng

- package repository: chứa các repository implement từ JpaRepository

- package service: chứa các service

- file Application.java để chạy ứng dụng

- package resources:
  * static: chứa các folder image: chứa ảnh logo, banner, và folder productImages: chứa ảnh sản phẩm
  * template: chứa các file html thymleaf
#  Cách để chạy ứng dụng:
- Bước 1: Chạy MySQL Workbench và tạo database dựa trên file sql đã cung cấp ở package mysql
- Bước 2: Chạy file MajorApplication để khởi tạo web
- Bước 3: Mở trình duyệt và truy cập vào http://localhost:8080/
- Bước 4: Đăng nhập để mua hàng:
  * Đăng kí tài khoản mới để đăng nhập
  * Đăng nhập bằng google
- Bước 5: Đăng nhập bằng tk admin:
  * username: admin@gmail.com
  * password: 123456
- Bước 6: Hoàn tất
  * Sau khi đã đăng nhập có thể thực hiện các chức năng ở http://localhost:8080/
  * Trang admin: http://localhost:8080/admin (chỉ tk admin mới vào được)
# API
- Get all products

![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/0662b143-fac1-416f-b9ee-8ad1806577a7)

- Add product

![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/45836af0-440a-4f2b-a3e1-c9db1c8c17fa)
Thêm sản phẩm Trà sữa trân châu đen
![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/97585402-2486-4691-8542-edf1e8c29af7)
Thêm sản phẩm vào Database

- Update product

![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/782409b6-8c4c-4b5d-9dd1-cf8b0e6d9cc6)
Cập nhật giá cho sản phẩm Trà sữa trân châu đen
![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/d786a382-084d-46b5-bf7d-1439553df1f8)
Cập nhật lên Database

- Delete product

![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/d81ba39b-6572-4405-af69-eb1da7600b66)
Xóa sản phẩm có id=9
![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/b7fd4f7c-6c29-4123-88f7-00fe8d377015)
Cập nhật lên Database

- Add order

![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/277e5368-b351-4c7e-a7a2-05c7478ebd02)
Thêm order thành công
![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/c5b315e1-f22a-4f04-8b7f-66abc5b29497)
Thêm order vào Database

- Get all orders

 ![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/07a5f3a8-2a53-4a73-9963-7323c2dee89a)

- Update order

![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/dea542fa-7abe-47a0-9b1a-80af5be59c0d)
Cập nhật đơn hàng chỉ còn 1 món
![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/19f868f5-b222-4fd2-82f1-52bb74989e84)
Cập nhật lên Database

- Delete order

![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/7fb91391-f82a-4ddd-9437-2b516fd035b0)
Xóa order có id=5
![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/cf0f7068-f36b-45e6-ba83-e21ddc82edd4)
Khi gọi API getAllOrders, order sẽ bị xóa
![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/408db3e0-521c-4bd4-808a-d89cbd1d37c6)
Cập nhật lại Database
# Demo
- Trang chủ

![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/375b2d06-dfd6-46b3-84a7-a327b5fd154e)

- Đăng nhập

 ![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/352a5210-ca9f-4954-859b-0e629b35a3ad)

- Đăng ký
  
 ![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/a8f95208-6022-4f7e-b343-4a0b5b351dd6)
 
- Trang sản phẩm

![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/8befeb6e-446c-4b82-87c0-ad5d82108f74)

- Lọc sản phẩm
  * Lọc theo danh mục "Milk tea"

![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/d1dcdb0e-a070-4082-8324-c64863437c0f)

Lọc theo tên

![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/5368227d-60e5-4f0d-9168-949c6ee84668)

- Xem thông tin sản phẩm: nhấn chọn Xem sản phẩm
  * Đặt hàng sản phẩm: nhấn chọn Thêm vào giỏ hàng

![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/97432d80-1401-40de-aedf-d33a91fe64cd)

- Trang giỏ hàng: Hiển thị các món đã thêm vào giỏ hàng, thông tin đơn hàng, tổng tiền, phí vận chuyển

![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/9ad90582-9778-4145-af3c-1a0b7d5a96d1)

- Trang thanh toán: sau khi bấm Đặt hàng sẽ chuyển đến trang Thanh toán

![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/fc434d81-c284-476c-bbc2-60f2d2777bb0)

- Trang chủ Admin

![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/93333319-10c4-47e7-b59c-0f8f375cc9e7)

- Trang quản lý danh mục

![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/4a7cde8a-7d28-4112-892a-35b789252ad9)

- Trang thêm danh mục mới: thêm mục Trà đào vào hệ thống

![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/3689180a-21fb-4ab0-aafc-216eae08a659)

Sau khi thêm thành công sẽ hiển thị ở trang Quản lý danh mục

![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/0d1dfa0f-e53c-4d09-8caf-e6c5aae22ba7)

- Trang quản lý sản phẩm

![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/49e2ec6c-630a-43aa-9a80-ae7f427e40c4)

- Trang thêm sản phẩm: thêm sản phẩm Trà đào cam sả vào hệ thống

![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/040ec059-076c-428c-9c65-0f8154975647)

Khi thêm thành công sẽ hiển thị ở trang Quản lý sản phẩm

![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/eada1592-f94b-4839-ba2f-84ea8a72f450)

Hiển thị ở trang Sản phẩm

![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/039f97c8-e1d7-422d-ac9e-fee6d1c6c34e)

- Trang quản lý đơn hàng

![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/f6741ae7-590d-4668-95a7-4a280e711be6)

Thêm đơn hàng mới

![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/ffe8dca0-2d01-431d-bffc-a3a190738f99)

Sau khi thêm thành công đơn hàng mới sẽ hiển thị ở trang Quản lý đơn hàng

![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/729c2ce7-8acd-46c7-b24e-197ec0ffe743)
