# Car-rental

Car-rental is a simple backend for car rental made for improve my programming skills.

## Tools & technologies I've used
- Spring boot 
- Maven
- H2 database
- Hibernate
- lombok
- flyway
- JDK 17


## How to Install and Run the Project?

Get project by clone repo
  
  `git clone https://github.com/sylwestergladki/Car-rental.git`

or download the zip.


## How to use?

To send request use a Postman. The app supports HTTP methods. The requests have to be in JSON format.

for endpoint `/cars`
- GET method - return a list of cars
- POST method - add the car to database

for endpoint  `/cars/{id}`
- DELETE method - delete the car
- - PUT method - update the car's properties

for endpoint `/users`
- GET method - return a list of users
- POST method - add the user to database

for endpoint  `/users/{id}`
- DELETE method - delete the user

for endpoint `/rentals`
- GET method - return a list of rentals
- POST method - add the rental to database
- PUT method - update the rental's properties

for endpoint  `/rentals/{id}`
- DELETE method - delete the rental



