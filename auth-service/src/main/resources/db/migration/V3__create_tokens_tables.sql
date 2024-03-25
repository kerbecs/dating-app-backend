CREATE TABLE IF NOT EXISTS login_token(
    login_token_id char(36) PRIMARY KEY,
    user_id bigint REFERENCES user_data(user_id),
    generation_date datetime NOT NULL
);

CREATE TABLE IF NOT EXISTS mail_token(
    mail_token_id char(36) PRIMARY KEY,
    user_id bigint REFERENCES user_data(user_id),
    generation_date datetime NOT NULL
)

