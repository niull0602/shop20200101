package com.service;

import com.pojo.Goods;

import java.util.List;

/**
 * Created by lemon on 2019-12-29 13:18.
 */
public interface GoodsService {
    public Integer addGood(Goods goods);
    public List<Goods> findAll();
    public List<Goods> searchByKeyWord(String name);
    public Integer updateGood(Goods goods);
    public Integer deleteGoodById(Long id);
}
