Drop database if exists WebDoggyStyle1;
create database WebDoggyStyle1;
use WebDoggyStyle1;

-- -----------------------------------------------------
-- Table estado
-- -----------------------------------------------------
create table if not exists tb_estado(
estado_id int not null auto_increment,
estado_nombre varchar(30) not null,
primary key (estado_id)
);
insert tb_estado(estado_nombre) values ("Activo");
insert tb_estado(estado_nombre) values ("Eliminado");
insert tb_estado(estado_nombre) values ("Suspendido");

-- -----------------------------------------------------
-- Table tipo
-- -----------------------------------------------------
create table if not exists tb_tipo(
tipo_id int not null auto_increment,
tipo_nombre varchar(30) not null,
primary key (tipo_id)
);
insert tb_tipo(tipo_nombre) values ("Administrador");
insert tb_tipo(tipo_nombre) values ("Cliente");

-- -----------------------------------------------------
-- Table distrito
-- -----------------------------------------------------
create table if not exists tb_distrito(
distrito_id int not null auto_increment,
distrito_nombre varchar(30) not null,
primary key (distrito_id)
);
insert tb_distrito(distrito_nombre) values ("La Perla");
insert tb_distrito(distrito_nombre) values ("San Miguel");
insert tb_distrito(distrito_nombre) values ("Bellavista");
insert tb_distrito(distrito_nombre) values ("Callao");
insert tb_distrito(distrito_nombre) values ("Carmen de la Legua");
insert tb_distrito(distrito_nombre) values ("Pueblo Libre");
insert tb_distrito(distrito_nombre) values ("Magdalnea");
insert tb_distrito(distrito_nombre) values ("Cercado de Lina");
insert tb_distrito(distrito_nombre) values ("Breña");

-- -----------------------------------------------------
-- Table tamano
-- -----------------------------------------------------
create table if not exists tb_tamano(
tamano_id int not null auto_increment,
tamano_nombre varchar(30) not null,
primary key (tamano_id)
);
insert tb_tamano(tamano_nombre) values ("Pequeño");
insert tb_tamano(tamano_nombre) values ("Mediano");
insert tb_tamano(tamano_nombre) values ("Grande");

-- -----------------------------------------------------
-- Table usuario
-- -----------------------------------------------------
create table if not exists tb_usuario(
usuario_id int not null auto_increment,
usuario_nombre char(50) not null,
usuario_apellido char(50) not null,
usuario_celular char(9) not null,
usuario_correo varchar(50) not null,
usuario_clave varchar(15) not null,
tipo_id int not null,
estado_id int not null,
primary key (usuario_id),
constraint FK_TipoEstadoxUsuario foreign key (estado_id) references tb_estado(estado_id)
);
insert tb_usuario values (null,"Giordany","Fernandez","987654321","u0001@gmail.com","admin",1,1);
insert tb_usuario values (null,"Diego","Arquiñigo","911157093","u0002@gmail.com","admin",1,1);
insert tb_usuario values (null,"Pepito","Perez","987412365","u0003@gmail.com","usuario",2,1);
insert tb_usuario values (null,"Ornella","Romero","987654323","u0004@gmail.com","usuario",2,1);
insert tb_usuario values (null,"Cesar","Romero","91234567","u0005@gmail.com","usuario",2,1);
insert tb_usuario values (null,"Tula","Rivera","976431258","u0006@gmail.com","usuario", 2,1);
insert tb_usuario values (null,"Vanessa","Ruiz","976789258","u0007@gmail.com","usuario", 2,1);
insert tb_usuario values (null,"Marilu","Marchan","965431258","u0008@gmail.com","usuario", 2,1);
insert tb_usuario values (null,"Rosa","Icochea","995163418","u0009@gmail.com","usuario", 2,1);
insert tb_usuario values (null,"Pedro","Castillo","976963258","u0010@gmail.com","usuario", 2,1);
insert tb_usuario values (null,"Keiko","Fujimori","932146258","u0011@gmail.com","usuario", 2,1);
insert tb_usuario values (null,"Rafael","Lopez","937854528","u0012@gmail.com","usuario", 2,1);
insert tb_usuario values (null,"Vladimir","Cerron","932754896","u0013@gmail.com","usuario", 2,1);
insert tb_usuario values (null,"Veronika","Mendoza","932141598","u0014@gmail.com","usuario", 2,1);
insert tb_usuario values (null,"Vladimiro","Montesinos","987456628","u0015@gmail.com","usuario", 2,1);
insert tb_usuario values (null,"Agustin","Mantilla","999854258","u0016@gmail.com","usuario", 2,1);
insert tb_usuario values (null,"Alan","Garcia","935248558","u0017@gmail.com","usuario", 2,1);
insert tb_usuario values (null,"Luis","Bedolla","939963458","u0018@gmail.com","usuario", 2,1);
insert tb_usuario values (null,"Lourdes","Flores","936666358","u0019@gmail.com","usuario", 2,1);
insert tb_usuario values (null,"Kenyi","fujimori","933574158","u0029@gmail.com","usuario", 2,1);
insert tb_usuario values (null,"Alfonzo","Barrantes","996324788","u0021@gmail.com","usuario", 2,1);
insert tb_usuario values (null,"Alberto","Andrade","900632258","u0022@gmail.com","usuario", 2,1);

-- -----------------------------------------------------
-- Table mascota
-- -----------------------------------------------------
create table if not exists tb_mascota(
mascota_id int not null auto_increment,
usuario_id int not null,
mascota_nombre char(40) not null,
mascota_raza varchar(30) not null,
tamano_id int not null,
mascota_edad int not null,
estado_id int not null,
primary key (mascota_id),
constraint FK_codigoUsuario foreign key (usuario_id) references tb_usuario (usuario_id),
constraint FK_TamanioMascota foreign key (tamano_id) references tb_tamano (tamano_id),
constraint FK_TipoEstadoxMascota foreign key (estado_id) references tb_estado (estado_id)
);
insert tb_mascota values (null,3,"Hercules","Labrador retriever",1,1,1);
insert tb_mascota values (null,3,"Pepe","Bulldog",1,3,1);
insert tb_mascota values (null,4,"Baby","Pomerania",1,3,1);
insert tb_mascota values (null,5,"Falcon","Gran Danes",1,4,1);
insert tb_mascota values (null,6,"Thor","Pastor aleman",1,10,1);
insert tb_mascota values (null,7,"Brandon","Cocker spaniel ingles",1,6,1);
insert tb_mascota values (null,8,"Manchas","Pointer ingles",1,1,1);
insert tb_mascota values (null,8,"Luna","Shih Tzu",1,6,1);
insert tb_mascota values (null,8,"Kira","Esquimal americano",1,13,1);
insert tb_mascota values (null,9,"Bimba","Pastor persa",1,14,1);
insert tb_mascota values (null,9,"Coco","Jack Russell terrier",1,3,1);
insert tb_mascota values (null,10,"Max","Perro Persa",1,4,1);
insert tb_mascota values (null,11,"Lucas","Corgi gales",1,6,1);
insert tb_mascota values (null,12,"Zeus","San bernardo",1,4,1);
insert tb_mascota values (null,13,"Satanas","Bull terrier",1,3,1);
insert tb_mascota values (null,13,"Dana","Crestado chino",1,4,1);
insert tb_mascota values (null,13,"Gala","Golden retriever",1,4,1);
insert tb_mascota values (null,14,"Noa","Boston terrier",1,6,1);
insert tb_mascota values (null,15,"Taco","Dachshund",1,2,1);
insert tb_mascota values (null,16,"Sushi","Galgo ingles",1,2,1);
insert tb_mascota values (null,17,"Macarron","Chihuahua",1,2,1);
insert tb_mascota values (null,18,"Choco","Rottweiler",1,4,1);
insert tb_mascota values (null,19,"Canela","Bichon frise",1,4,1);
insert tb_mascota values (null,20,"Ramon","Doberman",1,6,1);
insert tb_mascota values (null,21,"Mona","Samoyedo",1,4,1);
insert tb_mascota values (null,22,"Doritos","Chow Chow",1,6,1);

-- -----------------------------------------------------
-- Table productos
-- -----------------------------------------------------
create table if not exists tb_producto(
producto_id int not null auto_increment,
producto_nombre char(40) not null,
producto_precio int not null,
producto_stock int not null,
estado_id int not null,
primary key (producto_id),
constraint FK_TipoEstadoxProducto foreign key (estado_id) references tb_estado(estado_id)
);
insert into tb_producto values (null,"Delivery 01",5,10000000,1);
insert into tb_producto values (null,"Delivery 02",10,10000000,1);
insert into tb_producto values (null,"Baño Perro Pequeno",30,10000000,1);
insert into tb_producto values (null,"Baño Perro Mediano",45,10000000,1);
insert into tb_producto values (null,"Baño Perro Grande",60,10000000,1);
insert into tb_producto values (null,"Baño Perro Pequeno Medicado",35,10000000,1);
insert into tb_producto values (null,"Baño Perro Mediano Medicado",50,10000000,1);
insert into tb_producto values (null,"Baño Perro Grande Medicado",65,10000000,1);
insert into tb_producto values (null,"Baño Perro Pequeno Antipulgas",35,10000000,1);
insert into tb_producto values (null,"Baño Perro Mediano Antipulgas",35,10000000,1);
insert into tb_producto values (null,"Baño Perro Grande Antipulgas",40,10000000,1);
insert into tb_producto values (null,"Pipeta",35,10,1);
insert into tb_producto values (null,"Hueso",5,5,1);
insert into tb_producto values (null,"Cama para perro",40,20,1);
insert into tb_producto values (null,"Correa Para Perro",15,10000000,1);
insert into tb_producto values (null,"platos para perrro",35,10000000,1);
insert into tb_producto values (null,"Bolsa de residuos fecales",35,10000000,1);
insert into tb_producto values (null,"Vestidos para perros",35,10000000,1);
insert into tb_producto values (null,"Pastilla para desparasitar",35,60,1);
insert into tb_producto values (null,"Champu para mascota",35,50,1);
insert into tb_producto values (null,"Comida para mascota",10,60,1);
insert into tb_producto values (null,"Peinetas para perros",35,35,1);
insert into tb_producto values (null,"Pelotitas para perros",35,42,1);
insert into tb_producto values (null,"Toallas de Microfibra",35,15,1);

-- -----------------------------------------------------
-- Table proveedores
-- -----------------------------------------------------
create table if not exists tb_proveedor(
proveedor_id int not null auto_increment,
proveedor_ruc char(11) not null,
proveedor_nombre varchar(50) not null,
proveedor_direccion varchar(30) not null,
distrito_id varchar(40) not null,
proveedor_celular char(9) not null,
proveedor_email varchar(40) not null,
estado_id int not null,
primary key (proveedor_id),
constraint FK_TipoEstadoxProveedor foreign key (estado_id) references tb_estado(estado_id)
);


create table tb_cab_boleta(
num_bol      char(5) not null,
fch_bol    date,
cod_cliente  int not null,
primary key (num_bol),
foreign key (cod_cliente) references tb_usuario(usuario_id)
);

create table tb_det_boleta(
num_bol     char(5) not null,
idprod      int not null,
cantidad    int,
preciovta   decimal(8,2),
primary key (num_bol,idprod),
foreign key (num_bol) references tb_cab_boleta(num_bol),
foreign key (idprod) references tb_producto(producto_id)
);

select * from tb_usuario;
select * from tb_estado;
select * from tb_tamano;