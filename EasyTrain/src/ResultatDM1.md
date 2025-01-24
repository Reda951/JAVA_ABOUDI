# Épreuve E6 - EXPRESSION DES BESOINS :

**Date :** Vendredi 26 Janvier 2025  
**Nom :** Reda Aboudi  
**Sujet :** Épreuve E6 - Gestion des arrêts dans une application Java

---
## Remarque importante

> Il n'a pas été possible de tester le code développé, car le code de base provient d'un autre PC. J'ai essayé de recréer le nouveau code en m'aidant de l'ancien, en me basant sur les fonctionnalités existantes.

---
## Éléments modifiés dans le projet

### 1. **Classe `Arret.java`**

**Fichier :** `src/fr/esiee/modele/Arret.java`

**Modifications apportées :**
- Ajout de l'attribut `typeArret` pour définir le type d'arrêt ("terminus" ou "intermediaire").
- Mise à jour des constructeurs pour inclure `typeArret`.
- Ajout des getters et setters pour le nouvel attribut.
- Mise à jour de la méthode `afficherInformations()`.

**Méthodes ajoutées/modifiées :**

```java
private String typeArret;

public String getTypeArret() {
    return typeArret;
}

public void setTypeArret(String typeArret) {
    this.typeArret = typeArret;
}

// Constructeur mis à jour avec type d'arrêt
public Arret(int id, String ville, String heure, String typeArret) {
    this.id = id;
    this.ville = ville;
    this.heure = heure;
    this.typeArret = typeArret;
}

public Arret(String ville, String heure, String typeArret) {
    this.ville = ville;
    this.heure = heure;
    this.typeArret = typeArret;
}

@Override
public void afficherInformations() {
    System.out.println("ID: " + this.id);
    System.out.println("Ville: " + this.ville);
    System.out.println("Heure: " + this.heure);
    System.out.println("Type d'arrêt: " + this.typeArret);
}
```
### 2. **Mise à jour de la base de données**

Ajout de la colonne typeArret dans la table Arret :
```sql
ALTER TABLE Arret ADD COLUMN typeArret VARCHAR(20) NOT NULL;
```
Insertion de données de test dans la base de données :
```sql
INSERT INTO Arret (ville, heure, typeArret)
VALUES ('Bejaia', '12:00:00', 'terminus');
```
