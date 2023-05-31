package Information;

import java.util.HashMap;

public class User {

    String username;
    String password;
    HashMap<String, String> loginInfo = new HashMap<String, String>();

    public User(String username, String password) {
        loginInfo.put(username, password);
    }

    public String getLoginInfo(String username) {
        return loginInfo.get(username);
    }

}
