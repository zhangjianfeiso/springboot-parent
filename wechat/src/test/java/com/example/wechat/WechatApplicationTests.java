package com.example.wechat;

import com.example.wechat.common.bean.AccessToken;
import com.example.wechat.common.utils.AccessTokenUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WechatApplication.class)
public class WechatApplicationTests {

	@Autowired
	private AccessTokenUtil accessTokenUtil;

	@Test
	public void contextLoads() {
		AccessToken accessToken = accessTokenUtil.getAccessToken();
		System.out.println(accessToken);
	}

}
