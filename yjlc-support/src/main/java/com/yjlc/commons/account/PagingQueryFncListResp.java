package com.yjlc.commons.account;

import java.math.BigDecimal;

import com.joinwe.common.api.dto.PagingData;
import com.joinwe.common.api.dto.ServiceMessage;

public class PagingQueryFncListResp extends ServiceMessage {
	private static final long serialVersionUID = 1L;
	  private PagingData<Balance> balanceDataList;
	  
	  public class Balance
	  {
	    private Integer id;
	    private String seCode;
	    private String fnCode;
	    private String accTrdNo;
	    private String frtTrdNo;
	    private BigDecimal trdAmt;
	    private String trdCode;
	    private String trdTime;
	    private Integer balanceFig;
	    private BigDecimal balance;
	    private BigDecimal lockBalance;
	    private String trdMemo;
	    private int fnType;
	    private String crCode;
	    
	    public Balance() {}
	    
	    public Integer getId()
	    {
	      return this.id;
	    }
	    
	    public void setId(Integer id)
	    {
	      this.id = id;
	    }
	    
	    public String getSeCode()
	    {
	      return this.seCode;
	    }
	    
	    public void setSeCode(String seCode)
	    {
	      this.seCode = seCode;
	    }
	    
	    public String getFnCode()
	    {
	      return this.fnCode;
	    }
	    
	    public void setFnCode(String fnCode)
	    {
	      this.fnCode = fnCode;
	    }
	    
	    public String getAccTrdNo()
	    {
	      return this.accTrdNo;
	    }
	    
	    public void setAccTrdNo(String accTrdNo)
	    {
	      this.accTrdNo = accTrdNo;
	    }
	    
	    public String getFrtTrdNo()
	    {
	      return this.frtTrdNo;
	    }
	    
	    public void setFrtTrdNo(String frtTrdNo)
	    {
	      this.frtTrdNo = frtTrdNo;
	    }
	    
	    public BigDecimal getTrdAmt()
	    {
	      return this.trdAmt;
	    }
	    
	    public void setTrdAmt(BigDecimal trdAmt)
	    {
	      this.trdAmt = trdAmt;
	    }
	    
	    public String getTrdCode()
	    {
	      return this.trdCode;
	    }
	    
	    public void setTrdCode(String trdCode)
	    {
	      this.trdCode = trdCode;
	    }
	    
	    public String getTrdTime()
	    {
	      return this.trdTime;
	    }
	    
	    public void setTrdTime(String trdTime)
	    {
	      this.trdTime = trdTime;
	    }
	    
	    public Integer getBalanceFig()
	    {
	      return this.balanceFig;
	    }
	    
	    public void setBalanceFig(Integer balanceFig)
	    {
	      this.balanceFig = balanceFig;
	    }
	    
	    public BigDecimal getBalance()
	    {
	      return this.balance;
	    }
	    
	    public void setBalance(BigDecimal balance)
	    {
	      this.balance = balance;
	    }
	    
	    public BigDecimal getLockBalance()
	    {
	      return this.lockBalance;
	    }
	    
	    public void setLockBalance(BigDecimal lockBalance)
	    {
	      this.lockBalance = lockBalance;
	    }
	    
	    public String getTrdMemo()
	    {
	      return this.trdMemo;
	    }
	    
	    public void setTrdMemo(String trdMemo)
	    {
	      this.trdMemo = trdMemo;
	    }
	    
	    public int getFnType()
	    {
	      return this.fnType;
	    }
	    
	    public void setFnType(int fnType)
	    {
	      this.fnType = fnType;
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
	  
	  public PagingData<Balance> getBalanceDataList()
	  {
	    return this.balanceDataList;
	  }
	  
	  public void setBalanceDataList(PagingData<Balance> balanceDataList)
	  {
	    this.balanceDataList = balanceDataList;
	  }
}
