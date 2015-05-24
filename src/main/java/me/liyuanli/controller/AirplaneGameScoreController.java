package me.liyuanli.controller;

import me.liyuanli.enums.APIErrorEnum;
import me.liyuanli.model.APIResult;
import me.liyuanli.model.AirplaneGameScoreModel;
import me.liyuanli.service.IAirplaneGameScoreService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by
 * User: xiaomi
 * Date: 5/24/15
 * Time: 9:11 AM
 */
@Controller
public class AirplaneGameScoreController {
    @Autowired
    private IAirplaneGameScoreService airplaneGameScoreService;

    @RequestMapping(value = "/api/common/{version}/airplane/rank", method = RequestMethod.GET)
    @ResponseBody
    public APIResult getRankList() {
        return new APIResult(airplaneGameScoreService.getRankList());
    }

    @RequestMapping(value = "/api/common/{version}/airplane/rank", method = RequestMethod.POST)
    @ResponseBody
    public APIResult recordScore(@RequestBody AirplaneGameScoreModel param) {
        String nickName = param.getNickName();
        Integer score = param.getScore();
        if (StringUtils.isEmpty(nickName) || score == null) {
            return new APIResult(APIErrorEnum.PARAM_ERROR);
        }
        return new APIResult(airplaneGameScoreService.recordAnScore(param.getNickName(), param.getScore()));
    }
}
