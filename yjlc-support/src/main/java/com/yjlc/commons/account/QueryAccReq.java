package com.yjlc.commons.account;

import com.joinwe.common.api.dto.ServiceMessage;

public class QueryAccReq extends ServiceMessage {
	private String accCode;
	  private String crCode;
	  private String accStatus;
	  private Integer accType;
	  
	  public Integer getAccType()
	  {
	    return this.accType;
	  }
	  
	  public void setAccType(Integer accType)
	  {
	    this.accType = accType;
	  }
	  
	  public String getAccStatus()
	  {
	    return this.accStatus;
	  }
	  
	  public void setAccStatus(String accStatus)
	  {
	    this.accStatus = accStatus;
	  }
	  
	  public String getAccCode()
	  {
	    return this.accCode;
	  }
	  
	  public void setAccCode(String accCode)
	  {
	    this.accCode = accCode;
	  }
	  
	  public String getCrCode()
	  {
	    return this.crCode;
	  }
	  
	  public void setCrCode(String crCode)
	  {
	    this.crCode = crCode;
	  }
}
