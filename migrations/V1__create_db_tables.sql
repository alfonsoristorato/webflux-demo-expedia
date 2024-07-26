CREATE
EXTENSION IF NOT EXISTS moddatetime;

CREATE TABLE post
(
    id         UUID    NOT NULL,
    user_id    VARCHAR NOT NULL,
    content    VARCHAR NULL,
    tags       VARCHAR[] NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at TIMESTAMP WITHOUT TIME ZONE NULL,
    CONSTRAINT pk_post PRIMARY KEY (id),
);
CREATE TRIGGER update_timestamp
    BEFORE UPDATE
    ON post
    FOR EACH ROW
    EXECUTE PROCEDURE moddatetime(updated_at);

CREATE TABLE comment
(
    id         UUID    NOT NULL,
    user_id    VARCHAR NOT NULL,
    post_id    UUID    NOT NULL,
    comment    TEXT    NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at TIMESTAMP WITHOUT TIME ZONE NULL,
    CONSTRAINT fk_comment_post_id FOREIGN KEY (post_id) REFERENCES post (id) ON DELETE CASCADE,
    CONSTRAINT pk_comment PRIMARY KEY (id)
);
CREATE TRIGGER update_timestamp
    BEFORE UPDATE
    ON comment
    FOR EACH ROW
    EXECUTE PROCEDURE moddatetime(updated_at);

-- CREATE TABLE reaction
-- (
--     id            UUID    NOT NULL,
--     user_id       VARCHAR NOT NULL,
--     post_id       UUID NULL,
--     reaction_type VARCHAR NOT NULL,
--     created_at    TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
--     updated_at    TIMESTAMP WITHOUT TIME ZONE NULL,
--     CONSTRAINT fk_reaction_post_id FOREIGN KEY (post_id) REFERENCES post (id) ON DELETE CASCADE,
--     CONSTRAINT unique_reaction_user_id_and_post_id UNIQUE (user_id, post_id),
--     CONSTRAINT pk_reaction PRIMARY KEY (id)
-- );
-- CREATE TRIGGER update_timestamp
--     BEFORE UPDATE
--     ON reaction
--     FOR EACH ROW
--     EXECUTE PROCEDURE moddatetime(updated_at);
