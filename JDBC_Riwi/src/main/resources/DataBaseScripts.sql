CREATE TABLE aeroplanes(
	`id` int primary key not null auto_increment,
    `model` varchar(10),
    `capacity` int
);

CREATE TABLE IF NOT EXISTS flights(
	`id` int primary key not null auto_increment,
	`destination` varchar(90),
    `departure_date` date,
    `departure_time` time,
    `id_aeroplane` int,
    foreign key (`id_aeroplane`) references aeroplanes(`id`)
);

CREATE TABLE IF NOT EXISTS passengers(
	`id` int primary key not null auto_increment,
	`name` varchar(20),
	`last_name` varchar(20),
    `doi` varchar(10)
);

CREATE TABLE IF NOT EXISTS reservations(
	`id` int primary key not null auto_increment,
	`id_passenger` int,
    `id_flight` int,
    `reservation_date` date,
    `seat` varchar(5),
    foreign key (`id_passenger`) references passengers(`id`),
    foreign key (`id_flight`) references flights(`id`)
);

INSERT INTO aeroplanes (model, capacity) VALUES ('A380', 555);
INSERT INTO aeroplanes (model, capacity) VALUES ('B747', 400);
INSERT INTO aeroplanes (model, capacity) VALUES ('B737', 160);
INSERT INTO aeroplanes (model, capacity) VALUES ('A321', 220);
INSERT INTO aeroplanes (model, capacity) VALUES ('B787', 242);

INSERT INTO passengers (name, last_name, doi) VALUES ('Jesucristo', 'García', 'A123456789');
INSERT INTO passengers (name, last_name, doi) VALUES ('Pepito', 'Pérez', 'B987654321');
INSERT INTO passengers (name, last_name, doi) VALUES ('Luis', 'Rodríguez', 'C123456789');
INSERT INTO passengers (name, last_name, doi) VALUES ('Anita', 'Huerfanita', 'D987654321');
INSERT INTO passengers (name, last_name, doi) VALUES ('Quesocolo', 'Torombolo', 'E123456789');

INSERT INTO flights (destination, departure_date, departure_time, id_aeroplane) VALUES ('New York', '2024-08-15', '08:30:00', 1);
INSERT INTO flights (destination, departure_date, departure_time, id_aeroplane) VALUES ('Madrid', '2024-08-16', '14:45:00', 2);
INSERT INTO flights (destination, departure_date, departure_time, id_aeroplane) VALUES ('Tokyo', '2024-08-17', '22:00:00', 3);
INSERT INTO flights (destination, departure_date, departure_time, id_aeroplane) VALUES ('São Paulo', '2024-08-18', '06:15:00', 4);
INSERT INTO flights (destination, departure_date, departure_time, id_aeroplane) VALUES ('Paris', '2024-08-19', '17:30:00', 5);






