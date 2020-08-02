DROP TABLE IF EXISTS publishers CASCADE;

CREATE TABLE publishers(
	ID TEXT PRIMARY KEY,
	"name" VARCHAR(255) UNIQUE NOT NULL
);

INSERT INTO publishers (ID, "name") VALUES
    ('2ak','William Heinemann'),
    ('112','Poltex'),
    ('83f','StoryBox'),
    ('5k4','Vintage'),
    ('cub','Chatto & Windus'),
    ('2g8','Wordsworth');