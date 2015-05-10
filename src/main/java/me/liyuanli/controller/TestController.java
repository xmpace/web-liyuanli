package me.liyuanli.controller;

import me.liyuanli.model.APIResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by
 * User: xiaomi
 * Date: 5/10/15
 * Time: 1:34 AM
 */
@Controller
public class TestController {
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public APIResult<String> helloWorld(HttpServletResponse response) {
//        try {
//            response.getWriter().println("Hello World");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return new APIResult<>(new String("Hello world!"));
        return new APIResult<>("肖密");
    }
}
