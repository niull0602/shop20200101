import com.pojo.User;
import com.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by lemon on 2019-12-29 14:10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class UserTest {
    @Autowired
    private UserService service;
    @Test
    public void register(){
        User user = new User();
        user.setAddress("陕西省榆林市");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setHobby("dagsiaois");
        user.setImgUrl("http://file02.16sucai.com/d/file/2015/0128/8b0f093a8edea9f7e7458406f19098af.jpg");
        user.setPassword("123123");
        user.setSex((short)1);
        user.setUsername("iii");
        user.setNickName("我不");
        Integer result = service.registerUser(user);
        System.out.println(result);
    }

    @Test
    public void delete(){
        Integer logOut = service.logOut(1L);
        System.out.println(logOut);
    }

    @Test
    public void changePassWord(){
        Integer changePassword = service.changePassword("aa", "55667", "123456");
        System.out.println(changePassword);
    }

    @Test
    public void findByCondition(){
        List<User> list = service.findByCondition("我不");
        System.out.println(list);
    }

    @Test
    public void login(){
        Integer login = service.login("lemon", "123123");
        System.out.println(login);
    }
}
