create table vending_machine_field
(
    id                  bigserial                                       not null,
    field_id_in_machine integer                                         not null,
    machine_id          bigint                                          not null
        constraint vending_machine_field_vending_machine_id_fk
            references vending_machine,
    first_item_id       bigint
        constraint vending_machine_field_item_id_fk
            references item,
    second_item_id      bigint
        constraint vending_machine_field_item_id_fk_2
            references item,
    status              varchar(25) default 'ACTIVE'::character varying not null,
    created             timestamp   default CURRENT_TIMESTAMP           not null,
    updated             timestamp   default CURRENT_TIMESTAMP           not null
);

alter table vending_machine_field
    owner to postgres;

create unique index vending_machine_field_id_uindex
    on vending_machine_field (id);

INSERT INTO imperva_db.vending_machine_field (id, field_id_in_machine, machine_id, first_item_id, second_item_id, status, created, updated) VALUES (1, 1, 1, 2, 3, 'ACTIVE', '2021-07-30 01:19:37.314508', '2021-07-30 01:19:37.314508');
INSERT INTO imperva_db.vending_machine_field (id, field_id_in_machine, machine_id, first_item_id, second_item_id, status, created, updated) VALUES (2, 2, 1, 4, 3, 'ACTIVE', '2021-07-30 01:21:05.617621', '2021-07-30 01:21:05.617621');
INSERT INTO imperva_db.vending_machine_field (id, field_id_in_machine, machine_id, first_item_id, second_item_id, status, created, updated) VALUES (3, 1, 2, 3, 3, 'ACTIVE', '2021-07-30 01:22:23.354512', '2021-07-30 01:22:23.354512');
INSERT INTO imperva_db.vending_machine_field (id, field_id_in_machine, machine_id, first_item_id, second_item_id, status, created, updated) VALUES (4, 2, 2, 2, 3, 'ACTIVE', '2021-07-30 01:22:23.354512', '2021-07-30 01:22:23.354512');