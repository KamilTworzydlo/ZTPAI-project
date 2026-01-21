-- ======================
-- CATEGORY
-- ======================
INSERT INTO CATEGORY (ID, NAME) VALUES
(1, 'Szalunki ścienne'),
(2, 'Szalunki stropowe'),
(3, 'Rusztowania');

-- ======================
-- PRODUCT
-- ======================
INSERT INTO PRODUCT (ID, NAME, DESCRIPTION, PRICE_PER_DAY, CATEGORY_ID) VALUES
(1, 'Szalunek ścienny 1m2', 'Szalunek stalowy do ścian', 20.00, 1),
(2, 'Szalunek ścienny lekki', 'Lekki system panelowy', 18.00, 1),
(3, 'Szalunek stropowy', 'System szalunków stropowych', 25.00, 2),
(4, 'Podpora regulowana', 'Podpora do stropów', 10.00, 2),
(5, 'Belka drewniana H20', 'Belka stropowa H20', 7.00, 2),
(6, 'Rusztowanie modułowe', 'Rusztowanie 2m wysokości', 45.00, 3),
(7, 'Rusztowanie elewacyjne', 'System elewacyjny', 40.00, 3),
(8, 'Drabina montażowa', 'Drabina do rusztowań', 12.00, 3);

-- ======================
-- CUSTOMER
-- ======================
INSERT INTO CUSTOMER (ID, FIRST_NAME, LAST_NAME, PHONE, EMAIL) VALUES
(1, 'Jan', 'Kowalski', '600123456', 'jan.kowalski@mail.pl'),
(2, 'Anna', 'Nowak', '600987654', 'anna.nowak@mail.pl'),
(3, 'Piotr', 'Wisniewski', '601111222', 'piotr.w@mail.pl'),
(4, 'Katarzyna', 'Mazur', '602222333', 'k.mazur@mail.pl'),
(5, 'Michal', 'Lewandowski', '603333444', 'm.lew@mail.pl'),
(6, 'Pawel', 'Kaczmarek', '604444555', 'p.kacz@mail.pl');

-- ======================
-- RENTAL
-- ======================
INSERT INTO RENTAL (ID, CUSTOMER_ID, START_DATE, END_DATE, TOTAL_PRICE) VALUES
(1, 1, '2026-01-10', '2026-01-15', 250.00),
(2, 2, '2026-01-12', '2026-01-18', 320.00),
(3, 3, '2026-01-15', '2026-01-20', 410.00),
(4, 4, '2026-01-18', '2026-01-25', 600.00),
(5, 5, '2026-01-20', '2026-01-23', 180.00),
(6, 6, '2026-01-22', '2026-01-30', 900.00),
(7, 1, '2026-02-01', '2026-02-05', 300.00),
(8, 2, '2026-02-03', '2026-02-10', 520.00);

-- ======================
-- RENTAL_ITEM
-- ======================
INSERT INTO RENTAL_ITEM (ID, RENTAL_ID, PRODUCT_ID, QUANTITY, PRICE_PER_DAY) VALUES
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
