-- Oracle 12c+ (XE). Run as the user configured in DBConnection.java
CREATE TABLE home_user (
    user_id        NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    username       VARCHAR2(50)  NOT NULL UNIQUE,
    user_password  VARCHAR2(255) NOT NULL
);

CREATE TABLE history (
    history_id      NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    user_id         NUMBER         NOT NULL,
    system_name     VARCHAR2(50)   NOT NULL,
    action          VARCHAR2(500)  NOT NULL,
    exp             VARCHAR2(1000) NOT NULL,
    operation_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT fk_history_user FOREIGN KEY (user_id) REFERENCES home_user(user_id)
);
