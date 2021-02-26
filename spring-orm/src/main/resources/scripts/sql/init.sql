CREATE TABLE users
(
    id       BIGSERIAL PRIMARY KEY NOT NULL,
    login    VARCHAR(256)          NOT NULL UNIQUE,
    password VARCHAR(256)          NOT NULL,
    email    VARCHAR(512)          NOT NULL UNIQUE
);

CREATE TABLE item
(
    id      BIGSERIAL PRIMARY KEY NOT NULL,
    name    TEXT                  NOT NULL,
    price   DECIMAL(10, 2)        NOT NULL,
    version INTEGER DEFAULT 0     NOT NULL
);

CREATE INDEX item_name_price_idx ON item (name, price);

CREATE TABLE orders
(
    id            BIGSERIAL PRIMARY KEY                          NOT NULL,
    creation_date timestamptz                                    NOT NULL,
    state         VARCHAR(256)                                   NOT NULL,
    user_id       BIGINT REFERENCES users (id) ON DELETE CASCADE NOT NULL
);

CREATE INDEX order_state_idx ON orders (user_id, state);

CREATE TABLE item_order
(
    item_id  BIGINT REFERENCES item (id) ON DELETE CASCADE   NOT NULL,
    order_id BIGINT REFERENCES orders (id) ON DELETE CASCADE NOT NULL
);