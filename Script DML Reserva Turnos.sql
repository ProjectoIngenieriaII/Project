/* jdbc:mysql://localhost:3306/centroautomotriz?zeroDateTimeBehavior=CONVERT_TO_NULL [centroAutoUse on Default schema] */

/*USO DE LA BASE DE DATOS*/
use centroautomotriz;
/* INSERCION EN TABLAS */
/* DEPARTAMENTOS */
insert into departamentos (nom_depto)
values  ("Antioquia"), ("Boyaca"), ("Cundinamarca");

select * from departamentos;
delete from departamentos;

/* CIUDADES */
insert into ciudades (nom_ciudad, id_depto)
values ("Medellin", 1), ("Rionegro", 1), ("Envigado", 1), ("Tunja", 2), ("Duitama", 2), ("Bogota D.C.", 3), ("Chia", 3), ("Zipaquira", 3);

select * from ciudades;
delete from ciudades;

/* SUCURSALES */
insert into sucursales (nom_sucursal, dir_sucursal, tel_sucursal, id_ciudad)
values ("Centro Automotriz MoviCentro", "Carrera 43 A #19-87", 4463598, 1),
	   ("Centro Automotriz Poblado", "Calle 10 #41-25 ", 4729701, 1),
       ("Centro Automotriz Rionegro", "Calle 44 #50-62", 3565814, 2),
       ("Centro Automotriz Castillo", "Carrera 20 #12-08", 6071542, 3),
       ("Centro Automotriz Antillas", "Calle 24 #3-95", 8510934, 3),
       ("Centro Automotriz Compes", "Calle 14 #7-45", 9276510, 4),
       ("Centro Automotriz Filadelfia", "Carrera 15 #28-90", 3980025, 4),
       ("Centro Automotriz Laureles", "Calle 3 A #8-15", 6912502, 5),
       ("Centro Automotriz Calle 170", "Calle 170 #19-34", 3359851, 6),
       ("Centro Automotriz Calle 80", "Calle 80 #72-59 ", 3012769, 6),
       ("Centro Automotriz Villa Mayor", "Calle 38 #35-70", 7245100, 6),
       ("Centro Automotriz Ibaro", "Calle 11 #14-24", 8912601, 7),
       ("Centro Automotriz Altamira", "Carrera 51 # 10-87", 9230841, 8);
       
select * from sucursales;

insert into servicios (nom_servicio,valor_servicio, tiempo_servicio ,id_sucursal)
values ("Lavado",70000,30,1),
		("Pintura",100000,9,1),
        ("Taller",400000,180,1),
        ("Lavado",70000,30,2),
        ("Pintura",100000,9,2),        
        ("Pintura",100000,9,2),
        ("Lavado",70000,30,3),
        ("Pintura",100000,9,3),
		("Pintura",100000,9,3);


insert into horarios (horario)
values  ("7:00am a 8:00am"),
		("8:00am a 9:00am"),
        ("9:00am a 10:00am"),
        ("10:00am a 11:00am"),
        ("11:00am a 12:00pm"),
        ("12:00pm a 01:00pm"),
        ("12:00pm a 01:00pm"),
        ("01:00pm a 02:00pm"),
        ("02:00pm a 03:00pm"),
        ("03:00pm a 04:00pm"),
        ("04:00pm a 05:00pm"),
        ("05:00pm a 06:00pm");
        














