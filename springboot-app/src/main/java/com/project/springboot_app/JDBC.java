package com.project.springboot_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

@Slf4j
public class JDBC {
    public int insert(UserDetails adminlogin){
        DataSource dataSource=null;
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        int result=0;
        try{
            //getting ConfigDatasource
            dataSource=configDataSource.source();
            //attempt for connection to mysql
            connection=dataSource.getConnection();
            preparedStatement=connection.prepareStatement("insert into adminlogin(username,password) values(?,?)");
            preparedStatement.setString(1,adminlogin.getUsername());
            preparedStatement.setString(2,adminlogin.getPassword());
            result = preparedStatement.executeUpdate();
            System.out.println("heyy i set the value");
        }
        catch(SQLException e){
            log.getName();

            
        }
        return result;
    }
    
}
