INSERT INTO contestant (name, age, club, sex) VALUES ('Beni Bingus', 25, 'Klub A', 'M');
INSERT INTO contestant (name, age, club, sex) VALUES ('Jane Doe', 30, 'Klub B', 'F');

INSERT INTO discipline (name, result_type) VALUES ('100-meterløb', 'Tid');
INSERT INTO discipline (name, result_type) VALUES ('Diskoskast', 'Afstand');
INSERT INTO discipline (name, result_type) VALUES ('Boksning', 'Points');

INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (1, 1);
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (1, 2);
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (2, 1);

INSERT INTO result (date, result_value, contestant_id, discipline_id) VALUES (CURDATE(), '00:06:00:00', 1, 1);
INSERT INTO result (date, result_value, contestant_id, discipline_id) VALUES (CURDATE(), '100', 1, 2);
INSERT INTO result (date, result_value, contestant_id, discipline_id) VALUES (CURDATE(), '00:10:00:00', 2, 1);