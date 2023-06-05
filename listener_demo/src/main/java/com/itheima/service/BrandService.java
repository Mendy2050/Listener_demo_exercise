package com.itheima.service;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author Mendy
 * @create 2023-05-28 19:00
 */
public class BrandService {

    //1. acquire sqlSessionFactory
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();


    public List<Brand> selectAll(){
        //call BrandMapper.selectAll()

        //2. acquire sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. acquire BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4.call method
        List<Brand> brands = mapper.selectAll();

        //5. close
        sqlSession.close();

        //6. return
        return brands;
    }


    public void add(Brand brand){
        //call BrandMapper.add()

        //2. acquire sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. acquire BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. call add method
        mapper.add(brand);

        //5. commit transaction
        sqlSession.commit();

        //6. close
        sqlSession.close();
    }



    public Brand selectById(int id){
        //call BrandMapper.selectById()

        //2. acquire sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. acquire BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4.call method
        Brand brand = mapper.selecById(id);

        //5. close
        sqlSession.close();

        //6. return
        return brand;
    }


    public void update(Brand brand){
        //call BrandMapper.add()

        //2. acquire sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. acquire BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. call add method
        mapper.update(brand);

        //5. commit transaction
        sqlSession.commit();

        //6. close
        sqlSession.close();
    }

}
