package handler;

import java.util.List;

import request.UserAuthenticationRequest;

public class UsernameBannedHandler extends UserAuthenticationHandler {
	private List<String> bannedUsernames;
	
	public UsernameBannedHandler(UserAuthenticationHandler next) {
		super(next);
		
		bannedUsernames = List.of("jakehell", "bannedUser", "jakehell2");
	}
	
	@Override
	public UserAuthenticationResult handleUserCredentials(UserAuthenticationRequest request)
	{
		if(isUsernameBanned(request))
		{
			return getAuthenticationFailureResult(request);
		}
		
		return super.handleUserCredentials(request);
	}
	
	private boolean isUsernameBanned(UserAuthenticationRequest request)
	{
		return bannedUsernames.contains(request.getUsername());
	}
	
	private UserAuthenticationResult getAuthenticationFailureResult(UserAuthenticationRequest request)
	{
		UserAuthenticationResult result = new UserAuthenticationResult();
		result.setUsername(request.getUsername());
		result.setAuthenticated(false);
		
		return result;
	}
}
