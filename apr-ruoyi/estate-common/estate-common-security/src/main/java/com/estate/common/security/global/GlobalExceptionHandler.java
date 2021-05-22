package com.estate.common.security.global;

import com.estate.common.core.constant.HttpStatus;
import com.estate.common.core.exception.BaseException;
import com.estate.common.core.exception.CustomException;
import com.estate.common.core.result.Result;
import com.estate.common.core.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @author ruoyi
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 基础异常
     */
    @ExceptionHandler(BaseException.class)
    public Result baseException(BaseException e) {
        log.error(e.getMessage());
        return Result.error(e.getDefaultMessage());
    }

    /**
     * 业务异常
     */
    @ExceptionHandler(CustomException.class)
    public Result businessException(CustomException e) {
        if (StringUtils.isNull(e.getCode())) {
            return Result.error(e.getMessage());
        }
        return Result.error(e.getCode(), e.getMessage());
    }

    /**
     * 用户没有权限异常 403
     * @param e
     * @return
     */
    @ExceptionHandler(AccessDeniedException.class)
    public Result handleAuthorizationException(AccessDeniedException e) {
        log.error(e.getMessage());
        return Result.error(HttpStatus.FORBIDDEN, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        log.error(e.getMessage(), e);
        return Result.error(e.getMessage());
    }

    /**
     * 自定义验证异常
     */
//    @ExceptionHandler(BindException.class)
//    public AjaxResult validatedBindException(BindException e) {
//        log.error(e.getMessage(), e);
//        String message = e.getAllErrors().get(0).getDefaultMessage();
//        return AjaxResult.error(message);
//    }

    /**
     * 自定义验证异常
     */
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Object validExceptionHandler(MethodArgumentNotValidException e) {
//        log.error(e.getMessage(), e);
//        String message = e.getBindingResult().getFieldError().getDefaultMessage();
//        return AjaxResult.error(message);
//    }

    /**
     * 权限异常
     */
//    @ExceptionHandler(PreAuthorizeException.class)
//    public AjaxResult preAuthorizeException(PreAuthorizeException e) {
//        return AjaxResult.error("没有权限，请联系管理员授权");
//    }

}