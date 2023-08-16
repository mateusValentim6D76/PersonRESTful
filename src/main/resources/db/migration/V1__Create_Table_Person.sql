CREATE TABLE person (
  id bigint NOT NULL AUTO_INCREMENT,
  address varchar(90) NOT NULL,
  first_name varchar(80) NOT NULL,
  gender varchar(6) NOT NULL,
  last_name varchar(80) NOT NULL,
  registration_date date time(6) NOT NULL,
  PRIMARY KEY (id)
)