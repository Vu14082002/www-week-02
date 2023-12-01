# www-week-02
RESTFULL WEBSERVICE
## View home page
![Ảnh home page phần 1](https://github.com/Vu14082002/www-week-02/blob/master/src/main/webapp/view-demo/home_page_01.jpg)
![Ảnh home page phần 1](https://github.com/Vu14082002/www-week-02/blob/master/src/main/webapp/view-demo/home_page_02.jpg)
**Lấy sản phẩm có id=??? ** <br>
sau khi hiển thị sản phẩm bạn chọn số lượng sản phẩm bạn cần mua và sau đó click vào nut **Add to cart**<br>
trang web sẽ chuyển đến trang home page và sau đó cập nhật lại giở hàng và tổng tiền cần thành toán trong giỏ hàng 
![Ảnh home page phần 1](https://github.com/Vu14082002/www-week-02/blob/master/src/main/webapp/view-demo/add-to-cart.jpg)
** Vào giỏ hàng để xem các sản phẩm đã đặt hàng
![Ảnh home page phần 1](https://github.com/Vu14082002/www-week-02/blob/master/src/main/webapp/view-demo/cart.jpg)

# Mô Tả Xử Lý Web và API Endpoints

## Xử Lý Web

Có sử dụng `@WebFilter` cho các URL sau:

- `/cart/*`
- `/account/*`

## API Endpoints

### Customers API

#### Lấy thông tin một khách hàng

- **Method:** GET
- **Endpoint:** `http://localhost/api/customers/{{id}}`
- **Mô tả:** Lấy thông tin một khách hàng cụ thể bằng ID.

#### Lấy danh sách khách hàng

- **Method:** GET
- **Endpoint:** `http://localhost/api/customers`
- **Mô tả:** Lấy danh sách tất cả khách hàng.

#### Tạo khách hàng mới

- **Method:** POST
- **Endpoint:** `http://localhost/api/customers`
- **Mô tả:** Tạo khách hàng mới.

#### Cập nhật thông tin khách hàng

- **Method:** PUT
- **Endpoint:** `http://localhost/api/customers/{{id}}`
- **Mô tả:** Cập nhật thông tin của khách hàng bằng ID.

#### Xóa thông tin khách hàng

- **Method:** DELETE
- **Endpoint:** `http://localhost/api/customers/{{id}}`
- **Mô tả:** Xóa thông tin của khách hàng bằng ID.

### Employees API

#### Lấy thông tin một nhân viên

- **Method:** GET
- **Endpoint:** `http://localhost/api/employees/{{id}}`
- **Mô tả:** Lấy thông tin một nhân viên cụ thể bằng ID.

#### Lấy danh sách nhân viên

- **Method:** GET
- **Endpoint:** `http://localhost/api/employees`
- **Mô tả:** Lấy danh sách tất cả nhân viên.

#### Tạo nhân viên mới

- **Method:** POST
- **Endpoint:** `http://localhost/api/employees`
- **Mô tả:** Tạo nhân viên mới.

#### Cập nhật thông tin nhân viên

- **Method:** PUT
- **Endpoint:** `http://localhost/api/employees/{{id}}`
- **Mô tả:** Cập nhật thông tin của nhân viên bằng ID.

#### Xóa thông tin nhân viên

- **Method:** DELETE
- **Endpoint:** `http://localhost/api/employees/{{id}}`
- **Mô tả:** Xóa thông tin của nhân viên bằng ID.

## Order Details API

#### Lấy thông tin chi tiết đơn hàng

- **Method:** GET
- **Endpoint:** `http://localhost/api/order-details/{{orderId}}/{{procId}}`
- **Mô tả:** Lấy thông tin chi tiết đơn hàng dựa trên orderId và procId.

#### Lấy danh sách các chi tiết đơn hàng

- **Method:** GET
- **Endpoint:** `http://localhost/api/order-details`
- **Mô tả:** Lấy danh sách tất cả các chi tiết đơn hàng.

#### Tạo chi tiết đơn hàng mới

- **Method:** POST
- **Endpoint:** `http://localhost/api/order-details`
- **Mô tả:** Tạo một chi tiết đơn hàng mới.

#### Cập nhật thông tin chi tiết đơn hàng

- **Method:** PUT
- **Endpoint:** `http://localhost/api/order-details/{{orderId}}/{{procId}}`
- **Mô tả:** Cập nhật thông tin của chi tiết đơn hàng dựa trên orderId và procId.

#### Xóa chi tiết đơn hàng

- **Method:** DELETE
- **Endpoint:** `http://localhost/api/order-details/{{orderId}}/{{procId}}`
- **Mô tả:** Xóa chi tiết đơn hàng dựa trên orderId và procId.

## Orders API

#### Lấy thông tin một đơn hàng

- **Method:** GET
- **Endpoint:** `http://localhost/api/orders/{{id}}`
- **Mô tả:** Lấy thông tin một đơn hàng cụ thể bằng ID.

#### Lấy danh sách đơn hàng

- **Method:** GET
- **Endpoint:** `http://localhost/api/orders`
- **Mô tả:** Lấy danh sách tất cả các đơn hàng.

#### Tạo đơn hàng mới

- **Method:** POST
- **Endpoint:** `http://localhost/api/orders`
- **Mô tả:** Tạo một đơn hàng mới.

#### Cập nhật thông tin đơn hàng

- **Method:** PUT
- **Endpoint:** `http://localhost/api/orders/{{id}}`
- **Mô tả:** Cập nhật thông tin của đơn hàng bằng ID.

#### Xóa đơn hàng

- **Method:** DELETE
- **Endpoint:** `http://localhost/api/orders/{{id}}`
- **Mô tả:** Xóa đơn hàng bằng ID.

## Product Images API

#### Lấy thông tin một hình ảnh sản phẩm

- **Method:** GET
- **Endpoint:** `http://localhost/api/product-images/{{id}}`
- **Mô tả:** Lấy thông tin một hình ảnh sản phẩm dựa trên ID.

#### Lấy danh sách hình ảnh sản phẩm

- **Method:** GET
- **Endpoint:** `http://localhost/api/product-images`
- **Mô tả:** Lấy danh sách tất cả các hình ảnh sản phẩm.

#### Tạo hình ảnh sản phẩm mới

- **Method:** POST
- **Endpoint:** `http://localhost/api/product-images`
- **Mô tả:** Tạo một hình ảnh sản phẩm mới.

#### Cập nhật thông tin hình ảnh sản phẩm

- **Method:** PUT
- **Endpoint:** `http://localhost/api/product-images/{{id}}`
- **Mô tả:** Cập nhật thông tin của hình ảnh sản phẩm dựa trên ID.

#### Xóa hình ảnh sản phẩm

- **Method:** DELETE
- **Endpoint:** `http://localhost/api/product-images/{{id}}`
- **Mô tả:** Xóa hình ảnh sản phẩm dựa trên ID.

## Product Prices API

#### Lấy thông tin một giá sản phẩm

- **Method:** GET
- **Endpoint:** `http://localhost/api/product-prices/{{id}}`
- **Mô tả:** Lấy thông tin một giá sản phẩm dựa trên ID.

#### Lấy danh sách giá sản phẩm

- **Method:** GET
- **Endpoint:** `http://localhost/api/product-prices`
- **Mô tả:** Lấy danh sách tất cả các giá sản phẩm.

#### Tạo giá sản phẩm mới

- **Method:** POST
- **Endpoint:** `http://localhost/api/product-prices`
- **Mô tả:** Tạo một giá sản phẩm mới.

#### Cập nhật thông tin giá sản phẩm

- **Method:** PUT
- **Endpoint:** `http://localhost/api/product-prices/{{id}}`
- **Mô tả:** Cập nhật thông tin của giá sản phẩm dựa trên ID.

#### Xóa giá sản phẩm

- **Method:** DELETE
- **Endpoint:** `http://localhost/api/product-prices/{{id}}`
- **Mô tả:** Xóa giá sản phẩm dựa trên ID.

## Products API

#### Lấy thông tin một sản phẩm

- **Method:** GET
- **Endpoint:** `http://localhost/api/products/{{id}}`
- **Mô tả:** Lấy thông tin một sản phẩm dựa trên ID.

#### Lấy danh sách sản phẩm

- **Method:** GET
- **Endpoint:** `http://localhost/api/products`
- **Mô tả:** Lấy danh sách tất cả các sản phẩm.

#### Tạo sản phẩm mới

- **Method:** POST
- **Endpoint:** `http://localhost/api/products`
- **Mô tả:** Tạo một sản phẩm mới.

#### Cập nhật thông tin sản phẩm

- **Method:** PUT
- **Endpoint:** `http://localhost/api/products/{{id}}`
- **Mô tả:** Cập nhật thông tin của sản phẩm dựa trên ID.

#### Xóa sản phẩm

- **Method:** DELETE
- **Endpoint:** `http://localhost/api/products/{{id}}`
- **Mô tả:** Xóa sản phẩm dựa trên ID.

## Statistics API

#### Lấy thông tin thống kê

- **Method:** GET
- **Endpoint:** `http://localhost/api/statistics`
- **Mô tả:** Lấy thông tin thống kê, có thể là các thông tin thống kê tổng quát về sản phẩm, doanh thu, hoặc thông tin khác tùy thuộc vào ứng dụng cụ thể.

