package com.netease.course.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by gigabyte on 2016-06-21.
 */
@Controller
@RequestMapping("/into")
public class Test {
    @RequestMapping("/blogger")
    @ResponseBody
    public String update(@RequestParam String blogTitle, @RequestParam String blogContent, HttpServletResponse resp){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        BlogService blogservice = context.getBean("blogservice",BlogService.class);


        if(blogTitle.length()<21&&blogContent.length()<101&&blogTitle.length()>0&&blogContent.length()>0){
            blogservice.pressblog(blogTitle,blogContent);
            System.out.println("blog insert success");
            resp.setStatus(200);
            return "200,ok.blog insert success.<br>Please open developer tools to check statuscode.";}
        else {
            System.out.println("blog config is inlegal.");
            ((ConfigurableApplicationContext)context).close();
            resp.setStatus(400);
            return "blog insert failed.<br>Please open developer tools to check statuscode.<br>\nCheck the size of Title or Content.<br><h1>BlogTitle:"+blogTitle;}

    }

    @RequestMapping("/hello")
    public void ccoment(HttpServletResponse resp, HttpEntity he,Writer writer){
        try {
            writer.write("Hello,SpringMVC");
            System.out.println("Method ccoment visited.");
            resp.setStatus(408);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        //BlogDAO blogdao = context.getBean("blogdao",BlogDAO.class);
        BlogService blogservice = context.getBean("blogservice",BlogService.class);
        String title="title05";
        String content="content04";
        blogservice.pressblog(title,content);
        //BlogDAO blogDAO = context.getBean("blogdao",BlogDAO.class);
        //int x = blogDAO.count();
        //System.out.println(x);
        ((ConfigurableApplicationContext)context).close();

        System.out.println("hello!");
    }*/
}
