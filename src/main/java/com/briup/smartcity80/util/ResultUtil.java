package com.briup.smartcity80.util;

/**
 * 为了生成Result对象生成工具类
 * @Author lining
 * @Date 2022/12/26
 */
public class ResultUtil {
    private ResultUtil() {}

    public static Result success(){//默认成功
        return new Result(ResultEnum.SUCCESS);
    }
    public static Result success(Object data){
        return new Result(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(),data);
    }
    public static Result success(ResultEnum code){
        return new Result(code.getCode(),code.getMsg());
    }


    //失败-----------
    public static Result error(){//默认成功
        return new Result(ResultEnum.ERROR);
    }
    public static Result error(Object data){
        return new Result(ResultEnum.ERROR.getCode(), ResultEnum.ERROR.getMsg(),data);
    }
    public static Result error(String msg){
        return new Result(ResultEnum.ERROR.getCode(),msg);
    }
    public static Result error(ResultEnum code){
        return new Result(code);
    }
}
