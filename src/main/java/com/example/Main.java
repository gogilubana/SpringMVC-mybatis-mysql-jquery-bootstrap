package com.example;

import java.util.List;

import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



import com.example.dao.HelloDAO;
//import com.hmkcode.vo.Person;


public class Main {

	public static void main(String args[]){
		
		// Laod spring-config.xml file
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/example/config/spring-config.xml");
		
		//get jdbcTemplateHelloDAO
		DefaultSqlSessionFactory sessionFactory  = (DefaultSqlSessionFactory) ctx.getBean("sqlSessionFactory");
		
                HelloDAO helloDAO = new HelloDAO(sessionFactory);

		

	}
}
