package com.yjlc.commons.account;

import com.joinwe.common.api.dto.ServiceMessage;

public class CreateAccReq extends ServiceMessage{
	 private static final long serialVersionUID = 1L;
	  private String accName;
	  private int accType;
	  private String crCode;
	  private String idNum;
	  private String accMemo;
	  public String getAccName()
	  {
	    return this.accName;
	  }
	  
	  public void setAccName(String accName)
	  {
	    this.accName = accName;
	  }
	  
	  public int getAccType()
	  {
	    return this.accType;
	  }
	  
	  public void setAccType(int accType)
	  {
	    this.accType = accType;
	  }
	  
	  public String getCrCode()
	  {
	    return this.crCode;
	  }
	  
	  public void setCrCode(String crCode)
	  {
	    this.crCode = crCode;
	  }
	  
	  public String getIdNum()
	  {
	    return this.idNum;
	  }
	  
	  public void setIdNum(String idNum)
	  {
	    this.idNum = idNum;
	  }
	  
	  public String getAccMemo()
	  {
	    return this.accMemo;
	  }
	  
	  public void setAccMemo(String accMemo)
	  {
	    this.accMemo = accMemo;
	  }
}
