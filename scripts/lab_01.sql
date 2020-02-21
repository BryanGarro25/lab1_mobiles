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

drop table lab01_curso;
create table lab01_curso(
id_DB number (3) ,
codigo    varchar2(10) not null,
nombre   varchar2(50) not null,
creditos  number(1)  not null,
horas_semanales   number(2,1)  not null
);

drop table lab01_profesor;
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
-- Pruebas
conn lab01/lab01_DB
insert into lab01_DBA.lab01_curso(codigo, nombre, creditos,horas_semanales) values ('hola','test',2,4.2); 
insert into lab01_DBA.lab01_profesor (cedula,nombre,telefono,email) values ('123','Juan',0123456,'bryangarroeduarte@gmail.com');