package com.stackabuse.springSecurity.event;

import java.time.Instant;
import java.util.Date;

import org.springframework.context.ApplicationEvent;

import com.stackabuse.springSecurity.dto.LogOutRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OnUserLogoutSuccessEvent extends ApplicationEvent {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String userEmail;
    private final String token;
    private final transient LogOutRequest logOutRequest;
    private final Date eventTime;
    
    public OnUserLogoutSuccessEvent(String userEmail, String token, LogOutRequest logOutRequest) {
        super(userEmail);
        this.userEmail = userEmail;
        this.token = token;
        this.logOutRequest = logOutRequest;
        this.eventTime = Date.from(Instant.now());
    }
}
