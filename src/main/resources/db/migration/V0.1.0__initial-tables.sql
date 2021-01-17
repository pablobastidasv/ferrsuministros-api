CREATE TABLE products
(
    id       INT AUTO_INCREMENT,
    name     VARCHAR(200) NOT NULL,
    quantity INT          NOT NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE transactions
(
    id         INT AUTO_INCREMENT,
    type       VARCHAR(20) NOT NULL,
    quantity   INT         NOT NULL,
    product_id INT         NOT NULL,
    CONSTRAINT pk_transaction PRIMARY KEY (id),
    CONSTRAINT fk_transaction_product FOREIGN KEY (product_id) REFERENCES products (id)
);
