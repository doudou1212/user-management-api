CREATE TABLE consumer (
    id              SERIAL         NOT NULL,
    email           VARCHAR(128)    NOT NULL,
    name            VARCHAR(128)    NOT NULL,
    age             INTEGER         NOT NULL,
    created_at      TIMESTAMP WITH TIME ZONE    DEFAULT NOW(),
    updated_at      TIMESTAMP WITH TIME ZONE    DEFAULT NOW(),
    PRIMARY KEY (id)
);
