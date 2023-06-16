CREATE TABLE books (
  id SERIAL PRIMARY KEY,
  author text,
  launch_date timestamp(6) NOT NULL,
  price decimal(65,2) NOT NULL,
  title text
)
