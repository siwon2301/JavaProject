package kr.co.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class BookDAO {
	private final String DRIVER = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER_NAME = "ezen";
	private final String PASSWORD = "ezen";

	public BookDAO() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Ebook 작동 오류");
			e.printStackTrace();
		}
	}

	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		
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
	
	public void insert(BookDTO bdto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO ebook (bCode, bName, bGenre, bPrice, bPoint)"
				+ "VALUES (?, ?, ?, ?, ?)";
		boolean isOk = false;
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bdto.getBcode());
			pstmt.setString(2, bdto.getbName());
			pstmt.setString(3, bdto.getbGenre());
			pstmt.setInt(4, bdto.getbPrice());
			pstmt.setInt(5, bdto.getbPoint());
			
			pstmt.executeUpdate();
			
			isOk = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public List<BookDTO> select() {
		
	List<BookDTO> list2 = new ArrayList<BookDTO>();
	Connection conn = null;
	PreparedStatement pstmt = null;
	String sql = "SELECT * from ebook";
	ResultSet rs = null;
	
	boolean isOk = false;
	
	try {
		conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		conn.setAutoCommit(false);
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();

		while (rs.next()) {
			int bCode = rs.getInt("책코드");
			String bName = rs.getString("책코드");
			String bGenre = rs.getString("장르");
			int bprice = rs.getInt("가격");
			int bpoint = rs.getInt("적립금");
			boolean bAvailable = rs.getBoolean("대여여부");
			
			ArrayList<BookDTO> booklist = null;
			BookDTO bdto = new BookDTO(bCode, bName, bGenre, bprice, bpoint, bAvailable, booklist);
			list2.add(bdto);

			isOk = true;
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if (isOk) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		closeAll(rs, pstmt, conn);
	}
	
	return list2;
}
	public void update (BookDTO bdto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE ebook SET bName =? bGenre =? bprice =? bpoint =? bVailable =? WHERE bCode =?";
		
		boolean isOk = false;
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bdto.getbName());
			pstmt.setString(2, bdto.getbGenre());
			pstmt.setInt(3, bdto.getbPrice());
			pstmt.setInt(4, bdto.getbPoint());
			pstmt.setBoolean(5, bdto.getbAvailable());
			pstmt.setInt(6, bdto.getBcode());
			
			pstmt.executeUpdate();
			isOk = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (isOk) {
					conn.commit();
				} else {
					conn.rollback();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			closeAll(null, pstmt, conn);
		}
	}
	public void delete (BookDTO bdto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM ebook WHERE bCode =?";
		boolean isOk = false;
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bdto.getBcode());
			
			pstmt.executeUpdate();
			isOk = true;
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (isOk) {
					conn.commit();
				} else {
					conn.rollback();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			closeAll(null, pstmt, conn);
		}		
	}

	public BookDTO selectBybCode(int bCode) {
		
		BookDTO bdto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ArrayList<BookDTO> booklist = null;
		String sql = "SELECT bName 책이름, bGenre 장르, bprice 가격, bpoint 적립금 bAvailable 대여/반납 여부 WHERE bCode = ?";
		
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", USER_NAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bCode);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String bName = rs.getString("책이름");
				String bGenre = rs.getString("장르");
				int bprice = rs.getInt("가격");
				int bpritce = rs.getInt("적립금");
				boolean bAvailable = rs.getBoolean("대여/반납 여부");
				bdto = new BookDTO(bCode, bName, bGenre, bprice, bprice, bAvailable, booklist);
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs != null) {
					rs.close();
				} if (pstmt != null) {
					pstmt.close();
				} if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return bdto;
	}
}
