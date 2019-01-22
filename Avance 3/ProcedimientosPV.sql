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
select avg(tbl_articuloventa.calificacionVendedor) as promedioCalificacion
from tbl_persona, tbl_articuloventa,tbl_venta
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
create procedure obtenerArticulo(in ingreso int)
begin
select *
from tbl_articulo, tbl_persona
where tbl_articulo.vendedor = tbl_persona.cedula and idArticulo = ingreso ;  

end // 
delimiter ;

