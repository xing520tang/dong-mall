package com.tinyspot.dongmall.controller;

import com.tinyspot.dongmall.entity.Cart;
import com.tinyspot.dongmall.entity.CartR;
import com.tinyspot.dongmall.entity.CartT;
import com.tinyspot.dongmall.service.CartService;
import com.tinyspot.dongmall.util.Convert;
import com.tinyspot.dongmall.util.Result;
import com.tinyspot.dongmall.util.ResultGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author tinyspot
 * @Time 2019/11/18-9:37
 * 购物车相关controller
 */
@RestController
@RequestMapping("/cart")
public class CartController {

    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    @Autowired
    CartService cartService;

    /*
    根据userId返回该用户的购物车信息
     */
    @GetMapping("/all")
    public List<CartR> getAllCart(@RequestParam("userId") String userId){
        logger.info("查询用户"+userId+"的购物车信息...");
        List<CartT> list = cartService.getAllCartR(userId);

        //转换
        List<CartR> result = Convert.convertCartTList(list);

        return result;
    }


    /*
    更新购物车（添加或删除）
     */
    @PostMapping("/update")
    public Result updateCart(@RequestParam("add") boolean add, Cart cart){
        logger.info(cart.getUserId() + "更新购物车...");

        Result result = ResultGenerator.genSuccessResult();
        try{
            cartService.updateCart(cart, add);
        }catch (Exception e){
            logger.error("添加购物车错误！", e);
            result.setCode(ResultGenerator.RESULT_CODE_SERVER_ERROR);
            result.setMsg("添加购物车错误, 请联系管理员或稍后再试");
        }

        return result;
    }
}
