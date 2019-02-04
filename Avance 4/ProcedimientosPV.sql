use db_poliventas;

delimiter //
create procedure comprobarUsuario(in ingreso varchar(8), ingresoContra varchar(10))
begin
select *
from tbl_usuario , tbl_persona, tbl_rol
where tbl_rol.idRol= tbl_persona.rol and tbl_usuario.persona= tbl_persona.cedula and  usuario = ingreso and contrasena = ingresoContra;
end // 
delimiter ;

delimiter //
create procedure calificacionVendedor(in ingresoCedula varchar(10))
begin
select avg(tbl_venta.calificacionVendedor) as promedioCalificacion
from tbl_persona,tbl_venta
where tbl_venta.vendedor= tbl_persona.cedula and  ingresoCedula = tbl_persona.cedula
group by tbl_persona.cedula;
end // 
delimiter ;

delimiter //
create procedure busquedaArticulo(in nombreIngreso varchar(20), descripcionIngreso varchar(50))
begin
select idArticulo, nombre,descripcion, precio
from tbl_articulo
where tbl_articulo.nombre like concat('%',nombre,'%')  and  tbl_articulo.descripcion like concat('%',descripcionIngreso,'%')  ;
end // 
delimiter ;

delimiter //
create procedure listaArticulos(in nombreIngreso varchar(20), descripcionIngreso varchar(50))
begin
select idArticulo, concat(nombres," ",apellidos), nombre, precio
from tbl_articulo , tbl_persona
where tbl_articulo.vendedor= tbl_persona.cedula and tbl_articulo.nombre like concat('%',nombre,'%')  and  tbl_articulo.descripcion like concat('%',descripcionIngreso,'%')  ;
end // 
delimiter ;

delimiter //
create procedure masBuscados()
begin
select idArticulo, concat(nombres," ",apellidos), nombre, precio
from tbl_articulo , tbl_persona
where tbl_articulo.vendedor= tbl_persona.cedula 
order by (vecesBuscados) DESC ;

end // 
delimiter ;

delimiter //
create procedure obtenerVendedor(in ingreso int)
begin
select *
from tbl_persona
where cedula = ingreso ;  

end // 
delimiter //

delimiter //
create procedure obtenerArticulo(in ingreso int)
begin
select *
from tbl_articulo, tbl_persona
where tbl_articulo.vendedor = tbl_persona.cedula and idArticulo = ingreso ;  

end // 
delimiter ;




delimiter //
create procedure registrarArticulo( in nombreProducto varchar(20), vendedor varchar(10), categoria int, precio float,tiempoEntrega varchar(5),descripcion varchar(50))
begin 
INSERT INTO db_poliventas.tbl_articulo (`vendedor`,`nombre`,`categoria`,`precio`,`tiempoEntrega`, `descripcion`) VALUES (vendedor,nombreProducto,categoria,precio,tiempoEntrega,descripcion);
end // 
delimiter ;

delimiter //
create procedure obtenerVendedores()
begin
select cedula, concat(nombres," ", apellidos) as nombre
from tbl_persona
where tbl_persona.rol = 2;  

end // 
delimiter ;

delimiter //
create procedure obtenerCategorias()
begin
select idCategoria, nombre
from tbl_categoria;

end // 
delimiter ;

delimiter //
create procedure aumentarBusqueda(in codigo int)
begin
update tbl_articulo
set vecesBuscados= vecesBuscados + 1
where idArticulo = codigo;

end // 
delimiter ;

delimiter //
create procedure comprasPendientes(in ingresoComprador int)
begin
select *
from tbl_venta
where comprador = ingresocomprador and estadoVenta=1;

end // 
delimiter ;

delimiter //
create procedure ventasPendientes(in ingresoVendedor int)
begin
select idVenta , tbl_articulo.nombre, fecha, total, tbl_estadoventa.estadoVenta
from tbl_venta , tbl_articulo, tbl_estadoventa
where vendedor = ingresoVendedor and estadoVenta=1;

end // 
delimiter ;
