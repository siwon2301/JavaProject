package com.book;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.naver.MemberDTO;

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
	
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		
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
		String sql = "INSERT INTO ebookList (bookName, bookCode, price, point) VALUES (?, ?, ?, ?)";
		boolean isOk = false;
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql); 
			
			pstmt.setString(1, bdto.getBookName());
			pstmt.setInt(2, bdto.getBookCode());
			pstmt.setInt(3, bdto.getPrice());
			pstmt.setInt(4, bdto.getPoint());
			
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
	
	public void update(BookDTO bdto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE ebookList SET bookName =? price =? point =? WHERE bookCode =?";
		String sql2 = "UPDATE ebookList SET bookName =? point =? FROM ebookMember WHERE id =?";
		
		// MemberDTO dto = new MemberDTO(id, name, cash, point, books);
		
		boolean isOk = false;
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bdto.getBookName());
			pstmt.setInt(2, bdto.getPrice());
			pstmt.setInt(3, bdto.getPoint());
			pstmt.setInt(4, bdto.getBookCode());
			
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
	public void delete(BookDTO bdto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM bookList borrowing =? returning =? WHERE bookCode =?";
		boolean isOk = false;
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bdto.getborrowing());
			pstmt.setString(2, bdto.getReturning());
			pstmt.setInt(3, bdto.getBookCode());
			
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
	
	public List<BookDTO> select() {
		
	
	List<BookDTO> list = new ArrayList<BookDTO>();
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	String sql = "SELECT bookName 책이름, bookCode 책코드, price 책가격, point 포인트,"
			+ " borrowing 대여목록, returning 반납목록 FROM ebookList";
	ResultSet rs = null;
	
	boolean isOk = false;
	
	try {
		conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		conn.setAutoCommit(false);
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();

		while (rs.next()) {
			String bookName = rs.getString("책이름");
			int bookCode = rs.getInt("책코드");
			int price = rs.getInt("책가격");
			int point = rs.getInt("포인트");
			String borrowing = rs.getString("대여목록");
			String returning = rs.getString("반납목록");
			
			BookDTO bdto = new BookDTO(bookName, bookCode, price, point, borrowing, returning);
			list.add(bdto);

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
	
	return list;
	}
}
