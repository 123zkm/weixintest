package com.zkm.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.bean.WxJsapiSignature;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zkm.util.ResponseResult;

@Controller
@RequestMapping("test")
@Slf4j
public class TestController {

	@Autowired
	public WxMpService wxMpService;
	
	@RequestMapping("chooseImage")
	public String chooseImage(Model model) throws WxErrorException {
		WxJsapiSignature jsapiSignature = wxMpService.createJsapiSignature("http://123zkm.iok.la/test/chooseImage");
		log.debug(jsapiSignature.toString());
		model.addAttribute("jsapiSignature", jsapiSignature);
		return "chooseImage";
		
	}
	
	@RequestMapping("mediaDownload")
	@ResponseBody
	public ResponseResult<Object> mediaDownload(String mediaId) throws WxErrorException, IOException {
		// 获得一个在系统临时目录的文件
		File inFile = wxMpService.getMaterialService().mediaDownload(mediaId);		
		log.debug(mediaId);
		File outFile = null;
		if(inFile != null){
			outFile = new File(System.getProperty("user.dir")+IOUtils.DIR_SEPARATOR+UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(inFile.getPath()));
			FileUtils.copyFile(inFile, outFile);
		}
		return ResponseResult.success(outFile);
	}
}
