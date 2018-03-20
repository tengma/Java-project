package com.ratpack.demo.config;

import com.ratpack.demo.model.ArticleList;
import com.ratpack.demo.model.Content;
import com.ratpack.demo.model.Login;
import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author matengsi4184 Date: 2018/3/19 Time: 12:02.
 */
@Configuration
public class Config {

  @Bean
  public Content content() {
    return () -> "hello world!";
  }

  @Bean
  public ArticleList articles() {
    return () -> Arrays.asList("aaa", "bbb", "ccc");
  }

  @Bean
  public Login login() {
    return (name) -> name.equals("ma");
  }

}
