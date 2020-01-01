import com.pojo.Goods;
import com.service.GoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by lemon on 2019-12-29 13:20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class GoodsTest {
    @Autowired
    private GoodsService goodsService;
    @Test
    public void add(){
        Goods goods = new Goods();
        goods.setId(1L);
        goods.setGoodName("iphone8");
        goods.setGoodNumber(12);
        goods.setCreateTime(new Date());
        goods.setAddress("美国");
        goods.setGoodPrice(3999d);
        Integer integer = goodsService.addGood(goods);
        System.out.println(integer);
    }

    @Test
    public void findAll(){
        List<Goods> list = goodsService.findAll();
        System.out.println(list);
    }

    @Test
    public void findByKeyWord(){
        List<Goods> list = goodsService.searchByKeyWord("h");
        System.out.println(list);
    }

    @Test
    public void update(){
        Goods goods = new Goods();
        goods.setId(1L);
        goods.setGoodName("iphone8");
        goods.setGoodNumber(22);
        goods.setCreateTime(new Date());
        goods.setAddress("gdsgad");
        goods.setGoodPrice(3999d);
        goodsService.updateGood(goods);
    }

    @Test
    public void delete(){
        Integer integer = goodsService.deleteGoodById(5L);
        System.out.println(integer);
    }
}
