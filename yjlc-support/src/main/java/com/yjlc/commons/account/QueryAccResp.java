package com.yjlc.commons.account;

import java.util.List;

import com.joinwe.common.api.dto.ServiceMessage;
import com.yjlc.commons.account.entity.FunctionalMessage;
import com.yjlc.commons.account.entity.SeSummaryMessage;
import com.yjlc.commons.account.entity.SecondaryMessage;

public class QueryAccResp extends ServiceMessage {
	 private static final long serialVersionUID = 1L;
	  private SecondaryMessage secondary;
	  private SeSummaryMessage seSummary;
	  private List<FunctionalMessage> functionalList;
	  private FunctionalMessage functional;
	  
	  public SecondaryMessage getSecondary()
	  {
	    return this.secondary;
	  }
	  
	  public void setSecondary(SecondaryMessage secondary)
	  {
	    this.secondary = secondary;
	  }
	  
	  public SeSummaryMessage getSeSummary()
	  {
	    return this.seSummary;
	  }
	  
	  public void setSeSummary(SeSummaryMessage seSummary)
	  {
	    this.seSummary = seSummary;
	  }
	  
	  public List<FunctionalMessage> getFunctionalList()
	  {
	    return this.functionalList;
	  }
	  
	  public void setFunctionalList(List<FunctionalMessage> functionalList)
	  {
	    this.functionalList = functionalList;
	  }
	  
	  public FunctionalMessage getFunctional()
	  {
	    return this.functional;
	  }
	  
	  public void setFunctional(FunctionalMessage functional)
	  {
	    this.functional = functional;
	  }
}
