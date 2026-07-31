CREATE DATABASE IF NOT EXISTS Proyecto_TecnoStore;
USE Proyecto_TecnoStore;

-- ===========================
-- TABLA CATEGORIA_GAMA
-- ===========================
CREATE TABLE categoria_gama (
    id INT PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL UNIQUE
);

INSERT INTO categoria_gama (id, nombre) VALUES
    (1, 'ALTA'),
    (2, 'MEDIA'),
    (3, 'BAJA');

-- ===========================
-- TABLA CELULARES
-- ===========================
CREATE TABLE celulares (
    id INT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    sistema_operativo VARCHAR(30) NOT NULL,
    id_gama INT NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL,
    CONSTRAINT fk_celular_gama
        FOREIGN KEY (id_gama)
        REFERENCES categoria_gama(id)
);

-- ===========================
-- TABLA CLIENTES
-- ===========================
CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    identificacion VARCHAR(20) NOT NULL UNIQUE,
    correo VARCHAR(100),
    telefono VARCHAR(20)
);

-- ===========================
-- TABLA VENTAS
-- ===========================
CREATE TABLE ventas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    fecha DATE NOT NULL,
    total DECIMAL(10,2) NOT NULL,
    CONSTRAINT fk_venta_cliente
        FOREIGN KEY (id_cliente)
        REFERENCES clientes(id)
);

-- ===========================
-- TABLA DETALLE_VENTAS
-- ===========================
CREATE TABLE detalle_ventas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_venta INT NOT NULL,
    id_celular INT NOT NULL,
    cantidad INT NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,
    CONSTRAINT fk_detalle_venta
        FOREIGN KEY (id_venta)
        REFERENCES ventas(id),
    CONSTRAINT fk_detalle_celular
        FOREIGN KEY (id_celular)
        REFERENCES celulares(id)
);