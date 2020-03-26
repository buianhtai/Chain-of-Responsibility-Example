package handler;

import java.util.Map;

import request.UserAuthenticationRequest;

public class UserCachedHandler extends UserAuthenticationHandler {
	private Map<String, String> usernameToken;
	
	public UserCachedHandler(UserAuthenticationHandler next) {
		super(next);
		
		usernameToken = Map.of("cachedUser", "cachedUserToken", "jakehell4", "token5");
	}

	@Override
	public UserAuthenticationResult handleUserCredentials(UserAuthenticationRequest request)
	{
		String username = request.getUsername();
		if(usernameToken.containsKey(username))
		{
			return getSuccessfulUserAuthenticationResult(username);
		}
		
		return super.handleUserCredentials(request);
	}
	
	public UserAuthenticationResult getSuccessfulUserAuthenticationResult(String username)
	{
		UserAuthenticationResult result = new UserAuthenticationResult();
		result.setUsername(username);
		result.setToken(usernameToken.get(username));
		result.setAuthenticated(true);
		
		return result;
	}
}
