
create table cars(
                      id INT PRIMARY KEY AUTO_INCREMENT,
                      model VARCHAR(100) NOT NULL,
                      brand VARCHAR(100) NOT NULL,
                      color VARCHAR(100) NOT NULL,
                      fuel_type ENUM('DIESEL','PETROL','LPG','ELECTRIC')
);

