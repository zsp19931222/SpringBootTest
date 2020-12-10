package com.zsp.error;

import com.zsp.util.CommonEnum;
import com.zsp.util.Log;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * description:
 * author：Andy on 2020/11/19 0019-10:49
 * email:zsp872126510@gmail.com
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理自定义的业务异常
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public ResultBody bizExceptionHandler(HttpServletRequest req, BizException e) {
        Log.error("发生业务异常！原因是：{}", e.getErrorMsg());
        return ResultBody.error(e.getErrorCode(), e.getErrorMsg());
    }

    /**
     * 处理空指针的异常
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public ResultBody exceptionHandler(HttpServletRequest req, NullPointerException e) {
        Log.error("发生空指针异常！原因是:", e);
        return ResultBody.error(CommonEnum.BODY_NOT_MATCH);
    }

    /**
     * 处理空指针的异常
     */
    @ExceptionHandler(value = AccessDeniedException.class)
    @ResponseBody
    public ResultBody accessDeniedHandler(HttpServletRequest req, NullPointerException e) {
        Log.error("发生空指针异常！原因是:", e);
        return ResultBody.error(CommonEnum.BODY_NOT_MATCH);
    }


    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public ResultBody exceptionHandler(HttpServletRequest req, HttpRequestMethodNotSupportedException e) {
        Log.error("请求异常！原因是:", e);
        return ResultBody.error(CommonEnum.RequestMethodNotSupportedException);
    }


    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseBody
    public ResultBody exceptionHandler(HttpServletRequest req, HttpMessageNotReadableException e) {
        Log.error("请求异常！原因是:", e);
        return ResultBody.error(CommonEnum.HttpMessageNotReadableException);
    }
    /**
     * 所有验证框架异常捕获处理
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = {BindException.class, MethodArgumentNotValidException.class})
    public Object validationExceptionHandler(Exception exception) {
        BindingResult bindResult = null;
        if (exception instanceof BindException) {
            bindResult = ((BindException) exception).getBindingResult();
        }
        String msg;
        if (bindResult != null && bindResult.hasErrors()) {
            msg = bindResult.getAllErrors().get(0).getDefaultMessage();
            if (msg.contains("NumberFormatException")) {
                msg = "参数类型错误！";
            }
        }else {
            msg = "系统繁忙，请稍后重试...";
        }
        return ResultBody.error(msg);
    }


    /**
     * @param exception
     * @return
     * @throws Exception
     * @// TODO: 2018/4/25 处理token 过期异常
     */
    @ExceptionHandler(value = ExpiredJwtException.class)
    public ResultBody ExpiredJwtExceptionHandler(ExpiredJwtException exception) throws Exception {
        Log.info(exception.getMessage());
        return ResultBody.error("登录已过期！");
    }
    /**
     * 处理其他异常
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultBody exceptionHandler(HttpServletRequest req, Exception e) {
        Log.error("未知异常！原因是:", e);
        return ResultBody.error(CommonEnum.INTERNAL_SERVER_ERROR);
    }
}
