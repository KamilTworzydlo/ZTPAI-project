-- CATEGORY
INSERT INTO CATEGORY (id, name) VALUES
(1, 'Szalunki ścienne'),
(2, 'Szalunki stropowe'),
(3, 'Rusztowania');

-- PRODUCT
INSERT INTO PRODUCT (id, name, description, price_per_day, category_id) VALUES
(1, 'Szalunek ścienny 1m2', 'Szalunek stalowy do ścian', 20.00, 1),
(2, 'Szalunek stropowy', 'System szalunków stropowych', 25.00, 2),
(3, 'Rusztowanie modułowe', 'Rusztowanie 2m wysokości', 45.00, 3),
(4, 'Podpora regulowana', 'Podpora do stropów', 10.00, 2);

-- CUSTOMER
INSERT INTO CUSTOMER (id, first_name, last_name, phone, email) VALUES
(1, 'Jan', 'Kowalski', '600123456', 'jan.kowalski@mail.pl'),
(2, 'Anna', 'Nowak', '600987654', 'anna.nowak@mail.pl');

-- RENTAL
INSERT INTO RENTAL (id, customer_id, start_date, end_date, total_price) VALUES
(1, 1, '2026-01-10', '2026-01-15', 250.00),
(2, 2, '2026-01-12', '2026-01-18', 320.00);

-- RENTAL_ITEM
INSERT INTO RENTAL_ITEM (id, rental_id, product_id, quantity, price_per_day) VALUES
(1, 1, 1, 10, 20.00),
(2, 1, 4, 5, 10.00),
(3, 2, 3, 4, 45.00);
