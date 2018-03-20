package com.example.demo;

import com.example.demo.proto.LoginReq;
import com.example.demo.proto.LoginRes;
import java.net.URI;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {

	private static final String GET_STRING_URL = "/";
	private static final String LOGIN_URL = "/login";

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {
	}

	@Test
	public void loginTest() {
		LoginReq loginReq = LoginReq.newBuilder().setPhoneNum("ma").setPassword("123").build();

		HttpHeaders headers = new HttpHeaders();
		RequestEntity<LoginReq> requestEntity =
				new RequestEntity<>(loginReq, headers, HttpMethod.POST, URI.create(LOGIN_URL));

		ResponseEntity<LoginRes> responseEntity = restTemplate.exchange(requestEntity, LoginRes.class);

		System.out.println(responseEntity.getBody().getStatus());

	}

	@Test
	public void getStringTest(){
		String aa = restTemplate.getForObject(GET_STRING_URL, String.class);
		System.out.println(aa);
	}

}
