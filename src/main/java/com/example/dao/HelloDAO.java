package com.example.dao;
 

import java.util.List;
 
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.example.vo.Hello;
 
 
public class HelloDAO {
 
    private SqlSessionFactory sqlSessionFactory = null;
 
    public HelloDAO(SqlSessionFactory sqlSessionFactory){
    	this.sqlSessionFactory = sqlSessionFactory;
    }
 
    /**
     * Returns the list of all Hello instances from the database.
     * @return the list of all Hello instances from the database.
     */
    @SuppressWarnings("unchecked")
    public  List<Hello> selectAll(){
    	List<Hello> list = null;
        SqlSession session = sqlSessionFactory.openSession();
 
        try {
            list = session.selectList("Hello.selectAll");
        } finally {
            session.close();
        }
        System.out.println("selectAll() --> "+list);
        return list;

    }
    /**
     * Select instance of Hello from the database.
     * @param hello the instance to be persisted.
     */
   public Hello selectById(int id){
       	Hello hello = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
        	hello = session.selectOne("Hello.selectNameById", id);
        

        } finally {
            session.close();
        }
        return hello;
    }
   
   public String selectByIdString(int id){
       	Hello hello = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            hello = session.selectOne("Hello.selectNameById", id);
        } finally {
            session.close();
        }
        return ""+hello;
    }
    /**
     * Insert an instance of Hello into the database.
     * @param hello the instance to be persisted.
     */
   public int insert(Hello hello){
	   int id = 1; //default value -1
        SqlSession session = sqlSessionFactory.openSession();

        try {
            id = session.insert("Hello.insert", hello);
        } finally {
            session.commit();
            session.close();
        }
        System.out.println("insert("+hello+") --> "+hello.getId());
        return id;
    }
    /**
   * Update an instance of Hello into the database.
   * @param hello the instance to be persisted.
   */
  	public void update(Hello hello){
	   int id = -1;
      SqlSession session = sqlSessionFactory.openSession();

      try {
          id = session.update("Hello.update", hello);

      } finally {
          session.commit();
          session.close();
      }
      System.out.println("update("+hello+") --> updated");
  }
 
    /**
     * Delete an instance of Hello from the database.
     * @param id value of the instance to be deleted.
     */
    public void delete(int id){
 
        SqlSession session = sqlSessionFactory.openSession();
 
        try {
            session.delete("Hello.delete", id);
        } finally {
            session.commit();
            session.close();
        }
        System.out.println("delete("+id+")");

    }
}