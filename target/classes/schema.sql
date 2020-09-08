-- Squences
CREATE SEQUENCE IF NOT EXISTS "experience_experience_id_seq";
CREATE SEQUENCE IF NOT EXISTS "experience_log_experience_log_id_seq";

-- Table Definition
CREATE TABLE IF NOT EXISTS "experience" (
    "experience_id" int4 NOT NULL DEFAULT nextval('experience_experience_id_seq'::regclass),
    "balance" int4,
    "player_id" int4 NOT NULL,
    "created_at_timestamp" timestamp NOT NULL,
    "updated_at_timestamp" timestamp NOT NULL,
    PRIMARY KEY ("experience_id")
);

CREATE TABLE IF NOT EXISTS "experience_log" (
    "experience_log_id" int4 NOT NULL DEFAULT nextval('experience_log_experience_log_id_seq'::regclass),
    "experience_id" int4 NOT NULL,
    "player_id" int4 NOT NULL,
    "amount" int4,
    "xp_type" varchar,
    "remarks" varchar,
    "created_at_timestamp" timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY ("experience_log_id")
);