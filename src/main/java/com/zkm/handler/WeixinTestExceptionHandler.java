package com.zkm.handler;

import me.chanjar.weixin.common.bean.result.WxError;
import me.chanjar.weixin.common.exception.WxErrorException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zkm.enums.ResultEnum;
import com.zkm.exception.WeixinTestException;
import com.zkm.util.ResponseResult;

@ControllerAdvice
public class WeixinTestExceptionHandler {

	
	@ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseResult errorHandler(Exception ex) {
		ResponseResult rs = new ResponseResult();
		if(ex instanceof WxErrorException){
			ex = (WxErrorException) ex;
			WxError wxError = ((WxErrorException) ex).getError();
			rs.setCode(wxError.getErrorCode());
			rs.setMsg(wxError.getErrorMsg());
		}else{
			ex = (WeixinTestException) ex;
			rs.setCode(ResultEnum.ERROR.getCode());
			rs.setMsg(ex.getMessage());
		}
		
        return rs;
    }
	
}
