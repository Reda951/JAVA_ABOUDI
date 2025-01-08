package fr.esiee.modele;

public class Utilisateur {
    private int id; // Ajout du champ ID
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    private String telephone;
    private Role role;

    public Utilisateur() {}

    public Utilisateur(int id, String nom, String prenom, String email, String motDePasse, String telephone, Role role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.telephone = telephone;
        this.role = role;
    }

    public Utilisateur(String nom, String prenom, String email, String motDePasse, String telephone, Role role) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.telephone = telephone;
        this.role = role;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMotDePasse() { return motDePasse; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    public void afficherInformations() {
        System.out.println("ID: " + this.id);
        System.out.println("Nom: " + this.nom);
        System.out.println("Prénom: " + this.prenom);
        System.out.println("Email: " + this.email);
        System.out.println("Téléphone: " + this.telephone);
        System.out.println("Role: " + this.role);
    }
}
