package org.akj.mybatis;

import org.akj.mybatis.entity.Product;
import org.akj.mybatis.mapper.ProductMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ProductMapperTests {

    @Test
    public void test() throws IOException {
        MyDataSourceFactory myDataSourceFactory = new MyDataSourceFactory();
        Properties properties = new Properties();
        properties.load(Resources.getResourceAsStream("jdbc.properties"));
        myDataSourceFactory.setProperties(properties);
        DataSource dataSource = myDataSourceFactory.getDataSource();

        TransactionFactory transactionFactory =
                new JdbcTransactionFactory();
        Environment environment =
                new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(ProductMapper.class);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(configuration);

        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
            Product product = mapper.getProductById("44ddbe50-0135-4264-92dc-273784f61997");
            System.out.println(product);
        }
    }

    @Test
    public void test1() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            Product product = sqlSession.selectOne(
                    "findProductById", "44ddbe50-0135-4264-92dc-273784f61997");
            System.out.println(product);
        }
    }
}
