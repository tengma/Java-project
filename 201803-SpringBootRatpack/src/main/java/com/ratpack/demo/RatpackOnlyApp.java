package com.ratpack.demo;

import ratpack.exec.Blocking;
import ratpack.server.RatpackServer;

/**
 * @author matengsi4184 Date: 2018/3/19 Time: 14:53.
 */
public class RatpackOnlyApp {

  public static void main(String[] args) throws Exception{
    RatpackServer.start(server -> server
        .handlers(chain -> chain
            .get("new-route", ctx -> ctx.render("new route " + ctx.getRequest().getQueryParams().get("param") + " !"))
            .get(ctx -> ctx.render("Hello world!"))
            .get(":name", ctx -> ctx.render("Hello " + ctx.getPathTokens().get("name") + " !"))
        )
    );
  }

  public static void main1(String[] args) throws Exception{
    RatpackServer.start(server -> server
        .handlers(chain ->
            chain.get(ctx -> Blocking.get(() -> {
              Thread.sleep(5000);
              return "Hello World";
            }).then(str -> ctx.render(str)))));
  }

}
