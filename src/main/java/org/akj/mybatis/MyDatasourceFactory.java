package org.akj.mybatis;

import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.datasource.pooled.PooledDataSource;

import javax.sql.DataSource;
import java.util.Properties;

class MyDataSourceFactory implements DataSourceFactory {

    private Properties property;

    @Override
    public DataSource getDataSource() {

        PooledDataSource ds = new PooledDataSource();

        ds.setDriver(property.getProperty("driver"));
        ds.setUrl(property.getProperty("url"));
        ds.setUsername(property.getProperty("user"));
        ds.setPassword(property.getProperty("password"));

        return ds;
    }

    @Override
    public void setProperties(Properties property) {

        this.property = property;
    }
}