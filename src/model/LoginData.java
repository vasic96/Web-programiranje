package model;

public class LoginData {
	
	private String username;
	private String lozinka;
	
	public LoginData() {}

	public LoginData(String username, String password) {
		super();
		this.username = username;
		this.lozinka = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return lozinka;
	}

	public void setPassword(String password) {
		this.lozinka = password;
	}

	@Override
	public String toString() {
		return "LoginData [username=" + username + ", password=" + lozinka + "]";
	}
	
	
	
}
