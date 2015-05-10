package me.liyuanli.dao;

import me.liyuanli.domain.UserAccountsDO;
import me.liyuanli.params.UserAccountsSearchParam;

import java.util.List;

/**
 * Created by
 * User: xiaomi
 * Date: 5/10/15
 * Time: 3:06 PM
 */
public interface IUserAccountsDAO {
    int insert(UserAccountsDO userAccountsDO);

    int delete(Integer id);

    int update(UserAccountsDO userAccountsDO);

    List<UserAccountsDO> listByParam(UserAccountsSearchParam param);
}
