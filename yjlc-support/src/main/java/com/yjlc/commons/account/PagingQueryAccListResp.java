package com.yjlc.commons.account;

import java.math.BigDecimal;

import com.joinwe.common.api.dto.PagingData;
import com.joinwe.common.api.dto.ServiceMessage;

public class PagingQueryAccListResp extends ServiceMessage {
	private static final long serialVersionUID = 1L;
	  private PagingData<SecoundaryView> secoundaryViewList;
	  
	  public class SecoundaryView
	  {
	    private Integer id;
	    private String accCode;
	    private String accName;
	    private String masterCode;
	    private String accType;
	    private String accStatus;
	    private String accMemo;
	    private String createBy;
	    private String createTime;
	    private String modfiyBy;
	    private String modfiyTime;
	    private String frtTrdNum;
	    private BigDecimal avaAssert;
	    private BigDecimal lockAssert;
	    private BigDecimal debtAssert;
	    private String crCode;
	    
	    public SecoundaryView() {}
	    
	    public Integer getId()
	    {
	      return this.id;
	    }
	    
	    public void setId(Integer id)
	    {
	      this.id = id;
	    }
	    
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
	    
	    public String getMasterCode()
	    {
	      return this.masterCode;
	    }
	    
	    public void setMasterCode(String masterCode)
	    {
	      this.masterCode = masterCode;
	    }
	    
	    public String getAccType()
	    {
	      return this.accType;
	    }
	    
	    public void setAccType(String accType)
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
	    
	    public String getAccMemo()
	    {
	      return this.accMemo;
	    }
	    
	    public void setAccMemo(String accMemo)
	    {
	      this.accMemo = accMemo;
	    }
	    
	    public String getCreateBy()
	    {
	      return this.createBy;
	    }
	    
	    public void setCreateBy(String createBy)
	    {
	      this.createBy = createBy;
	    }
	    
	    public String getCreateTime()
	    {
	      return this.createTime;
	    }
	    
	    public void setCreateTime(String createTime)
	    {
	      this.createTime = createTime;
	    }
	    
	    public String getModfiyBy()
	    {
	      return this.modfiyBy;
	    }
	    
	    public void setModfiyBy(String modfiyBy)
	    {
	      this.modfiyBy = modfiyBy;
	    }
	    
	    public String getModfiyTime()
	    {
	      return this.modfiyTime;
	    }
	    
	    public void setModfiyTime(String modfiyTime)
	    {
	      this.modfiyTime = modfiyTime;
	    }
	    
	    public String getFrtTrdNum()
	    {
	      return this.frtTrdNum;
	    }
	    
	    public void setFrtTrdNum(String frtTrdNum)
	    {
	      this.frtTrdNum = frtTrdNum;
	    }
	    
	    public BigDecimal getAvaAssert()
	    {
	      return this.avaAssert;
	    }
	    
	    public void setAvaAssert(BigDecimal avaAssert)
	    {
	      this.avaAssert = avaAssert;
	    }
	    
	    public BigDecimal getLockAssert()
	    {
	      return this.lockAssert;
	    }
	    
	    public void setLockAssert(BigDecimal lockAssert)
	    {
	      this.lockAssert = lockAssert;
	    }
	    
	    public BigDecimal getDebtAssert()
	    {
	      return this.debtAssert;
	    }
	    
	    public void setDebtAssert(BigDecimal debtAssert)
	    {
	      this.debtAssert = debtAssert;
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
	  
	  public PagingData<SecoundaryView> getSecoundaryViewList()
	  {
	    return this.secoundaryViewList;
	  }
	  
	  public void setSecoundaryViewList(PagingData<SecoundaryView> secoundaryViewList)
	  {
	    this.secoundaryViewList = secoundaryViewList;
	  }
}
