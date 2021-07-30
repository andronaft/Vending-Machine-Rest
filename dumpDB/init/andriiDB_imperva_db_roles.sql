create table roles
(
    id      serial                                          not null
        constraint roles_pkey
            primary key,
    name    varchar(100)                                    not null
        constraint name
            unique,
    created timestamp   default CURRENT_TIMESTAMP           not null,
    updated timestamp   default CURRENT_TIMESTAMP           not null,
    status  varchar(25) default 'ACTIVE'::character varying not null
);

alter table roles
    owner to postgres;

INSERT INTO imperva_db.roles (id, name, created, updated, status) VALUES (1, 'ROLE_USER', '2020-04-05 18:53:36.000000', '2020-04-05 18:53:36.000000', 'ACTIVE');
INSERT INTO imperva_db.roles (id, name, created, updated, status) VALUES (2, 'ROLE_ADMIN', '2020-04-05 18:53:36.000000', '2020-04-05 18:53:36.000000', 'ACTIVE');