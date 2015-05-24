package me.liyuanli.params;

import java.util.Date;

/**
 * Created by
 * User: xiaomi
 * Date: 5/24/15
 * Time: 8:55 AM
 */
public class AirplaneGameScoreSearchParam {
    private Integer id;
    private Date gmtCreate;
    private Date gmtModified;
    private String nickName;
    private Integer score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
