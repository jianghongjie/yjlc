package com.yjlc.commons.account;

import com.joinwe.common.api.dto.ServiceMessage;

public class ModifyAccReq extends ServiceMessage {
	/**
	 * 描述: TODO(用一句话描述该文件做什么) 
	 */
	private static final long serialVersionUID = 1L;
	private String accCode;
	  private String accName;
	  private String modifyBy;
	  private String accStatus;
	  private String accMemo;
	  
	  public String getAccCode()
	  {
	    return this.accCode;
	  }
	  
	  public void setAccCode(String accCode)
	  {
	    this.accCode = accCode;
	  }
	  
	  public String getAccName()
	  {
	    return this.accName;
	  }
	  
	  public void setAccName(String accName)
	  {
	    this.accName = accName;
	  }
	  
	  public String getModifyBy()
	  {
	    return this.modifyBy;
	  }
	  
	  public void setModifyBy(String modifyBy)
	  {
	    this.modifyBy = modifyBy;
	  }
	  
	  public String getAccStatus()
	  {
	    return this.accStatus;
	  }
	  
	  public void setAccStatus(String accStatus)
	  {
	    this.accStatus = accStatus;
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
