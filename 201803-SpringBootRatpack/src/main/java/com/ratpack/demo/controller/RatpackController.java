package com.ratpack.demo.controller;

import com.ratpack.demo.model.ArticleList;
import com.ratpack.demo.model.Content;
import com.ratpack.demo.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import ratpack.func.Action;
import ratpack.handling.Chain;
import ratpack.server.ServerConfig;
import ratpack.spring.config.EnableRatpack;

/**
 * @author matengsi4184 Date: 2018/3/19 Time: 14:19.
 */
@Controller
@EnableRatpack
public class RatpackController {

  @Autowired
  private Content content;

  @Autowired
  private ArticleList list;

  @Autowired
  private Login login;

  @Bean
  public Action<Chain> hello() {
    return chain -> chain.get("hello", ctx -> ctx.render(content.body()));
  }

  @Bean
  public Action<Chain> list() {
    return chain -> chain.get("list", ctx -> ctx.render(list
        .articles()
        .toString()));
  }

  @Bean
  public Action<Chain> loginCheck() {
    return chain -> chain.get("login",
        ctx -> ctx.render(
            login.login(ctx.getRequest().getQueryParams().get("name")).toString()));
  }

  @Bean
  public ServerConfig ratpackServerConfig() {
    return ServerConfig
        .builder()
        .findBaseDir("public")
        .build();
  }

}
