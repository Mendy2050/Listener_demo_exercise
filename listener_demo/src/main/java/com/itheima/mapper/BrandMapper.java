package com.itheima.mapper;

import com.itheima.pojo.Brand;

import java.util.List;

/**
 * @author Mendy
 * @create 2023-05-28 17:34
 */
public interface BrandMapper {

    List<Brand> selectAll();

    void add(Brand brand);

    Brand selecById(int id);

    void update(Brand brand);

}
