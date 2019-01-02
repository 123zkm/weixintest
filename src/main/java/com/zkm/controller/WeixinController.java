package com.zkm.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by SqMax on 2018/3/23.
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {
	
	private final String APPID = "wx490c861a42629ff7";
	
	private final String APP_SECRET = "6dfe7d94fc1d705e92af74d7827de57d";
	
	 //用户同意授权，获取code
    String toAuth="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx490c861a42629ff7&redirect_uri=http://123zkm.iok.la/weixinzkm/weixin/auth&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
	
    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code){
        log.info("进入auth方法.......");
        log.info("code={}",code);

        String url="https://api.weixin.qq.com/sns/oauth2/access_token?"
                +"appid="+APPID+"&secret="+APP_SECRET+"&code="+ code +"&grant_type=authorization_code";
        RestTemplate restTemplate=new RestTemplate();
        String response=restTemplate.getForObject(url,String.class);
        log.info("response={}",response);

    }

}
