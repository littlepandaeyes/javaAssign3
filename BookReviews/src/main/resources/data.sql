INSERT INTO MY_USER_DETAILS
(USERNAME, PASSWORD, ROLES, ACCOUNT_NON_EXPIRED, ACCOUNT_NON_LOCKED, CREDENTIALS_NON_EXPIRED, ENABLED)
VALUES('bob', 'pass', 'ROLE_USER', TRUE, TRUE, TRUE, TRUE);

INSERT INTO book (title, author) VALUES ('Q-Squared', 'Peter David');
INSERT INTO book (title, author) VALUES ('Silo', 'Hugh Howey');
INSERT INTO book (title, author) VALUES ('Solo Leveling', 'Chu gong');

INSERT INTO review (book_id, review) VALUES (1, 'fascinating');
INSERT INTO review (book_id, review) VALUES (1, 'generational');
INSERT INTO review (book_id, review) VALUES (1, 'could not put down');

INSERT INTO review (book_id, review) VALUES (2, 'riveting');
INSERT INTO review (book_id, review) VALUES (2, 'inspired');
INSERT INTO review (book_id, review) VALUES (2, 'I would watch');

INSERT INTO review (book_id, review) VALUES (3, 'fast paced');
INSERT INTO review (book_id, review) VALUES (3, 'amazing art');
INSERT INTO review (book_id, review) VALUES (3, 'need the next chapter');
