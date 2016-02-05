package ua.kiev.prog;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by Andzhel on 02.02.2016.
 */
@XmlRootElement(name="member")
public class Member {
    private String login;
    private String password;
    private boolean online;
    private String lastConnection;
    private String sessionID;

    public Member(){}

    public Member(String login, String password) {
        this.login = login;
        this.password = password;
        this.online = false;
    }

    public String getLogin() {
        return login;
    }

    @XmlElement
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    @XmlElement
    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isOnline() {
        return online;
    }

    @XmlAttribute
    public void setOnline(boolean online) {
        this.online = online;
    }

    public String getLastConnection() {
        return lastConnection;
    }

    @XmlAttribute
    public void setLastConnection(String lastConnection) {
        this.lastConnection = lastConnection;
    }


    public String getSessionID() {
        return sessionID;
    }

    @XmlAttribute
    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    @Override
    public String toString() {
        return login;
    }
}
