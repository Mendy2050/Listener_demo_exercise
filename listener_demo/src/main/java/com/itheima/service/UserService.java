package com.itheima.service;

import com.itheima.mapper.UserMapper;
import com.itheima.util.SqlSessionFactoryUtils;
import com.itheima.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author Mendy
 * @create 2023-05-31 18:09
 */
public class UserService {

    //1. acquire sqlSessionFactory
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();


    public User login(String username, String password){
        //2. acquire sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            //3. acquire UserMapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            //4.call method
            User user = mapper.select(username, password);

            return user;
        } finally {
            //5. close
            sqlSession.close();
        }
    }


    public boolean register(User user){
        //2. acquire sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            //3. acquire UserMapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            //4. Check if the "desired username" for registration exists
            User u = mapper.selectByUsername(user.getUsername());

            if(u == null){
                //The "desired username" for registration does not exist
                // we can register this "desired username"
                mapper.add(user);

                //commit the transaction
                sqlSession.commit();
            }

            return u == null;
        } finally {
            sqlSession.close();
        }
    }

}
