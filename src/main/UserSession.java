package main;

public class UserSession {
	private UserSession() {} // private constructor
	private static UserSession instance = new UserSession();
	
	// User Property
	private String _username;
	private String _password;

	public static UserSession getInstance(boolean isReuse) {
        if(!isReuse || instance == null){
            instance = new UserSession();
        } 
        return instance;
    }
	
	public void signIn(String username, String password) {
		_username = username;
		_password = password;
	}
	
	public void logout() {
		instance = null;
	}
	
	public void testingMethod() {
		System.out.println(String.format("[Session] Tesing: U: %s, P: %s", _username, _password));
	}
}
