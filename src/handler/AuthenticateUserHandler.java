package handler;

import request.UserAuthenticationRequest;

public class AuthenticateUserHandler extends UserAuthenticationHandler {

	public AuthenticateUserHandler(UserAuthenticationHandler next) {
		super(next);
	}
	
	@Override
	public UserAuthenticationResult handleUserCredentials(UserAuthenticationRequest request)
	{
		if(authenticateUser(request))
		{
			return createSuccessfulResult(request);
		}
		
		return super.handleUserCredentials(request);
	}
	
	private boolean authenticateUser(UserAuthenticationRequest request)
	{
		if(request.getUsername().equals("authenticatedUser") && request.getPassword().equals("password"))
		{
			return true;
		}

		return false;
	}
	
	private UserAuthenticationResult createSuccessfulResult(UserAuthenticationRequest request)
	{
		UserAuthenticationResult result = new UserAuthenticationResult();
		result.setAuthenticated(true);
		result.setUsername(request.getUsername());
		result.setToken(generateToken());
		
		return result;
	}
	
	private String generateToken()
	{
		return "token";
	}
}
