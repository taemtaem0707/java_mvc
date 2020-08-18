package memberInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ScheduledFuture;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.sun.istack.internal.Pool;

public class memberInfoDao {
	private static memberInfoDao instance = new memberInfoDao();
	private static String memberInfoSelect = "select * from bigdatamember order by regdate desc";
	private static String confirmId = "select count(id) as cnt from bigdatamember where id = ?";
	private static String memberInfoInsert = "insert into bigdatamember(id, pw, name, n_name, email) values(?,?,?,?,?)"; // 수정 시 입력 값을 바꿀 위치
	private static String userCheck = "select pw from bigdatamember where id=?"; // 로그인 시 아이디, 비밀번호 확인
	private static String memberInfoModify = "update bigdatamember set pw=?, name=?, n_name=?, email=? where id=?";
	private static String getMemberInfo = "select * from bigdatamember where id=?";
	private static String memberInfoDelete = "delete from bigdatamember where id=?";
	private static String getMemberList = "select * from bigdatamember order by regdate desc";
	
	private memberInfoDao() {
	}
	
	public static memberInfoDao getInstance() {
		return instance;
	}
	
	private Connection getConnection() {
		Connection conn = null;
		conn = jdbcUtill.getConnection();
		return conn;
	}
	
	public ArrayList<memberInfoDto> memberInfoSelect() {
		ArrayList<memberInfoDto> dtos = new ArrayList<memberInfoDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(memberInfoSelect);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");  // 수정 시 입력 값을 바꿀 위치
				String pw = rs.getString("pw");  // 수정 시 입력 값을 바꿀 위치
				String name = rs.getString("name");  // 수정 시 입력 값을 바꿀 위치
				String n_name = rs.getString("n_name");  // 수정 시 입력 값을 바꿀 위치
				String email = rs.getString("email");  // 수정 시 입력 값을 바꿀 위치
				String regdate = rs.getString("regdate");  // 수정 시 입력 값을 바꿀 위치
				
				memberInfoDto member = new memberInfoDto(id, pw, name, n_name, email, regdate);  // 수정 시 입력 값을 바꿀 위치
				dtos.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtill.close(rs, pstmt, conn);
		}

		return dtos;
	}
	
	public int confirmId(String id) {
		int ri = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(confirmId);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				ri = rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtill.close(rs, pstmt, conn);
		}

		return ri;
	}
	
	public int memberInfoInsert(memberInfoDto dto) {
		int ri = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(memberInfoInsert);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getN_name());
			pstmt.setString(5, dto.getEmail());
			ri = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtill.close(pstmt, conn);
		}
		return ri;
	}

	public int userCheck(String id, String pw) {
		int ri = -1; //성공1 없으면-1 틀리면0
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;	
		
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(userCheck);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String dbPw = rs.getString("pw");
				if(pw.equals(dbPw)) {
					ri = 1;
				}else {
					ri = 0;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtill.close(rs, pstmt, conn);
		}

		return ri;
	}
	
	public int memberInfoModify(memberInfoDto dto) {
		int ri = 0;
	
		Connection conn = null;
		PreparedStatement pstmt = null;
	
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(memberInfoModify);
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getN_name());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getId());
			ri = pstmt.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtill.close(pstmt, conn);
		}
		return ri;
	}

	public memberInfoDto getMemberInfo(String id) {
		memberInfoDto dto = null;
		// 워크벤치를 뛰움
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//워크벤치 접속
			conn = getConnection();
			//워크벤치 쿼리창
			pstmt = conn.prepareStatement(getMemberInfo);
			pstmt.setString(1, id);
			//실행
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String n_name = rs.getString("n_name");
				String email = rs.getString("email");
				String regdate = rs.getString("regdate");
				dto = new memberInfoDto(id, pw, name, n_name, email, regdate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtill.close(rs, pstmt, conn);
		}

		return dto;
	}

	public int memberInfoDelete(String id) {
		int ri = 0;
	
		Connection conn = null;
		PreparedStatement pstmt = null;
	
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(memberInfoDelete);
			pstmt.setString(1, id);
			ri = pstmt.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtill.close(pstmt, conn);
		}
		return ri;
	}

	public ArrayList<memberInfoDto> getMemberList() {
		ArrayList<memberInfoDto> members = new ArrayList<memberInfoDto>();
		memberInfoDto member = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection(); // 연결
			pstmt = conn.prepareStatement(getMemberList); // 쿼리문입력
			rs = pstmt.executeQuery(); // 쿼리실행. rs.getString or getInt를 통해 꺼내올 수 있음
			
			while(rs.next()) {
				String id = rs.getString("id"); // rs에서 값을 꺼내는 과정
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String n_name = rs.getString("n_name");
				String email = rs.getString("email");
				String regdate = rs.getString("regdate");
			
				member = new memberInfoDto(id, pw, name, n_name, email, regdate); //회원 한 명 생성
				members.add(member); // members에 위에서 생성한 멤버를 모두 추가
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtill.close(rs, pstmt, conn);
		}
		
		return members;
	}
	
}

