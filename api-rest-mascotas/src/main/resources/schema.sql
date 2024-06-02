drop table Mascota if exists;

create table if not exists Mascota (
    id identity,
    nombre varchar(50) not null,
    fecha_nac date not null,
    raza varchar(50) not null,
    peso varchar(10) not null,
 	tiene_chip varchar(10) not null,
    url_foto varchar(50) not null
);
