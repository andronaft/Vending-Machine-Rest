create table vending_machine
(
    id              bigserial                                       not null
        constraint vending_machine_pk
            primary key,
    name            varchar(10),
    location        text,
    status          varchar(25) default 'ACTIVE'::character varying not null,
    created         timestamp   default CURRENT_TIMESTAMP           not null,
    updated         timestamp   default CURRENT_TIMESTAMP           not null,
    current_deposit integer     default 0                           not null,
    deposit         integer     default 0                           not null
);

alter table vending_machine
    owner to postgres;

create unique index vending_machine_id_uindex
    on vending_machine (id);

INSERT INTO imperva_db.vending_machine (id, name, location, status, created, updated, current_deposit, deposit) VALUES (2, 'Cute Snail', '50.442526, 30.575322', 'ACTIVE', '2021-07-30 00:50:44.481271', '2021-07-30 00:50:44.481271', 0, 0);
INSERT INTO imperva_db.vending_machine (id, name, location, status, created, updated, current_deposit, deposit) VALUES (1, 'Funny Cow', '50.492232, 30.400979', 'ACTIVE', '2021-07-30 00:49:07.459237', '2021-07-30 00:49:07.459237', 0, 0);