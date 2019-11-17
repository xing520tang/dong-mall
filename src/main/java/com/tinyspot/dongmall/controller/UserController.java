package com.tinyspot.dongmall.controller;

import cn.hutool.http.HttpRequest;
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

    @GetMapping("/code")
    @ResponseBody
    public Result getOpenId(@RequestParam("code") String code){
        logger.debug("code: " + code);
        logger.debug("url: " + URL_PREFIX + code + URL_SUFFIX);

        String body = HttpRequest.get(URL_PREFIX + code + URL_SUFFIX)
                .execute().body();

        Result result = ResultGenerator.genSuccessResult();
        result.setData(body);
        return result;
    }
}
