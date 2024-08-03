create database simu_jdbc;
use simu_jdbc;

create table if not exists coders(
    `id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `doi` VARCHAR(10) UNIQUE,
    `name` VARCHAR(30),
    `last_name` VARCHAR(30),
    `clan` VARCHAR(30),
    `technology` VARCHAR(10)
);

create table if not exists companies(
    `id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(90),
    `address` VARCHAR(120)
);

create table if not exists vacancies(
    `id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(90),
    `description` TEXT,
    `technology` VARCHAR(10),
    `status` ENUM('ACTIVE', 'INACTIVE') DEFAULT 'INACTIVE',
    `dor` DATE NOT NULL,
    `company_id` INT,
    FOREIGN KEY (`company_id`) REFERENCES companies(`id`) ON DELETE CASCADE
);

create table if not exists hirings(
    `id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `coder_id` INT,
    `vacancy_id` INT,
    `salary` DECIMAL(6,2),
    `doh` DATE NOT NULL,
    FOREIGN KEY (`coder_id`) REFERENCES coders(`id`) ON DELETE CASCADE,
    FOREIGN KEY (`vacancy_id`) REFERENCES vacancies(`id`) ON DELETE CASCADE
);
-- Poblar tabla coders
INSERT INTO coders (doi, name, last_name, clan, technology) VALUES ('1234567890', 'Pepito', 'Pérez', 'Jeff Bezos', 'Python');
INSERT INTO coders (doi, name, last_name, clan, technology) VALUES ('0987654321', 'Anita', 'Huerfanita', 'Berners Lee', 'Java');
INSERT INTO coders (doi, name, last_name, clan, technology) VALUES ('1122334455', 'Simón', 'Bobito', 'Ritchie', 'JavaScript');
INSERT INTO coders (doi, name, last_name, clan, technology) VALUES ('2233445566', 'Fulanita', 'de Tal', 'Lovelace', 'Ruby');
INSERT INTO coders (doi, name, last_name, clan, technology) VALUES ('3344556677', 'Juanito', 'Alimaña', 'Meta', 'C++');
-- Poblar tabla companies
INSERT INTO companies (name, address) VALUES ('Innovaciones Tecnológicas S.A.S.', 'Calle 100 #11-22, Oficina 303, Bogotá, Cundinamarca');
INSERT INTO companies (name, address) VALUES ('Soluciones Ambientales Ltda.', 'Carrera 15 #45-67, Edificio Verde, Medellín, Antioquia');
INSERT INTO companies (name, address) VALUES ('Empresas Futuro S.A.', 'Avenida El Dorado #60-12, Piso 7, Bogotá, Cundinamarca');
-- Poblar tabla vacancies
INSERT INTO vacancies (title, description, technology, status, dor, company_id) 
VALUES (
    'Senior Software Developer', 
    'Looking for an experienced software developer to work on innovative tech projects. Must have experience with Python and Django.', 
    'Python', 
    'ACTIVE', 
    '2024-08-01', 
    1  
);
INSERT INTO vacancies (title, description, technology, status, dor, company_id) 
VALUES (
    'Front-End Developer', 
    'Join our team as a front-end developer. Expertise in JavaScript, React, and UI/UX design required.', 
    'JavaScript', 
    'INACTIVE', 
    '2024-08-01', 
    2
);
INSERT INTO vacancies (title, description, technology, status, dor, company_id) 
VALUES (
    'Database Administrator', 
    'Seeking a skilled Database Administrator to manage and optimize our database systems. Experience with SQL and NoSQL databases is essential.', 
    'SQL', 
    'ACTIVE', 
    '2024-08-01', 
    3
);
INSERT INTO vacancies (title, description, technology, status, dor, company_id) 
VALUES (
    'Backend Engineer', 
    'We need a backend engineer with experience in Node.js and microservices architecture. Strong problem-solving skills required.', 
    'Node.js', 
    'ACTIVE', 
    '2024-08-01', 
    1 
);
INSERT INTO vacancies (title, description, technology, status, dor, company_id) 
VALUES (
    'UX/UI Designer', 
    'A creative UX/UI Designer is needed to enhance user experiences for our web and mobile applications. Experience with Adobe XD and Figma is a plus.', 
    'Design', 
    'INACTIVE', 
    '2024-08-01', 
    2 
);
-- Poblar tabla hirings
INSERT INTO hirings (coder_id, vacancy_id, salary, doh) 
VALUES (
    4,  -- Coder with ID 4
    2,  -- Vacancy with ID 2
    7000.00,  -- Salary
    '2024-08-22'  -- Date of Hiring
);
INSERT INTO hirings (coder_id, vacancy_id, salary, doh) 
VALUES (
    5,  -- Coder with ID 5
    1,  -- Vacancy with ID 1
    7400.00,  -- Salary
    '2024-08-25'  -- Date of Hiring
);
INSERT INTO hirings (coder_id, vacancy_id, salary, doh) 
VALUES (
    2,  -- Coder with ID 2
    3,  -- Vacancy with ID 3
    6900.00,  -- Salary
    '2024-08-28'  -- Date of Hiring
);
INSERT INTO hirings (coder_id, vacancy_id, salary, doh) 
VALUES (
    1,  -- Coder with ID 1
    4,  -- Vacancy with ID 4
    7800.00,  -- Salary
    '2024-08-30'  -- Date of Hiring
);



