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



