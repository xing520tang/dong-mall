package com.tinyspot.dongmall.service;

import com.tinyspot.dongmall.entity.Cart;
import com.tinyspot.dongmall.entity.CartT;
import com.tinyspot.dongmall.mapper.CartMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author tinyspot
 * @Time 2019/11/18-9:40
 */
@Service
public class CartService {

    private static final Logger logger = LoggerFactory.getLogger(CartService.class);

    @Autowired
    CartMapper cartMapper;

    public List<CartT> getAllCartR(String userId) {
        List<CartT> cartTs = cartMapper.getCartByUserId(userId);
        return cartTs;
    }


    /**
     * 更新购物车
     * @param cart
     * @param add 表示是否在原有基础上添加
     */
    public void updateCart(Cart cart, boolean add) {
        if(cart.getNumber() > 0){ //添加购物车
            if (add){ //表示在原有基础上添加
                //先查出原来的number
                int preNumber = cartMapper.getNumberBygoodsIdUserIdAndParam(cart);
                //加上原先的数量
                cart.setNumber(preNumber + cart.getNumber());
                //更新购物车中的number
                cartMapper.updateCartByUserIdGoodsIdAndParam(cart);
            }else{ //原来没有，所有直接添加
                cartMapper.insertCart(cart);
            }
        }else{//删除购物车
            //先查出原来的number
            int number = cartMapper.getNumberBygoodsIdUserIdAndParam(cart);
            number += cart.getNumber();
            //判断一下number是否大于0，若是表示只是删减数量
            if(number > 0){ //更新购物车number
                cart.setNumber(number);
                cartMapper.updateCartByUserIdGoodsIdAndParam(cart);
            }else{ //删除购物车中该商品
                cartMapper.deleteCartByUserIdGoodsIdAndParam(cart);
            }
        }
    }
}
