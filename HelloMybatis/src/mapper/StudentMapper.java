package mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pojo.Student;

public interface StudentMapper {

    // 根据 id 查询学生信息
    @Select("SELECT * FROM student WHERE studentID = #{id}")
    public Student findStudentById(int id) throws Exception;

    // 添加学生信息
    @Insert("INSERT INTO student(studentID, name) VALUES(#{id}, #{name})")
    public void insertStudent(Student student) throws Exception;

    // 删除学生信息
    @Delete("DELETE FROM student WHERE studentID = #{id}")
    public void deleteStudent(int id) throws Exception;

    // 修改学生信息
    @Update("UPDATE student SET name = #{name} WHERE studentID = #{id}")
    public void updateStudent(Student student) throws Exception;
}
