package pri.arnold1.dao;

import org.apache.commons.dbutils.DbUtils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Arnold
 * @Date: 2022/7/9 11:13
 */
public abstract class BaseDAO {

    public int update(Connection conn,String sql,Object ... obj) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0;i < obj.length;i++){
                ps.setObject(i + 1,obj[i]);
            }
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(ps);
        }
        return 0;
    }

    public <T> T getInstance(Connection conn,Class<T> clazz,String sql,Object ... obj) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0;i < obj.length;i++){
                ps.setObject(i + 1,obj[i]);
            }
            ResultSet rs = ps.executeQuery();
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
            DbUtils.closeQuietly(ps);
        }
        return null;
    }

    public <T> List<T> getListFor(Connection conn,Class<T> clazz,String sql,Object ... args) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0;i < args.length;i++){
                ps.setObject(i + 1,args[i]);
            }
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            ArrayList<T> ts = new ArrayList<>();
            while (rs.next()){
                T t = clazz.newInstance();
                for (int i = 0;i < columnCount;i++){
                    Object object = rs.getObject(i + 1);
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.set(t,object);
                }
                ts.add(t);
            }
            return ts;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(ps);
        }
        return null;
    }

    public <E> E  getValue(Connection conn,String sql,Object ... args) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0;i < args.length;i++){
                ps.setObject(i + 1,args[i]);
            }
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return (E) rs.getObject(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(ps);
        }
        return null;
    }
}
