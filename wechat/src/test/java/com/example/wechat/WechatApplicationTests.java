/*
package com.example.wechat;



import com.example.wechat.api.WechatUserApi;
import com.example.wechat.common.bean.*;
import com.example.wechat.common.utils.AccessTokenUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WechatApplication.class)
public class WechatApplicationTests {

	@Autowired
	private AccessTokenUtil accessTokenUtil;
	@Autowired
	private WechatUserApi wechatUserApi;

	@Test
	public void getUsers(){
		FocusesUser wechatFocusesOnUsers = wechatUserApi.getWechatFocusesOnUsers("");
		List<FocusesUser.Data> data = wechatFocusesOnUsers.getData();
		System.out.println(wechatFocusesOnUsers);
		System.out.println(data);
	}

	@Test
	public void getUserInfo(){
		//oCndhs9K4U34AGGrTqWRr4LHGEAs
		//oyhsn0nE-uDb3Alt-1XjuaeWvCrA
		UserInfo wechatUserInfo = wechatUserApi.getWechatUserInfo("oyhsn0nE-uDb3Alt-1XjuaeWvCrA");
		System.out.println(wechatUserInfo);
	}

	@Test
	public void get(){
		BatchgetUserInfoRes batchgetRes = new BatchgetUserInfoRes();
		List<BatchgetUserInfoRes.Data> data = new ArrayList<>();
		data.add(new BatchgetUserInfoRes.Data("ogk2v0ejj-V9o-y8wp4PutGy7UeI"));
		data.add(new BatchgetUserInfoRes.Data("ogk2v0bl7YGxV9zSf4eYFquPIcs0"));
		batchgetRes.setUser_list(data);
		BatchgetUserInfo batchgetUserInfo = wechatUserApi.getBatchgetUserInfo(batchgetRes);
		System.out.println(batchgetUserInfo);
	}

	@Test
	public void contextLoads() {
		AccessToken accessToken = accessTokenUtil.getAccessToken();
		System.out.println(accessToken);
	}


}
*/
