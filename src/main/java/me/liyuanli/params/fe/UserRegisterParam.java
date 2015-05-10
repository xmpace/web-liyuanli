package me.liyuanli.params.fe;

/**
 * Created by
 * User: xiaomi
 * Date: 5/10/15
 * Time: 3:20 PM
 */
public class UserRegisterParam {
    private String login;
    private String nickName;
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
