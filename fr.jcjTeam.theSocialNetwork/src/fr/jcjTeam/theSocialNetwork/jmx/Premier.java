package fr.jcjTeam.theSocialNetwork.jmx;

public class Premier implements PremierMBean {

    private String nom = "PremierMBean";
    private int valeur = 100;

    public String getNom() {
        return nom;
    }

    public int getValeur() {
        return valeur;
    }

    public synchronized void setValeur(int valeur) {
        this.valeur = valeur;
    }
    
    public synchronized void setNom(String nom) {
        this.nom = nom;
    }

    public void rafraichir() {
        System.out.println("Nom : "+this.getNom()+" valeur : "+this.getValeur());
    }

}

