package com.github.phper666.schemaregistry.rest.exception.handler;

import com.github.phper666.schemaregistry.rest.exception.SchemaRegistryException;
import com.github.phper666.schemaregistry.rest.exception.code.EnumCode;
import com.github.phper666.schemaregistry.utils.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liyuzhao
 * @email 562405704@qq.com
 * @date 2020/9/17 10:14 下午
 * @software IntelliJ IDEA
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理自定义的业务异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = SchemaRegistryException.class)
    @ResponseBody
    public ResponseData schemaRegisterExceptionHandler(HttpServletRequest req, SchemaRegistryException e){
        logger.error("schema-register异常！原因是：{}",e.getErrMsg());
        return ResponseData.fail(e.getErrCode(),e.getErrMsg());
    }

    /**
     * 处理空指针的异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public ResponseData exceptionHandler(HttpServletRequest req, NullPointerException e){
        logger.error("发生空指针异常！原因是:",e);
        return ResponseData.fail(EnumCode.ERROR_CODE, e.getMessage());
    }


    /**
     * 处理其他异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseData exceptionHandler(HttpServletRequest req, Exception e){
        logger.error("未知异常！原因是:",e);
        return ResponseData.fail(EnumCode.ERROR_CODE, e.getMessage());
    }
}
