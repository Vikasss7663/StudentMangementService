CREATE TABLE IF NOT EXISTS  student (
school_id INT AUTO_INCREMENT,
school_name varchar(255) NOT NULL,
email_to varchar(255) NOT NULL,
email_bcc varchar(255) NOT NULL,
email_cc varchar(255) NOT NULL,
PRIMARY KEY(school_id)
);