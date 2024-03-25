CREATE TABLE IF NOT EXISTS user_data(
    user_id bigint AUTO_INCREMENT PRIMARY KEY,
    email varchar(30) NOT NULL CHECK(length(email) >= 5) UNIQUE,
    password varchar(68) NOT NULL,
    is_active boolean NOT NULL DEFAULT false,
    registration_date datetime NOT NULL
    );
commit;

CREATE TABLE IF NOT EXISTS banned_user(
    user_id bigint PRIMARY KEY REFERENCES user_data(user_id),
    reason varchar(200) NOT NULL,
    ban_date datetime NOT NULL
)

