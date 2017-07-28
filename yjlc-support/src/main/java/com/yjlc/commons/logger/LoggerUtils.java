package com.yjlc.commons.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtils {
    private static final Logger commonLog = LoggerFactory.getLogger("commonLog"); // 普通日志
    private static final Logger payLog = LoggerFactory.getLogger("payLog");// 支付日志
    private static final Logger tradeLog = LoggerFactory.getLogger("tradeLog");// 交易日志
    private static final Logger exceptionLogger = LoggerFactory.getLogger("exceptionLog");// 异常日志

    public static void printCommonLog(String msg) {
        commonLog.info(msg);
    }

    /**
     * 描述: 打印支付日志 
     * 参数: @param msg
     * 参数: @param payNo
     * 参数: @param type
     * 返回值类型: void
     * 作者: Administrator  
     * 日期: 2017-4-2 上午10:44:10
     */
    public static void printPayLog(String msg, Integer payNo,PayType type ) {
       payLog.info(msg, payNo, type.getIndex());
    }

   /**
    * 描述: </p>打印交易日志</p>
    * 参数: @param msg
    * 参数: @param id
    * 参数: @param type
    * 返回值类型: void
    * 作者: 姜宏杰  
    * 日期: 2017-4-2 上午10:43:51
    */
    public static void printTradeLog(String msg, Integer id, TradeType type) {
        tradeLog.info(msg, id, type.getIndex());
    }

    public static void printExceptionLog(String msg, Throwable t) {
        exceptionLogger.info(msg, t);
    }

    
    public enum PayType {
        param(1, "参数"), 
        data(2, "返回");
        private int index;
        private String title;
        private PayType(int index, String title) {
            this.index = index;
            this.title = title;
        }
        public int getIndex() {
            return index;
        }
        public void setIndex(int index) {
            this.index = index;
        }
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
    }
    
    public enum TradeType {
        order(1, "订单"), 
        withdraw(2, "提现"), 
        refund(3, "退款"),
        recharge(4, "充值");
        private int index;

        private String title;

        private TradeType(int index, String title) {
            this.index = index;
            this.title = title;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

    }
}
