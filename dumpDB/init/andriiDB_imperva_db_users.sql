create table users
(
    id         serial                                          not null
        constraint users_pkey
            primary key,
    username   varchar(100)                                    not null
        constraint username
            unique,
    email      varchar(255)                                    not null
        constraint email
            unique,
    first_name varchar(100)                                    not null,
    last_name  varchar(100)                                    not null,
    password   varchar(255)                                    not null,
    created    timestamp   default CURRENT_TIMESTAMP           not null,
    updated    timestamp   default CURRENT_TIMESTAMP           not null,
    status     varchar(25) default 'ACTIVE'::character varying not null,
    gender     varchar(10)
);

alter table users
    owner to postgres;

INSERT INTO imperva_db.users (id, username, email, first_name, last_name, password, created, updated, status, gender) VALUES (6, 'admin', 'sfadf', 'sdfsdf', 'sdfsdf', '$2a$10$y4WUFXV4e.WD/2deJ4rQy.wr7hOAhjSZ1UPtq0gX05dVFSYEPjkAS', '2021-07-30 03:25:35.240000', '2021-07-30 03:25:35.240000', 'ACTIVE', 'male');