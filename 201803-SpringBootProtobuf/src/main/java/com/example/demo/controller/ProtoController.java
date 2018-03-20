package com.example.demo.controller;

import com.example.demo.proto.LoginReq;
import com.example.demo.proto.LoginRes;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author matengsi4184 Date: 2018/3/12 Time: 11:48.
 */
@RestController
public class ProtoController {

  @RequestMapping(value = "/login")
  public ResponseEntity<LoginRes> login(RequestEntity<LoginReq> requestEntity) {

    LoginReq loginReq = requestEntity.getBody();

    LoginRes.Builder loginRes = LoginRes.newBuilder();

    if (loginReq.getPhoneNum().equals("ma") && loginReq.getPassword().equals("123")) {
      loginRes.setStatus("success!");
    } else {
      loginRes.setStatus("Error!");
    }

    System.out.println(loginRes.build());

    return ResponseEntity.ok(loginRes.build());
  }

  @RequestMapping(value = "/")
  public String getString() {
    return "hello";
  }

}
