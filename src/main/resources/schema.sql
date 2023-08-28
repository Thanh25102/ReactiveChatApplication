CREATE TABLE IF NOT EXISTS users
(
    id       UUID         NOT NULL PRIMARY KEY,
    fullName VARCHAR(255) NOT NULL,
    email    VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);
CREATE TABLE IF NOT EXISTS CONVERSIONS
(
    id   UUID NOT NULL PRIMARY KEY,
    name VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS MESSAGES
(
    id              UUID NOT NULL PRIMARY KEY,
    message_text    VARCHAR(255),
    conversation_id UUID NOT NULL,

    FOREIGN KEY (conversation_id) REFERENCES CONVERSIONS (id)
);
CREATE TABLE IF NOT EXISTS GROUP_MEMBER
(
    user_id         UUID      NOT NULL,
    conversation_id UUID      NOT NULL,
    joined_datetime TIMESTAMP NOT NULL,
    left_datetime   TIMESTAMP NOT NULL,

    PRIMARY KEY (user_id, conversation_id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (conversation_id) REFERENCES CONVERSIONS (id)
);
