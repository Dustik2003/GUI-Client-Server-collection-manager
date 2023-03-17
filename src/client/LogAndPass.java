package client;

import java.io.Serializable;

public class LogAndPass implements Serializable {
    private String login,password;
    private boolean autOrReg;

    public LogAndPass(String login, String password, boolean autOrReg) {
        this.login = login;
        this.password = password;
        this.autOrReg = autOrReg;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public boolean getAutOrReg() {
        return autOrReg;
    }
}
