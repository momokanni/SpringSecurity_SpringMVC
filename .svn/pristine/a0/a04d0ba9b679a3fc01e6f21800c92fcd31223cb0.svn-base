package com.caishen91.jupiter.authorize.handler;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.caishen91.jupiter.authorize.enums.ResultEnums;
import com.caishen91.jupiter.authorize.exception.BaseAccessDeniedException;
import com.caishen91.jupiter.authorize.exception.BaseAuthenticationException;
import com.caishen91.jupiter.authorize.util.ResultUtil;
import com.caishen91.jupiter.authorize.vo.ResultVO;

@ControllerAdvice
public class ExceptionHandle {
	
	private static Logger log = LoggerFactory.getLogger(ExceptionHandle.class);
	
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(value = {BaseAuthenticationException.class,BaseAccessDeniedException.class})
	@ResponseStatus(value = HttpStatus.FORBIDDEN)
	public ResultVO handelrAuthExpection(HttpServletRequest request, HttpServletResponse response,Exception e) throws UnsupportedEncodingException {
		if(e instanceof BaseAuthenticationException) {
			BaseAuthenticationException auth = (BaseAuthenticationException) e;
			return ResultUtil.error(auth.getCode(), auth.getMessage());
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResultVO handlerUserException(Exception e){
		e.printStackTrace();
		log.error("system error:{}" , e.getMessage());
		return ResultUtil.error(ResultEnums.SYSTEM_ERROR.getCode(),ResultEnums.SYSTEM_ERROR.getMsg());
	}
}
