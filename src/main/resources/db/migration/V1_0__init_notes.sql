CREATE TABLE IF NOT EXISTS workspace (
    id              INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name            TEXT NOT NULL UNIQUE,
    created_at      TIMESTAMPTZ DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS book (
    id              INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name            TEXT NOT NULL UNIQUE,
    workspace_id    INT REFERENCES workspace(id) ON DELETE CASCADE,
    created_at      TIMESTAMPTZ DEFAULT NOW(),
    updated_at      TIMESTAMPTZ DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS chapter (
    id              INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name            TEXT,
    book_id         INT REFERENCES book(id) ON DELETE CASCADE,
    created_at      TIMESTAMPTZ DEFAULT NOW(),
    updated_at      TIMESTAMPTZ DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS page (
    id                 BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    page_number        INT NOT NULL,
    content            JSONB NOT NULL,
    chapter_id         INT REFERENCES chapter(id) ON DELETE CASCADE,
    book_id            INT REFERENCES book(id) ON DELETE CASCADE,
    created_at         TIMESTAMPTZ DEFAULT NOW(),
    updated_at         TIMESTAMPTZ DEFAULT NOW()
);
ALTER TABLE page ADD CONSTRAINT unique_page_number_per_book UNIQUE (book_id, page_number);