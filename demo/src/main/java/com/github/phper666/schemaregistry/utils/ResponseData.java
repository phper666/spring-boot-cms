package com.github.phper666.schemaregistry.utils;

/**
 * @author liyuzhao
 * @email 562405704@qq.com
 * @date 2020/9/17 11:18 上午
 * @software IntelliJ IDEA
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * define the common response data
 *
 * @author lazycece
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData<T> {

    /**
     * the response errcode
     */
    private Integer errcode;
    /**
     * the response errmsg
     */
    private String errmsg;
    /**
     * the response data
     */
    private T data;

    public interface ResponseMsg {

        String SUCCESS = "ok";
        String FAIL = "fail";
    }

    public interface ResponseCode {

        Integer SUCCESS = 0;
        Integer FAIL = -1;
    }

    /**
     * define success response data by default code and errmsg, but no data
     *
     * @return response
     */
    public static ResponseData success() {
        return new ResponseData<>(ResponseCode.SUCCESS, ResponseMsg.SUCCESS, null);
    }

    /**
     * define success response data by default code and errmsg, the data is flexible
     *
     * @param data data
     * @param <T>  T
     * @return response
     */
    public static <T> ResponseData<T> success(T data) {
        return new ResponseData<>(ResponseCode.SUCCESS, ResponseMsg.SUCCESS, data);
    }

    /**
     * define the fail response by default code and errmsg
     *
     * @return response
     */
    public static ResponseData fail() {
        return new ResponseData<>(ResponseCode.FAIL, ResponseMsg.FAIL, null);
    }

    /**
     * define the fail response by default code, and the errmsg is flexible
     *
     * @param errmsg fail errmsg
     * @return response
     */
    public static ResponseData fail(String errmsg) {
        return new ResponseData<>(ResponseCode.FAIL, errmsg, null);
    }

    /**
     * define the fail response, the code and errmsg both flexible
     *
     * @param errcode  errcode
     * @param errmsg errmsg
     * @return response
     */
    public static ResponseData fail(Integer errcode, String errmsg) {
        return new ResponseData<>(errcode, errmsg, null);
    }
}

