package fr.jcjTeam.theSocialNetwork.jmx;

public interface MessageMBean {

    public int getMessageNumber();
    public void addMessage(String title, String content);
    public void refreshMessageNumber();

}