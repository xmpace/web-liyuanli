package me.liyuanli.controller;

import me.liyuanli.enums.APIErrorEnum;
import me.liyuanli.exceptions.APIErrorException;
import me.liyuanli.model.APIResult;
import me.liyuanli.model.UserModel;
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
 * Time: 4:31 PM
 */
@Controller
public class AccountsController {
    @Autowired
    private IUserAccountsService userAccountsService;

    @RequestMapping(value = "/api/common/{version}/accounts", method = RequestMethod.POST)
    @ResponseBody
    public APIResult register(@RequestBody UserRegisterParam registerParam) {
        String paramErrMsg = null;
        if (registerParam.getLogin() == null) {
            paramErrMsg = "登录名不能为空";
        }
        if (registerParam.getNickName() == null) {
            paramErrMsg = "昵称不能为空";
        }
        if (registerParam.getPassword() == null) {
            paramErrMsg = "密码不能为空";
        }
        if (paramErrMsg != null) {
            return new APIResult(APIErrorEnum.PARAM_ERROR.getValue(), paramErrMsg);
        }
        UserModel userModel = null;
        try {
            userModel = userAccountsService.createUser(registerParam);
        } catch (APIErrorException e) {
            return new APIResult(e);
        }
        return new APIResult(userModel);
    }
}
