package daoImp;

import dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import po.User;

import java.util.List;

/**
 * @author : Lenovo
 * @description :
 * @create :2018-05-21 11:38
 **/
public class UserDaoImp implements UserDao {
    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImp(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User findUserById(int id) {
        SqlSession sq = sqlSessionFactory.openSession();
        User user = sq.selectOne("mapper.UserMapper.findUserById",id);
        sq.close();
        return user;
    }

    public List<User> findUserByName(String name){
        SqlSession sq = sqlSessionFactory.openSession();
        List<User> list = sq.selectList("dao.findUserByName",name);
        sq.close();
        return list;
    }
}
