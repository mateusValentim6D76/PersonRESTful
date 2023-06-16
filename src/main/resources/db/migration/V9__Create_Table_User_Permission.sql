CREATE TABLE IF NOT EXISTS user_permission (
  id_user SERIAL NOT NULL,
  id_permission SERIAL NOT NULL,
  fk_user_id_permission SERIAL NOT NULL,
  fk_user_permission_permission SERIAL NOT NULL,
  PRIMARY KEY (id_user, id_permission),
  FOREIGN KEY (fk_user_id_user) REFERENCES users(id),
  FOREIGN KEY (fk_user_permission_permission) REFERENCES permission(id)
)