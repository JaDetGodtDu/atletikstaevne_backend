
INSERT INTO contestant (name, age, club, sex) VALUES ('Beni Bingus', '1996-01-01', 'Klub A', 'M');
INSERT INTO contestant (name, age, club, sex) VALUES ('Jane Doe', '1991-01-01', 'Klub B', 'F');
INSERT INTO contestant (name, age, club, sex) VALUES ('Alice Smith', '1993-01-01', 'Klub A', 'F');
INSERT INTO contestant (name, age, club, sex) VALUES ('John Johnson', '1994-01-01', 'Klub B', 'M');
INSERT INTO contestant (name, age, club, sex) VALUES ('Sarah Brown', '1998-01-01', 'Klub C', 'F');
INSERT INTO contestant (name, age, club, sex) VALUES ('Michael White', '1990-01-01', 'Klub A', 'M');
INSERT INTO contestant (name, age, club, sex) VALUES ('Emily Davis', '1995-01-01', 'Klub B', 'F');
INSERT INTO contestant (name, age, club, sex) VALUES ('David Wilson', '1992-01-01', 'Klub C', 'M');
INSERT INTO contestant (name, age, club, sex) VALUES ('Olivia Martinez', '1997-01-01', 'Klub A', 'F');
INSERT INTO contestant (name, age, club, sex) VALUES ('James Anderson', '1991-01-01', 'Klub B', 'M');
INSERT INTO contestant (name, age, club, sex) VALUES ('Sophia Garcia', '1996-01-01', 'Klub C', 'F');
INSERT INTO contestant (name, age, club, sex) VALUES ('Daniel Taylor', '1989-01-01', 'Klub A', 'M');

INSERT INTO contestant (name, age, club, sex) VALUES ('Barn 1', '2016-01-01', 'Klub A', 'M');
INSERT INTO contestant (name, age, club, sex) VALUES ('Barn 2', '2015-01-01', 'Klub B', 'F');
INSERT INTO contestant (name, age, club, sex) VALUES ('Ung 1', '2012-01-01', 'Klub A', 'M');
INSERT INTO contestant (name, age, club, sex) VALUES ('Ung 2', '2011-01-01', 'Klub B', 'F');
INSERT INTO contestant (name, age, club, sex) VALUES ('Junior 1', '2008-01-01', 'Klub A', 'M');
INSERT INTO contestant (name, age, club, sex) VALUES ('Junior 2', '2003-01-01', 'Klub B', 'F');
INSERT INTO contestant (name, age, club, sex) VALUES ('Senior 1', '1980-01-01', 'Klub A', 'M');
INSERT INTO contestant (name, age, club, sex) VALUES ('Senior 2', '1970-01-01', 'Klub B', 'F');

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
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (11, 3);
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (12, 1);
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (13, 1);
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (14, 2);
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (15, 1);
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (16, 2);
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (17, 1);
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (17, 2);
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (18, 1);
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (19, 2);
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (19, 3);
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (20, 1);
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (20, 2);

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