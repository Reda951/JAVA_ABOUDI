
# Étape 3 : Création du Modèle Relationnel
![Alt Text](https://i.giphy.com/media/v1.Y2lkPTc5MGI3NjExN2xqMWZiZWloMjMzcTlxZnljaWZhbDdkZGMzdG8wYzI5cWk4eGRzYiZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/QYegusLPPA2V4Gplk6/giphy.gif)

## 1. Table `Utilisateur`

Cette table représente les utilisateurs de l'application, avec un rôle prédefini.

```sql
CREATE TABLE Utilisateur (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    mot_de_passe VARCHAR(255) NOT NULL,
    telephone VARCHAR(20),
    role ENUM('ADMIN', 'UTILISATEUR', 'INVITE') NOT NULL
);
```

- **Clé primaire** : `id` (générée avec `AUTO_INCREMENT`).
- **Email unique** : Garantit qu'il n'y a pas deux utilisateurs avec le même email.
- **Rôle** : Utilisation d'un type `ENUM` pour gérer les rôles (`ADMIN`, `UTILISATEUR`, `INVITE`).

## 2. Table `Arret`

Cette table contient les informations sur chaque arrêt, comme la ville et les heures de passage.

```sql
CREATE TABLE Arret (
    id INT PRIMARY KEY AUTO_INCREMENT,
    ville VARCHAR(100) NOT NULL,
    heure TIME NOT NULL
);
```

- **Clé primaire** : `id`.
- **Ville** : Nom de la ville où l'arrêt a lieu.
- **Heure** : Heure de l'arrêt au format `TIME`.

## 3. Table `Trajet`

Cette table contient les informations des trajets, tels que le moyen de transport et la durée du trajet.

```sql
CREATE TABLE Trajet (
    id INT PRIMARY KEY AUTO_INCREMENT,
    moyen_transport VARCHAR(50) NOT NULL,
    duree INT NOT NULL
);
```

- **Clé primaire** : `id`.
- **Moyen de transport** : Type de transport utilisé (ex. : Train, Bus).
- **Durée** : Durée du trajet (en minutes).

## 4. Table `Trajet_Arret` 

Chaque trajet comporte plusieurs arrêts, et chaque arrêt peut être associé à plusieurs trajets. Nous devons créer une table de relation pour gérer cette relation.

```sql
CREATE TABLE Trajet_Arret (
    trajet_id INT,
    arret_id INT,
    PRIMARY KEY (trajet_id, arret_id),
    FOREIGN KEY (trajet_id) REFERENCES Trajet(id) ON DELETE CASCADE,
    FOREIGN KEY (arret_id) REFERENCES Arret(id) ON DELETE CASCADE
);
```

- **Clé primaire** : Combinaison de `trajet_id` et `arret_id`.
- **Foreign keys** : 
    - `trajet_id` fait référence à la colonne `id` dans la table `Trajet`.
    - `arret_id` fait référence à la colonne `id` dans la table `Arret`.
- **On Delete Cascade** : Supprime automatiquement les entrées associées si un trajet ou un arrêt est supprimé.

## Insertion des données qu'on utilise en exemple : 

### Insertion dans ma table `Utilisateur`

```sql
INSERT INTO Utilisateur (nom, prenom, email, mot_de_passe, telephone, role) 
VALUES ('Aboudi', 'Reda', 'reda.aboudi@icloud.com', 'alg213', '06291765287', 'UTILISATEUR');
```

### Insertion dans ma table `Arret`

```sql
INSERT INTO Arret (ville, heure) 
VALUES ('Taverny', '08:00'), ('Saint-Prix', '08:30'), ('Ermont', '09:00'), ('Pontoise', '09:30');
```

### Insertion dans ma table `Trajet`

```sql
INSERT INTO Trajet (moyen_transport, duree) 
VALUES ('Train', 30), ('Bus', 60);
```

### Association des arrêts aux trajets dans ma table `Trajet_Arret`

```sql
INSERT INTO Trajet_Arret (trajet_id, arret_id) 
VALUES (1, 1), (1, 2), (2, 2), (2, 3), (2, 4);
```

## Conclusion

Ce modèle relationnel permet de gérer les utilisateurs, les arrêts, les trajets, et leurs relations dans une base de données relationnelle en SQL. Chaque entité a été mappée à une table spécifique avec les relations nécessaires entre elles.


