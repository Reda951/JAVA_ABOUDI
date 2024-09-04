// Reda Aboudi
// 4 Septembre 2024
// TP exploratoire
public class Voyage {
    private String destination;
    private double prix;
    private int duree;

    public Voyage() {
    }
    public Voyage(String destination, int duree, double prix) {
        this.destination = destination;
        this.duree = duree;
        this.prix = prix;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public int getDuree() {
        return duree;
    }
    public void setDuree(int duree) {
        this.duree = duree;
    }
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
}




