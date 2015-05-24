package me.liyuanli.service.impl;

import me.liyuanli.dao.IAirplaneGameScoreDAO;
import me.liyuanli.domain.AirplaneGameScoreDO;
import me.liyuanli.model.AirplaneGameScoreModel;
import me.liyuanli.service.IAirplaneGameScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by
 * User: xiaomi
 * Date: 5/24/15
 * Time: 9:03 AM
 */
@Service
public class AirplaneGameScoreServiceImpl implements IAirplaneGameScoreService {
    @Autowired
    private IAirplaneGameScoreDAO airplaneGameScoreDAO;

    @Override
    public AirplaneGameScoreModel recordAnScore(String nickName, Integer score) {
        AirplaneGameScoreDO airplaneGameScoreDO = new AirplaneGameScoreDO();
        airplaneGameScoreDO.setNickName(nickName);
        airplaneGameScoreDO.setScore(score);
        if (airplaneGameScoreDAO.insert(airplaneGameScoreDO) == 1) {
            AirplaneGameScoreModel result = new AirplaneGameScoreModel();
            result.setNickName(nickName);
            result.setScore(score);
            return result;
        }
        return null;
    }

    @Override
    public List<AirplaneGameScoreModel> getRankList() {
        List<AirplaneGameScoreDO> rankList = airplaneGameScoreDAO.getScoreTopN(10);
        return domainToModel(rankList);
    }

    private List<AirplaneGameScoreModel> domainToModel(List<AirplaneGameScoreDO> domains) {
        List<AirplaneGameScoreModel> models = new ArrayList<>();
        for (AirplaneGameScoreDO domain : domains) {
            models.add(domainToModel(domain));
        }
        return models;
    }

    private AirplaneGameScoreModel domainToModel(AirplaneGameScoreDO domain) {
        AirplaneGameScoreModel model = new AirplaneGameScoreModel();
        model.setScore(domain.getScore());
        model.setNickName(domain.getNickName());
        return model;
    }
}
