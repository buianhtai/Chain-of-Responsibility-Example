package main;

import handler.AuthenticateUserHandler;
import handler.ForceAuthenticationFailureHandler;
import handler.UserAuthenticationResult;
import handler.UserCachedHandler;
import handler.UsernameBannedHandler;
import request.UserAuthenticationRequest;

public class Main {

	public static void main(String[] args) {
		ForceAuthenticationFailureHandler forceAuthenticationFailureHandler = new ForceAuthenticationFailureHandler(null);
		AuthenticateUserHandler authenticateUserHandler = new AuthenticateUserHandler(forceAuthenticationFailureHandler);
		UserCachedHandler userCachedHandler = new UserCachedHandler(authenticateUserHandler);
		UsernameBannedHandler usernameBannedHandler = new UsernameBannedHandler(userCachedHandler);
		
		UserAuthenticationRequest banned = new UserAuthenticationRequest("bannedUser", "password");
		UserAuthenticationRequest cached = new UserAuthenticationRequest("cachedUser", "password");
		UserAuthenticationRequest authenticated = new UserAuthenticationRequest("authenticatedUser", "password");
		UserAuthenticationRequest failure = new UserAuthenticationRequest("authenticateFailure", "password");
		
		UserAuthenticationResult bannedResult = usernameBannedHandler.handleUserCredentials(banned);
		UserAuthenticationResult cachedResult = usernameBannedHandler.handleUserCredentials(cached);
		UserAuthenticationResult authenticatedResult = usernameBannedHandler.handleUserCredentials(authenticated);
		UserAuthenticationResult failureResult = usernameBannedHandler.handleUserCredentials(failure);
		
		System.out.println(bannedResult.toString());
		System.out.println();
		System.out.println(cachedResult.toString());
		System.out.println();
		System.out.println(authenticatedResult.toString());
		System.out.println();
		System.out.println(failureResult.toString());
	}
}