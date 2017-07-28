package com.yjlc.commons.account;

import com.joinwe.common.api.dto.ServiceMessage;

public class ModifyAccResp extends ServiceMessage {
	private String accName;
	  private String accCode;
	  
	  public String getAccName()
	  {
	    return this.accName;
	  }
	  
	  public void setAccName(String accName)
	  {
	    this.accName = accName;
	  }
	  
	  public String getAccCode()
	  {
	    return this.accCode;
	  }
	  
	  public void setAccCode(String accCode)
	  {
	    this.accCode = accCode;
	  }
}
