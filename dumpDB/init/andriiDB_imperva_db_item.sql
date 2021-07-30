create table item
(
    id      bigserial                                       not null
        constraint item_pk
            primary key,
    name    text                                            not null,
    price   integer     default 10                          not null,
    created timestamp   default CURRENT_TIMESTAMP           not null,
    updated timestamp   default CURRENT_TIMESTAMP           not null,
    status  varchar(25) default 'ACTIVE'::character varying not null
);

alter table item
    owner to postgres;

INSERT INTO imperva_db.item (id, name, price, created, updated, status) VALUES (2, 'Ganta', 11, '2021-07-30 01:00:19.009351', '2021-07-30 01:00:19.009351', 'ACTIVE');
INSERT INTO imperva_db.item (id, name, price, created, updated, status) VALUES (3, 'Sola-Cola', 12, '2021-07-30 01:00:35.141478', '2021-07-30 01:00:35.141478', 'ACTIVE');
INSERT INTO imperva_db.item (id, name, price, created, updated, status) VALUES (4, 'Xprite', 11, '2021-07-30 01:01:14.855525', '2021-07-30 01:01:14.855525', 'ACTIVE');
INSERT INTO imperva_db.item (id, name, price, created, updated, status) VALUES (1, 'Tarhun', 9, '2021-07-30 02:18:43.481208', '2021-07-30 02:18:43.481208', 'ACTIVE');
INSERT INTO imperva_db.item (id, name, price, created, updated, status) VALUES (6, 'Shmirimda', 5, '2021-07-30 05:23:37.266463', '2021-07-30 05:23:37.266463', 'ACTIVE');