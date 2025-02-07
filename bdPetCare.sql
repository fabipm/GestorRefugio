-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.27-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.4.0.6659
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para bdrefugio
CREATE DATABASE IF NOT EXISTS `bdrefugio` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `bdrefugio`;

-- Volcando estructura para tabla bdrefugio.administrador
CREATE TABLE IF NOT EXISTS `administrador` (
  `idAdministrador` int(11) NOT NULL AUTO_INCREMENT,
  `idCargo` int(11) DEFAULT NULL,
  `DNI` varchar(50) NOT NULL DEFAULT '0',
  `contraseña` varchar(30) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idAdministrador`),
  KEY `idCargo` (`idCargo`),
  CONSTRAINT `administrador_ibfk_1` FOREIGN KEY (`idCargo`) REFERENCES `cargo` (`idCargo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla bdrefugio.administrador: ~1 rows (aproximadamente)
INSERT INTO `administrador` (`idAdministrador`, `idCargo`, `DNI`, `contraseña`, `nombre`) VALUES
	(1, 1, '123456', '123', 'SuperUsuario');

-- Volcando estructura para tabla bdrefugio.adoptante
CREATE TABLE IF NOT EXISTS `adoptante` (
  `idAdoptante` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(50) NOT NULL,
  `apellidopaterno` varchar(50) NOT NULL,
  `apellidomaterno` varchar(50) DEFAULT NULL,
  `fecha` date NOT NULL,
  `idDistrito` int(11) DEFAULT NULL,
  `genero` enum('masculino','femenino') DEFAULT NULL,
  `ocupacion` varchar(20) NOT NULL,
  `celular` varchar(20) NOT NULL,
  `edad` varchar(2) NOT NULL,
  `dni` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idAdoptante`),
  KEY `idDistrito` (`idDistrito`),
  CONSTRAINT `adoptante_ibfk_1` FOREIGN KEY (`idDistrito`) REFERENCES `distrito` (`idDistrito`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla bdrefugio.adoptante: ~4 rows (aproximadamente)
INSERT INTO `adoptante` (`idAdoptante`, `nombres`, `apellidopaterno`, `apellidomaterno`, `fecha`, `idDistrito`, `genero`, `ocupacion`, `celular`, `edad`, `dni`) VALUES
	(1, 'PABLO DANIEL', 'SALAZAR', 'PEÑA', '2024-04-23', 2, 'masculino', 'Estudiante', '987854854', '18', '75369721'),
	(2, 'LINDA NICOL TATIANA', 'YANAPA', 'JILAJA', '2024-04-23', 3, 'femenino', 'Estudiante', '987654654', '22', '77505558'),
	(3, 'EDITH NAYELI', 'GOMEZ', 'QUISPE', '2024-04-23', 3, 'femenino', 'Estudiante', '987654654', '22', '75537143'),
	(4, 'DIONICIO EVARISTO', 'CHAMBE', 'CHAMBILLA', '2024-04-23', 4, 'masculino', 'Estudiante', '987321321', '45', '71218507'),
	(5, 'JAIME ELIAS', 'FLORES', 'QUISPE', '2024-04-23', 5, 'masculino', 'Estudiante', '987987987', '20', '72883481');

-- Volcando estructura para tabla bdrefugio.animal
CREATE TABLE IF NOT EXISTS `animal` (
  `idAnimal` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) DEFAULT NULL,
  `fecha` date NOT NULL,
  `estado` enum('activo','inactivo') DEFAULT 'activo',
  `genero` enum('macho','hembra') DEFAULT NULL,
  `tipo` enum('perro','gato') DEFAULT NULL,
  `foto` longblob DEFAULT NULL,
  `raza` varchar(30) DEFAULT NULL,
  `edad` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`idAnimal`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla bdrefugio.animal: ~3 rows (aproximadamente)
INSERT INTO `animal` (`idAnimal`, `nombre`, `fecha`, `estado`, `genero`, `tipo`, `foto`, `raza`, `edad`) VALUES
	(1, 'Choco', '2024-04-23', 'activo', 'macho', 'perro','' , 'Mezclado', '2');
INSERT INTO `animal` (`idAnimal`, `nombre`, `fecha`, `estado`, `genero`, `tipo`, `foto`, `raza`, `edad`) VALUES
	(2, 'Tobi', '2024-04-23', 'activo', 'macho', 'perro', '' , 'grandanes', '2'),
	(3, 'Copito', '2024-04-23', 'activo', 'hembra', 'gato', '' , 'Persa', '1');

-- Volcando estructura para tabla bdrefugio.cargo
CREATE TABLE IF NOT EXISTS `cargo` (
  `idCargo` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(20) NOT NULL,
  PRIMARY KEY (`idCargo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla bdrefugio.cargo: ~2 rows (aproximadamente)
INSERT INTO `cargo` (`idCargo`, `Nombre`) VALUES
	(1, 'Administrador'),
	(2, 'Voluntario');

-- Volcando estructura para tabla bdrefugio.distrito
CREATE TABLE IF NOT EXISTS `distrito` (
  `idDistrito` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) NOT NULL,
  PRIMARY KEY (`idDistrito`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla bdrefugio.distrito: ~5 rows (aproximadamente)
INSERT INTO `distrito` (`idDistrito`, `nombre`) VALUES
	(1, 'Alto de la Alianza'),
	(2, 'Coronel Gregorio Albarracín Lanchipa'),
	(3, 'Ciudad Nueva'),
	(4, 'Pocollay'),
	(5, 'Tacna');

-- Volcando estructura para tabla bdrefugio.evidencia
CREATE TABLE IF NOT EXISTS `evidencia` (
  `idEvidencia` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` enum('si','no') DEFAULT 'no',
  PRIMARY KEY (`idEvidencia`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla bdrefugio.evidencia: ~2 rows (aproximadamente)
INSERT INTO `evidencia` (`idEvidencia`, `nombre`) VALUES
	(1, 'no'),
	(2, 'si');

-- Volcando estructura para tabla bdrefugio.formularioadopcion
CREATE TABLE IF NOT EXISTS `formularioadopcion` (
  `idFormularioAdopcion` int(11) NOT NULL AUTO_INCREMENT,
  `idEvidencia` int(11) NOT NULL,
  `idAdoptante` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `p1` varchar(255) DEFAULT NULL,
  `p2` varchar(255) DEFAULT NULL,
  `p3` varchar(255) DEFAULT NULL,
  `p4` varchar(255) DEFAULT NULL,
  `p5` varchar(255) DEFAULT NULL,
  `estado` enum('aprobado','pendiente','rechazado') DEFAULT 'pendiente',
  `nombre` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idFormularioAdopcion`),
  KEY `idEvidencia` (`idEvidencia`),
  KEY `idAdoptante` (`idAdoptante`),
  CONSTRAINT `formularioadopcion_ibfk_3` FOREIGN KEY (`idEvidencia`) REFERENCES `evidencia` (`idEvidencia`),
  CONSTRAINT `formularioadopcion_ibfk_4` FOREIGN KEY (`idAdoptante`) REFERENCES `adoptante` (`idAdoptante`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla bdrefugio.formularioadopcion: ~4 rows (aproximadamente)
INSERT INTO `formularioadopcion` (`idFormularioAdopcion`, `idEvidencia`, `idAdoptante`, `fecha`, `p1`, `p2`, `p3`, `p4`, `p5`, `estado`, `nombre`) VALUES
	(1, 1, 1, '2024-04-23', 'Si, me gustan mucho', 'SI, anteriormente tenia un perro', 'La mayoria del dia solo no podre estar cuando trabaje', 'Siento que me falta una compañia en casa', 'No, me quedare siempre en tacna, enc aso sea mudarme lo haria con mi mascota', 'pendiente', 'SuperUsuario'),
	(2, 1, 2, '2024-04-23', 'No, pero me gustaria la verdad', 'Cuidaba las de mi abuela', 'Creo que la mayoria del dia', 'Ya tengo la responsabilidad para cuidar a un pequeño', 'No, pero sacaria todos los permisos', 'pendiente', 'SuperUsuario'),
	(3, 1, 3, '2024-04-23', 'Si, me gusta mucho', 'Si, toda la vida', 'Todo el dia', 'Porque quiero compañia para mi perro', 'Sacaria los papeles correspodientes', 'aprobado', 'SuperUsuario'),
	(4, 1, 4, '2024-04-23', 'No la verdad que no', 'No seria la primera vez', 'Lo necesario no salgo mucho', 'Porrque me gustan los animales', 'Si, me mudare a otro lugar lo llevaria conmigo', 'aprobado', 'SuperUsuario'),
	(5, 2, 5, '2024-04-23', 'Si ', 'Si antes ', 'La amyoria del tiempo', 'asdas', 'asdsd', 'aprobado', 'ELARD RICARDO');

-- Volcando estructura para tabla bdrefugio.voluntario
CREATE TABLE IF NOT EXISTS `voluntario` (
  `idVoluntario` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `nombres` varchar(50) NOT NULL,
  `apellidopaterno` varchar(100) NOT NULL,
  `apellidomaterno` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `idDistrito` int(11) NOT NULL,
  `genero` enum('masculino','femenino') DEFAULT NULL,
  `ocupacion` varchar(20) DEFAULT NULL,
  `edad` varchar(2) NOT NULL,
  `clave` varchar(8) DEFAULT NULL,
  `idCargo` int(11) NOT NULL DEFAULT 2,
  `estado` enum('activo','inactivo') DEFAULT 'activo',
  `DNI` varchar(12) DEFAULT NULL,
  `hora_inicio` time DEFAULT NULL,
  `hora_fin` time DEFAULT NULL,
  PRIMARY KEY (`idVoluntario`),
  KEY `idCargo` (`idCargo`),
  KEY `idDistrito` (`idDistrito`),
  CONSTRAINT `voluntario_ibfk_1` FOREIGN KEY (`idCargo`) REFERENCES `cargo` (`idCargo`),
  CONSTRAINT `voluntario_ibfk_2` FOREIGN KEY (`idDistrito`) REFERENCES `distrito` (`idDistrito`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla bdrefugio.voluntario: ~1 rows (aproximadamente)
INSERT INTO `voluntario` (`idVoluntario`, `fecha`, `nombres`, `apellidopaterno`, `apellidomaterno`, `direccion`, `idDistrito`, `genero`, `ocupacion`, `edad`, `clave`, `idCargo`, `estado`, `DNI`, `hora_inicio`, `hora_fin`) VALUES
	(1, '2024-04-23', 'FABIOLA ESTEFANI', 'POMA', 'MACHICADO', 'Urba Tcana', 1, 'femenino', 'Estudiante', '20', '1379', 2, 'activo', '74575952', '15:00:00', '20:00:00'),
	(2, '2024-04-23', 'ELARD RICARDO', 'RODRIGUEZ', 'MARCA', 'Urba Tacna', 4, 'masculino', 'Ingeniero', '30', '888', 2, 'activo', '04743075', '16:00:00', '17:00:00'),
	(3, '2024-04-23', 'ERICK YOEL', 'AYMA', 'CHOQUE', 'tata', 1, 'femenino', 'asd', '20', '1346', 2, 'activo', '70850581', '08:00:00', '09:00:00');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
