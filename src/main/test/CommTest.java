import com.hdjf.oa.domain.Role;
import com.hdjf.oa.domain.User;
import com.hdjf.oa.service.RoleService;
import com.hdjf.oa.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by harrishuang on 2017/8/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Transactional
public class CommTest {

    @Resource
    private RoleService roleService;



    @Resource
    private UserService userService;


    @Test
    public void test(){
        Configuration configuration = new Configuration();
        System.out.println(configuration);
    }


    @Test
    public void  test2(){
        for (int i = 0; i < 10; i++) {
            Role role=new Role();
            role.setName("dd");
            role.setDescription("mose");
            roleService.add(role);
        }
    }


    @Test
    public void  testUser(){
        User user=new User();
        user.setName("d");
        user.setDescription("ddddd");
        user.setEmail("dsasdasd");
        userService.add(user);

    }



    @Test
    public void test1() {
        Configuration configuration = new Configuration();
        SessionFactory sf = configuration.configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        tx.begin();
        User user = new User();
        user.setName("张三");
        user.setEmail("123456@qq.com");
        session.persist(user);
        tx.commit();
        session.close();
    }
}
