package com.yjlc.commons.constants;

public enum ErrorCode {
	version_no_match(101, "版本过低，请下载高版本"),
	time_over(101, "试用时间已过，请下载正式版本");
	
    private int index;

    private String title;

    private ErrorCode(int index, String title) {
        this.index = index;
        this.title = title;
    }

    public static String getTitle(int index) {
        for (ErrorCode ms : ErrorCode.values()) {
            if (ms.getIndex() == index) {
                return ms.title;
            }
        }
        return null;
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
