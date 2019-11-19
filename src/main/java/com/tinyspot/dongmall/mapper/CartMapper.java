package com.tinyspot.dongmall.mapper;

import com.tinyspot.dongmall.entity.Cart;
import com.tinyspot.dongmall.entity.CartT;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author tinyspot
 * @Time 2019/11/18-9:47
 */
@Mapper
public interface CartMapper {

    /*
    根据用户id查出该用户的购物车信息
     */
    @Select("SELECT c.*, detail, now_price, old_price, seckill, picture " +
            "FROM cart c LEFT JOIN goods g ON c.`goods_id`=g.`id` WHERE user_id = #{userId};")
    List<CartT> getCartByUserId(String userId);


    /*
    插入购物车
     */
    @Insert("insert into cart(user_id, goods_id, param, number) values(#{userId}, #{goodsId}, #{param}, #{number})")
    void insertCart(Cart cart);


    /*
    根据用户id和商品id和商品规格查出该用户已经选了多少该商品
     */
    @Select("select number from cart where user_id=#{userId} and goods_id=#{goodsId} and param=#{param}")
    Integer getNumberBygoodsIdUserIdAndParam(Cart cart);

    /*
    根据用户id和商品id和商品规格更新该用户的购物车
     */
    @Update("update cart set number=#{number} where user_id=#{userId} and goods_id=#{goodsId} and param=#{param}")
    void updateCartByUserIdGoodsIdAndParam(Cart cart);

    /*
    根据用户id和商品id和商品规格删除一条购物车记录
     */
    @Delete("delete from cart where user_id=#{userId} and goods_id=#{goodsId} and param=#{param}")
    void deleteCartByUserIdGoodsIdAndParam(Cart cart);
}
