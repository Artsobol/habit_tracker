DROP TABLE IF EXISTS check_in;
CREATE TABLE check_in(
    id BIGSERIAL PRIMARY KEY,
    habit_id BIGINT NOT NULL REFERENCES habit(id) ON DELETE CASCADE,
    date DATE NOT NULL,
    amount INTEGER NOT NULL CHECK (amount >= 0),
    note TEXT,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),

    UNIQUE(habit_id, date)
);