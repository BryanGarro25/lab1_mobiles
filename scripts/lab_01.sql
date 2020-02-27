host cls
conn system/root
SET LINESIZE 32000;
SET PAGESIZE 40000;
drop user lab01 cascade;
drop user lab01_DBA cascade;

create user lab01_DBA identified by lab01_DBA_DB; 
--Este usuario administra la base de datos.
grant dba to lab01_DBA;
conn lab01_DBA/lab01_DBA_DB

create user lab01 identified by lab01_DB; 
--ESte usuario es el que va a utilizar el sistema.
grant create session to lab01;

--drop table lab01_curso;
create table lab01_curso(
id_DB number (3) ,
codigo    varchar2(10) not null,
nombre   varchar2(50) not null,
creditos  number(1)  not null,
horas_semanales   number(2,1)  not null
);

--drop table lab01_profesor;
create table lab01_profesor(
id_DB number (3) not null,
cedula    varchar2(10) not null,
nombre   varchar2(50) not null,
telefono  number(10)  not null,
email   varchar2(50)  not null
);

alter table lab01_curso add constraint lab01_curso_PK primary key (id_DB);
alter table lab01_profesor add constraint lab01_profesor_PK primary key (id_DB);
alter table lab01_curso add constraint lab01_curso_UK unique (codigo);
alter table lab01_profesor add constraint lab01_profesor_UK unique (cedula);

GRANT SELECT, INSERT, UPDATE, DELETE ON lab01_curso TO lab01;
GRANT SELECT, INSERT, UPDATE, DELETE ON lab01_profesor TO lab01;
create sequence sec_curso   start with 1    increment by 1;
create sequence sec_profesor   start with 1    increment by 1;

create or replace trigger auto_increment_lab01_curso BEFORE INSERT on lab01_curso
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
begin
  SELECT sec_curso.NEXTVAL
  INTO   :new.id_DB
  FROM   dual;
end auto_increment_lab01_curso;
/

create or replace trigger auto_increment_lab01_profesor BEFORE INSERT on lab01_profesor
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
begin
  SELECT sec_profesor.NEXTVAL
  INTO   :new.id_DB
  FROM   dual;
end auto_increment_lab01_profesor;
/
CREATE OR REPLACE PACKAGE types
AS
     TYPE ref_cursor IS REF CURSOR;
END;
/
--procedimientos profesores
create or replace procedure PA_insertarProfesor(new_cedula in lab01_profesor.cedula%type,
												new_nombre in lab01_profesor.nombre%type,
												new_telefono in lab01_profesor.telefono%type,
												new_email in lab01_profesor.email%type
												)
as
begin 
	insert into  lab01_profesor(cedula, nombre, telefono, email) values(new_cedula, new_nombre, new_telefono,new_email);
end;
/
create or replace function PA_buscarProfesor(id in lab01_profesor.id_DB%type)
return Types.ref_cursor
as
	profesor_cursor types.ref_cursor;
begin 
	open profesor_cursor for
		select * from lab01_profesor where lab01_profesor.id_DB=id;
return profesor_cursor;
end;
/
create or replace function PA_listarProfesores
return Types.ref_cursor
as 
	profesor_cursor types.ref_cursor;
begin
	open profesor_cursor for 
		select * from lab01_profesor;
return profesor_cursor;
end;
/
create or replace procedure PA_modificarProfesor( id in lab01_profesor.id_DB%type,
												  new_cedula in lab01_profesor.cedula%type,
												  new_nombre in lab01_profesor.nombre%type,
												  new_telefono in lab01_profesor.telefono%type,
												  new_correo in lab01_profesor.email%type
												  )
as
begin 
 update lab01_profesor set cedula=new_cedula, nombre=new_nombre, telefono=new_telefono, email = new_correo where lab01_profesor.id_DB =id;
 commit;
end;
/
create or replace procedure PA_eliminarProfesor(id in lab01_profesor.id_DB%type)
as
begin
	delete from lab01_profesor where lab01_profesor.id_DB = id;
end;
/
--Procedimientos curso
create or replace procedure PA_insertarCurso(new_codigo in lab01_curso.codigo%type,
											 new_nombre in lab01_curso.nombre%type,
											 new_creditos in lab01_curso.creditos%type,
											 new_horasSemanales in lab01_curso.horas_semanales%type
											 )
as 
begin 
 insert into lab01_curso(codigo, nombre, creditos, horas_semanales) values(new_codigo,new_nombre,new_creditos, new_horasSemanales);
 commit;
end;
/
create or replace function PA_buscarCurso(id in lab01_curso.id_DB%type)
return Types.ref_cursor
as
	curso_cursor types.ref_cursor;
begin 
	open curso_cursor for
	select * from lab01_curso where lab01_curso.id_DB = id;
return curso_cursor;
end;
/
create or replace function PA_listarCursos 
return Types.ref_cursor
as
	curso_cursor types.ref_cursor;
begin
	open curso_cursor for
	select * from lab01_curso;
return curso_cursor;
end;
/
create or replace procedure PA_modificarCurso( id in lab01_curso.id_DB%type,
											 new_codigo in lab01_curso.codigo%type,
											 new_nombre in lab01_curso.nombre%type,
											 new_creditos in lab01_curso.creditos%type,
											 new_horasSemanales in lab01_curso.horas_semanales%type
											 )
as 
begin 
 update lab01_curso set codigo=new_codigo, nombre=new_nombre, creditos=new_creditos, horas_semanales=new_horasSemanales where lab01_curso.id_DB = id;
end;
/

create or replace procedure PA_eliminarCurso(id in lab01_curso.id_DB%type)
as
begin
	delete from lab01_curso where lab01_curso.id_DB = id;
end;
/
-- Pruebas
conn lab01/lab01_DB
insert into lab01_DBA.lab01_curso(codigo, nombre, creditos,horas_semanales) values ('hola','test',2,4.2); 
insert into lab01_DBA.lab01_profesor (cedula,nombre,telefono,email) values ('123','Juan',0123456,'bryangarroeduarte@gmail.com');
conn lab01_DBA/lab01_DBA_DB;