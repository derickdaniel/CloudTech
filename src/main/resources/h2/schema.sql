DROP TABLE IF EXISTS USER_ACCOUNT;

CREATE TABLE USER_ACCOUNT (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL,
  mobile VARCHAR(20) DEFAULT NULL,
  created_at timestamp without time zone DEFAULT CURRENT_TIME
);