package me.liyuanli.dao.impl;

import me.liyuanli.dao.IAirplaneGameScoreDAO;
import me.liyuanli.domain.AirplaneGameScoreDO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by
 * User: xiaomi
 * Date: 5/24/15
 * Time: 8:56 AM
 */
@Repository
public class AirplaneGameScoreDAOImpl implements IAirplaneGameScoreDAO {
    private static final String BASE_MAPPER = "me.liyuanli.AirplaneGameScore.";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public int insert(AirplaneGameScoreDO airplaneGameScoreDO) {
        return sqlSessionTemplate.insert(BASE_MAPPER + "insert", airplaneGameScoreDO);
    }

    @Override
    public List<AirplaneGameScoreDO> getScoreTopN(int topN) {
        return sqlSessionTemplate.selectList(BASE_MAPPER + "getScoreTopN", topN);
    }
}
