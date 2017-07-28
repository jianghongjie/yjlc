package com.yjlc.commons.util;
//import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Token {
	private byte[] creation;
	  private Date creationDate;
	  private byte[] digest;
	  private byte[] expires;
	  private Date expiresDate;
	  private byte[] hash;
	  private byte[] header;
	  private String tokenStr;
	  private byte[] rawToken;
	  private byte[] user;

	  public Token()
	  {
	    init();
	  }

	  public Token(String token)
	  {
	    init();
	    this.tokenStr = token;
	    this.rawToken = BASE64Util.decodeAsBytes(token);
	    this.user = new byte[this.rawToken.length - 40];
	    for (int i = 0; i < 4; i++) {
	      this.header[i] = this.rawToken[i];
	    }
	    for (int i = 4; i < 12; i++) {
	      this.creation[(i - 4)] = this.rawToken[i];
	    }
	    for (int i = 12; i < 20; i++) {
	      this.expires[(i - 12)] = this.rawToken[i];
	    }
	    for (int i = 20; i < this.rawToken.length - 20; i++) {
	      this.user[(i - 20)] = this.rawToken[i];
	    }
	    for (int i = this.rawToken.length - 20; i < this.rawToken.length; i++) {
	      this.digest[(i - (this.rawToken.length - 20))] = this.rawToken[i];
	    }
	    this.creationDate = new Date(Long.parseLong(new String(this.creation), 16) * 1000L);
	    this.expiresDate = new Date(Long.parseLong(new String(this.expires), 16) * 1000L);
	  }

	  public Date getCreationDate()
	  {
	    return this.creationDate;
	  }

	  public MessageDigest getMessageDigest()
	  {
	    try
	    {
	      return MessageDigest.getInstance("SHA-1");
	    } catch (NoSuchAlgorithmException nsae) {
	    }
	    return null;
	  }

	  public Date getExpiresDate()
	  {
	    return this.expiresDate;
	  }

	  public String getUsername()
	  {
	    String userName = null;
	    try {
	      userName = new String(this.user, "UTF-8");
	    }
	    catch (UnsupportedEncodingException e) {
	      userName = new String(this.user);
	    }
	    return userName;
	  }

	  public String getUsername(String code) {
	    String userName = null;
	    try {
	      userName = new String(this.user, code);
	    }
	    catch (UnsupportedEncodingException e) {
	      userName = new String(this.user);
	    }
	    return userName;
	  }

	  private void init() {
	    this.creation = new byte[8];
	    this.digest = new byte[20];
	    this.expires = new byte[8];
	    this.hash = new byte[20];
	    this.header = new byte[4];
	  }

	  public boolean isValid(String secretKey){
	    boolean validDigest = false;
	    boolean validDateRange = false;

	    byte[] bytes = null;
	    Date now = new Date();
	    MessageDigest md = getMessageDigest();
	    bytes = TokenManager.concatenate(bytes, this.header);
	    bytes = TokenManager.concatenate(bytes, this.creation);
	    bytes = TokenManager.concatenate(bytes, this.expires);
	    bytes = TokenManager.concatenate(bytes, this.user);
	    bytes = TokenManager.concatenate(bytes, BASE64Util.decodeAsBytes(secretKey));
	    byte[] newDigest = md.digest(bytes);
	    validDigest = MessageDigest.isEqual(this.digest, newDigest);
//	    System.out.println("valid message digest :" + validDigest);
	    validDateRange = now.before(this.expiresDate);
	    boolean result = (validDigest) && (validDateRange);

	    System.out.println("creationDate[" + this.creationDate + "]<now[" + now + "]<expiresDate[" + this.expiresDate + "],validDateRange:" + validDateRange + ",verify result:" + result);
	    return result;
	  }

	  public String toString()
	  {
	    return this.tokenStr;
	  }

	  public byte[] getCreation()
	  {
	    return this.creation;
	  }

	  public void setCreation(byte[] creation)
	  {
	    this.creation = creation;
	  }

	  public byte[] getExpires()
	  {
	    return this.expires;
	  }

	  public void setExpires(byte[] expires)
	  {
	    this.expires = expires;
	  }

	  public byte[] getHeader()
	  {
	    return this.header;
	  }

	  public void setHeader(byte[] header)
	  {
	    this.header = header;
	  }

	  public void setCreationDate(Date creationDate)
	  {
	    this.creationDate = creationDate;
	  }

	  public void setDigest(byte[] digest)
	  {
	    this.digest = digest;
	  }

	  public void setExpiresDate(Date expiresDate)
	  {
	    this.expiresDate = expiresDate;
	  }

	  public void setUser(byte[] user)
	  {
	    this.user = user;
	  }

	  public byte[] getUser()
	  {
	    return this.user;
	  }

	  public String getTokenStr()
	  {
	    return this.tokenStr;
	  }
	  
}
