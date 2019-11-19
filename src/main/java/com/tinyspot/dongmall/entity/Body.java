package com.tinyspot.dongmall.entity;

/**
 * @Author tinyspot
 * @Time 2019/11/18-15:16
 * 微信接口响应返回的正确body，也就是说登录成功后获得的sessionkey和openid放入这个body中
 */

public class Body {
    private String session_key;
    private String openid;

    public Body(){}

    public Body(String session_key, String openid) {
        this.session_key = session_key;
        this.openid = openid;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    @Override
    public String toString() {
        return "Body{" +
                "session_key='" + session_key + '\'' +
                ", openid='" + openid + '\'' +
                '}';
    }
}
