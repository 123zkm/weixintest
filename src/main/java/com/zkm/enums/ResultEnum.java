package com.zkm.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

	SUCCESS(0,"成功"),
	ERROR(1,"失败")
	;
	
	
	private Integer code;

    private String message;

	private ResultEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
    
    
}
