package com.tinyspot.dongmall.controller;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import com.tinyspot.dongmall.entity.Body;
import com.tinyspot.dongmall.util.Result;
import com.tinyspot.dongmall.util.ResultGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author tinyspot
 * @Time 2019/11/15-15:25
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    //打印日志对象
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private static final String URL_PREFIX = "https://api.weixin.qq.com/sns/jscode2session?appid=wxbde71ac66c3d74e4&secret=e294f5475d5391dd89c3223b575fcc7f&js_code=";
    private static final String URL_SUFFIX = "&grazant_type=authorization_code";

    @GetMapping("/login")
    @ResponseBody
    public Result getOpenId(@RequestParam("code") String code){
        logger.debug("用户登录，code为: " + code);
        //logger.debug("url: " + URL_PREFIX + code + URL_SUFFIX);

        Result result = ResultGenerator.genSuccessResult();
        String bodyStr = null;
        try{
            bodyStr = HttpRequest.get(URL_PREFIX + code + URL_SUFFIX)
                    .execute().body();
            //logger.debug(bodyStr);

            String substring = bodyStr.substring(bodyStr.indexOf("{"));

            //将json串转为body对象
            Body body = JSONUtil.toBean(substring, Body.class);

            if (body.getOpenid() == null){  //表示微信那边返回错误码了
                throw new RuntimeException("微信那边返回错误码了");
            }else { //成功获取openid
                Digester md5 = new Digester(DigestAlgorithm.MD5);
                String openidMd5 = md5.digestHex(body.getOpenid());
                result.setData(openidMd5); //传回前端
            }

        }catch (Exception e){
            logger.error("登录时请求微信接口出错");
            result.setCode(ResultGenerator.RESULT_CODE_SERVER_ERROR);
            result.setMsg("登录出错，请联系管理员或重试！");
        }

        return result;
    }
}
