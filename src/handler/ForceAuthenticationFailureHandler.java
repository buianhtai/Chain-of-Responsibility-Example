package handler;

import request.UserAuthenticationRequest;

public class ForceAuthenticationFailureHandler extends UserAuthenticationHandler {

	public ForceAuthenticationFailureHandler(UserAuthenticationHandler next) {
		super(next);
	}
	
	@Override
	public UserAuthenticationResult handleUserCredentials(UserAuthenticationRequest request)
	{
		return getAuthenticationFailureResult(request);
	}
	
	private UserAuthenticationResult getAuthenticationFailureResult(UserAuthenticationRequest request)
	{
		UserAuthenticationResult result = new UserAuthenticationResult();
		result.setUsername(request.getUsername());
		result.setAuthenticated(false);
		
		return result;
	}
}
