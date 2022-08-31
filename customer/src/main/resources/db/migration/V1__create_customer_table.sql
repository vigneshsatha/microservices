create table customer
(
    id           varchar(40),
    first_name   varchar(100) null,
    last_name    varchar(100) null,
    age          int          null,
    address_line_1 varchar(100) null,
    address_line_2 varchar(100) null,
    constraint id
        primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

