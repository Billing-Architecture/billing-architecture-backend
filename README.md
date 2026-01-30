# Billing API
> API to manage orders, billings and payments. Developed with Java Spring Boot, PostgreSQL and Docker.

---

## Descripción
The Billing API is a backend project that manages order payments and billing generation, along with other functionalities such as storing product, order, billing, and payments information. It's connected to a notification service found in 'notification-architecture-backend' to send notifications to users.  
It's designed following best development practices, with a modular architecture.  

---

## Technologies used
- Java 21  
- Spring Boot 4.0.1  
- Spring Web + Tomcat  
- Spring Data JPA  
- Hibernate  
- PostgreSQL  

---

## Project Structure
src/main/billing/service/billing-service  
├── controllers/ # Business logic  
├── domain/ # Database models  
├── jpa/ #JPA-based business logic implementations  
├── repositorys/ #JPA repositories for data access  
├── services/ # Reusable services  
└── BillingServiceApplication.java # Start the server  

---

## Requirements
- Java 21  
- Docker y Docker Compose  
- Git  

---

## Endpoints

### Products
| Method | Endpoint              | Description                     |
|--------|-----------------------|---------------------------------|
| GET    | /products/list        | Get a list of products          |
| GET    | /products/find/{id}   | Get a single product            |
| POST   | /products/add         | Create a new product            |
| PUT    | /products/edit        | Update information of a product |
| DELETE | /products/{id}        | Delete a product                |

### Bills
| Method | Endpoint              | Description                     |
|--------|-----------------------|---------------------------------|
| GET    | /bills/list           | Get a list of bills             |
| POST   | /bills/add            | Add and generate bill           |

### Orders Details
| Method | Endpoint              | Description                     |
|--------|-----------------------|---------------------------------|
| GET    | /details/list         | Get a list of orders details    |
| POST   | /details/add          | Add and generate order detail   |

### Payments
| Method | Endpoint              | Description                     |
|--------|-----------------------|---------------------------------|
| GET    | /payments/list        | Get a list of payments          |
| POST   | /payments/add         | Add and generate payment        |

---

## Example Request (JSON)
Here are two examples of how to make a request to the endpoints described above. You can use tools commonly used for testing and consuming APIs, such as Postman.  

### Example to get products
- HTTP Request to get a list of products
```json
    GET http://host:port/products/list
```

### Example to get a product
- HTTP Request to get a product
```json
    GET http://host:port/products/find/1
```

### Example to create a product
- Request to create a product
```json
{
    "productCode": "product_code",
    "productName": "product",
    "productDescription": "product description",
    "productDefaultPrice": 999,
    "productTaxPercentage": 13.0,
    "productDescountPercentage": 5.0
}
```

### Example to update a product
- Request to update a product
```json
{  
    "productId": 1,
    "productCode": "product_code",
    "productName": "product",
    "productDescription": "product description",
    "productDefaultPrice": 999,
    "productTaxPercentage": 13.0,
    "productDescountPercentage": 5.0
}  
```

### Example to update a product
- Request to update a product
```json
{  
    "productId": 1,
    "productCode": "product_code",
    "productName": "product",
    "productDescription": "product description",
    "productDefaultPrice": 999,
    "productTaxPercentage": 13.0,
    "productDescountPercentage": 5.0
}  
```

### Example to delete a product
- HTTP Request to delete a product
```json
    DELETE http://host:port/products/delete/1
```

---

## Installation and execution
1. Clone the repository
```bash
git clone https://github.com/Billing-Architecture/billing-architecture-backend.git
cd billing-service
```

2. Configure environment variables  
Instead of using .env files, the application is configured using application.properties and operating system environment variables.  
```bash
$env:DB_URL="jdbc:database_url"  
$env:DB_USER="database_user"  
$env:DB_PASSWORD="password"   
```
---

## Author
Dennis Gómez Alvarado
