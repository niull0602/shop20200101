package com.service.impl;

import com.dao.GoodsDao;
import com.pojo.Goods;
import com.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lemon on 2019-12-29 13:18.
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;
    @Override
    public Integer addGood(Goods goods) {
        return goodsDao.addGoods(goods);
    }

    @Override
    public List<Goods> findAll() {
        return goodsDao.findAll();
    }

    @Override
    public List<Goods> searchByKeyWord(String name) {
        return goodsDao.findByKeuWord(name);
    }

    @Override
    public Integer updateGood(Goods goods) {
        return goodsDao.updateGood(goods);
    }

    @Override
    public Integer deleteGoodById(Long id) {
        return goodsDao.delete(id);
    }
}
