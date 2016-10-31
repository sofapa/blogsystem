package com.netease.course.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Date;
@Repository
public class BlogDAOImpl implements BlogDAO {

    private JdbcTemplate jdbcTemplate;


   /* public void SetJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        System.out.println("jdbcTemplate construct!");
    }
    */


    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        if(this.jdbcTemplate==null) System.out.println("world!");
        //System.out.println("constructor!!");

    }

    public void insertArticle(String title, String content) {
        //System.out.println("where is the pointer");
        if(this.jdbcTemplate==null) System.out.println("hello");;
        //this.jdbcTemplate.execute("create table mytable (id integer, name varchar(100))");
        Date datetime = new Date();
        this.jdbcTemplate.update("insert into blog ( blogTitle, blogContent ,nowDate) values (?,?,?)",title,content,datetime);
        //System.out.println("I am pointer!");
    }
    public void queryArticle(){
        //jdbcTemplate.query("select * from blog;",rowMapper);
    }
    public int count() {
        //return this.jdbcTemplate.queryForObject("select blogId(*) from blog", Integer.class);
        System.out.println("query count");
        return 3;
    }
}
