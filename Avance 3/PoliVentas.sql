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
    descripcion varchar(20)
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
    
create table tbl_usuario(
	cedula varchar(10) primary key,
    nombres varchar(20),
    apellidos varchar(20),
    telefono varchar(10),
    tieneWhatsapp boolean,
    email varchar(30),
    direccion varchar(30),
    matricula varchar(10),
    rol int,
    foreign key (rol) references tbl_rol(idRol)
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
    foreign key (vendedor) references tbl_usuario(cedula)
    );
    
create table tbl_venta(
	idVenta int auto_increment primary key,
    estadoVenta int,
    fecha date,
    total float,
    vendedor varchar(10),
    comprador varchar(10),
    foreign key (vendedor) references tbl_usuario(cedula),
    foreign key (comprador) references tbl_usuario(cedula),
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
    
create table tbl_articuloVenta(
	idArticuloVenta int auto_increment primary key,
    venta int,
    articulo int,
    cantidad int,
    calificacionArticulo int,
    calificacionVendedor int,
    foreign key (venta) references tbl_venta(idVenta),
    foreign key (articulo) references tbl_articulo(idArticulo)
);

