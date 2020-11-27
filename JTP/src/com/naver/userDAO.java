package com.naver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class userDAO {
	private final String DRIVER = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "ezen";
	private final String PASSWORD = "ezen";
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private String sql = null;
	private ResultSet rs = null;

	public userDAO() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void closeAll() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ining() throws Exception {
		conn = DriverManager.getConnection(URL, USER, PASSWORD);
		pstmt = conn.prepareStatement(sql);
	}

	public void insert(userDTO dto) {
		sql = "INSERT INTO userDTO VALUES (?,?,?,?)";

		try {
			ining();

			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getCash());
			pstmt.setInt(4, dto.getPoint());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
	}

	public void delete(userDTO dto) {
		sql = "DELETE FROM userDTO WHERE id = ?";

		try {
			ining();

			pstmt.setString(1, dto.getId());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
	}

	public void update(userDTO dto) {
		sql = "UPDATE userDTO SET name = ? WHERE id = ?";

		try {
			ining();

			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getId());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
	}

	public List<userDTO> select() {
		List<userDTO> list = new ArrayList<userDTO>();
		sql = "SELECT * FROM userDTO";

		try {
			ining();

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int cash = rs.getInt("cash");
				int point = rs.getInt("point");

				userDTO dto = new userDTO(id, name, cash, point);
				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return list;
	}

	public userDTO selectbyID(String ID) {
		userDTO dto = null;
		sql = "SELECT * FROM userDTO WHERE id = ";

		try {
			ining();
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int cash = rs.getInt("cash");
				int point = rs.getInt("point");

				dto = new userDTO(id, name, cash, point);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return dto;
	}

}
