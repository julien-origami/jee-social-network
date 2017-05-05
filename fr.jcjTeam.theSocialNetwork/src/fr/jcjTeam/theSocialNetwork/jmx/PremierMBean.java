package fr.jcjTeam.theSocialNetwork.jmx;

public interface PremierMBean {

    public String getNom();
    public int getValeur();
    public void setValeur(int valeur);
    public void setNom(String nom);
    public void rafraichir();

}