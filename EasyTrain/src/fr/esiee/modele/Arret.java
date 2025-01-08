package fr.esiee.modele;

public class Arret {
    private int id; // Champ pour l'ID
    private String ville;
    private String heure;

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

    public void afficherInformations() {
        System.out.println("ID: " + this.id);
        System.out.println("Ville: " + this.ville);
        System.out.println("Heure: " + this.heure);
    }
}
