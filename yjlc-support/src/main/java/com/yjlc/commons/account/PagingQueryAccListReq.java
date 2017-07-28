package com.yjlc.commons.account;

import com.joinwe.common.api.dto.ServiceMessage;

public class PagingQueryAccListReq extends ServiceMessage {
	private static final long serialVersionUID = 1L;
	  private String accCode;
	  private String accName;
	  private String crCode;
	  private String accStatus;
	  private String beginTime;
	  private String endTime;
	  private Integer pageIndex;
	  private Integer pageSize;
	  
	  public String getAccName()
	  {
	    return this.accName;
	  }
	  
	  public void setAccName(String accName)
	  {
	    this.accName = accName;
	  }
	  
	  public String getBeginTime()
	  {
	    return this.beginTime;
	  }
	  
	  public void setBeginTime(String beginTime)
	  {
	    this.beginTime = beginTime;
	  }
	  
	  public String getEndTime()
	  {
	    return this.endTime;
	  }
	  
	  public void setEndTime(String endTime)
	  {
	    this.endTime = endTime;
	  }
	  
	  public String getAccCode()
	  {
	    return this.accCode;
	  }
	  
	  public void setAccCode(String accCode)
	  {
	    this.accCode = accCode;
	  }
	  
	  public Integer getPageIndex()
	  {
	    return this.pageIndex;
	  }
	  
	  public void setPageIndex(Integer pageIndex)
	  {
	    this.pageIndex = pageIndex;
	  }
	  
	  public Integer getPageSize()
	  {
	    return this.pageSize;
	  }
	  
	  public void setPageSize(Integer pageSize)
	  {
	    this.pageSize = pageSize;
	  }
	  
	  public String getCrCode(){
	    return this.crCode;
	  }
	  
	  public void setCrCode(String crCode){
	    this.crCode = crCode;
	  }
	  
	  public String getAccStatus()
	  {
	    return this.accStatus;
	  }
	  
	  public void setAccStatus(String accStatus)
	  {
	    this.accStatus = accStatus;
	  }
}
