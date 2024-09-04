// Reda Aboudi
// 4 Septembre 2024
// TP exploratoire
public class Main  {
    public static void main(String[] args) {
        Voyage monVoyage = new Voyage("Alger", 7, 2800);
        System.out.println("Votre vol est à destination de : " + monVoyage.getDestination());
        System.out.println("La durée de votre vol est de : " + monVoyage.getDuree() + " jours");
        System.out.println("Le prix du vol est de : " + monVoyage.getPrix() + " €");
    }
}
