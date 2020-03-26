package handler;

public class UserAuthenticationResult {
	private String token;
	private String username;
	private boolean authenticated;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public boolean isAuthenticated() {
		return authenticated;
	}
	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}
	
	@Override
	public String toString()
	{
		return "Username: " + username 
				+ "\nToken: " + token
				+ "\nIsAuthenticated: " + authenticated;
	}
}
