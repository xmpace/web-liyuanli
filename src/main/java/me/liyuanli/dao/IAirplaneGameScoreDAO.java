package me.liyuanli.dao;

import me.liyuanli.domain.AirplaneGameScoreDO;

import java.util.List;

/**
 * Created by
 * User: xiaomi
 * Date: 5/24/15
 * Time: 8:56 AM
 */
public interface IAirplaneGameScoreDAO {
    int insert(AirplaneGameScoreDO airplaneGameScoreDO);

    List<AirplaneGameScoreDO> getScoreTopN(int topN);
}
