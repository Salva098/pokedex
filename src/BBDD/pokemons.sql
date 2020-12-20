-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: pokedex
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `usuario` varchar(255) NOT NULL,
  `contrasena` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('admin','admin'),('admin1','admin1');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pokemon`
--

DROP TABLE IF EXISTS `pokemon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pokemon` (
  `n_pokemon` int NOT NULL,
  `Nombre` varchar(255) DEFAULT NULL,
  `Altura` float DEFAULT NULL,
  `Categoria` varchar(255) DEFAULT NULL,
  `Peso` float DEFAULT NULL,
  `Descripcion` varchar(500) DEFAULT NULL,
  `Habilidad` varchar(255) DEFAULT NULL,
  `Sonido` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`n_pokemon`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pokemon`
--

LOCK TABLES `pokemon` WRITE;
/*!40000 ALTER TABLE `pokemon` DISABLE KEYS */;
INSERT INTO `pokemon` VALUES (1,'Bulbasaur',0.7,'Semilla',6.9,'Este Pokémon nace con una semilla en el lomo, que brota con el paso del tiempo.','Espesura','https://play.pokemonshowdown.com/audio/cries/charmander.mp3'),(2,'Ivysaur',1,'Semilla',13,'Cuando le crece bastante el bulbo del lomo, pierde la capacidad de erguirse sobre las patas traseras.','Espesura','https://play.pokemonshowdown.com/audio/cries/ivysaur.mp3'),(3,'Venusaur',2,'Semilla',100,'La planta florece cuando absorbe energía solar, lo cual le obliga a buscar siempre la luz del sol.','Semilla','https://play.pokemonshowdown.com/audio/cries/venusaur.mp3'),(4,'Charmander ',0.6,'Lagartija',8.5,'Prefiere las cosas calientes. Dicen que cuando llueve le sale vapor de la punta de la cola.','Mar Llamas','https://play.pokemonshowdown.com/audio/cries/charmander.mp3');
/*!40000 ALTER TABLE `pokemon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pokemon_tipos`
--

DROP TABLE IF EXISTS `pokemon_tipos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pokemon_tipos` (
  `n_pokemon` int NOT NULL,
  `idTipos` int NOT NULL,
  PRIMARY KEY (`n_pokemon`,`idTipos`),
  KEY `idTipos_idx` (`idTipos`),
  CONSTRAINT `idTipos` FOREIGN KEY (`idTipos`) REFERENCES `tipos` (`idTipos`),
  CONSTRAINT `n_pokemon` FOREIGN KEY (`n_pokemon`) REFERENCES `pokemon` (`n_pokemon`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pokemon_tipos`
--

LOCK TABLES `pokemon_tipos` WRITE;
/*!40000 ALTER TABLE `pokemon_tipos` DISABLE KEYS */;
/*!40000 ALTER TABLE `pokemon_tipos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos`
--

DROP TABLE IF EXISTS `tipos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipos` (
  `idTipos` int NOT NULL,
  `Tipo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idTipos`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos`
--

LOCK TABLES `tipos` WRITE;
/*!40000 ALTER TABLE `tipos` DISABLE KEYS */;
INSERT INTO `tipos` VALUES (0,'acero'),(1,'agua'),(2,'bicho'),(3,'dragon'),(4,'electrico'),(5,'fuego'),(6,'hada'),(7,'hielo'),(8,'lucha'),(9,'normal'),(10,'planta'),(11,'psiquico'),(12,'roca'),(13,'siniestro'),(14,'tierra'),(15,'veneno'),(16,'volador');
/*!40000 ALTER TABLE `tipos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-20 20:31:34
