DROP TABLE IF EXISTS authors CASCADE;

CREATE TABLE authors(
	ID serial PRIMARY KEY,
	"first_name" VARCHAR(50) NOT NULL,
  	"surname" VARCHAR(50) NOT NULL
);

INSERT INTO authors ("first_name", "surname") VALUES
	('Tom',	'Hanks'),
    ('Dexter', 'Dias'),
    ('Jane', 'Austen'),
    ('Gunter', 'Grass'),
    ('Deborah', 'Moggah'),
    ('Margaret', 'Atwood'),
    ('Nigella', 'Lawson'),
    ('Mark', 'Twain');