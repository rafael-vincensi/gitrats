-- V1__create_initial_schema.sql

CREATE TABLE users (
    id              BIGSERIAL PRIMARY KEY,
    username        VARCHAR(255) NOT NULL,
    display_name    VARCHAR(255),
    bio             VARCHAR(255),
    profile_picture TEXT,
    created_at      TIMESTAMP NOT NULL,
    updated_at      TIMESTAMP,
    CONSTRAINT uq_users_username UNIQUE (username)
);

CREATE TABLE groups (
    id            BIGSERIAL PRIMARY KEY,
    name          VARCHAR(255),
    code          VARCHAR(6) NOT NULL,
    group_picture TEXT,
    created_at    TIMESTAMP NOT NULL,
    CONSTRAINT uq_groups_code UNIQUE (code)
);

CREATE TABLE checkins (
    id          BIGSERIAL PRIMARY KEY,
    title       VARCHAR(255),
    title_type  VARCHAR(255),
    description VARCHAR(255),
    img_url     TEXT,
    created_at  TIMESTAMP NOT NULL,
    user_id     BIGINT NOT NULL,
    CONSTRAINT fk_checkins_user FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE group_member (
   id         BIGSERIAL PRIMARY KEY,
   user_id    BIGINT NOT NULL,
   group_id   BIGINT NOT NULL,
   joined_at  TIMESTAMP NOT NULL,
   CONSTRAINT fk_group_member_user
   FOREIGN KEY (user_id) REFERENCES users(id),
   CONSTRAINT fk_group_member_group
   FOREIGN KEY (group_id) REFERENCES groups(id),
   CONSTRAINT uq_group_member_user_group
   UNIQUE (user_id, group_id)
);

CREATE INDEX idx_checkins_user_id ON checkins(user_id);
CREATE INDEX idx_group_member_user_id ON group_member(user_id);
CREATE INDEX idx_group_member_group_id ON group_member(group_id);