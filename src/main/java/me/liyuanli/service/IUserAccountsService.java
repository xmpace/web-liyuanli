package me.liyuanli.service;

import me.liyuanli.exceptions.APIErrorException;
import me.liyuanli.model.UserModel;
import me.liyuanli.params.fe.UserRegisterParam;

/**
 * Created by
 * User: xiaomi
 * Date: 5/10/15
 * Time: 3:15 PM
 */
public interface IUserAccountsService {
    UserModel createUser(UserRegisterParam userRegisterParam) throws APIErrorException;

    String login(String login, String password) throws APIErrorException;
}
