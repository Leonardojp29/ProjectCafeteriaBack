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
INSERT INTO Menu (ID, Nombre, idcategoria, Precio, Descripcion, Imagen) VALUES
(1, 'Café Americano', 1, 1.50, 'Café negro clásico, fuerte y lleno de sabor.', 'http://localhost:8080/uploads/cafeamericano1.jpeg'),
(2, 'Café Espresso', 1, 2.00, 'Un shot concentrado de café para un golpe de energía.', 'http://localhost:8080/uploads/cafe-espresso2.jpg'),
(3, 'Cappuccino', 1, 2.50, 'Café espresso con leche vaporizada y espuma de leche.', 'http://localhost:8080/uploads/Cappuccino.jpg'),
(4, 'Latte', 1, 2.75, 'Café espresso con abundante leche vaporizada y un toque de espuma.', 'http://localhost:8080/uploads/Latte.jpg'),
(5, 'Café Mocha', 1, 3.00, 'Café espresso con chocolate, leche vaporizada y crema batida.', 'http://localhost:8080/uploads/CafeMocha.jpg'),
(6, 'Té Chai Latte', 4, 3.25, 'Té negro con especias, leche vaporizada y espuma de leche.', 'http://localhost:8080/uploads/TéChaiLatte.jpg'),
(7, 'Té Verde', 4, 2.00, 'Té verde refrescante y saludable.', 'http://localhost:8080/uploads/TeVerde.jpg'),
(8, 'Té Negro', 4, 2.00, 'Té negro fuerte y tradicional.', 'http://localhost:8080/uploads/TeNegro.jpg'),
(9, 'Limonada', 4, 2.50, 'Limonada casera fresca y cítrica.', 'http://localhost:8080/uploads/Limonada.jpg'),
(10, 'Batido de Fresa', 4, 3.50, 'Batido de leche con fresas frescas y un toque de azúcar.', 'http://localhost:8080/uploads/BatidoDeFresa.jpg'),
(11, 'Croissant', 3, 1.75, 'Croissant francés mantecoso y hojaldroso.', 'http://localhost:8080/uploads/Croissant.jpeg'),
(12, 'Muffin de Arándanos', 2, 2.00, 'Muffin suave y esponjoso con arándanos frescos.', 'http://localhost:8080/uploads/Muffin de Arándanos.jpg'),
(13, 'Muffin de Chocolate', 2, 2.00, 'Muffin de chocolate rico y dulce.', 'http://localhost:8080/uploads/Muffin de Chocolate.jpg'),
(14, 'Pastel de Zanahoria', 2, 2.50, 'Pastel de zanahoria húmedo con glaseado de queso crema.', 'http://localhost:8080/uploads/Pastel de Zanahoria.jpg'),
(15, 'Tarta de Queso', 2, 3.00, 'Tarta de queso clásica con base de galleta.', 'http://localhost:8080/uploads/Tarta de Queso.jpg'),
(16, 'Brownie', 2, 1.50, 'Brownie de chocolate denso y fudgy.', 'http://localhost:8080/uploads/Brownie.jpg'),
(17, 'Sándwich de Jamón y Queso', 3, 3.50, 'Sándwich clásico con jamón y queso en pan tostado.', 'http://localhost:8080/uploads/Sándwich de Jamón y Queso.jpg'),
(18, 'Sándwich de Pollo', 3, 4.00, 'Sándwich de pollo a la parrilla con lechuga y tomate.', 'http://localhost:8080/uploads/Sándwich de Pollo.jpg'),
(19, 'Sándwich Vegetariano', 3, 3.75, 'Sándwich con vegetales frescos y hummus.', 'http://localhost:8080/uploads/Sandwich vegetariano.jpeg'),
(20, 'Ensalada César', 3, 4.50, 'Ensalada clásica César con pollo a la parrilla.', 'http://localhost:8080/uploads/Ensalada César.jpg'),
(21, 'Ensalada de Frutas', 2, 3.25, 'Ensalada fresca con una variedad de frutas de temporada.', 'http://localhost:8080/uploads/Ensalada de Frutas.jpg'),
(22, 'Galleta de Avena', 2, 1.25, 'Galleta crujiente y saludable de avena.', 'http://localhost:8080/uploads/Galleta de Avena.jpg'),
(23, 'Galleta de Chocolate', 2, 1.25, 'Galleta suave y dulce de chocolate.', 'http://localhost:8080/uploads/Galleta de Chocolate.webp'),
(24, 'Té Helado', 4, 2.75, 'Té negro frío y refrescante con limón.', 'http://localhost:8080/uploads/Té Helado.jpg'),
(25, 'Chocolatina Caliente', 4, 3.00, 'Bebida caliente de chocolate con leche vaporizada.', 'http://localhost:8080/uploads/Chocolatina Caliente.jpg'),
(26, 'Frappuccino de Vainilla', 4, 3.75, 'Bebida fría con sabor a vainilla y crema batida.', 'http://localhost:8080/uploads/Frappuccino de Vainilla.jpeg'),
(27, 'Frappuccino de Caramelo', 4, 3.75, 'Bebida fría con caramelo, leche y crema batida.', 'http://localhost:8080/uploads/Frappuccino de Caramelo.jpg'),
(28, 'Panqueques', 2, 3.50, 'Panqueques esponjosos con jarabe de arce.', 'http://localhost:8080/uploads/Panqueques.jpg'),
(29, 'Canelé', 2, 2.00, 'Pequeño pastel francés con una costra crujiente y un interior suave.', 'http://localhost:8080/uploads/Canelé.jpg'),
(30, 'Macaron', 2, 1.50, 'Delicado macaron francés con relleno de crema.', 'http://localhost:8080/uploads/Macaron.webp'),
(31, 'Scone', 2, 1.75, 'Panecillo inglés perfecto para acompañar el té.', 'http://localhost:8080/uploads/Scone.jpeg'),
(34, 'Café Cortado', 1, 2.25, 'Café espresso con una pequeña cantidad de leche caliente, suavizando su sabor intenso.', 'http://localhost:8080/uploads/Café Cortado.png'),
(35, 'Macchiato', 1, 2.50, 'Café espresso con una capa ligera de espuma de leche. Perfecto para quienes quieren un toque de suavidad en su café fuerte.', 'http://localhost:8080/uploads/Macchiato.webp'),
(36, 'Flat White', 1, 3.00, 'Similar al latte, pero con una proporción mayor de café respecto a la leche y una textura más sedosa.', 'http://localhost:8080/uploads/Flat White.jpg'),
(37, 'Café Vienés', 1, 3.50, 'Café negro con crema batida y una pizca de chocolate rallado o canela para un toque especial.', 'http://localhost:8080/uploads/Café Vienés.jpg'),
(38, 'Affogato', 1, 4.00, 'Postre italiano que combina un shot de espresso caliente vertido sobre una bola de helado de vainilla.', 'http://localhost:8080/uploads/Affogato.jpg'),
(39, 'Café Irlandés', 1, 5.00, 'Bebida caliente que mezcla café negro con whisky irlandés y azúcar, cubierta con una capa de crema batida.', 'http://localhost:8080/uploads/Café Irlandés.jpg'),
(40, 'Sándwich de Chicharrón', 3, 6.00, 'Sándwich típico limeño que incluye chicharrón de cerdo, camote frito y salsa criolla (cebolla, ají, limón y culantro) en un pan francés.', 'http://localhost:8080/uploads/Sándwich de Chicharrón.jpg'),
(41, 'Butifarra', 3, 4.50, 'Sándwich limeño de jamón del país (jamón cocido y adobado), con salsa criolla en pan francés.', 'http://localhost:8080/uploads/Butifarra.jpg'),
(42, 'Sándwich de Lomo Saltado', 3, 5.50, 'Sándwich con lomo saltado (trozos de carne, cebolla, tomate y ají amarillo salteados) en pan francés.', 'http://localhost:8080/uploads/Sándwich de Lomo Saltado.jpg'),
(43, 'Triple', 3, 3.00, 'Sándwich vegetariano con capas de huevo, tomate y palta (aguacate) en pan de molde.', 'http://localhost:8080/uploads/Triple.webp'),
(44, 'Sánguche de Pavo', 3, 4.25, 'Sándwich con pavo al horno, lechuga, tomate y mayonesa en pan de molde o pan francés.', 'http://localhost:8080/uploads/Sánguche de Pavo.webp');



