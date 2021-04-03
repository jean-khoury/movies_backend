CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE TABLE Movies(
    id uuid DEFAULT uuid_generate_v4 () NOT NULL,
    name varchar NOT NULL,
    genre varchar NOT NULL,
    description varchar NOT NULL,
    rating decimal(2,1),
    CONSTRAINT chk_Ratings CHECK (rating >= 0 AND rating <= 5),
    PRIMARY KEY (id)
);