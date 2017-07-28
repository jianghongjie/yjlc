package com.yjlc.commons.util;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.StringTokenizer;
//import javax.servlet.http.Cookie;

public class TokenManager {
//	  public static final String COOKIE_DOMAIN = "cookie.domain";
//	  public static final String COOKIE_NAME = "LtpaToken";
	  public static final String DOMINO_SECRET = "domino.secret";
	  public static final String TOKEN_EXPIRATION = "token.expiration";
	  private static Properties properties = null;
	  private static boolean isConfigLoaded = false;
	  public static String secret = "aqerxfevdfg";
	  private static String expiration = "1";//1分钟

	  private static void initConfig(){
	    if (!isConfigLoaded){
	    	properties = new Properties();
	    		isConfigLoaded = true;
	    }
	  }

	  
	  public static Token generate(String canonicalUser,Date creationDate){
	    initConfig();
//	    Date creationDate = new Date();
	    Date expirationDate = new Date();
	    int interval = Integer.parseInt(expiration);
	    expirationDate.setTime(creationDate.getTime() + 60000 * interval);

	    return generate(canonicalUser, creationDate, expirationDate);
	  }
	  
	  public static Token generate(String canonicalUser)
	  {
	    Date creationDate = new Date();
	    return generate(canonicalUser, creationDate);
	  }
 
	  private static  Token generate(String canonicalUser, Date tokenCreation, Date tokenExpires)
	  {

	     Token ltpa = new  Token();

	     Calendar calendar = Calendar.getInstance();
	     MessageDigest md = ltpa.getMessageDigest();

	    ltpa.setHeader(new byte[] { 0, 1, 2, 3 });
	    try
	      {
	        ltpa.setUser(canonicalUser.getBytes("UTF-8"));
	      }
	      catch (UnsupportedEncodingException e) {
	        ltpa.setUser(canonicalUser.getBytes());
	      }

	    byte[] token = null;

	    calendar.setTime(tokenCreation);
	    ltpa.setCreation(Long.toHexString(calendar.getTime().getTime() / 1000L).toUpperCase().getBytes());

	    calendar.setTime(tokenExpires);
	    ltpa.setExpires(Long.toHexString(calendar.getTime().getTime() / 1000L).toUpperCase().getBytes());

	    token = concatenate(token, ltpa.getHeader());
	    token = concatenate(token, ltpa.getCreation());
	    token = concatenate(token, ltpa.getExpires());
	    token = concatenate(token, ltpa.getUser());

	    md.update(token);
	    byte[] digest = md.digest(BASE64Util.decodeAsBytes(secret));

	    ltpa.setDigest(digest);
	    token = concatenate(token, digest);

	    String tokenStr = BASE64Util.encode(token);
	    String result = "";
	    StringTokenizer st = new StringTokenizer(tokenStr);

	    while (st.hasMoreTokens()) {
	      result = result + st.nextToken();
	    }
	    return new Token(result);
	  }


//	  public static Cookie toCookie(String ltpaToken)
//	  {
//	    Cookie cookie = new Cookie("LtpaToken", ltpaToken);
//	    String domain = properties.getProperty("cookie.domain");
//	    if ((domain != null) && (!"".equals(domain)))
//	    {
//	      cookie.setDomain(domain);
//	    }
//	    cookie.setPath("/");
//	    cookie.setSecure(false);
//	    cookie.setMaxAge(-1);
//	    return cookie;
//	  }

//	  private static void checkConfig() {
//	    if (!isConfigLoaded())
//	    {
//	      throw new ConfigurationError("LtpaToken properties is unloaded properly. ");
//	    }
//	  }

//	  private static boolean isConfigLoaded()
//	  {
//	    return isConfigLoaded;
//	  }

//	  public static String getDefaultLtpaConfig()
//	  {
//	    String portalConfig = System.getProperty("portal.config");
//	    if ((portalConfig == null) || ("".equals(portalConfig)))
//	    {
//	      System.err.println("[Eas Portal] please set system property [portal.config].");
//	    }
//	    File portalConfigFile = new File(portalConfig);
//	    String configPath = portalConfigFile.getParentFile().getAbsolutePath() + "/LtpaToken.properties";
//	    return configPath;
//	  }

//	  public static synchronized void loadDefaultConfig()
//	  {
//	    loadConfig(getDefaultLtpaConfig());
//	  }

	  private static boolean compare(String token, String userNumber)
	  {
	    boolean result = false;
	     Token lt = new  Token(token);
	    String username = lt.getUsername();
	    result = username == null ? false : username.equals(userNumber);
	    return result;
	  }
	  
	  public static byte[] concatenate(byte[] a, byte[] b)
	  {
	    if (a == null) {
	      return b;
	    }
	    byte[] bytes = new byte[a.length + b.length];

	    System.arraycopy(a, 0, bytes, 0, a.length);
	    System.arraycopy(b, 0, bytes, a.length, b.length);
	    return bytes;
	  }
	  
	  public static void main(String [] args)
	  {
		  Token token = TokenManager.generate("10005");
		  System.out.println(token.getTokenStr());
		  
//		  Token token =  new Token("AAECAzU4RTBDMjBDNThFMEMyNDgxMTExbOvdOs15eWqyvLwg4akwupp7BQU=");
		  System.out.println(token.getTokenStr());
		  System.out.println(token.isValid("10005"));
	  }
}
