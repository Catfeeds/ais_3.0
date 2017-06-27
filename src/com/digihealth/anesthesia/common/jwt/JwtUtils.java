package com.digihealth.anesthesia.common.jwt;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import org.apache.log4j.Logger;
import com.digihealth.anesthesia.sysMng.po.BasUser;
import com.digihealth.anesthesia.common.listener.ConstantHolder;
import com.digihealth.anesthesia.common.utils.Exceptions;
import com.digihealth.anesthesia.common.utils.JsonType;
import net.sf.json.JSONObject;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

public class JwtUtils {
	
	private static Logger logger = Logger.getLogger(JwtUtils.class);
	
	//private static String secret = "digihealth";
	
	//Sample method to construct a JWT
	public static String createJWT(String subject, long ttlMillis,String secret) {

	    //The JWT signature algorithm we will be using to sign the token
	    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

	    long nowMillis = System.currentTimeMillis();
	    Date now = new Date(nowMillis);
	    //System.out.println("now=="+now);
	    
	    //We will sign our JWT with our ApiKey secret
	    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secret);
	    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

	    //Let's set the JWT Claims
	    JwtBuilder builder = Jwts.builder()//.setId(id)
	                                .setIssuedAt(now)
	                                .setSubject(subject)
	                                //.setIssuer(issuer)
	                                .signWith(signatureAlgorithm, signingKey);
	    
	    //if it has been specified, let's add the expiration
	    if (ttlMillis >= 0) {
	    long expMillis = nowMillis + ttlMillis;
	        Date exp = new Date(expMillis);
	        builder.setExpiration(exp);
	    }

	    //Builds the JWT and serializes it to a compact, URL-safe string
	    return builder.compact();
	}
	
	public static Map<String,Object> parseJWT(String jwt,String secret) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Jws<Claims> jws = null;
		try {
			//This line will throw an exception if it is not a signed JWS (as expected)
		    jws = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(secret)).parseClaimsJws(jwt);
		    //OK, we can trust this JWT
		    
		} catch (SignatureException e) {
			logger.error("SignatureException:parseJWT=="+ Exceptions.getStackTraceAsString(e));
		    //don't trust the JWT!
			resultMap.put(ConstantHolder.TOKEN_STATE, TokenState.INVALID.name());
			return resultMap;
		}catch (ExpiredJwtException e) {
			logger.error("ExpiredJwtException:parseJWT=="+ Exceptions.getStackTraceAsString(e));
			resultMap.put(ConstantHolder.TOKEN_STATE, TokenState.EXPIRED.name());
			return resultMap;
		}catch (JwtException e) {
			logger.error("JwtException:parseJWT=="+ Exceptions.getStackTraceAsString(e));
			resultMap.put(ConstantHolder.TOKEN_STATE, TokenState.INVALID.name());
			return resultMap;
		}
		
	    Claims claims = jws.getBody();
	    //logger.info("parseJWT--ID: " + claims.getId());
	    logger.info("parseJWT--Subject: " + claims.getSubject());
	    logger.info("parseJWT--Expiration: " + claims.getExpiration());
	    resultMap.put(ConstantHolder.TOKEN_CLAIMS, claims);
	    resultMap.put(ConstantHolder.TOKEN_STATE, TokenState.VALID.name());
	    return resultMap;
	}
	
	public static String generalSubject(BasUser user) {
		JSONObject jo = new JSONObject();
		jo.put("username", user.getUserName());
		jo.put("beid", user.getBeid());
		return jo.toString();
	}
	
	public static String getKey(String username,String beid){
		return username + ConstantHolder.TOKEN_LINK + beid + ConstantHolder.TOKEN_SUBFIX;
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		//String uuid = UUID.randomUUID().toString();
		//System.out.println("uuid=="+uuid);
		String secret = "digihealth";
		BasUser user = new BasUser();
		user.setUserName("admin");
		//user.setBeid("101");
		String subject = JwtUtils.generalSubject(user);
		String jwt = JwtUtils.createJWT(subject, (long)1000*60,secret);
		//Thread.sleep(5000);
		//System.out.println("jwt=="+jwt+",length="+jwt.length());
		//jwt= "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJlMWFhZGFmYS1hYzY0LTRiZTUtOTk5Ny01ODhhYTQ1YTZkYTUiLCJpYXQiOjE0ODg5Mzg1MjUsInN1YiI6IntcInVzZXJuYW.ffwfwfwfwefewewv";
		Map<String, Object> resultMap = JwtUtils.parseJWT(jwt,secret);
		
		System.out.println(JsonType.jsonType(resultMap));
		
//		String subject1 = JwtUtils.generalSubject(user );
//		String jwt1 = JwtUtils.createJWT(subject1, (long)1000*60,secret);
//		Map<String, Object> resultMap1 = JwtUtils.parseJWT(jwt1,secret);
		if(resultMap.containsKey(ConstantHolder.TOKEN_STATE)){
			
			String state = (String)resultMap.get(ConstantHolder.TOKEN_STATE);
			System.out.println(state);
		}
		//System.out.println(state);
//		System.out.println(JsonType.jsonType(resultMap1));
	}
	
	
}
