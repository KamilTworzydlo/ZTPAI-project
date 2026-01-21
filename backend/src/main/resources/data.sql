-- ======================
-- CATEGORY
-- ======================
INSERT INTO CATEGORY (ID, NAME) VALUES
(1, 'Szalunki scienne'),
(2, 'Szalunki stropowe'),
(3, 'Rusztowania');

-- ======================
-- PRODUCT
-- ======================
INSERT INTO PRODUCT (NAME, DESCRIPTION, PRICE_PER_DAY, CATEGORY_ID) VALUES
('Szalunek scienny 1m2', 'Szalunek stalowy do scian', 20.00, 1),
('Szalunek scienny lekki', 'Lekki system panelowy', 18.00, 1),
('Szalunek stropowy', 'System szalunkow stropowych', 25.00, 2),
('Podpora regulowana', 'Podpora do stropow', 10.00, 2),
('Belka drewniana H20', 'Belka stropowa H20', 7.00, 2),
('Rusztowanie modulowe', 'Rusztowanie 2m wysokosci', 45.00, 3),
('Rusztowanie elewacyjne', 'System elewacyjny', 40.00, 3),
('Drabina montazowa', 'Drabina do rusztowan', 12.00, 3);
('Panel scienny premium', 'Panel wzmacniany', 30.00, 1),
('Panel scienny economy', 'Tani system scienny', 15.00, 1),
('Strop aluminiowy', 'Lekki system stropowy', 28.00, 2),
('Podpora ciezka', 'Wzmocniona podpora', 14.00, 2),
('Belka stalowa', 'Belka stalowa stropowa', 12.00, 2),
('Rusztowanie jezdne', 'Rusztowanie mobilne', 50.00, 3),
('Pomost roboczy', 'Pomost do rusztowan', 20.00, 3);

-- ======================
-- CUSTOMER
-- ======================
INSERT INTO CUSTOMER (FIRST_NAME, LAST_NAME, PHONE, EMAIL) VALUES
('Jan', 'Kowalski', '600123456', 'jan.kowalski@mail.pl'),
('Anna', 'Nowak', '600987654', 'anna.nowak@mail.pl'),
('Piotr', 'Wisniewski', '601111222', 'piotr.w@mail.pl'),
('Katarzyna', 'Mazur', '602222333', 'k.mazur@mail.pl'),
('Michal', 'Lewandowski', '603333444', 'm.lew@mail.pl'),
('Pawel', 'Kaczmarek', '604444555', 'p.kacz@mail.pl');
('Adam', 'Dabrowski', '605111222', 'adam.d@mail.pl'),
('Tomasz', 'Pawlak', '606222333', 't.pawlak@mail.pl'),
('Marcin', 'Krol', '607333444', 'marcin.k@mail.pl'),
('Agnieszka', 'Zielinska', '608444555', 'a.ziel@mail.pl'),
('Monika', 'Szymanska', '609555666', 'monika.s@mail.pl'),
('Robert', 'Wojcik', '610666777', 'r.wojcik@mail.pl');