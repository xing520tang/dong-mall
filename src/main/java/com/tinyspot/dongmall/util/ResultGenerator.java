package com.tinyspot.dongmall.util;

/**
 * @Author tinyspot
 * @Time 2019/11/15-17:06
 * 结果生成器
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
    private static final String DEFAULT_FAIL_MESSAGE = "FAIL";
    private static final int RESULT_CODE_SUCCESS = 200;
    private static final int RESULT_CODE_SERVER_ERROR = 500;

    public static Result genSuccessResult(){
        Result result = new Result(RESULT_CODE_SUCCESS, DEFAULT_SUCCESS_MESSAGE);
        return result;
    }

    public static Result genSuccessResult(String msg){
        Result result = new Result();
        result.setCode(RESULT_CODE_SUCCESS);
        result.setMsg(msg);
        return result;
    }

    public static Result genSuccessResult(Object data){
        Result result = genSuccessResult();
        result.setData(data);
        return result;
    }

    public static Result genFailResult(String msg){
        Result result = new Result();
        result.setCode(RESULT_CODE_SERVER_ERROR);
        result.setMsg(msg);
        return result;
    }
}
