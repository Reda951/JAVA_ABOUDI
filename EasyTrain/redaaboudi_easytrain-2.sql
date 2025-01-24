-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:8889
-- Généré le : ven. 24 jan. 2025 à 14:19
-- Version du serveur : 8.0.40
-- Version de PHP : 8.3.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `redaaboudi_easytrain`
--

-- --------------------------------------------------------

--
-- Structure de la table `Arret`
--

CREATE TABLE `Arret` (
  `id` int NOT NULL,
  `ville` varchar(100) NOT NULL,
  `heure` time NOT NULL,
  `trajet_id` int DEFAULT NULL,
  `typeArret` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `Arret`
--

INSERT INTO `Arret` (`id`, `ville`, `heure`, `trajet_id`, `typeArret`) VALUES
(1, 'Paris', '08:30:00', 1, NULL),
(2, 'Lyon', '10:15:00', 1, NULL),
(3, 'Marseille', '12:00:00', 2, NULL),
(4, 'Bejaia', '12:00:00', NULL, 'terminus');

-- --------------------------------------------------------

--
-- Structure de la table `Role`
--

CREATE TABLE `Role` (
  `id` int NOT NULL,
  `nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `Role`
--

INSERT INTO `Role` (`id`, `nom`) VALUES
(1, 'Admin'),
(3, 'Conducteur'),
(2, 'Utilisateur');

-- --------------------------------------------------------

--
-- Structure de la table `Trajet`
--

CREATE TABLE `Trajet` (
  `id` int NOT NULL,
  `moyen_transport` varchar(50) NOT NULL,
  `duree` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `Trajet`
--

INSERT INTO `Trajet` (`id`, `moyen_transport`, `duree`) VALUES
(1, 'Train', 45),
(2, 'Bus', 30);

-- --------------------------------------------------------

--
-- Structure de la table `Utilisateur`
--

CREATE TABLE `Utilisateur` (
  `id` int NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `mot_de_passe` varchar(255) NOT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `role_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `Utilisateur`
--

INSERT INTO `Utilisateur` (`id`, `nom`, `prenom`, `email`, `mot_de_passe`, `telephone`, `role_id`) VALUES
(1, 'Dupont', 'Jean', 'jean.dupont@example.com', 'password123', '0612345678', 1),
(2, 'Martin', 'Alice', 'alice.martin@example.com', 'securepwd', '0698765432', 2);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `Arret`
--
ALTER TABLE `Arret`
  ADD PRIMARY KEY (`id`),
  ADD KEY `trajet_id` (`trajet_id`);

--
-- Index pour la table `Role`
--
ALTER TABLE `Role`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nom` (`nom`);

--
-- Index pour la table `Trajet`
--
ALTER TABLE `Trajet`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `Utilisateur`
--
ALTER TABLE `Utilisateur`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `role_id` (`role_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `Arret`
--
ALTER TABLE `Arret`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `Role`
--
ALTER TABLE `Role`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `Trajet`
--
ALTER TABLE `Trajet`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `Utilisateur`
--
ALTER TABLE `Utilisateur`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `Arret`
--
ALTER TABLE `Arret`
  ADD CONSTRAINT `arret_ibfk_1` FOREIGN KEY (`trajet_id`) REFERENCES `Trajet` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `Utilisateur`
--
ALTER TABLE `Utilisateur`
  ADD CONSTRAINT `utilisateur_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `Role` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
