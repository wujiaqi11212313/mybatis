import dao.UserDao;
import daoImp.UserDaoImp;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import po.User;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author : Lenovo
 * @description :
 * @create :2018-05-21 14:37
 **/
public class Test01 {
    SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void setUp() throws IOException {
        //mybatis的配置文件
        String resource = "conf.xml";
        //加载配置文件
        InputStream is = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }

    @Test
    public void TestfindUserById() throws Exception {
        //创建UserDao的对象
        UserDao userDao = new UserDaoImp(sqlSessionFactory);
        User user = userDao.findUserById(1);
        System.out.print(user.getName());
    }

    @Test
    public void TestfindUserByName(){
        UserDao userDao = new UserDaoImp(sqlSessionFactory);
        List<User> list = userDao.findUserByName("tom");
        System.out.println(list.get(1).getName());
    }

    @Test
    public void ttt(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper的对象，mybatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用userMapper的方法
        List list = userMapper.findUserByName("tom");
        sqlSession.close();
        System.out.println(list);
    }

}
