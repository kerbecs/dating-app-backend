CREATE TABLE reset_password_token(
  reset_pass_token_id varchar(100) PRIMARY KEY ,
  generation_date datetime NOT NULL,
  user_id bigint REFERENCES user_data(user_id)
);