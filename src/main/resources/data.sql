INSERT INTO address(street, zipcode, city)
VALUES ('Rue Italie', 1000, 'Bruxelles'),
       ('Rue Espagne', 1060, 'Saint-Gilles'),
       ('Grand Place', 1000, 'Bruxelles'),
       ('Boulevard de l''Atomium', 1020, 'Bruxelles'),
       ('Rue Washington', 1050, 'Ixelles');

INSERT INTO employee(name, firstname, service, floor, address_id)
VALUES ('Coq', 'Fernand', 'Helpdesk', 1, 1),
       ('Dupont', 'Julien', 'Reception', 0, 2),
       ('Habiba', 'Selma', 'RH', 6, 4),
       ('Zéribi', 'Karim', 'Director', 7, 3),
       ('Abdoulay', 'Issa', 'Developer', 5, 5);