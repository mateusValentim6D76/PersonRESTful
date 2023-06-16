CREATE TABLE IF NOT EXISTS person (
  id SERIAL NOT NULL PRIMARY KEY,
  address varchar(90) NOT NULL,
  first_name varchar(80) NOT NULL,
  gender varchar(6) NOT NULL,
  last_name varchar(80) NOT NULL
)