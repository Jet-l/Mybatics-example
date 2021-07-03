package com.dbly;

import com.dbly.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

public class JUnitTest {
    @Test
    public void testStudent() throws IOException {
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
        SqlSession sqlSession
                = factory.openSession();
        //5.通过session对象插入数据
        Student student = new Student();
        student.setSname("阿瑟东");
        student.setSsex("女");
        student.setClassName("东北林业大学");
        sqlSession.insert("insertStudent",student);
        sqlSession.commit();
        //6.关闭session
        sqlSession.close();
    }
}
