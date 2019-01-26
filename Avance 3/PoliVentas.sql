drop database if exists db_poliVentas ;
create database db_poliVentas;
use db_poliVentas;

create table tbl_categoria(
	idCategoria int auto_increment primary key ,
    nombre varchar(30),
    descripcion varchar(50)
    );
    
create table tbl_rol(
	idRol int auto_increment primary key ,
    tipo varchar(15),
    descripcion varchar(50)
    );

create table tbl_estadoVenta(
	idEstadoVenta int auto_increment primary key ,
    estadoVenta varchar(10),
    descripcion varchar(20)
    );
    
create table tbl_tipoPago(
	idtipoPago int auto_increment primary key ,
    tipo varchar(15),
    descripcion varchar(20)
    );
    
create table tbl_persona(
	cedula varchar(10) primary key,
    nombres varchar(20),
    apellidos varchar(20),
    telefono varchar(10),
    tieneWhatsapp boolean,
    email varchar(30),
    direccion varchar(30),
    rol int,
    foreign key (rol) references tbl_rol(idRol)
    );
create table tbl_usuario(
	usuario varchar(8),
    contrasena varchar(10),
    persona varchar(10),
    foreign key (persona) references tbl_persona(cedula)
    );    

    
create table tbl_articulo(
	idArticulo int auto_increment primary key,
    vendedor varchar(10),
    nombre varchar(20),
    categoria int,
    precio float,
    tiempoEntrega varchar(5),
    vecesBuscados int,
    descripcion varchar(50),
    fechaPublicacion date,
    foreign key (categoria) references tbl_categoria(idCategoria),
    foreign key (vendedor) references tbl_persona(cedula)
    );
    
create table tbl_venta(
	idVenta int auto_increment primary key,
    estadoVenta int,
    fecha date,
    total float,
    vendedor varchar(10),
    comprador varchar(10),
    articulo int,
    calificacionArticulo float,
    calificacionVendedor float,
    foreign key (articulo) references tbl_articulo(idArticulo),
    foreign key (vendedor) references tbl_persona(cedula),
    foreign key (comprador) references tbl_persona(cedula),
    foreign key (estadoVenta) references tbl_estadoVenta(idEstadoVenta)
    );
    
create table tbl_pago(
	idPago int auto_increment primary key ,
    venta int,
    tipo int,
    descripcion varchar(20),
    foreign key (venta) references tbl_venta(idVenta),
    foreign key (tipo) references tbl_tipopago(idTipoPago)
    );
    


INSERT INTO `db_poliventas`.`tbl_rol` (`tipo`, `descripcion`) VALUES ('admin', 'administrador de articulos y usuarios');
INSERT INTO `db_poliventas`.`tbl_rol` (`tipo`, `descripcion`) VALUES ('vendedor', 'usa funciones de comprador');
INSERT INTO `db_poliventas`.`tbl_rol` (`tipo`, `descripcion`) VALUES ('comprador', 'tiene ciertas restircciones');
INSERT INTO `db_poliventas`.`tbl_persona` (`cedula`, `nombres`, `apellidos`, `telefono`, `tieneWhatsapp`, `email`, `direccion`, `rol`) VALUES ('0950467290', 'Eileen', 'Sanchez', '0987654321', '1', 'eileen_sanchez@hotmail.es', 'Cristobal Colon 131 y Salinas', '1');
INSERT INTO `db_poliventas`.`tbl_persona` (`cedula`, `nombres`, `apellidos`, `telefono`, `tieneWhatsapp`, `email`, `direccion`, `rol`) VALUES ('0987654321', 'Belen', 'Sanchez', '0987654321', '0', 'eileen_sanchez@hotmail.es', 'Cristobal Colon 131 y Salinas', '2');
INSERT INTO `db_poliventas`.`tbl_persona` (`cedula`, `nombres`, `apellidos`, `telefono`, `tieneWhatsapp`, `email`, `direccion`, `rol`) VALUES ('0999999999', 'Belencita', 'Sanchez', '0987654321', '1', 'eileen_sanchez@hotmail.es', 'Cristobal Colon 131 y Salinas', '3');
INSERT INTO `db_poliventas`.`tbl_usuario` (`usuario`, `contrasena`, `persona`) VALUES ('eibesanc','1234','0950467290');
INSERT INTO `db_poliventas`.`tbl_usuario` (`usuario`, `contrasena`, `persona`) VALUES ('eileen','4321','0987654321');
INSERT INTO `db_poliventas`.`tbl_usuario` (`usuario`, `contrasena`, `persona`) VALUES ('belen','2314','0999999999');
INSERT INTO `db_poliventas`.`tbl_categoria` (`idCategoria`, `nombre`, `descripcion`) VALUES ('1', 'accesorio', 'accesorio de belleza');
INSERT INTO `db_poliventas`.`tbl_articulo` (`idArticulo`, `vendedor`, `nombre`, `categoria`, `precio`, `vecesBuscados`, `descripcion`, `fechaPublicacion`) VALUES ('1', '0999999999', 'gafas', '1', '5', '0', 'gafas de sol', '2019-01-26');

