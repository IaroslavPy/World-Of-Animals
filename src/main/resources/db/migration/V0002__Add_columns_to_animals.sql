ALTER TABLE animals
ADD COLUMN sex ENUM('M', 'F') NOT NULL,
ADD COLUMN age VARCHAR(128) NOT NULL,
ADD COLUMN size VARCHAR(128) NOT NULL;