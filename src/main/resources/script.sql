
CREATE TABLE kategoria (
	id INTEGER NOT NULL AUTO_INCREMENT,
    nazov VARCHAR(255) NOT NULL,
    PRIMARY KEY (id) 
);

--
ALTER TABLE uloha ADD COLUMN kategoria_id INTEGER NOT NULL DEFAULT 0;
--
INSERT INTO kategoria VALUES
(0, 'Nezaradené');

--
UPDATE kategoria SET id = 0 WHERE id = 1;

