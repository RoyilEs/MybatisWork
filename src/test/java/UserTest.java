import com.zhangxiande.mapper.UserMapper;
import com.zhangxiande.pojo.User;
import com.zhangxiande.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class UserTest {

    @Test
    public void test01() {
        User user1 = new User();
        user1.setUname("XXX");
        user1.setUphone("114514");
        user1.setUage(20);

        SqlSession sqlSession = MyBatisUtils.geSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Boolean flag = userMapper.insertUser(user1);
        if (flag) {
            User user = userMapper.findByName(user1.getUname());
            System.out.println(user.toString());
        } else {
            System.out.println("填入失败");
        }
        sqlSession.close();
    }
}
