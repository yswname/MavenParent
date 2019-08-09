package cn.com.idea.demo.maven.dao.impl;

import cn.com.idea.demo.maven.dao.IUserDAO;
import cn.com.idea.demo.maven.db.DBConnection;
import cn.com.idea.demo.maven.entity.UserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements IUserDAO {
    @Override
    public void saveUser(UserEntity user) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        DBConnection dbConn = DBConnection.getInstance();
        try{
            String sql = "insert into dm_user (ur_user_name,ur_name,ur_age) values(?,?,?)";
            conn = dbConn.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,user.getUrUserName());
            pstmt.setString(2,user.getUrName());
            pstmt.setInt(3,user.getUrAge());

            pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbConn.close(conn,pstmt,rs);
        }
    }

    @Override
    public UserEntity findById(int urId) {
        UserEntity user = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        DBConnection dbConn = DBConnection.getInstance();
        try{
            String sql = "select * from dm_user where ur_id=?";
            conn = dbConn.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,urId);

            rs = pstmt.executeQuery();
            if(rs.next()){
                user = new UserEntity();
                user.setUrAge(rs.getInt("ur_age"));
                user.setUrId(rs.getInt("ur_id"));
                user.setUrName(rs.getString("ur_name"));
                user.setUrUserName(rs.getString("ur_user_name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbConn.close(conn,pstmt,rs);
        }
        return user;
    }

    @Override
    public List<UserEntity> findAll() {
        List<UserEntity> userList = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        DBConnection dbConn = DBConnection.getInstance();
        try{
            String sql = "select * from dm_user";
            conn = dbConn.getConnection();
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
            userList = new ArrayList<UserEntity>();
            UserEntity user = null;
            while(rs.next()){
                user = new UserEntity();
                user.setUrAge(rs.getInt("ur_age"));
                user.setUrId(rs.getInt("ur_id"));
                user.setUrName(rs.getString("ur_name"));
                user.setUrUserName(rs.getString("ur_user_name"));
                userList.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbConn.close(conn,pstmt,rs);
        }
        return userList;
    }
}
