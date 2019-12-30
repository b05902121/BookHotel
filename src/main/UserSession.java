package main;

import java.util.ArrayList;

public class UserSession {
    private UserSession() {} // private constructor
    private static UserSession instance;

    // User Property
    private String _username;
    private String _password;
    private ArrayList<Room> _orderedRoom;

    public static UserSession getInstance(boolean isReuse) {
        if(!isReuse || instance == null){
            instance = new UserSession();
            instance._orderedRoom = new ArrayList<Room>();
        } 
        return instance;
    }

    public void signIn(String username, String password) {
        _username = username;
        _password = password;
    }

    public void logout() {
        // TODO: Update user detail to DB
        instance = null;
    }

    public void orderRoom(Room room) {
        _orderedRoom.add(room);
    }

    public void cancelRoom(Room room) {
        _orderedRoom.remove(room);
    }

    public void testingMethod() {
        System.out.println(String.format("[Session] Tesing: U: %s, P: %s, RC: %d",
                _username, _password, _orderedRoom.size()));
    }
}
