package fr.ecole;

public class Devise {
    private int quantite;
    private String monnaie;

    public Devise(int somme, String monnaie) {
        this.quantite = somme;
        this.monnaie = monnaie;
    }

    public int getQuantite() {
        return quantite;
    }

    public String getMonnaie() {
        return monnaie;
    }

    public Devise add(Devise m) {
        if (!this.monnaie.equals(m.getMonnaie())) {
            throw new IllegalArgumentException("Frérot, les monnaies doivent être les mêmes pour les calculer wsh !");
        }
        return new Devise(this.quantite + m.getQuantite(), this.monnaie);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Devise devise = (Devise) obj;
        return quantite == devise.quantite && monnaie.equals(devise.monnaie);
    }

    @Override
    public int hashCode() {
        return 31 * quantite + (monnaie != null ? monnaie.hashCode() : 0);
    }
}
