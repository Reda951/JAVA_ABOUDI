-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:8889
-- Généré le : ven. 18 oct. 2024 à 12:52
-- Version du serveur : 5.7.39
-- Version de PHP : 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `Redaaboudi_easytrain`
--

-- --------------------------------------------------------

--
-- Structure de la table `Arret`
--

CREATE TABLE `Arret` (
  `id` int(11) NOT NULL,
  `ville` varchar(100) NOT NULL,
  `heure` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `Arret`
--

INSERT INTO `Arret` (`id`, `ville`, `heure`) VALUES
(1, 'Taverny', '08:00:00'),
(2, 'Saint-Prix', '08:30:00'),
(3, 'Ermont', '09:00:00'),
(4, 'Pontoise', '09:30:00');

-- --------------------------------------------------------

--
-- Structure de la table `Trajet`
--

CREATE TABLE `Trajet` (
  `id` int(11) NOT NULL,
  `moyen_transport` varchar(50) NOT NULL,
  `duree` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `Trajet`
--

INSERT INTO `Trajet` (`id`, `moyen_transport`, `duree`) VALUES
(1, 'Train', 30),
(2, 'Bus', 60);

-- --------------------------------------------------------

--
-- Structure de la table `Trajet_Arret`
--

CREATE TABLE `Trajet_Arret` (
  `trajet_id` int(11) NOT NULL,
  `arret_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `Trajet_Arret`
--

INSERT INTO `Trajet_Arret` (`trajet_id`, `arret_id`) VALUES
(1, 1),
(1, 2),
(2, 2),
(2, 3),
(2, 4);

-- --------------------------------------------------------

--
-- Structure de la table `Utilisateur`
--

CREATE TABLE `Utilisateur` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `mot_de_passe` varchar(255) NOT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `role` enum('ADMIN','UTILISATEUR','INVITE') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `Utilisateur`
--

INSERT INTO `Utilisateur` (`id`, `nom`, `prenom`, `email`, `mot_de_passe`, `telephone`, `role`) VALUES
(1, 'Aboudi', 'Reda', 'reda.aboudi@icloud.com', 'alg213', '06291765287', 'UTILISATEUR');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `Arret`
--
ALTER TABLE `Arret`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `Trajet`
--
ALTER TABLE `Trajet`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `Trajet_Arret`
--
ALTER TABLE `Trajet_Arret`
  ADD PRIMARY KEY (`trajet_id`,`arret_id`),
  ADD KEY `arret_id` (`arret_id`);

--
-- Index pour la table `Utilisateur`
--
ALTER TABLE `Utilisateur`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `Arret`
--
ALTER TABLE `Arret`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `Trajet`
--
ALTER TABLE `Trajet`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `Utilisateur`
--
ALTER TABLE `Utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `Trajet_Arret`
--
ALTER TABLE `Trajet_Arret`
  ADD CONSTRAINT `trajet_arret_ibfk_1` FOREIGN KEY (`trajet_id`) REFERENCES `Trajet` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `trajet_arret_ibfk_2` FOREIGN KEY (`arret_id`) REFERENCES `Arret` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
