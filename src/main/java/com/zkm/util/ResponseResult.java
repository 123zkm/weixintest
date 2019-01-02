package com.zkm.util;

import lombok.Data;

import com.zkm.enums.ResultEnum;

@Data
public class ResponseResult<T> {

	private Integer code;
	private String msg;
	T result;

	public static ResponseResult<Object> success(Object result){
		ResponseResult<Object> rs = new ResponseResult<Object>();
		rs.setCode(ResultEnum.SUCCESS.getCode());
		rs.setMsg(ResultEnum.SUCCESS.getMessage());
		rs.setResult(result);
		return rs;
	}
	
	public static ResponseResult<Object> error(){
		ResponseResult<Object> rs = new ResponseResult<Object>();
		rs.setCode(ResultEnum.ERROR.getCode());
		rs.setMsg(ResultEnum.ERROR.getMessage());
		return rs;
	}
	
}
