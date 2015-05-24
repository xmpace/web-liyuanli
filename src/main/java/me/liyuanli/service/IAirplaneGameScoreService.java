package me.liyuanli.service;

import me.liyuanli.model.AirplaneGameScoreModel;

import java.util.List;

/**
 * Created by
 * User: xiaomi
 * Date: 5/24/15
 * Time: 9:03 AM
 */
public interface IAirplaneGameScoreService {
    AirplaneGameScoreModel recordAnScore(String nickName, Integer score);

    List<AirplaneGameScoreModel> getRankList();
}
