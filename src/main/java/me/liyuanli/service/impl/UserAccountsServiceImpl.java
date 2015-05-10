package me.liyuanli.service.impl;

import me.liyuanli.dao.IUserAccountsDAO;
import me.liyuanli.domain.UserAccountsDO;
import me.liyuanli.enums.APIErrorEnum;
import me.liyuanli.exceptions.APIErrorException;
import me.liyuanli.model.UserModel;
import me.liyuanli.params.UserAccountsSearchParam;
import me.liyuanli.params.fe.UserRegisterParam;
import me.liyuanli.service.IUserAccountsService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by
 * User: xiaomi
 * Date: 5/10/15
 * Time: 3:15 PM
 */
@Service
public class UserAccountsServiceImpl implements IUserAccountsService {
    @Autowired
    private IUserAccountsDAO userAccountsDAO;

    @Override
    public UserModel createUser(UserRegisterParam userRegisterParam) throws APIErrorException {
        String login = userRegisterParam.getLogin();
        String password = userRegisterParam.getPassword();
        String nickName = userRegisterParam.getNickName();
        if (isLoginExists(login)) {
            throw new APIErrorException(APIErrorEnum.LOGIN_ALREADY_EXISTS_ERROR);
        }
        if (isNickNameExists(nickName)) {
            throw new APIErrorException(APIErrorEnum.NICK_NAME_ALREADY_EXISTS_ERROR);
        }
        checkNewNickName(nickName);
        checkNewPassword(password);

        UserAccountsDO userAccountsDO = new UserAccountsDO();
        userAccountsDO.setLogin(login);
        userAccountsDO.setNickName(nickName);
        userAccountsDO.setPassword(password);
        userAccountsDO.setIsAdmin(0);
        userAccountsDAO.insert(userAccountsDO);

        UserModel userModel = new UserModel();
        userModel.setUserId(userAccountsDO.getId());
        userModel.setLogin(login);
        userModel.setNickName(nickName);
        userModel.setIsAdmin(0);
        return userModel;
    }

    private boolean isNickNameExists(String nickName) {
        if (nickName == null) {
            return true;
        }
        UserAccountsSearchParam param = new UserAccountsSearchParam();
        param.setNickName(nickName);
        List<UserAccountsDO> userAccountsDOs = userAccountsDAO.listByParam(param);
        return CollectionUtils.isNotEmpty(userAccountsDOs);
    }

    private boolean isLoginExists(String login) {
        if (login == null) {
            return true;
        }
        UserAccountsSearchParam param = new UserAccountsSearchParam();
        param.setLogin(login);
        List<UserAccountsDO> userAccountsDOs = userAccountsDAO.listByParam(param);
        return CollectionUtils.isNotEmpty(userAccountsDOs);
    }

    private void checkNewNickName(String nickName) throws APIErrorException {
        if (StringUtils.isEmpty(nickName) || StringUtils.isBlank(nickName)) {
            throw new APIErrorException(APIErrorEnum.NICK_NAME_BLANK_ERROR);
        }
    }

    private void checkNewPassword(String password) throws APIErrorException {
        if (password == null || password.length() < 6 || password.length() > 16) {
            throw new APIErrorException(APIErrorEnum.PASSWORD_LENGTH_ERROR);
        }
    }

    @Override
    public String login(String login, String password) throws APIErrorException {
        if (login == null) {
            throw new APIErrorException(APIErrorEnum.PARAM_ERROR.getValue(), "登录名不能为空");
        }
        UserAccountsSearchParam param = new UserAccountsSearchParam();
        param.setLogin(login);
        List<UserAccountsDO> userAccountsDOs = userAccountsDAO.listByParam(param);
        if (CollectionUtils.isEmpty(userAccountsDOs)) {
            throw new APIErrorException(APIErrorEnum.LOGIN_NOT_EXISTS_ERROR);
        }
        UserAccountsDO userAccountsDO = userAccountsDOs.get(0);
        if (!StringUtils.equals(password, userAccountsDO.getPassword())) {
            throw new APIErrorException(APIErrorEnum.PASSWORD_ERROR);
        }
        return "akj19fy1ud3acs4h1y2ac2hw9u12g9u29ey19h";
    }
}
