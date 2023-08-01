#Spring Boot Book Seller

	Endpoints

####Login
-	Sign-Up

```
POST /api/authentication/sign-up HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Content-Length: 71

{
    "name":"user",
    "username":"user",
    "password":"user"
}

```

-	Sign-In

```
POST /api/authentication/sign-in HTTP/1.1
Host: localhost:8080
Authorization: 
Content-Type: application/json
Content-Length: 51

{
    "username":"user",
    "password":"user"
}

```

####Book Services

-	Create a book

```
POST /api/book HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjoiUk9MRV9BRE1JTiIsInVzZXJJZCI6MiwiZXhwIjoxNjkwOTkzOTgzfQ.KJewOm6MmlxiVaLC67dZoSsQPTojrvglzEOVehgkOcPSJstWLWJcI5_9HSJDFMktyWWOZqoHaf4sgABfaRm1Vg
Content-Length: 123

{
    "title":"Test Book",
    "price":"10",
    "description":"Test description",
    "author":"Test author"
}

```
-	Delete a book

```
DELETE /api/book/3 HTTP/1.1
Host: localhost:8080
Authorization: Bearer ****(admin)

```
-	Get all books

```
GET /api/book HTTP/1.1
Host: localhost:8080

```

#### Purchase History
-	Find all purchase history
  
```
GET /api/purchase-history HTTP/1.1
Host: localhost:8080
Authorization: Bearer ****(user or admin)
```
-	Create a purchase history	

```
POST /api/purchase-history HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Authorization: Bearer ****(user or admin)
Content-Length: 60

{
    "userId":"1",
    "bookId":"1",
    "price":"10"
}
```