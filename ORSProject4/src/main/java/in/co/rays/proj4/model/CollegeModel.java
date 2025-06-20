package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.proj4.bean.CollegeBean;
import in.co.rays.proj4.util.JDBCDataSource;

public class CollegeModel {
	public void add(CollegeBean bean) throws Exception {
		Connection conn = null;

		try {
			int pk = nextPk();
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO st_college VALUES(?,?,?,?,?,?,?,?,?,?)");

//			pstmt.setLong(1, bean.getId());
			pstmt.setLong(1, pk);
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getAddress());
			pstmt.setString(4, bean.getState());
			pstmt.setString(5, bean.getCity());
			pstmt.setString(6, bean.getPhoneNo());
			pstmt.setString(7, bean.getCreatedBy());
			pstmt.setString(8, bean.getModifiedBy());
			pstmt.setTimestamp(9, bean.getCreatedDatetime());
			pstmt.setTimestamp(10, bean.getModifiedDatetime());

			pstmt.executeUpdate();
			System.out.println("data inserted");
			conn.commit();

		} catch (Exception e) {
			JDBCDataSource.trnRollback(conn);
			e.printStackTrace();
		}

	}

	public void delete(long id) throws Exception {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM st_college WHERE id=?");

			pstmt.setLong(1, id);

			pstmt.executeUpdate();

			conn.commit();
			System.out.println("data deleted");
			pstmt.close();

		} catch (Exception e) {
			JDBCDataSource.trnRollback(conn);
			e.printStackTrace();
		}
	}

	public void update(CollegeBean bean) throws Exception {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"UPDATE st_college SET NAME=?,ADDRESS=?,STATE=?,CITY=?,PHONE_NO=?,MODIFIED_BY=?,MODIFIED_DATETIME=? WHERE ID=?");

			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getAddress());
			pstmt.setString(3, bean.getState());
			pstmt.setString(4, bean.getCity());
			pstmt.setString(5, bean.getPhoneNo());
			pstmt.setString(6, bean.getModifiedBy());
			pstmt.setTimestamp(7, bean.getModifiedDatetime());
			pstmt.setLong(8, bean.getId());

			pstmt.executeUpdate();
			System.out.println("updated successfully...");
			conn.commit();

		} catch (Exception e) {
			JDBCDataSource.trnRollback(conn);
			e.printStackTrace();
		}
	}

	public Integer nextPk() {
		Connection conn = null;
		int pk = 0;

		try {
			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_college");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				pk = rs.getInt(1);
			}
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return pk + 1;
	}
	public CollegeBean findByPk(long id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("Select * from st_college where id=?");

		pstmt.setLong(1, id);

		ResultSet rs = pstmt.executeQuery();

		CollegeBean bean = null;

		while (rs.next()) {
			bean = new CollegeBean();

			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setAddress(rs.getString(3));
			bean.setState(rs.getString(4));
			bean.setCity(rs.getString(5));
			bean.setPhoneNo(rs.getString(6));
			bean.setCreatedBy(rs.getString(7));
			bean.setModifiedBy(rs.getString(8));
			bean.setCreatedDatetime(rs.getTimestamp(9));
			bean.setModifiedDatetime(rs.getTimestamp(10));
		}
		rs.close();

		JDBCDataSource.closeConnection(conn);

		return bean;
	}
	public CollegeBean findByName(String name) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("Select * from st_college where name=?");

		pstmt.setString(1, name);

		ResultSet rs = pstmt.executeQuery();

		CollegeBean bean = null;

		while (rs.next()) {
			bean = new CollegeBean();

			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setAddress(rs.getString(3));
			bean.setState(rs.getString(4));
			bean.setCity(rs.getString(5));
			bean.setPhoneNo(rs.getString(6));
			bean.setCreatedBy(rs.getString(7));
			bean.setModifiedBy(rs.getString(8));
			bean.setCreatedDatetime(rs.getTimestamp(9));
			bean.setModifiedDatetime(rs.getTimestamp(10));
		}
		rs.close();
		JDBCDataSource.closeConnection(conn);

		return bean;
	}
	public List search(CollegeBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		StringBuilder sql = new StringBuilder("select * from st_college where 1 = 1");

		if (bean != null) {
			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and name like '" + bean.getName() + "%'");
			}
		}

//		if (pageSize > 0) {
//			pageNo = (pageNo - 1) * pageSize;
//			sql.append(" limit " + pageNo + ", " + pageSize);
//		}

		System.out.println("sql--->" + sql.toString());

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {
			bean = new CollegeBean();

			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setAddress(rs.getString(3));
			bean.setState(rs.getString(4));
			bean.setCity(rs.getString(5));
			bean.setPhoneNo(rs.getString(6));
			bean.setCreatedBy(rs.getString(7));
			bean.setModifiedBy(rs.getString(8));
			bean.setCreatedDatetime(rs.getTimestamp(9));
			bean.setModifiedDatetime(rs.getTimestamp(10));

			list.add(bean);
		}
		rs.close();
		JDBCDataSource.closeConnection(conn);

		return list;
	}

}