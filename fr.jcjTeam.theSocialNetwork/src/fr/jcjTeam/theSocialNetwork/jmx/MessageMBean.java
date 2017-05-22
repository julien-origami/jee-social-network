package fr.jcjTeam.theSocialNetwork.jmx;

public interface MessageMBean {

    public int getMessageNumber();
    public void addMessage(String title, String content);
    public String getTitle();
    public String getContent();
    public void setTitle(String title);
    public void setContent(String content);
    public void refreshMessageNumber();

}