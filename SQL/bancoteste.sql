-- MySQL dump 10.13  Distrib 5.7.26, for Linux (x86_64)
--
-- Host: localhost    Database: prontuario
-- ------------------------------------------------------
-- Server version	5.7.26-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `consultas`
--

DROP TABLE IF EXISTS `consultas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consultas` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SINTOMAS` varchar(300) NOT NULL,
  `OBSERVACOES` varchar(100) DEFAULT NULL,
  `DATA_HORA` datetime DEFAULT NULL,
  `PACIENTE_ID` int(11) NOT NULL,
  `MEDICO_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `PACIENTE_ID` (`PACIENTE_ID`),
  KEY `MEDICO_ID` (`MEDICO_ID`),
  CONSTRAINT `consultas_ibfk_1` FOREIGN KEY (`PACIENTE_ID`) REFERENCES `pacientes` (`ID`),
  CONSTRAINT `consultas_ibfk_2` FOREIGN KEY (`MEDICO_ID`) REFERENCES `medicos` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consultas`
--

LOCK TABLES `consultas` WRITE;
/*!40000 ALTER TABLE `consultas` DISABLE KEYS */;
INSERT INTO `consultas` VALUES (2,'Dor nas costas','','2019-05-03 12:00:00',1,1);
/*!40000 ALTER TABLE `consultas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionarios`
--

DROP TABLE IF EXISTS `funcionarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionarios` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `MATRICULA` varchar(20) NOT NULL,
  `NOME` varchar(50) NOT NULL,
  `CPF` varchar(20) NOT NULL,
  `SENHA` varchar(200) NOT NULL,
  `DT_NASCIMENTO` date DEFAULT NULL,
  `FUNCAO` varchar(50) DEFAULT NULL,
  `ATIVO` char(1) NOT NULL,
  `PERMISSAO` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionarios`
--

LOCK TABLES `funcionarios` WRITE;
/*!40000 ALTER TABLE `funcionarios` DISABLE KEYS */;
INSERT INTO `funcionarios` VALUES (1,'20170300015','Bruno Ricardo Silva Trindade','039.243.022-35','202cb962ac59075b964b07152d234b70','2000-05-03','Gerente','S',1),(2,'20170300014','Bruno Ricardo Silva Trindade','111.111.111-11','202cb962ac59075b964b07152d234b70','2000-05-03','Gerente','S',2);
/*!40000 ALTER TABLE `funcionarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicos`
--

DROP TABLE IF EXISTS `medicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicos` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CRM` varchar(20) NOT NULL,
  `ESPECIALIDADE` varchar(50) NOT NULL,
  `FUNCIONARIO_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FUNCIONARIO_ID` (`FUNCIONARIO_ID`),
  CONSTRAINT `medicos_ibfk_1` FOREIGN KEY (`FUNCIONARIO_ID`) REFERENCES `funcionarios` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicos`
--

LOCK TABLES `medicos` WRITE;
/*!40000 ALTER TABLE `medicos` DISABLE KEYS */;
INSERT INTO `medicos` VALUES (1,'1234-5','Clínico Geral',2);
/*!40000 ALTER TABLE `medicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pacientes`
--

DROP TABLE IF EXISTS `pacientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pacientes` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(50) NOT NULL,
  `CPF` varchar(15) NOT NULL,
  `DT_NASCIMENTO` date DEFAULT NULL,
  `ESTADO_CIVIL` varchar(50) DEFAULT NULL,
  `CONJUGE` varchar(50) DEFAULT NULL,
  `ENDERECO` varchar(60) DEFAULT NULL,
  `BAIRRO` varchar(50) DEFAULT NULL,
  `CIDADE` varchar(50) DEFAULT NULL,
  `CEP` varchar(50) DEFAULT NULL,
  `UF` char(2) DEFAULT NULL,
  `FONE` varchar(25) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `PROFISSAO` varchar(50) DEFAULT NULL,
  `OBITO` char(1) NOT NULL,
  `OBS` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pacientes`
--

LOCK TABLES `pacientes` WRITE;
/*!40000 ALTER TABLE `pacientes` DISABLE KEYS */;
INSERT INTO `pacientes` VALUES (1,'Raimundo Irineu','123.123.123-12','1980-03-01','Solteiro','Ninguem','Rua Ovo','Galinha','Rio Branco','','AC','','','Pedreiro','N','');
/*!40000 ALTER TABLE `pacientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perguntas`
--

DROP TABLE IF EXISTS `perguntas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perguntas` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRICAO` varchar(80) NOT NULL,
  `TIPO` int(11) NOT NULL,
  `QUESTIONARIO` char(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perguntas`
--

LOCK TABLES `perguntas` WRITE;
/*!40000 ALTER TABLE `perguntas` DISABLE KEYS */;
/*!40000 ALTER TABLE `perguntas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `procedimentos`
--

DROP TABLE IF EXISTS `procedimentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `procedimentos` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TIPO` varchar(30) NOT NULL,
  `DESCRICAO` varchar(80) NOT NULL,
  `DATA_HORA` datetime NOT NULL,
  `CONSULTA_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `CONSULTA_ID` (`CONSULTA_ID`),
  CONSTRAINT `procedimentos_ibfk_1` FOREIGN KEY (`CONSULTA_ID`) REFERENCES `consultas` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `procedimentos`
--

LOCK TABLES `procedimentos` WRITE;
/*!40000 ALTER TABLE `procedimentos` DISABLE KEYS */;
/*!40000 ALTER TABLE `procedimentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `respostas`
--

DROP TABLE IF EXISTS `respostas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `respostas` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CONTEUDO` varchar(50) NOT NULL,
  `PERGUNTA_ID` int(11) NOT NULL,
  `PACIENTE_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `PERGUNTA_ID` (`PERGUNTA_ID`),
  KEY `PACIENTE_ID` (`PACIENTE_ID`),
  CONSTRAINT `respostas_ibfk_1` FOREIGN KEY (`PERGUNTA_ID`) REFERENCES `perguntas` (`ID`),
  CONSTRAINT `respostas_ibfk_2` FOREIGN KEY (`PACIENTE_ID`) REFERENCES `pacientes` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respostas`
--

LOCK TABLES `respostas` WRITE;
/*!40000 ALTER TABLE `respostas` DISABLE KEYS */;
/*!40000 ALTER TABLE `respostas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-09 21:57:28
