package me.liyuanli.controller;

import me.liyuanli.enums.APIErrorEnum;
import me.liyuanli.exceptions.APIErrorException;
import me.liyuanli.model.APIResult;
import me.liyuanli.params.fe.UserRegisterParam;
import me.liyuanli.service.IUserAccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by
 * User: xiaomi
 * Date: 5/10/15
 * Time: 4:44 PM
 */
@Controller
public class LoginController {
    @Autowired
    private IUserAccountsService userAccountsService;

    @RequestMapping(value = "/api/common/{version}/login", method = RequestMethod.POST)
    @ResponseBody
    public APIResult login(@RequestBody UserRegisterParam param) {
        String login = param.getLogin();
        String password = param.getPassword();
        if (login == null || password == null) {
            return new APIResult(APIErrorEnum.PARAM_ERROR.getValue(), "用户名或密码为空");
        }
        String token = null;
        try {
            token = userAccountsService.login(login, password);
        } catch (APIErrorException e) {
            return new APIResult(e);
        }
        return new APIResult(token);
    }
}
