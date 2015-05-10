package me.liyuanli.dao.impl;

import me.liyuanli.dao.IUserAccountsDAO;
import me.liyuanli.domain.UserAccountsDO;
import me.liyuanli.params.UserAccountsSearchParam;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by
 * User: xiaomi
 * Date: 5/10/15
 * Time: 3:08 PM
 */
@Repository
public class UserAccountsDAOImpl implements IUserAccountsDAO {
    private static final String BASE_MAPPER = "me.liyuanli.UserAccountsMapper.";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public int insert(UserAccountsDO userAccountsDO) {
        return sqlSessionTemplate.insert(BASE_MAPPER + "insert", userAccountsDO);
    }

    @Override
    public int delete(Integer id) {
        return sqlSessionTemplate.delete(BASE_MAPPER + "delete", id);
    }

    @Override
    public int update(UserAccountsDO userAccountsDO) {
        return sqlSessionTemplate.update(BASE_MAPPER + "update", userAccountsDO);
    }

    @Override
    public List<UserAccountsDO> listByParam(UserAccountsSearchParam param) {
        return sqlSessionTemplate.selectList(BASE_MAPPER + "listByParam", param);
    }
}
