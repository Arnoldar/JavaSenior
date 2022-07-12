package pri.arnold.preparedstatement;

import jdk.nashorn.internal.scripts.JD;
import org.junit.Test;
import pri.arnold.bean.Student;
import pri.arnold.utils.JDBCUtils;
import pri.arnold.utils.JDBCUtils1;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

/**
 * @Author: Arnold
 * @Date: 2022/7/6 13:50
 */
public class testForStudent {


    @Test
    public void test3(){
        Scanner scann = new Scanner(System.in);
        System.out.println("请选择您要输入的类型：\na:准考证号\nb:身份证号");
        String type = scann.next();
        switch (type){
            case "a":
                System.out.println("请输入准考证号：");
                String examCard = scann.next();
                examSearch(examCard);
                break;
            case "b":
                System.out.println("请输入身份证号：");
                String idCard = scann.next();
                idSearch(idCard);
                break;
            default:
                System.out.println("输入有误！");
                break;
        }
    }



    public void idSearch(Object ... obj){
        String sql = "select FlowID flowID,Type type,IDCard idCard,ExamCard examCard,StudentName studentName," +
                "Location location,Grade grade from examstudent where IDCard = ?";
        Student student = queryForAll(Student.class, sql, obj);
        if (student != null){
            getDetailInfo(student);
        }else {
            System.out.println("查无此人！请重新进入程序");
        }
    }

    public void examSearch(Object ... obj){
        String sql = "select FlowID flowID,Type type,IDCard idCard,ExamCard examCard,StudentName studentName," +
                "Location location,Grade grade from examstudent where ExamCard = ?";
        Student student = queryForAll(Student.class, sql, obj);
        if (student != null){
            getDetailInfo(student);
        }else {
            System.out.println("查无此人！请重新进入程序");
        }
    }

    public void getDetailInfo(Student student){
        System.out.println("====查询结果====");
        System.out.println("流水号：" + student.getFlowID());
        System.out.println("四级/六级：" + student.getType());
        System.out.println("身份证号：" + student.getIdCard());
        System.out.println("准考证号：" + student.getExamCard());
        System.out.println("学生姓名：" + student.getStudentName());
        System.out.println("区域：" + student.getLocation());
        System.out.println("成绩：" + student.getGrade());
    }



    public <T> T queryForAll(Class<T> clazz,String sql,Object ... obj){

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils1.getConnection();

            ps = conn.prepareStatement(sql);

            for (int i = 0;i < obj.length;i++){
                ps.setObject(i + 1,obj[i]);
            }

            rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            if (rs.next()){
                T t = clazz.newInstance();
                for (int i = 0;i < columnCount;i++){
                    Object object = rs.getObject(i + 1);
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t,object);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils1.closeResource(conn,ps,rs);
        }
        return null;
    }







    @Test
    public void test(){
        Scanner scann = new Scanner(System.in);
        System.out.println("请输入考生的详细信息");
        System.out.println("Type:");
        int type = scann.nextInt();
        System.out.println("IDCard:");
        String idCard = scann.next();
        System.out.println("ExamCard:");
        String examCard = scann.next();
        System.out.println("StudentName:");
        String studentName = scann.next();
        System.out.println("Location:");
        String location = scann.next();
        System.out.println("Grade:");
        int grade = scann.nextInt();
        insertStudent(type,idCard,examCard,studentName,location,grade);
    }

    @Test
    public void test2(){
        Scanner scann = new Scanner(System.in);
        System.out.println("请输入学生的考号:");
        String examCard = scann.next();
        deleteStudent(examCard);
    }

    public void insertStudent(Object ... obj){
        String sql = "insert into examstudent(Type,IDCard,ExamCard,StudentName,Location,Grade) values(?,?,?,?,?,?)";
        int update = update(sql, obj);
        if (update > 0){
            System.out.println("信息录入成功！");
        }else {
            System.out.println("信息录入失败！");
        }
    }

    public void deleteStudent(Object ... obj){
        String sql = "delete from examstudent where ExamCard=?";
        int update = update(sql, obj);
        if (update > 0){
            System.out.println("删除成功！");
        }else {
            System.out.println("查无此人，请重新输入！");
        }
    }

    public int update(String sql,Object ... obj) {

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();

            ps = conn.prepareStatement(sql);

            for (int i = 0;i < obj.length;i++){
                ps.setObject(i + 1,obj[i]);
            }
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps);
        }
        return 0;
    }
}
