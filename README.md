# MidTerm_Java_Technology
# Entity-relationship diagram
![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/16e0614c-de70-4767-870b-26f7b1c4fb44)
# Giải thích cấu trúc code
![image](https://github.com/nhanvodk24/MidTerm_Java_Technology/assets/95085184/729b45e1-66e9-431e-909d-261386546cd9)
- package api: chứa 2 controller để triển khai API để thực hiện các thao tác CRUD trên dữ liệu của sản phẩm, đơn đặt hàng trong ứng dụng. Ngoài ra còn có file sendData.txt chứa các raw json để test api.

- package configuration: chứa config của spring security

- package controller: chứa các controller để render và thực hiện các thao tác trên trang web chính và admin

- package dto: dùng để chuyển đổi đối tượng có liên kết với Hibernate (Hibernate proxy) và không có Serializer nào được tìm thấy để tạo thành JSON thành một đối tượng đơn giản hơn.

- package global: chứa cart hiện tại gồm một danh sách sản phẩm

- package model: chứa các model

- package mysql: file mysql tạo database trước khi chạy ứng dụng

- package repository: chứa các repository implement từ JpaRepository

- package service: chứa các service

- file java main để chạy ứng dụng

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
