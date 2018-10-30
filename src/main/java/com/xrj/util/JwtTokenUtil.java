package com.xrj.util;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtTokenUtil implements Serializable {
	
	public JwtTokenUtil() {
	}

	private static final long serialVersionUID = -3301605591108950415L;

	public static final String CLAIM_KEY_UUID = "uuid";
	public static final String CLAIM_KEY_USERNAME = "username";
	public static final String CLAIM_KEY_CREATED = "created";
	public static final String CLAIM_KEY_PHONE = "phone";
	public static final String CLAIM_KEY_EMAIL = "email";
	public static final String CLAIM_KEY_USER_ID = "userid";
	public static final String CLAIM_KEY_AUTHORTIES = "";

	private String secret = "foudao@2018";

	private Long expiration = 60 * 60 * 24 * 30L;

	public JwtUser getJwtUser(String token) {
		JwtUser jwtUser = null;
		Long userId = null;
		final Claims claims = getClaimsFromToken(token);
		try {
			if (claims.get(CLAIM_KEY_USER_ID) != null && claims.get(CLAIM_KEY_USER_ID) instanceof Integer) {
				Integer userid = (Integer) claims.get(CLAIM_KEY_USER_ID);
				userId = userid.longValue();
			} else {
				userId = (Long) claims.get(CLAIM_KEY_USER_ID);
			}
			
			String uuid = "";
			if (claims.get(CLAIM_KEY_UUID) != null) {
				uuid = (String) claims.get(CLAIM_KEY_UUID);
			}
			
			String username = "";
			if(claims.get(CLAIM_KEY_USERNAME) != null) {
				username = (String) claims.get(CLAIM_KEY_USERNAME);
			}
			
			String phone = "";
			if(claims.get(CLAIM_KEY_PHONE) != null) {
				phone = (String) claims.get(CLAIM_KEY_PHONE);
			}
			
			Date created = null;
			if(claims.get(CLAIM_KEY_CREATED) != null) {
				created = new Date((Long) claims.get(CLAIM_KEY_CREATED));
			}
			
			jwtUser = new JwtUser(userId, uuid, username, "", "", phone, created);
		} catch (Exception e) {
			jwtUser = null;
		}

		return jwtUser;
	}

	public String getUseruuidFromToken(String token) {
		String username;
		try {
			final Claims claims = getClaimsFromToken(token);
			username = (String) claims.get(CLAIM_KEY_UUID);
		} catch (Exception e) {
			username = null;
		}
		return username;
	}

	public Long getUserIdFromToken(String token) {
		Long userId;
		try {
			final Claims claims = getClaimsFromToken(token);
			userId = (Long) claims.get(CLAIM_KEY_USER_ID);
		} catch (Exception e) {
			userId = null;
		}
		return userId;
	}

	public String getUserPhoneFromToken(String token) {
		String phone;
		try {
			final Claims claims = getClaimsFromToken(token);
			phone = (String) claims.get(CLAIM_KEY_PHONE);
		} catch (Exception e) {
			phone = null;
		}
		return phone;
	}

	public Date getCreatedDateFromToken(String token) {
		Date created;
		try {
			final Claims claims = getClaimsFromToken(token);
			created = new Date((Long) claims.get(CLAIM_KEY_CREATED));
		} catch (Exception e) {
			created = null;
		}
		return created;
	}

	public Date getExpirationDateFromToken(String token) {
		Date expiration;
		try {
			final Claims claims = getClaimsFromToken(token);
			expiration = claims.getExpiration();
		} catch (Exception e) {
			expiration = null;
		}
		return expiration;
	}

	/**
	 * 由token解析需要的内容
	 * 
	 * @param token
	 * @return
	 */
	private Claims getClaimsFromToken(String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			claims = null;
		}
		return claims;
	}

	private Date generateExpirationDate() {
		return new Date(System.currentTimeMillis() + expiration * 1000);
	}

	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
		return (lastPasswordReset != null && created.before(lastPasswordReset));
	}

	public String generateToken(Map<String, Object> claims) {
		return Jwts.builder().setClaims(claims).setExpiration(generateExpirationDate())
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	public Boolean canTokenBeRefreshed(String token, Date lastPasswordReset) {
		final Date created = getCreatedDateFromToken(token);
		return !isCreatedBeforeLastPasswordReset(created, lastPasswordReset) && !isTokenExpired(token);
	}

	public String refreshToken(String token) {
		String refreshedToken;
		try {
			final Claims claims = getClaimsFromToken(token);
			claims.put(CLAIM_KEY_CREATED, new Date());
			refreshedToken = generateToken(claims);
		} catch (Exception e) {
			refreshedToken = null;
		}
		return refreshedToken;
	}
	
	public Boolean validateTokenByPhone(String token, JwtUser user) {
		final String phone = getUserPhoneFromToken(token);
		final Date created = getCreatedDateFromToken(token);
		// final Date expiration = getExpirationDateFromToken(token);
		return (phone.equals(user.getPhone()) && !isTokenExpired(token)
				&& !isCreatedBeforeLastPasswordReset(created, user.getLastPasswordResetDate()));
	}

	public Boolean validateToken(String token, JwtUser user) {
		final String userUuid = getUseruuidFromToken(token);
		final Date created = getCreatedDateFromToken(token);
		// final Date expiration = getExpirationDateFromToken(token);
		return (userUuid.equals(user.getUuid()) && !isTokenExpired(token)
				&& !isCreatedBeforeLastPasswordReset(created, user.getLastPasswordResetDate()));
	}
	
    public String generateToken(JwtUser user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_PHONE, user.getPhone());
        claims.put(CLAIM_KEY_EMAIL, user.getEmail());
        claims.put(CLAIM_KEY_UUID, user.getUuid());
        claims.put(CLAIM_KEY_USER_ID, user.getId());
        claims.put(CLAIM_KEY_USERNAME, user.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }
    
    public static void main(String[] args) {
		JwtTokenUtil util = new JwtTokenUtil();
		JwtUser user = new JwtUser(1L, "9294cfaa-bda4-4429-ba21-d338f62c8748", "", "", "", "", null);
		String token = util.generateToken(user);
		System.out.println(token);
		
		System.out.println(util.validateToken(token, user));
		JwtUser validateUser = util.getJwtUser(token);
		System.out.println("===");
	}
}
