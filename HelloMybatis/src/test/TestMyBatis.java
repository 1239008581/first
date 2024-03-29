package test;

import mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Student;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMyBatis {

    public static void main(String[] args) throws Exception {
        // 根据 mybatis-config.xml 配置的信息得到 sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 然后根据 sqlSessionFactory 得到 session
        SqlSession session = sqlSessionFactory.openSession();

        // 增加学生
//        Student student1 = new Student();
//        student1.setId(4);
//        student1.setStudentID(4);
//        student1.setName("新增加的学生");
//        session.insert("addStudent", student1);
//
//        // 删除学生
//        Student student2 = new Student();
//        student2.setId(1);
//        session.delete("deleteStudent", student2);
//
//        // 获取学生
//        Student student3 = session.selectOne("getStudent", 2);
//
//        // 修改学生
//        student3.setName("修改的学生");
//        session.update("updateStudent", student3);

//        // 最后通过 session 的 selectList() 方法调用 sql 语句 listStudent
//        List<Student> listStudent = session.selectList("listStudent");
//        for (Student student : listStudent) {
//            System.out.println("ID:" + student.getId() + ",NAME:" + student.getName());
//        }

//        //模糊查询
//        List<Student> students = session.selectList("findStudentByName", "三颗心脏");
//        for (Student student : students) {
//            System.out.println("ID:" + student.getId() + ",NAME:" + student.getName());
//        }
//
//        // 提交修改
//        session.commit();
        // 关闭 session

        //测试Mapper动态代理
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        // 执行 Mapper 代理独享的查询方法
        Student student = studentMapper.findStudentById(2);
        System.out.println("学生的姓名为：" + student.getName());
        session.close();
    }
}