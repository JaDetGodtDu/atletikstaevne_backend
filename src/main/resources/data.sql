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

INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (3, 1); -- Sarah Brown - 100-meterløb
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (3, 3); -- Sarah Brown - Boksning
-- Example 2: Single discipline
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (4, 2); -- Michael White - Diskoskast
-- Example 3: Multiple disciplines
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (5, 1); -- Emily Davis - 100-meterløb
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (5, 2); -- Emily Davis - Diskoskast
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (5, 3); -- Emily Davis - Boksning
-- Example 4: Single discipline
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (6, 3); -- David Wilson - Boksning
-- Example 5: Single discipline
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (7, 1); -- Olivia Martinez - 100-meterløb
-- Example 6: Multiple disciplines
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (8, 2); -- James Anderson - Diskoskast
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (8, 3); -- James Anderson - Boksning
-- Example 7: Single discipline
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (9, 1); -- Sophia Garcia - 100-meterløb
-- Example 8: Multiple disciplines
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (10, 1); -- Daniel Taylor - 100-meterløb
INSERT INTO contestant_discipline (contestant_id, discipline_id) VALUES (10, 2); -- Daniel Taylor - Diskoskast

INSERT INTO result (date, result_value, contestant_id, discipline_id) VALUES (CURDATE(), '00:06:00:00', 1, 1);
INSERT INTO result (date, result_value, contestant_id, discipline_id) VALUES (CURDATE(), '100', 1, 2);
INSERT INTO result (date, result_value, contestant_id, discipline_id) VALUES (CURDATE(), '00:10:00:00', 2, 1);