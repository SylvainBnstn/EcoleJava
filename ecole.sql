-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 28, 2019 at 05:32 PM
-- Server version: 5.7.24
-- PHP Version: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ecole`
--
CREATE DATABASE IF NOT EXISTS `ecole` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `ecole`;

-- --------------------------------------------------------

--
-- Table structure for table `annee`
--

DROP TABLE IF EXISTS `annee`;
CREATE TABLE IF NOT EXISTS `annee` (
  `Id_annee` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Id_annee`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `bulletin`
--

DROP TABLE IF EXISTS `bulletin`;
CREATE TABLE IF NOT EXISTS `bulletin` (
  `Id_bulletin` int(11) NOT NULL AUTO_INCREMENT,
  `Id_trimestre` int(11) NOT NULL,
  `Id_eleve` int(11) NOT NULL,
  `Appreciation` varchar(255) NOT NULL,
  PRIMARY KEY (`Id_bulletin`),
  KEY `Id_eleve` (`Id_eleve`),
  KEY `Id_trimestre` (`Id_trimestre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `classe`
--

DROP TABLE IF EXISTS `classe`;
CREATE TABLE IF NOT EXISTS `classe` (
  `Id_classe` int(11) NOT NULL AUTO_INCREMENT,
  `Id_niveau` int(11) NOT NULL,
  `Nom` varchar(255) NOT NULL,
  `Id_annee` int(11) NOT NULL,
  PRIMARY KEY (`Id_classe`),
  KEY `classe_ibfk_1` (`Id_annee`),
  KEY `Id_niveau` (`Id_niveau`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `detail_bulletin`
--

DROP TABLE IF EXISTS `detail_bulletin`;
CREATE TABLE IF NOT EXISTS `detail_bulletin` (
  `Id_detail_bulletin` int(11) NOT NULL AUTO_INCREMENT,
  `Id_bulletin` int(11) NOT NULL,
  `Id_enseignant` int(11) NOT NULL,
  `Appreciation` varchar(255) NOT NULL,
  PRIMARY KEY (`Id_detail_bulletin`),
  KEY `Id_bulletin` (`Id_bulletin`),
  KEY `Id_enseignant` (`Id_enseignant`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `discipline`
--

DROP TABLE IF EXISTS `discipline`;
CREATE TABLE IF NOT EXISTS `discipline` (
  `Id_discipline` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  PRIMARY KEY (`Id_discipline`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `eleve`
--

DROP TABLE IF EXISTS `eleve`;
CREATE TABLE IF NOT EXISTS `eleve` (
  `Id_eleve` int(11) NOT NULL AUTO_INCREMENT,
  `Id_classe` int(11) NOT NULL,
  `Id_personne` int(11) NOT NULL,
  PRIMARY KEY (`Id_eleve`),
  KEY `Id_classe` (`Id_classe`),
  KEY `Id_personne` (`Id_personne`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `enseignant`
--

DROP TABLE IF EXISTS `enseignant`;
CREATE TABLE IF NOT EXISTS `enseignant` (
  `Id_enseignant` int(11) NOT NULL AUTO_INCREMENT,
  `Id_classe` int(11) NOT NULL,
  `Id_discipline` int(11) NOT NULL,
  `Id_personne` int(11) NOT NULL,
  PRIMARY KEY (`Id_enseignant`),
  KEY `Id_classe` (`Id_classe`),
  KEY `Id_personne` (`Id_personne`),
  KEY `Id_discipline` (`Id_discipline`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `niveau`
--

DROP TABLE IF EXISTS `niveau`;
CREATE TABLE IF NOT EXISTS `niveau` (
  `Id_niveau` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  PRIMARY KEY (`Id_niveau`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `note`
--

DROP TABLE IF EXISTS `note`;
CREATE TABLE IF NOT EXISTS `note` (
  `Id_note` int(11) NOT NULL AUTO_INCREMENT,
  `Id_detail_bulletin` int(11) NOT NULL,
  `Appreciation` varchar(255) NOT NULL,
  `Note` float(11) NOT NULL,
  PRIMARY KEY (`Id_note`),
  KEY `Id_detail_bulletin` (`Id_detail_bulletin`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `personne`
--

DROP TABLE IF EXISTS `personne`;
CREATE TABLE IF NOT EXISTS `personne` (
  `Id_personne` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  `Prenom` varchar(255) NOT NULL,
  `Type` int(11) NOT NULL,
  PRIMARY KEY (`Id_personne`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `trimestre`
--

DROP TABLE IF EXISTS `trimestre`;
CREATE TABLE IF NOT EXISTS `trimestre` (
  `IdTrimestre` int(11) NOT NULL AUTO_INCREMENT,
  `Numero` int(11) NOT NULL,
  `Debut` int(11) NOT NULL,
  `Fin` int(11) NOT NULL,
  `Id_annee` int(11) NOT NULL,
  PRIMARY KEY (`IdTrimestre`),
  KEY `IdAnnee` (`Id_annee`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bulletin`
--
ALTER TABLE `bulletin`
  ADD CONSTRAINT `bulletin_ibfk_1` FOREIGN KEY (`Id_eleve`) REFERENCES `eleve` (`Id_eleve`),
  ADD CONSTRAINT `bulletin_ibfk_2` FOREIGN KEY (`Id_trimestre`) REFERENCES `trimestre` (`IdTrimestre`);

--
-- Constraints for table `classe`
--
ALTER TABLE `classe`
  ADD CONSTRAINT `classe_ibfk_1` FOREIGN KEY (`Id_annee`) REFERENCES `annee` (`Id_annee`),
  ADD CONSTRAINT `classe_ibfk_2` FOREIGN KEY (`Id_niveau`) REFERENCES `niveau` (`Id_niveau`);

--
-- Constraints for table `detail_bulletin`
--
ALTER TABLE `detail_bulletin`
  ADD CONSTRAINT `detail_bulletin_ibfk_1` FOREIGN KEY (`Id_bulletin`) REFERENCES `bulletin` (`Id_bulletin`),
  ADD CONSTRAINT `detail_bulletin_ibfk_2` FOREIGN KEY (`Id_enseignant`) REFERENCES `enseignant` (`Id_enseignant`);

--
-- Constraints for table `eleve`
--
ALTER TABLE `eleve`
  ADD CONSTRAINT `eleve_ibfk_1` FOREIGN KEY (`Id_classe`) REFERENCES `classe` (`Id_classe`),
  ADD CONSTRAINT `eleve_ibfk_2` FOREIGN KEY (`Id_personne`) REFERENCES `personne` (`Id_personne`);

--
-- Constraints for table `enseignant`
--
ALTER TABLE `enseignant`
  ADD CONSTRAINT `enseignant_ibfk_1` FOREIGN KEY (`Id_classe`) REFERENCES `classe` (`Id_classe`),
  ADD CONSTRAINT `enseignant_ibfk_2` FOREIGN KEY (`Id_personne`) REFERENCES `personne` (`Id_personne`),
  ADD CONSTRAINT `enseignant_ibfk_3` FOREIGN KEY (`Id_discipline`) REFERENCES `discipline` (`Id_discipline`);

--
-- Constraints for table `note`
--
ALTER TABLE `note`
  ADD CONSTRAINT `note_ibfk_1` FOREIGN KEY (`Id_detail_bulletin`) REFERENCES `detail_bulletin` (`Id_detail_bulletin`);

--
-- Constraints for table `trimestre`
--
ALTER TABLE `trimestre`
  ADD CONSTRAINT `trimestre_ibfk_1` FOREIGN KEY (`Id_annee`) REFERENCES `annee` (`Id_annee`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
