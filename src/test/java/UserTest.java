
import com.zhangxiande.mapper.UserMapper;
import com.zhangxiande.pojo.User;
import com.zhangxiande.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
    private SqlSession sqlSession;
    private UserMapper userMapper;

    @Before
    public void init() {
        sqlSession = MyBatisUtils.geSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }


    @Test
    public void test01() {
        User user1 = new User();
        user1.setUname("xxx");
        user1.setUphone("114514");
        user1.setUage(20);
        Boolean flag = userMapper.insertUser(user1);
        if (flag) {
            User user = userMapper.findByName(user1.getUname());
            System.out.println(user.toString());
        } else {
            System.out.println("填入失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test02() {
        User byId = userMapper.findById(4);
        System.out.println(byId.toString());
    }

    @Test
    public void test03(){
        User user = new User();
        user.setUid(4);
        user.setUname("hahhahaha");

        Boolean flag = userMapper.updateUserByID(user);
        if (flag) {
            User user1 = userMapper.findByName(user.getUname());
            System.out.println(user1.getUname());
        } else {
            System.out.println("错误");
        }
    }


    @Test
    public void test04(){
        userMapper.deleteUserByID(15);
    }


    @After
    public void destory(){
        sqlSession.commit();
        sqlSession.close();
    }
}
