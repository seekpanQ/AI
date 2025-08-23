package com.toastmasters.meeting.common;

import java.io.Serializable;
import lombok.Data;

/**
 * <p>
 *   统一响应结果包装类
 * </p>
 * @author seekpan
 */
@Data
public class RestResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 响应码
     */
    private String code;

    /**
     * 响应消息
     */
    private String msg;

    /**
     * 响应数据
     */
    private T data;

    /**
     * 构造函数
     */
    public RestResult() {
    }

    /**
     * 成功返回
     *
     * @param data 返回的数据
     * @return RestResult 对象
     */
    public static <T> RestResult<T> success(T data) {
        RestResult<T> result = new RestResult<>();
        result.setCode("000000");
        result.setMsg("调用成功");
        result.setData(data);
        return result;
    }

    /**
     * 错误返回
     *
     * @param code 错误码
     * @param msg  错误信息
     * @return RestResult 对象
     */
    public static <T> RestResult<T> error(String code, String msg) {
        RestResult<T> result = new RestResult<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
