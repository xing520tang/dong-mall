package com.tinyspot.dongmall.mapper;

import com.tinyspot.dongmall.entity.Goods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Author tinyspot
 * @Time 2019/11/17-15:29
 */
@Mapper
public interface GoodsMapper {

    /*
    查询所有秒杀商品
     */
    @Select("select * from goods where seckill = 1")
    List<Goods> selectAllSeckillGoods();

    /*
    查询所有商品
     */
    @Select("select * from goods")
    List<Goods> selectAllGoods();


    /*
    根据id查询某个商品
     */
    @Select("select * from goods where id = #{id}")
    Goods getGoodsById(Integer id);

    /*
    插入商品
     */
    @Insert("insert into goods(name,type_id,type_name, now_price, old_price, sold, detail, param, seckill, picture) " +
            "values(#{name}, #{typeId}, #{typeName}, #{nowPrice}, #{oldPrice}, #{sold}, #{detail}, #{param}, #{seckill}, #{picture})")
    void insertGoods(Goods good);

    /*
    更新商品的sold
     */
    @Update("update goods set sold=#{sold} where id = #{id}")
    void updateGoods(Goods goods);
}
