INSERT INTO contestant (name, age, club, sex) VALUES ('Beni Bingus', 25, 'Klub A', 'M');
INSERT INTO contestant (name, age, club, sex) VALUES ('Jane Doe', 30, 'Klub B', 'F');
INSERT INTO contestant (name, age, club, sex) VALUES ('Alice Smith', 28, 'Klub A', 'F');
INSERT INTO contestant (name, age, club, sex) VALUES ('John Johnson', 27, 'Klub B', 'M');
INSERT INTO contestant (name, age, club, sex) VALUES ('Sarah Brown', 23, 'Klub C', 'F');
INSERT INTO contestant (name, age, club, sex) VALUES ('Michael White', 31, 'Klub A', 'M');
INSERT INTO contestant (name, age, club, sex) VALUES ('Emily Davis', 26, 'Klub B', 'F');
INSERT INTO contestant (name, age, club, sex) VALUES ('David Wilson', 29, 'Klub C', 'M');
INSERT INTO contestant (name, age, club, sex) VALUES ('Olivia Martinez', 24, 'Klub A', 'F');
INSERT INTO contestant (name, age, club, sex) VALUES ('James Anderson', 30, 'Klub B', 'M');
INSERT INTO contestant (name, age, club, sex) VALUES ('Sophia Garcia', 25, 'Klub C', 'F');
INSERT INTO contestant (name, age, club, sex) VALUES ('Daniel Taylor', 32, 'Klub A', 'M');

INSERT INTO discipline (name, result_type) VALUES ('100-meterløb', 'Tid');
INSERT INTO discipline (name, result_type) VALUES ('Diskoskast', 'Afstand');
INSERT INTO discipline (name, result_type) VALUES ('Boksning', 'Points');

INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (1, 1);
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (1, 2);
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (2, 1);

INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (3, 1);
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (3, 3);
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (4, 2);
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (5, 1);
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (5, 2);
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (5, 3);
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (6, 3);
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (7, 1);
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (8, 2);
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (8, 3);
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (9, 1);
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (10, 1);
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (10, 2);

INSERT INTO result (date, result_value, contestant_id, discipline_id)
VALUES (CURDATE(), '00:06:00:00', 1, 1);
INSERT INTO result (date, result_value, contestant_id, discipline_id)
VALUES (CURDATE(), '100', 1, 2);
INSERT INTO result (date, result_value, contestant_id, discipline_id)
VALUES (CURDATE(), '00:10:00:00', 2, 1);
INSERT INTO result (date, result_value, contestant_id, discipline_id)
VALUES (CURDATE(), '00:12:00:00', 9, 1);
INSERT INTO result (date, result_value, contestant_id, discipline_id)
VALUES (CURDATE(), '00:11:00:00', 10, 1);
INSERT INTO result (date, result_value, contestant_id, discipline_id)
VALUES (CURDATE(), '120', 10, 2);
INSERT INTO result (date, result_value, contestant_id, discipline_id)
VALUES (CURDATE(), '00:09:30:00', 5, 1);
INSERT INTO result (date, result_value, contestant_id, discipline_id)
VALUES (CURDATE(), '300', 5, 3);
INSERT INTO result (date, result_value, contestant_id, discipline_id)
VALUES (CURDATE(), '110', 4, 2);
INSERT INTO result (date, result_value, contestant_id, discipline_id)
VALUES (CURDATE(), '250', 6, 3);
INSERT INTO result (date, result_value, contestant_id, discipline_id)
VALUES (CURDATE(), '130', 8, 2);
INSERT INTO result (date, result_value, contestant_id, discipline_id)
VALUES (CURDATE(), '320', 8, 3);
INSERT INTO result (date, result_value, contestant_id, discipline_id)
VALUES (CURDATE(), '00:11:45:00', 7, 1);