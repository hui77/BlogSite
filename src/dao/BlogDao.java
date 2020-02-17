package dao;

import static dao.GlobalInfos.DBName;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import entity.Blog;
import util.DBUtils;

public class BlogDao {
	/** 查询用户博文 */
	public static List<Blog> searchBlogs(String id) throws Exception {
		Connection conn = DBUtils.getConn(DBName);
		String selectSql = "select * from Blog where AuthorId=?";
		PreparedStatement pstmt = conn.prepareStatement(selectSql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		List<Blog> blogs = new LinkedList<Blog>();
		while(rs.next()) {
			blogs.add(new Blog(rs.getString("Id"), rs.getDate("PublishDate"), rs.getString("Title"), rs.getString("Content"), rs.getInt("FavorNum")));
		}
		conn.close();
		return blogs;
	}
	
	/** 查询用热点博文 */
	public static List<Blog> searchHotBlogs() throws Exception {
		Connection conn = DBUtils.getConn(DBName);
		String selectSql = "select * from Blog order by FavorNum desc limit 0,10;";
		PreparedStatement pstmt = conn.prepareStatement(selectSql);
		ResultSet rs = pstmt.executeQuery();
		List<Blog> blogs = new LinkedList<Blog>();
		while(rs.next()) {
			blogs.add(new Blog(rs.getString("Id"), rs.getString("AuthorId"), rs.getDate("PublishDate"), rs.getString("Title"), rs.getString("Content"), rs.getInt("FavorNum")));
		}
		conn.close();
		return blogs;
	}
}
