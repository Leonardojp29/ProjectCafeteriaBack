CREATE DATABASE BD_CAFE;
USE BD_CAFE;

CREATE TABLE TipoUsuario (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Tipo VARCHAR(20)
);

INSERT INTO TipoUsuario (Tipo) VALUES ('administrador');
INSERT INTO TipoUsuario (Tipo) VALUES ('cliente');

select * from tipoUsuario;

CREATE TABLE Usuario (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(100),
    Apellido VARCHAR(100),
    Email VARCHAR(100),
    Usuario VARCHAR(50),
    Contraseña VARCHAR(100),
    tipo_usuario_id INT,
    FOREIGN KEY (tipo_usuario_id) REFERENCES TipoUsuario(ID)
);
INSERT INTO Usuario (Nombre, Apellido, Email, Usuario, Contraseña, tipo_usuario_id)
VALUES 
('Juan', 'Pérez', 'juan@example.com', 'juanperez', 'clave123', 1),
('María', 'García', 'maria@example.com', 'mariagarcia', 'secreto456', 2),
('Pedro', 'Martínez', 'pedro@example.com', 'pedromartinez', 'password789', 2);
select * from Usuario;


CREATE TABLE Categoria (
  idcategoria INT AUTO_INCREMENT PRIMARY KEY,  
  nombre VARCHAR(45) 
);
INSERT INTO Categoria (nombre) VALUES ('CAFES');
INSERT INTO Categoria (nombre) VALUES ('POSTRES');
INSERT INTO Categoria (nombre) VALUES ('SANDWICHES');
INSERT INTO Categoria (nombre) VALUES ('OTRAS BEBIDAS');

select * from categoria;

CREATE TABLE Menu (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(100),
    idcategoria INT,
    Precio DECIMAL(10, 2),
    Descripcion VARCHAR(255),
    Imagen VARCHAR(255),
    FOREIGN KEY (idcategoria) REFERENCES Categoria(idcategoria)
);
INSERT INTO Menu (Nombre, idcategoria, Precio, Descripcion, Imagen) VALUES
('Café Americano', 1, 1.50, 'Café negro clásico, fuerte y lleno de sabor.', 'https://example.com/images/cafe_americano.jpg'),
('Café Espresso', 1, 2.00, 'Un shot concentrado de café para un golpe de energía.', 'https://example.com/images/cafe_espresso.jpg'),
('Cappuccino', 1, 2.50, 'Café espresso con leche vaporizada y espuma de leche.', 'https://example.com/images/cappuccino.jpg'),
('Latte', 1, 2.75, 'Café espresso con abundante leche vaporizada y un toque de espuma.', 'https://example.com/images/latte.jpg'),
('Café Mocha', 1, 3.00, 'Café espresso con chocolate, leche vaporizada y crema batida.', 'https://example.com/images/cafe_mocha.jpg'),
('Té Chai Latte', 4, 3.25, 'Té negro con especias, leche vaporizada y espuma de leche.', 'https://example.com/images/te_chai_latte.jpg'),
('Té Verde', 4, 2.00, 'Té verde refrescante y saludable.', 'https://example.com/images/te_verde.jpg'),
('Té Negro', 4, 2.00, 'Té negro fuerte y tradicional.', 'https://example.com/images/te_negro.jpg'),
('Limonada', 4, 2.50, 'Limonada casera fresca y cítrica.', 'https://example.com/images/limonada.jpg'),
('Batido de Fresa', 4, 3.50, 'Batido de leche con fresas frescas y un toque de azúcar.', 'https://example.com/images/batido_de_fresa.jpg'),
('Croissant', 3, 1.75, 'Croissant francés mantecoso y hojaldroso.', 'https://example.com/images/croissant.jpg'),
('Muffin de Arándanos', 2, 2.00, 'Muffin suave y esponjoso con arándanos frescos.', 'https://example.com/images/muffin_de_arandanos.jpg'),
('Muffin de Chocolate', 2, 2.00, 'Muffin de chocolate rico y dulce.', 'https://example.com/images/muffin_de_chocolate.jpg'),
('Pastel de Zanahoria', 2, 2.50, 'Pastel de zanahoria húmedo con glaseado de queso crema.', 'https://example.com/images/pastel_de_zanahoria.jpg'),
('Tarta de Queso', 2, 3.00, 'Tarta de queso clásica con base de galleta.', 'https://example.com/images/tarta_de_queso.jpg'),
('Brownie', 2, 1.50, 'Brownie de chocolate denso y fudgy.', 'https://example.com/images/brownie.jpg'),
('Sándwich de Jamón y Queso', 3, 3.50, 'Sándwich clásico con jamón y queso en pan tostado.', 'https://example.com/images/sandwich_de_jamon_y_queso.jpg'),
('Sándwich de Pollo', 3, 4.00, 'Sándwich de pollo a la parrilla con lechuga y tomate.', 'https://example.com/images/sandwich_de_pollo.jpg'),
('Sándwich Vegetariano', 3, 3.75, 'Sándwich con vegetales frescos y hummus.', 'https://example.com/images/sandwich_vegetariano.jpg'),
('Ensalada César', 3, 4.50, 'Ensalada clásica César con pollo a la parrilla.', 'https://example.com/images/ensalada_cesar.jpg'),
('Ensalada de Frutas', 2, 3.25, 'Ensalada fresca con una variedad de frutas de temporada.', 'https://example.com/images/ensalada_de_frutas.jpg'),
('Galleta de Avena', 2, 1.25, 'Galleta crujiente y saludable de avena.', 'https://example.com/images/galleta_de_avena.jpg'),
('Galleta de Chocolate', 2, 1.25, 'Galleta suave y dulce de chocolate.', 'https://example.com/images/galleta_de_chocolate.jpg'),
('Té Helado', 4, 2.75, 'Té negro frío y refrescante con limón.', 'https://example.com/images/te_helado.jpg'),
('Chocolatina Caliente', 4, 3.00, 'Bebida caliente de chocolate con leche vaporizada.', 'https://example.com/images/chocolatina_caliente.jpg'),
('Frappuccino de Vainilla', 4, 3.75, 'Bebida fría con sabor a vainilla y crema batida.', 'https://example.com/images/frappuccino_de_vainilla.jpg'),
('Frappuccino de Caramelo', 4, 3.75, 'Bebida fría con caramelo, leche y crema batida.', 'https://example.com/images/frappuccino_de_caramelo.jpg'),
('Panqueques', 2, 3.50, 'Panqueques esponjosos con jarabe de arce.', 'https://example.com/images/panqueques.jpg'),
('Canelé', 2, 2.00, 'Pequeño pastel francés con una costra crujiente y un interior suave.', 'https://example.com/images/canele.jpg'),
('Macaron', 2, 1.50, 'Delicado macaron francés con relleno de crema.', 'https://example.com/images/macaron.jpg'),
('Scone', 2, 1.75, 'Panecillo inglés perfecto para acompañar el té.', 'https://example.com/images/scone.jpg');



select * from menu;


CREATE TABLE reserva (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    correo VARCHAR(255) NOT NULL,
    telefono VARCHAR(15) NOT NULL,
    cantidad INT NOT NULL,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    mensaje TEXT
);
INSERT INTO reserva (nombre, correo, telefono, cantidad, fecha, hora, mensaje)
VALUES ('Juan Pérez', 'juan@example.com', '555-123-4567', 4, '2024-05-15', '18:30:00', 'Necesitamos una mesa grande.');
INSERT INTO reserva (nombre, correo, telefono, cantidad, fecha, hora, mensaje)
VALUES ('María González', 'maria@example.com', '555-987-6543', 2, '2024-05-18', '19:00:00', 'Queremos una reserva para una cena especial.');
INSERT INTO reserva (nombre, correo, telefono, cantidad, fecha, hora, mensaje)
VALUES ('Luis Rodríguez', 'luis@example.com', '555-567-8901', 6, '2024-05-20', '20:00:00', 'Celebramos un cumpleaños, ¿tienen algún servicio especial?');

select * from reserva;

CREATE TABLE distrito (
	IDdistrito INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);
INSERT INTO distrito (nombre) VALUES 
('Cercado de Lima'),
('Ate'),
('Barranco'),
('Breña'),
('Comas'),
('Chorrillos'),
('El Agustino'),
('Jesús María'),
('La Victoria'),
('Lince'),
('Magdalena del Mar'),
('Miraflores'),
('Pueblo Libre'),
('Puente Piedra'),
('Rimac'),
('San Isidro'),
('San Juan de Lurigancho'),
('San Juan de Miraflores'),
('San Luis'),
('San Martín de Porres'),
('San Miguel'),
('Santiago de Surco'),
('Surquillo'),
('Villa El Salvador'),
('Villa María del Triunfo');

CREATE TABLE locales (
	id INT AUTO_INCREMENT PRIMARY KEY,
    IDdistrito INT,
    direccion VARCHAR (255) NOT NULL,
    horario VARCHAR (255) NOT NULL,
    FOREIGN KEY (IDdistrito) REFERENCES distrito(IDdistrito)
);
INSERT INTO locales (IDdistrito, direccion, horario) VALUES 
(1, 'Av. Abancay 123', 'Lunes a Viernes: 09:00 - 18:00'),
(2, 'Av. Nicolas Ayllón 456', 'Lunes a Sábado: 08:00 - 20:00'),
(3, 'Jr. 28 de Julio 789', 'Todos los días: 10:00 - 22:00'),
(4, 'Av. Venezuela 101', 'Lunes a Viernes: 08:00 - 17:00'),
(5, 'Av. Tupac Amaru 202', 'Todos los días: 09:00 - 21:00'),
(6, 'Av. Huaylas 303', 'Lunes a Domingo: 10:00 - 23:00'),
(7, 'Av. Riva Agüero 404', 'Lunes a Sábado: 09:00 - 19:00');

select * from locales;
select * from distrito;


