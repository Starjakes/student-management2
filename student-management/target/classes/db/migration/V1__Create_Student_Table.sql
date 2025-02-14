-- Create students table
CREATE TABLE students (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    course VARCHAR(100) NOT NULL,
    date_of_birth DATE NOT NULL,
    phone_number VARCHAR(15) UNIQUE,
    gender VARCHAR(10) NOT NULL,
    address VARCHAR(255),
    is_active BOOLEAN NOT NULL DEFAULT TRUE
);
