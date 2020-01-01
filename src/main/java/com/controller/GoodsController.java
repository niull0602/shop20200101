package com.controller;

import com.pojo.Goods;
import com.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lemon on 2020-01-01 10:23.
 */
@RestController
public class GoodsController {
    @Autowired
    private GoodsService service;

    @GetMapping(value = "getGoodList",produces = "text/html;charset=utf-8")
    public String getList(){
        List<Goods> list = service.findAll();
        return list.toString();
    }

    @PostMapping(value = "addGood",produces = "text/html;charset=utf-8")
    public String addGood(Goods good){
        Integer res = service.addGood(good);
        if (res==1)
            return "添加成功";
        else
            return "添加失败";
    }

    @DeleteMapping(value = "deleteGood",produces = "text/html;charset=utf-8")
    public String deleteGoodById(Goods good){
        Long id = good.getId();
        Integer res = service.deleteGoodById(id);
        if (res==1)
            return "删除成功";
        else
            return "删除失败";
    }

    @PutMapping(value = "updateGood",produces = "text/html;charset=utf-8")
    public String update(Goods goods){
        Integer res = service.updateGood(goods);
        if (res==1)
            return "更新成功";
        else
            return "更新失败";
    }
}
