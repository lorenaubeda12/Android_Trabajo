-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 22-03-2023 a las 23:13:26
-- Versión del servidor: 8.0.32
-- Versión de PHP: 7.4.3-4ubuntu2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db4free_sys`
--
CREATE DATABASE IF NOT EXISTS `db4free_sys` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `db4free_sys`;
--
-- Base de datos: `lorena_trabajo`
--
CREATE DATABASE IF NOT EXISTS `lorena_trabajo` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `lorena_trabajo`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id_categoria` int NOT NULL,
  `nombre_categoria` varchar(60) NOT NULL,
  `img_categoria` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id_categoria`, `nombre_categoria`, `img_categoria`) VALUES
(1, 'Zapatilla', 'https://drive.google.com/file/d/1aIoZNwtx_9DE98jOKNW2mdZWdKvY3deL/view?usp=sharing'),
(2, 'Blusa', 'https://drive.google.com/file/d/1wcb8oRgtmW-DTxhsAC1x49_RDnyb4PMz/view?usp=sharing'),
(3, 'Bota', 'https://drive.google.com/file/d/1LIlFMk5PpRGh6pTnR3tsFdLF05sI6YbG/view?usp=share_link'),
(4, 'Gorro', 'https://drive.google.com/file/d/1J8I-H2TsATCJmbNvMY0p0t103keZ3Xv7/view?usp=share_link'),
(5, 'Camisa', 'https://drive.google.com/file/d/1oIupMBc1cvldLWm1ULovoRud2P-E9NGH/view?usp=sharing'),
(6, 'Pantalon', 'https://drive.google.com/file/d/1o82A_As0-u2MA-1n6S7qFTagrnfj8ob5/view?usp=sharing'),
(7, 'Vestido', 'https://drive.google.com/file/d/1S_2xHZSb_4oCmNhQleahJ2lO76pSO2Zn/view?usp=sharing'),
(8, 'Bolso', 'https://drive.google.com/file/d/1gZeDTNk-gkm16MeMNAR7uZWxLL-kxaRB/view?usp=share_link'),
(10, 'Chaqueta', 'https://drive.google.com/file/d/1hh25MjnJbtgjJFMXDf5aKcckZP8MbJSn/view?usp=share_link');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

CREATE TABLE `compra` (
  `id_compra` int NOT NULL,
  `id_producto` int NOT NULL,
  `id_usuario` int NOT NULL,
  `fecha_compra` date NOT NULL,
  `precio_compra` decimal(10,0) NOT NULL,
  `tipo_envio` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `compra`
--

INSERT INTO `compra` (`id_compra`, `id_producto`, `id_usuario`, `fecha_compra`, `precio_compra`, `tipo_envio`) VALUES
(1, 19, 8, '2023-03-21', 13, 1),
(2, 2, 2, '2023-03-21', 14, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id` int NOT NULL,
  `nombre_producto` varchar(30) NOT NULL,
  `descripcion` varchar(60) NOT NULL,
  `precio` decimal(10,0) NOT NULL,
  `categoria` int NOT NULL,
  `imagen` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `id_usuario` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `nombre_producto`, `descripcion`, `precio`, `categoria`, `imagen`, `id_usuario`) VALUES
(1, 'Blusa blanca mujer', 'Blusa blanca talla 42, seminueva', 10, 2, 'https://drive.google.com/file/d/1BWAtlB9JfU9YDjfo2WV-vqP3zhY_lmHT/view?usp=share_link', 2),
(2, 'Blusa rayas mujer', 'Blusa blanca talla 42, con rallas azules', 15, 2, 'https://drive.google.com/file/d/1vvpJEbzi8Otdew_7-y_iqhE4pVNsZ8P4/view?usp=share_link', 2),
(3, 'Vestido camisero mujer', 'Vestido camisero talla 42 blanco seminuevo', 13, 7, 'https://drive.google.com/file/d/1Lryc48m-oQgXBxPg4JAf0DE_R1AaASq8/view?usp=share_link', 15),
(4, 'Blusa con cuello negro', 'Blusa blanca con lazo negro en cuello, talla XL ', 8, 2, 'https://drive.google.com/file/d/1nK_yeGei1JaqXbXY5kMfnHBfSnXzg9ix/view?usp=share_link', 15),
(5, 'Blusa hombros descubiertos', 'Blusa con hombros descubiertos talla L ', 6, 2, 'https://drive.google.com/file/d/1Xiv1nI23M7x6xdMkCS89zh206CnDWqP5/view?usp=share_link\r\n', 15),
(6, 'bolso grande negro AMELI', 'Bolso negro de marca AMELI, nuevo a estrenar', 100, 8, 'https://drive.google.com/file/d/10R-cCXeya05Ro6kiEQxA5J0w5gS8695Q/view?usp=share_link', 15),
(7, 'bolso pequeño rojo', 'Bolso rojo pequeño', 30, 8, 'https://drive.google.com/file/d/1Ql0k2mmoYq75pmPLy9fS4sPPuEqScN2P/view?usp=share_link\r\n', 2),
(8, 'bolso pequeño marron', 'Bolso marron pequeño', 15, 8, 'https://drive.google.com/file/d/1DXb6C79_rwnvLUrMezzGWarFMs5jESLK/view?usp=share_link', 2),
(9, 'bolso LV marron grande', 'Bolso marron LV nuevo grande', 200, 8, 'https://drive.google.com/file/d/1gjhGSNWjvie_x0SzPGSU2pBkWyrGCT2h/view?usp=sharing', 14),
(10, 'botas negras bajitas', 'Botas negras bajas de piel .Talla 38. Nuevas a estrenar.', 15, 3, 'https://drive.google.com/file/d/1HlWYutoDTmogtx8F40BxAM4rz9n_HPvN/view?usp=share_link', 3),
(11, 'botas marrones bajitas', 'Botas marrones bajas. Talla 38.  Precio original 20€', 10, 3, 'https://drive.google.com/file/d/1B1EaLsv7oh18fpjiiAAgSNsGvZ6edbtU/view?usp=share_link', 15),
(12, 'botas moradas altas', 'Botas moradas altas. Talla 38', 12, 3, 'https://drive.google.com/file/d/1_rxN8q2FAD229NsiU73bYSfarGaNdwuq/view?usp=share_link', 2),
(13, 'Camisa negra hombre', 'Camisa negra hombre talla L.', 10, 5, 'https://drive.google.com/file/d/1x4R7XHWtSaOSM8mqZQPLHFgrBcMfPgYc/view?usp=share_link', 14),
(14, 'Camisa blanca hombre', 'Camisa blanca hombre talla L.', 8, 5, 'https://drive.google.com/file/d/1YdubKXCyCytUyr8EwsDapc4Cq2MlqFqL/view?usp=share_link', 14),
(15, 'Camisa azul', 'Camisa azul talla XL.', 5, 5, 'https://drive.google.com/file/d/1-S26gJU4kvQknaJNIJ69VG8nLtkPkqRy/view?usp=share_link', 2),
(16, 'Chaqueta marron ', 'Chaqueta marron XL.', 10, 10, 'https://drive.google.com/file/d/1dPeNKUorAWjchdfwJ_rIzLKbd2XxQ1FQ/view?usp=share_link\r\n', 3),
(17, 'Blazer larga rallas ', 'Blazer larga rallas. Talla S.', 10, 10, 'https://drive.google.com/file/d/1qeLJJaZSnwOopgQ2aQOnisE4EH5uTd3C/view?usp=share_link', 15),
(18, 'Chaqueta vaquera hombre ', 'Talla S.', 12, 10, 'https://drive.google.com/file/d/1ZMAdoHtZnHiPnTJwyzggv9PCgDt6gKOk/view?usp=share_link', 3),
(19, 'Americana hombre gris ', 'Talla L. Nueva. Gucci', 45, 10, 'https://drive.google.com/file/d/11QQ5LELEBDsFWC3xjfTwiXFV1FojV4Li/view?usp=share_link', 14),
(20, 'Gorra blanca basica ', 'Gorra blanca basicai', 5, 4, 'https://drive.google.com/file/d/1F0aAxk9n5L-gb9GnsPv2yukw9nfRHkZ3/view?usp=share_link', 14),
(21, 'Gorra pescador ', 'Gorra pescador', 5, 4, 'https://drive.google.com/file/d/1rW2D-OIyZwzjRKVE9O9cI8XwHbvA5_53/view?usp=share_link', 14),
(22, 'Pantalon vaquero hombre ', 'Pantalon talla 36, nuevo', 10, 6, 'https://drive.google.com/file/d/1u8IKpcT3xTGZVRhfVhigxxiLJMrtb3O7/view?usp=share_link\r\n', 3),
(23, 'Pantalon vaquero mujer ', 'Pantalon talla  40, nuevo', 12, 6, 'https://drive.google.com/file/d/19irxO30APhO5aYlsKXSgTPTHzFG1vMRD/view?usp=share_link', 2),
(24, 'Pantalon chino hombre negro ', 'Pantalon talla 50, nuevo', 11, 6, 'https://drive.google.com/file/d/1QoKzeE37Bxp7E3rdyxzCO-UqqemKgzCm/view?usp=share_link', 3),
(25, 'Pantalon chino mujer ', 'Pantalon talla 50, rojo', 11, 6, 'https://drive.google.com/file/d/1nQc_w89X0aXQLx4LSZI99yBpGoFMIPvF/view?usp=share_link', 13),
(26, 'Pantalon vaquero ', 'Pantalon talla 40', 13, 6, 'https://drive.google.com/file/d/1uA1qy-ZmjIInEUU9W0mvevgqtLdAXHSm/view?usp=sharing', 15),
(27, 'Pantalon vaquero ', 'Pantalon talla 38', 10, 6, 'https://drive.google.com/file/d/1lgfzFyIgQWxSF-qZjzv72rp1vVR6CrTQ/view?usp=share_link', 14),
(28, 'Pantalon vaquero ', 'Pantalon talla 40', 18, 6, 'https://drive.google.com/file/d/1LS0oufPl3uQmiTj58P_3FquC85Pkj5QR/view?usp=share_link\r\n', 3),
(29, 'Pantalon vaquero ', 'Pantalon talla 40', 13, 6, 'https://drive.google.com/file/d/1Pxip5RpjEkfV9jWAiUfPqlmRBdHTouDc/view?usp=share_link\r\n', 15),
(30, 'Pantalon vaquero ', 'Pantalon talla 40', 13, 6, 'https://drive.google.com/file/d/1ewPm_6EtXK1s6CEGBp5fIMoY1wA79CiY/view?usp=share_link\r\n', 2),
(31, 'Vestido naranja ', 'Vestido mexico naranja talla XL', 5, 7, 'https://drive.google.com/file/d/1icP13OoN1R9Qe6lVDWA3ZVokudZ2ZP0m/view?usp=share_link', 14),
(32, 'Vestido flores ', 'Vestido flores rojo talla XL', 15, 7, 'https://drive.google.com/file/d/1lFTRGSh8Y-lHvvPDySMjLI53JkZ3dUts/view?usp=share_link\r\n', 14),
(33, 'Vestido amarillo largo', 'Vestido largo amarillo .Talla L', 20, 7, 'https://drive.google.com/file/d/1VMk56mRtOlDFzB8ifwdW1N0rPa30dnpG/view?usp=share_link\r\n', 14),
(34, 'Mono marron', 'Talla L', 20, 7, 'https://drive.google.com/file/d/1FINTATktHvMglE81kiLwMRTKqzShKj9w/view?usp=share_link', 2),
(35, 'Vestido de fiesta plateado', 'Talla L', 40, 7, 'https://drive.google.com/file/d/1Kq7TTLzijSG7D0FRlCo6xBI4Xnaufxrv/view?usp=share_link', 15),
(36, 'Vestido flores largo', 'Talla S', 10, 7, 'https://drive.google.com/file/d/1q1dqPOQT74pghUZWoKTS3CEJiCZR1WN7/view?usp=sharing', 2),
(37, 'Converse rojas', 'Talla 40 ', 25, 1, 'https://drive.google.com/file/d/1RTL-0GcIkNoUoe0kocL6pMUcNu_whJMp/view?usp=share_link', 13),
(38, 'Zapatillas blancas bajas', 'Talla 36 ', 25, 1, 'https://drive.google.com/file/d/14XswtJzYNZANwgUF2JhJsvKwWloScgAO/view?usp=sharing\r\n', 13),
(39, 'Botas hombre ', 'Talla 36 ', 25, 3, 'https://drive.google.com/file/d/1eEPznnAmdr-Uzfcg2hRfuBMVoyWYLgWf/view?usp=sharing', 13),
(40, 'Zapatillas altas azules ', 'Talla 46 ', 15, 1, 'https://drive.google.com/file/d/1BrKd-PYozlpHgqJJ3gYIWauZf97gvXuL/view?usp=share_link', 2),
(41, 'Zapatillas altas azules ', 'Talla 38 ', 15, 1, 'https://drive.google.com/file/d/17drWopafDCn-P9nPEMTyuKCX49-mg2Wq/view?usp=share_link', 15),
(42, 'Camiseta Negra', 'Camiseta negra XL', 6, 5, 'https://drive.google.com/file/d/16tm2sPNHYAtPribviQi9shx8k1Ob_4Zp/view?usp=sharing', 15);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_envio`
--

CREATE TABLE `tipo_envio` (
  `id_tipo_envio` int NOT NULL,
  `nombre_tipo_envio` varchar(60) NOT NULL,
  `precio` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `tipo_envio`
--

INSERT INTO `tipo_envio` (`id_tipo_envio`, `nombre_tipo_envio`, `precio`) VALUES
(1, 'Envío estándar', 5),
(2, 'Envío gratis', 0),
(3, 'Envío urgente', 10),
(4, 'Certificado', 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellidos` varchar(60) NOT NULL,
  `email` varchar(100) NOT NULL,
  `contrasena` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ciudad` varchar(100) NOT NULL,
  `provincia` varchar(100) NOT NULL,
  `pais` varchar(100) NOT NULL,
  `Direccion` varchar(255) NOT NULL,
  `telefono` varchar(60) NOT NULL,
  `tipo_usuario` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `nombre`, `apellidos`, `email`, `contrasena`, `ciudad`, `provincia`, `pais`, `Direccion`, `telefono`, `tipo_usuario`) VALUES
(1, 'Juan', 'Pérez Rodríguez', 'juanperez@gmail.com', 'contraseña123', 'Madrid', 'Madrid', 'España', '0', '+34666666666', 'cliente'),
(2, 'Maria', 'Gonzales', 'mgonzales@gmail.com', '12345', 'Madrid', 'Madrid', 'España', '0', '+34123456789', 'vendedor'),
(3, 'Juan', 'Martinez', 'juanMartinez1293@gmail.com', 'contraseña', 'Madrid', 'Madrid', 'España', '0', '+3466662226', 'vendedor'),
(4, 'Eugenio', 'Derbez', 'ederbezz@gmail.com', '12346', 'Madrid', 'Madrid', 'España', '0', '+34666677666', 'cliente'),
(5, 'Miguel', 'Pérez Rodríguez', 'miguelMiguel@gmail.com', 'abcde', 'Zaragoza', 'Zaragoza', 'España', '0', '+34633666666', 'cliente'),
(6, 'Pedro', 'Pardos', 'ppardos@gmail.com', 'ppardos', 'Madrid', 'Madrid', 'España', '0', '+34668526666', 'cliente'),
(7, 'Roberto', 'Gaona', 'r.gaona@gmail.com', '141118', 'Madrid', 'Madrid', 'España', '0', '+34123666666', 'cliente'),
(8, 'Ana', 'Blasco', 'ablasco@gmail.com', '123', 'Madrid', 'Madrid', 'España', '0', '+34661216666', 'cliente'),
(9, 'Lorena', 'Ubeda', 'lorenaubeda@gmail.com', 'contraseña123', 'Zaragoza', 'Zaragoza', 'España', '0', '+34668866666', 'cliente'),
(10, 'Martha', 'Ubeda', 'mubeda@gmail.com', 'contraseña123', 'Zaragoza', 'Zaragoza', 'España', '0', '+34634283593', 'cliente'),
(11, 'Nina', 'Gaona', 'ninota@gmail.com', 'miau123', 'Zaragoza', 'Zaragoza', 'España', '0', '+34666666666', 'cliente'),
(12, 'Pandora', 'Lighter', 'pligther@gmail.com', 'contraseña', 'Madrid', 'Madrid', 'España', '0', '+34170620224', 'cliente'),
(13, 'Tinker', 'Chonker', 'tinkercito@gmail.com', 'contraseña123', 'Madrid', 'Madrid', 'España', '0', '+34666666666', 'vendedor'),
(14, 'Emanuel', 'Pérez Rodríguez', 'emmaN@gmail.com', 'contraseña123', 'Madrid', 'Madrid', 'España', '0', '+34666666666', 'vendedor'),
(15, 'Ystola', 'WoL', 'ystola@gmail.com', '123', 'Madrid', 'Madrid', 'España', '0', '+3466666236', 'vendedor'),
(16, 'Lorena', 'Blasco', 'a2613@svalero.com', '123', 'Zaragoza', 'Zaragoza', 'España', 'ave/cataluñaa 26', '671100656', 'vendedor'),
(17, 'Lorena', 'Blasco', 'lorena@lorena.com', '123', 'pruebas', 'pruebas', 'pruebas', 'prueba', '1234567891', 'Comprador'),
(18, 'Pandora', 'Ubeda', 'esto es una prueba', '123', 'Zaragoza', 'Zaragoza', 'España', 'prueba', '123456789', 'Comprador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `valoracion`
--

CREATE TABLE `valoracion` (
  `id_valoracion` int NOT NULL,
  `id_producto` int NOT NULL,
  `id_usuario` int NOT NULL,
  `id_compra` int NOT NULL,
  `valoracion` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `valoracion`
--

INSERT INTO `valoracion` (`id_valoracion`, `id_producto`, `id_usuario`, `id_compra`, `valoracion`) VALUES
(1, 1, 8, 1, 5),
(2, 2, 2, 2, 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Indices de la tabla `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`id_compra`),
  ADD KEY `id_producto` (`id_producto`),
  ADD KEY `id_usuario` (`id_usuario`),
  ADD KEY `tipo_envio` (`tipo_envio`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_usuario` (`id_usuario`),
  ADD KEY `categoria` (`categoria`);

--
-- Indices de la tabla `tipo_envio`
--
ALTER TABLE `tipo_envio`
  ADD PRIMARY KEY (`id_tipo_envio`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `valoracion`
--
ALTER TABLE `valoracion`
  ADD PRIMARY KEY (`id_valoracion`,`id_compra`),
  ADD KEY `id_producto` (`id_producto`),
  ADD KEY `id_usuario` (`id_usuario`),
  ADD KEY `id_compra` (`id_compra`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id_categoria` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `compra`
--
ALTER TABLE `compra`
  MODIFY `id_compra` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT de la tabla `tipo_envio`
--
ALTER TABLE `tipo_envio`
  MODIFY `id_tipo_envio` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `valoracion`
--
ALTER TABLE `valoracion`
  MODIFY `id_valoracion` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id`),
  ADD CONSTRAINT `compra_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `compra_ibfk_3` FOREIGN KEY (`tipo_envio`) REFERENCES `tipo_envio` (`id_tipo_envio`);

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `producto_ibfk_2` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`id_categoria`);

--
-- Filtros para la tabla `valoracion`
--
ALTER TABLE `valoracion`
  ADD CONSTRAINT `valoracion_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id`),
  ADD CONSTRAINT `valoracion_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `valoracion_ibfk_3` FOREIGN KEY (`id_compra`) REFERENCES `compra` (`id_compra`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
