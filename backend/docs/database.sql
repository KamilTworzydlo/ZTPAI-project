DROP TABLE IF EXISTS RENTAL_ITEM;
DROP TABLE IF EXISTS RENTAL;
DROP TABLE IF EXISTS PRODUCT;
DROP TABLE IF EXISTS CATEGORY;
DROP TABLE IF EXISTS CUSTOMER;

CREATE TABLE CATEGORY (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE PRODUCT (
    id INT PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    description TEXT,
    price_per_day DECIMAL(10,2) NOT NULL,
    category_id INT NOT NULL,
    FOREIGN KEY (category_id) REFERENCES CATEGORY(id)
);

CREATE TABLE CUSTOMER (
    id INT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    phone VARCHAR(20),
    email VARCHAR(150)
);

CREATE TABLE RENTAL (
    id INT PRIMARY KEY,
    customer_id INT NOT NULL,
    start_date DATE,
    end_date DATE,
    total_price DECIMAL(10,2),
    FOREIGN KEY (customer_id) REFERENCES CUSTOMER(id)
);

CREATE TABLE RENTAL_ITEM (
    id INT PRIMARY KEY,
    rental_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    price_per_day DECIMAL(10,2),
    FOREIGN KEY (rental_id) REFERENCES RENTAL(id),
    FOREIGN KEY (product_id) REFERENCES PRODUCT(id)
);

INSERT INTO CATEGORY (id, name) VALUES
(1, 'Szalunki ścienne'),
(2, 'Szalunki stropowe'),
(3, 'Rusztowania');

INSERT INTO PRODUCT (id, name, description, price_per_day, category_id) VALUES
(1, 'Szalunek ścienny 1m2', 'Szalunek stalowy do ścian', 20.00, 1),
(2, 'Szalunek ścienny lekki', 'Lekki system panelowy', 18.00, 1),
(3, 'Szalunek stropowy', 'System szalunków stropowych', 25.00, 2),
(4, 'Podpora regulowana', 'Podpora do stropów', 10.00, 2),
(5, 'Belka drewniana H20', 'Belka stropowa H20', 7.00, 2),
(6, 'Rusztowanie modułowe', 'Rusztowanie 2m wysokości', 45.00, 3),
(7, 'Rusztowanie elewacyjne', 'System elewacyjny', 40.00, 3),
(8, 'Drabina montażowa', 'Drabina do rusztowań', 12.00, 3);

INSERT INTO CUSTOMER (id, first_name, last_name, phone, email) VALUES
(1, 'Jan', 'Kowalski', '600123456', 'jan.kowalski@mail.pl'),
(2, 'Anna', 'Nowak', '600987654', 'anna.nowak@mail.pl'),
(3, 'Piotr', 'Wiśniewski', '601111222', 'piotr.w@mail.pl'),
(4, 'Katarzyna', 'Mazur', '602222333', 'k.mazur@mail.pl'),
(5, 'Michał', 'Lewandowski', '603333444', 'm.lew@mail.pl'),
(6, 'Paweł', 'Kaczmarek', '604444555', 'p.kacz@mail.pl');

INSERT INTO RENTAL (id, customer_id, start_date, end_date, total_price) VALUES
(1, 1, '2026-01-10', '2026-01-15', 250.00),
(2, 2, '2026-01-12', '2026-01-18', 320.00),
(3, 3, '2026-01-15', '2026-01-20', 410.00),
(4, 4, '2026-01-18', '2026-01-25', 600.00),
(5, 5, '2026-01-20', '2026-01-23', 180.00),
(6, 6, '2026-01-22', '2026-01-30', 900.00),
(7, 1, '2026-02-01', '2026-02-05', 300.00),
(8, 2, '2026-02-03', '2026-02-10', 520.00);

INSERT INTO RENTAL_ITEM (id, rental_id, product_id, quantity, price_per_day) VALUES
(1, 1, 1, 10, 20.00),
(2, 1, 4, 5, 10.00),
(3, 2, 6, 4, 45.00),
(4, 2, 8, 2, 12.00),
(5, 3, 3, 8, 25.00),
(6, 3, 5, 20, 7.00),
(7, 4, 7, 10, 40.00),
(8, 5, 2, 6, 18.00),
(9, 6, 6, 12, 45.00),
(10, 8, 3, 10, 25.00);

