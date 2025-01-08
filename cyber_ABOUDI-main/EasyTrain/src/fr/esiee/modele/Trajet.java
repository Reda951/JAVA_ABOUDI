package fr.esiee.modele;

import java.util.List;

public class Trajet {
    private int id;
    private List<Arret> arrets;
    private String moyenTransport;  
    private int duree;            


    public Trajet(int id, String moyenTransport, int duree, List<Arret> arrets) {
        this.id = id;
        this.moyenTransport = moyenTransport;
        this.duree = duree;
        this.arrets = arrets;
    }

    public Trajet(String moyenTransport, int duree, List<Arret> arrets) {
        this.moyenTransport = moyenTransport;
        this.duree = duree;
        this.arrets = arrets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMoyenTransport() {
        return moyenTransport;
    }

    public void setMoyenTransport(String moyenTransport) {
        this.moyenTransport = moyenTransport;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }
 
    public List<Arret> getArrets() {
        return arrets;
    }

    public void setArrets(List<Arret> arrets) {
        this.arrets = arrets;
    }
}
