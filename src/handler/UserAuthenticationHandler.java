package handler;

import request.UserAuthenticationRequest;

public abstract class UserAuthenticationHandler {
	private UserAuthenticationHandler next;
	
	public UserAuthenticationHandler(UserAuthenticationHandler next)
	{
		this.next = next;
	}
	
	public UserAuthenticationResult handleUserCredentials(UserAuthenticationRequest request)
	{
		return next.handleUserCredentials(request);
	}
}
