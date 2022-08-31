create table orders
(
    id          INT                                not null,
    customer_id varchar(40)                        not null,
    order_date  DATETIME default CURRENT_TIMESTAMP not null,
    created_on  DATETIME default CURRENT_TIMESTAMP null,
    updated_on  DATETIME default NULL              null on update CURRENT_TIMESTAMP,
    constraint id
        primary key (id)
);

create index customer_id_idx
    on orders (customer_id);

create table item
(
    id       int          not null,
    order_id int          not null,
    name     varchar(100) not null,
    price    double       not null,
    created_on  DATETIME default CURRENT_TIMESTAMP null,
    updated_on  DATETIME default NULL              null on update CURRENT_TIMESTAMP,
    constraint pk
        primary key (id),
    FOREIGN KEY (order_id) REFERENCES orders(id)
);

create index order_id_idx
    on item (order_id);

