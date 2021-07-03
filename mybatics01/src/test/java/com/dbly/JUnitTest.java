package com.dbly;

import com.dbly.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class JUnitTest {
    private SqlSession sqlSession;
    @Before
    public void init() throws IOException {
        //1.读取mybatis配置
        Reader reader = Resources.getResourceAsReader(
                "Mapper/SqlMap.xml"
        );

        //2.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder
                = new SqlSessionFactoryBuilder();
        //3.获取SqlSessionFactory对象
        SqlSessionFactory factory
                = builder.build(reader);
        //4.获取Sqlsession对象
        sqlSession = factory.openSession();
    }
    @Test
    public void testStudent(){
        //5.通过session对象插入数据
        Student student = new Student();
        student.setSname("gfdhb");
        student.setSsex("女");
        student.setClassName("东北林业大学");
        sqlSession.insert("insertStudent",student);
        sqlSession.commit();

    }


    @Test
    public void testSelectStudent(){
      List<Student> list = sqlSession.selectList("findAllStudent");
      for (Student student : list){
          System.out.println(student);
      }
    }

    @Test
    public void testDeleteStudent(){
        sqlSession.delete("deleteStudent",1);
        sqlSession.commit();
    }
    @Test
    public void testUpdateStudent(){
        Student student =new Student();
        student.setSid(3);
        student.setSname("sdasasf");
        sqlSession.update("updateStudent",student);
        sqlSession.commit();
    }

    @After
    public void close(){
        //6.关闭session
        sqlSession.close();
    }
}
