package fr.esiee.modele;

public class Arret {
    private int id; // Champ pour l'ID
    private String ville;
    private String heure;
    private String typeArret; // "terminus" ou "intermediaire"

    public Arret() {}

    public Arret(int id, String ville, String heure) {
        this.id = id;
        this.ville = ville;
        this.heure = heure;
    }

    public Arret(String ville, String heure) {
        this.ville = ville;
        this.heure = heure;
    }

    // Création d'un constructeur Type d'arret
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    // Getter et setter pour le type d'arrêt
    public String getTypeArret() {
        return typeArret;
    }

    public void setTypeArret(String typeArret) {
        this.typeArret = typeArret;
    }

    // Mise à jour de la méthode d'affichage pour inclure le type d'arrêt
    public void afficherInformations() {
        System.out.println("ID: " + this.id);
        System.out.println("Ville: " + this.ville);
        System.out.println("Heure: " + this.heure);
        System.out.println("Type d'arrêt: " + this.typeArret);
    }
}
