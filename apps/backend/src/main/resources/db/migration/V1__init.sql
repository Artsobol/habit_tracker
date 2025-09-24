create schema if not exists habit_tracker;
set search_path = habit_tracker;

drop table if exists habit;
create table habit (
                       id BIGSERIAL PRIMARY KEY,
                       title VARCHAR(100) NOT NULL,
                       description TEXT,
                       status VARCHAR(7) NOT NULL DEFAULT 'ACTIVE' CHECK (status IN ('ACTIVE', 'ARCHIVE')),
                       schedule_type VARCHAR NOT NULL DEFAULT 'DAILY' CHECK (schedule_type IN ('DAILY', 'DAYS_OF_WEEK', 'N_PER_WEEK')),
                       target_per_day INTEGER,
                       target_per_week INTEGER,
                       start_date DATE,
                       end_date DATE CHECK (end_date >= start_date),
                       created_at TIMESTAMP NOT NULL DEFAULT NOW(),
                       updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);

drop table if exists habit_days;
create table habit_days (
                            habit_id BIGINT NOT NULL REFERENCES habit(id) ON DELETE CASCADE,
                            day VARCHAR(9) CHECK (day IN ('SUNDAY', 'MONDAY', 'TUESDAY', 'WEDNESDAY', 'THURSDAY', 'FRIDAY', 'SATURDAY')),

                            primary key (habit_id, day)
);