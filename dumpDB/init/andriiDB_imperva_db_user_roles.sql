create table user_roles
(
    user_id bigint
        constraint fk_user_roles_user
            references users
            on delete cascade,
    role_id bigint
        constraint fk_user_roles_roles
            references roles
            on delete cascade
);

alter table user_roles
    owner to postgres;

INSERT INTO imperva_db.user_roles (user_id, role_id) VALUES (6, 1);
INSERT INTO imperva_db.user_roles (user_id, role_id) VALUES (6, 2);