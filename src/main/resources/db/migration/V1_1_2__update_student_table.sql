ALTER TABLE student
ADD COLUMN school_id INT NOT NULL;

ALTER TABLE student
ADD FOREIGN KEY (school_id) REFERENCES school(school_id);