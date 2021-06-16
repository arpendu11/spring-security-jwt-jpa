package com.stackabuse.springSecurity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
public class UserLogoutException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final String user;
    private final String message;

    public UserLogoutException(String user, String message) {
        super(String.format("Couldn't log out device [%s]: [%s])", user, message));
        this.user = user;
        this.message = message;
    }
}
