package com.zkm.controller;

import java.io.File;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.bean.WxJsapiSignature;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zkm.util.ResponseResult;

@RestController
@RequestMapping("weChat")
@Slf4j
public class WechatController {

	@Autowired
	public WxMpService wxMpService;

	@RequestMapping("getToken")
	public ResponseResult<Object> getToken() throws WxErrorException {
		String accessToken = wxMpService.getAccessToken();
		log.debug(accessToken);
		return ResponseResult.success(accessToken);
	}
	
	@RequestMapping("getJsapiTicket")
	public ResponseResult<Object> getJsapiTicket() throws WxErrorException {
		String jsapiTicket = wxMpService.getJsapiTicket();
		log.debug(jsapiTicket);
		return ResponseResult.success(jsapiTicket);
	}
	
	@RequestMapping("createJsapiSignature")
	public ResponseResult<Object> createJsapiSignature() throws WxErrorException {
		WxJsapiSignature jsapiSignature = wxMpService.createJsapiSignature("http://localhost:8080/weChat/getToken");
		log.debug(jsapiSignature.toString());
		return ResponseResult.success(jsapiSignature);
	}
	
	
	

}
