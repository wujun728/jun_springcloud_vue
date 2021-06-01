package com.gs.exception;

/**
 * @ProjectName: srpingbootdatajpa
 * @Package: com.gs.exception
 * @Description: java类作用描述
 * @Author: Administrator
 * @CreateDate: 2018/4/24 17:47
 * @UpdateUser: Administrator
 * @UpdateDate: 2018/4/24 17:47
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
public class MyException  extends Exception{

private String errorCode;
    public MyException(String message) {
        super(message);

    }

    public MyException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
