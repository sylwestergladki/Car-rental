
create table rentals(
    id INT PRIMARY KEY AUTO_INCREMENT,
    car_id int not null ,
    user_id int not null ,
    is_active bit
);

ALTER TABLE rentals
    ADD FOREIGN KEY (car_id)
        REFERENCES cars(id);

ALTER TABLE rentals
    ADD FOREIGN KEY (user_id)
        REFERENCES users(id);