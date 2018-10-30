package com.xrj.util;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class JwtUser implements Serializable{
	private static final long serialVersionUID = -7267402860061570647L;
	private Long id;
	private final String uuid;
    private final String username;
    private final String password;
    private final String email;
    private final String phone;
    private final Date lastPasswordResetDate;

    public JwtUser(
    		Long id,
    		String uuid,
            String username,
            String password,
            String email,
            String phone,
            Date lastPasswordResetDate) {
        this.id = id;
        this.uuid = uuid;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.lastPasswordResetDate = lastPasswordResetDate;
    }


    @JsonIgnore
    public Long getId() {
        return id;
    }
    
    @JsonIgnore
    public String getUuid() {
    	return uuid;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }

    @JsonIgnore
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }
}
