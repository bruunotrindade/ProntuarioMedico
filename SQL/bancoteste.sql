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

CREATE DATABASE prontuario;

USE prontuario;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consultas`
--

LOCK TABLES `consultas` WRITE;
/*!40000 ALTER TABLE `consultas` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionarios`
--

LOCK TABLES `funcionarios` WRITE;
/*!40000 ALTER TABLE `funcionarios` DISABLE KEYS */;
INSERT INTO `funcionarios` VALUES (1,'20170300015','Bruno Ricardo Silva Trindade','039.243.022-35','202cb962ac59075b964b07152d234b70','2000-05-03','Gerente','S',1),(2,'20170300014','Bruno Ricardo Silva Trindade','111.111.111-11','202cb962ac59075b964b07152d234b70','2000-05-03','Medico','S',1),(3,'123','Ademir','222.222.222-22','202cb962ac59075b964b07152d234b70','2000-05-03','Ademir','S',3),(6,'431','Hurdu','444.444.444-44','202cb962ac59075b964b07152d234b70','2003-03-03','Hurdu','N',1);
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
INSERT INTO `medicos` VALUES (1,'1234-5','Oftalmologista',2);
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
  `SEXO` char(1) DEFAULT NULL,
  `DT_NASCIMENTO` date DEFAULT NULL,
  `ESTADO_CIVIL` varchar(50) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pacientes`
--

LOCK TABLES `pacientes` WRITE;
/*!40000 ALTER TABLE `pacientes` DISABLE KEYS */;
INSERT INTO `pacientes` VALUES (1,'Raimundo Irineu','123.123.123-12','M','1980-03-01','Solteiro','Rua Ovo','Galinha','Rio Branco','','AC','','','Pedreiro','N',''),(3,'Romeu Julieto','112.312.312-31','M','2003-03-03','Solteiro','','','','     -   ','AC','     -    ','','','N','');
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
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perguntas`
--

LOCK TABLES `perguntas` WRITE;
/*!40000 ALTER TABLE `perguntas` DISABLE KEYS */;
INSERT INTO `perguntas` VALUES (30,'Infarto?',1,'A'),(31,'Hipertensão Arterial (Pressão Alta)?',1,'A'),(32,'Dispnéia (Falta de ar)?',1,'A'),(33,'Asma?',1,'A'),(34,'Tuberculose?',1,'A'),(35,'Bronquite (Tosse crônica)?',1,'A'),(36,'Doença do estômago (úlcera, gastrite)?',1,'A'),(37,'Doença do fígado (hepatite)?',1,'A'),(38,'Hérnia?',1,'A'),(39,'Doença do pâncreas (pancreatite)?',1,'A'),(40,'Diabetes?',1,'A'),(41,'Câncer ou tumores?',1,'A'),(42,'Doença da pele?',1,'A'),(43,'Cefaléias (dores de cabeça frequentes)?',1,'A'),(44,'Cálculo biliar?',1,'A'),(45,'Dores no corpo?',1,'A'),(46,'Doenças da tireóide?',1,'A'),(47,'Alergia? Se sim, qual?',0,'A'),(48,'Intolerância a vacinas ou soros?',1,'A'),(49,'Fraturas?',1,'A'),(50,'Reumatismo?',1,'A'),(51,'Já foi submetido a cirurgia?',1,'A'),(52,'Alcoolismo?',1,'A'),(53,'Doença dos nervos?',1,'A'),(54,'Diabetes?',1,'H'),(55,'Doenças do coração?',1,'H'),(56,'Pressão alta?',1,'H'),(57,'Câncer?',1,'H'),(58,'Depressão?',1,'H'),(59,'Surdez?',1,'H'),(60,'Alcoolismo?',1,'H'),(61,'Tuberculose pulmonar?',1,'H'),(62,'Asma?',1,'H'),(63,'Alergia? Se sim, qual?',0,'H');
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
) ENGINE=InnoDB AUTO_INCREMENT=137 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respostas`
--

LOCK TABLES `respostas` WRITE;
/*!40000 ALTER TABLE `respostas` DISABLE KEYS */;
INSERT INTO `respostas` VALUES (103,'Não',30,3),(104,'Não',31,3),(105,'Não',32,3),(106,'Sim',33,3),(107,'Sim',34,3),(108,'Sim',35,3),(109,'Sim',36,3),(110,'Sim',37,3),(111,'Sim',38,3),(112,'Sim',39,3),(113,'Sim',40,3),(114,'Sim',41,3),(115,'Sim',42,3),(116,'Sim',43,3),(117,'Sim',44,3),(118,'Sim',45,3),(119,'Sim',46,3),(120,'Sim',47,3),(121,'Sim',48,3),(122,'Sim',49,3),(123,'Sim',50,3),(124,'Sim',51,3),(125,'Sim',52,3),(126,'Sim',53,3),(127,'Avó',54,3),(128,'Não',55,3),(129,'Não',56,3),(130,'Não',57,3),(131,'Não',58,3),(132,'Tio',59,3),(133,'Pai',60,3),(134,'Pai',61,3),(135,'Não',62,3),(136,'Não',63,3);
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

-- Dump completed on 2019-07-18 22:36:44
