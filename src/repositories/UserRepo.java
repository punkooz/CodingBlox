package repositories;

import entities.User;

import java.util.HashMap;

public class UserRepo {

    HashMap<String, User> userMap;

    public UserRepo() {
        this.userMap = new HashMap<>();
    }

    public void save(String userName){
        User user = new User(userName);
        userMap.put(userName, user);
    }

    public HashMap<String, User> getUserMap() {
        return userMap;
    }

    public User findUserByName(String userName){
        return userMap.get(userName);
    }

    public void saveUser(User u) {
        userMap.put(u.getName(), u);

    }
}
