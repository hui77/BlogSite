package dao;

import static dao.GlobalInfos.DBName;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import util.DBUtils;

public class RelationDao {
	/** 查询关注数量 */
	public static int getAttentionNum(String id) throws Exception {
		Connection conn = DBUtils.getConn(DBName);
		String selectSql = "select count(*) c from Relation where NoticerId=?";
		PreparedStatement pstmt = conn.prepareStatement(selectSql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		int count = rs.getInt("c");
		conn.close();
		return count;
	}
	/** 查询关注的用户id列表 */
	public static List<String> getAttentionIdList(String id) throws Exception {
		Connection conn = DBUtils.getConn(DBName);
		String selectSql = "select NoticedId from Relation where NoticerId=?";
		PreparedStatement pstmt = conn.prepareStatement(selectSql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		List<String> idList = new LinkedList<String>();
		while(rs.next()) {
			idList.add(rs.getString("NoticedId"));
		}
		conn.close();
		return idList;
	}
}
