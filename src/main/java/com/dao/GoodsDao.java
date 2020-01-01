package com.dao;

import com.mapper.GoodsMapper;
import com.pojo.Goods;
import com.pojo.GoodsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lemon on 2019-12-29 13:10.
 */
@Repository
public class GoodsDao {
    @Autowired
    private GoodsMapper goodsMapper;

    public Integer addGoods(Goods goods){
        return goodsMapper.insert(goods);
    }

    public List<Goods> findAll() {
        GoodsExample example = new GoodsExample();
        return goodsMapper.selectByExample(example);
    }

    public List<Goods> findByKeuWord(String name) {
        GoodsExample example = new GoodsExample();
        example.createCriteria().andGoodNameLike("%"+name+"%");
        return goodsMapper.selectByExample(example);
    }

    public Integer updateGood(Goods goods) {
        return goodsMapper.updateByPrimaryKey(goods);
    }

    public Integer delete(Long id) {
        return goodsMapper.deleteByPrimaryKey(id);
    }
}
