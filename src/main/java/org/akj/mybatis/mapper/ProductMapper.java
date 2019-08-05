package org.akj.mybatis.mapper;

import org.akj.mybatis.entity.Product;
import org.apache.ibatis.annotations.Select;

public interface ProductMapper {
    @Select("SELECT * FROM products WHERE id = #{id}")
    Product getProductById(String id);
}
