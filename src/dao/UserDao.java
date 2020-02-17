package dao;

import static dao.GlobalInfos.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import entity.User;
import util.DBUtils;

public class UserDao {
	/** 用户注册 */
	public static int registerUser(User u) throws Exception {
		Connection conn = DBUtils.getConn(DBName);
		String insertSql = "insert into User (Id, Password, Nickname) values(?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(insertSql);
		pstmt.setString(1, u.getId());
		pstmt.setString(2, u.getPassword());
		pstmt.setString(3, u.getNickname());
		int count = pstmt.executeUpdate();
		conn.close();
		return count;
	}
	
	/** 查询是否存在Id */
	public static boolean findId(String id) throws Exception {
		Connection conn = DBUtils.getConn(DBName);
		String selectSql = "select * from User where Id=?";
		PreparedStatement pstmt = conn.prepareStatement(selectSql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		boolean flag = rs.next();
		conn.close();
		return flag;
	}
	
	/** 验证密码 */
	public static boolean verifyPassword(User u) throws Exception {
		Connection conn = DBUtils.getConn(DBName);
		String selectSql = "select * from User where Id=? and Password=?";
		PreparedStatement pstmt = conn.prepareStatement(selectSql);
		pstmt.setString(1, u.getId());
		pstmt.setString(2, u.getPassword());
		ResultSet rs = pstmt.executeQuery();
		boolean flag = rs.next();
		conn.close();
		return flag;
	}
	
	/** 修改密码 */
	public static int updatePassword(User u) throws Exception {
		Connection conn = DBUtils.getConn(DBName);
		String updateSql = "update User set Password=? where Id=?";
		PreparedStatement pstmt = conn.prepareStatement(updateSql);
		pstmt.setString(1, u.getPassword());
		pstmt.setString(2, u.getId());
		int count = pstmt.executeUpdate();
		conn.close();
		return count;
	}
	
	/** 修改个人信息 */
	public static int updateInfos(User u) throws Exception {
		Connection conn = DBUtils.getConn(DBName);
		String updateSql = "update User set Nickname=?,Gender=?,Profession=?,Email=?,Introduction=? where Id=?";
		PreparedStatement pstmt = conn.prepareStatement(updateSql);
		pstmt.setString(1, u.getNickname());
		pstmt.setString(2, u.getGender());
		pstmt.setString(3, u.getProfession());
		pstmt.setString(4, u.getEmail());
		pstmt.setString(5, u.getIntroduction());
		pstmt.setString(6, u.getId());
		int count = pstmt.executeUpdate();
		conn.close();
		return count;
	}
	
	/** 查询个人信息 */
	public static User getInfos(String id) throws Exception {
		Connection conn = DBUtils.getConn(DBName);
		String selectSql = "select * from User where Id=?";
		PreparedStatement pstmt = conn.prepareStatement(selectSql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		User u = null;
		if(rs.next()) {
			u = new User(id, rs.getString("Nickname"), rs.getString("Gender"), rs.getString("Profession"), rs.getString("Email"), rs.getString("Introduction"));
		}
		conn.close();
		return u;
	}
	
	/** 根据昵称模糊查询匹配的用户 */
	public static List<User> searchUsersByNicknameVaguely(String key) throws Exception {
		Connection conn = DBUtils.getConn(DBName);
		String selectSql = "select * from User where Nickname like %?%";
		PreparedStatement pstmt = conn.prepareStatement(selectSql);
		pstmt.setString(1, key);
		ResultSet rs = pstmt.executeQuery();
		List<User> userList = new LinkedList<User>();
		while(rs.next()) {
			userList.add(new User(rs.getString("Id"), rs.getString("Nickname"), rs.getString("Gender"), rs.getString("Profession"), rs.getString("Email"), rs.getString("Introduction")));
		}
		conn.close();
		return userList;
	}
}
