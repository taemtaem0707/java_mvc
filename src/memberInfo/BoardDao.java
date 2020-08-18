package memberInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class BoardDao {
	private static BoardDao instance = new BoardDao();
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;


	//dbcp 사용
	private BoardDao() {
	}	
	public static BoardDao getInstance() {
		return instance;
	}
	private Connection getConnection() {
		Connection conn = null;
		conn = jdbcUtill.getConnection();
		return conn;
	}

	//글 한 개 가져오기
	public BoardDto getBoardOne(int idx) {
		BoardDto board = null;
		String sql = "select * from board where idx=?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,idx);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String homepage = rs.getString("homepage");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String pw = rs.getString("pw");
				int hit = rs.getInt("hit");
				int group = rs.getInt("group");
				int step = rs.getInt("step");
				int indent = rs.getInt("indent");
				String regdate = rs.getString("regdate");

				board = new BoardDto(idx, name, email, homepage, title, content, pw, hit, regdate, group, step, indent);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtill.close(rs, pstmt, conn);
		}

		return board;
	}

	//글 전부 가져오기
	public ArrayList<BoardDto> getBoardAll(int pageNum, int pageList) {
		ArrayList<BoardDto> boards = new ArrayList<BoardDto>();
		BoardDto board = null;
		String sql = "select * from board order by `group` desc, step asc limit ?,?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pageList*(pageNum-1));
			pstmt.setInt(2, pageList);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int idx = rs.getInt("idx");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String homepage = rs.getString("homepage");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String pw = rs.getString("pw");
				int hit = rs.getInt("hit");
				int group = rs.getInt("group");
				int step = rs.getInt("step");
				int indent = rs.getInt("indent");
				String regdate = rs.getString("regdate");

				board = new BoardDto(idx, name, email, homepage, title, content, pw, hit, regdate, group, step, indent);
				boards.add(board);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtill.close(rs, pstmt, conn);
		}

		return boards;
	}

	//name값에 해당하는 글 전부 가져오기
	public ArrayList<BoardDto> getBoardNameAll(String searchName, int pageNum, int pageList) {
		ArrayList<BoardDto> boards = new ArrayList<BoardDto>();
		BoardDto board = null;
		String sql = "select * from board where name like ? order by `group` desc, step asc limit ?,?";
		System.out.println(sql);
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchName+"%");
			pstmt.setInt(2, pageList*(pageNum-1));
			pstmt.setInt(3, pageList);

			rs = pstmt.executeQuery();
			while(rs.next()) {
				int idx = rs.getInt("idx");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String homepage = rs.getString("homepage");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String pw = rs.getString("pw");
				int hit = rs.getInt("hit");
				int group = rs.getInt("group");
				int step = rs.getInt("step");
				int indent = rs.getInt("indent");
				String regdate = rs.getString("regdate");

				board = new BoardDto(idx, name, email, homepage, title, content, pw, hit, regdate, group, step, indent);
				boards.add(board);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtill.close(rs, pstmt, conn);
		}

		return boards;
	}

	//content값에 해당되는 글 모두 가져오기
	public ArrayList<BoardDto> getBoardContentAll(String searchContent, int pageNum, int pageList) {
		ArrayList<BoardDto> boards = new ArrayList<BoardDto>();
		BoardDto board = null;
		String sql = "select * from board where content like ? order by `group` desc, step asc limit ?,?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchContent+"%");
			pstmt.setInt(2, pageList*(pageNum-1));
			pstmt.setInt(3, pageList);

			rs = pstmt.executeQuery();
			while(rs.next()) {
				int idx = rs.getInt("idx");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String homepage = rs.getString("homepage");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String pw = rs.getString("pw");
				int hit = rs.getInt("hit");
				int group = rs.getInt("group");
				int step = rs.getInt("step");
				int indent = rs.getInt("indent");
				String regdate = rs.getString("regdate");

				board = new BoardDto(idx, name, email, homepage, title, content, pw, hit, regdate, group, step, indent);
				boards.add(board);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtill.close(rs, pstmt, conn);
		}

		return boards;
	}

	//title값에 해당되는 글 모두 가져오기
	public ArrayList<BoardDto> getBoardTitleAll(String searchTitle, int pageNum, int pageList) {
		ArrayList<BoardDto> boards = new ArrayList<BoardDto>();
		BoardDto board = null;
		String sql = "select * from board where title like ? order by `group` desc, step asc limit ?,?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchTitle+"%");
			pstmt.setInt(2, pageList*(pageNum-1));
			pstmt.setInt(3, pageList);

			rs = pstmt.executeQuery();
			while(rs.next()) {
				int idx = rs.getInt("idx");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String homepage = rs.getString("homepage");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String pw = rs.getString("pw");
				int hit = rs.getInt("hit");
				int group = rs.getInt("group");
				int step = rs.getInt("step");
				int indent = rs.getInt("indent");
				String regdate = rs.getString("regdate");

				board = new BoardDto(idx, name, email, homepage, title, content, pw, hit, regdate, group, step, indent);
				boards.add(board);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtill.close(rs, pstmt, conn);
		}

		return boards;
	}

	//글 작성
	public int write(BoardDto dto) {		
		System.out.println(dto.toString());
		int ri = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		//idx 값 가져오기
		int idx = getIdx();

		String sql = "INSERT INTO board (idx, name, email, homepage, title, content, pw, `group`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getHomepage());
			pstmt.setString(5, dto.getTitle());
			pstmt.setString(6, dto.getContent());
			pstmt.setString(7, dto.getPw());
			pstmt.setInt(8, idx);
			ri = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtill.close(pstmt, conn);
		}
		return ri;

	}

	//작성한 글 비밀번호 확인
	public int writeCheck(int idx, String pw) {
		int ri = -1; //성공1 없으면-1 틀리면0
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;	
		String sql ="select pw from board where idx=?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
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

	//조회수 증가
	public void setBoardHit(int idx) {
		String sql = "update board set hit = hit + 1 where idx=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,idx);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtill.close(pstmt, conn);
		}
	}

	//글 수정
	public int update(BoardDto boardDto, int idx) {		
		int ri = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "update board set name=?, email=?, homepage=?, title=?, content=? where idx=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDto.getName());
			pstmt.setString(2, boardDto.getEmail());
			pstmt.setString(3, boardDto.getHomepage());
			pstmt.setString(4, boardDto.getTitle());
			pstmt.setString(5, boardDto.getContent());
			pstmt.setInt(6, idx);
			ri = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtill.close(pstmt, conn);
		}
		return ri;

	}

	//글 삭제
	public int delete(int idx) {		
		int ri = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "delete from board where idx=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			ri = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtill.close(pstmt, conn);
		}
		return ri;

	}

	//글 답변 작성
	public int reply(BoardDto dto) {		
		int ri = 0;

		//답변 전 reply 리스트 변경
		setReply(dto.getGroup(), dto.getStep());

		Connection conn = null;
		PreparedStatement pstmt = null;
		int idx = getIdx();
		String sql = "INSERT INTO board (idx, name, email, homepage, title, content, pw, `group`, step, indent) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getHomepage());
			pstmt.setString(5, dto.getTitle());
			pstmt.setString(6, dto.getContent());
			pstmt.setString(7, dto.getPw());
			pstmt.setInt(8, dto.getGroup());
			pstmt.setInt(9, dto.getStep()+1);
			pstmt.setInt(10, dto.getIndent()+1);
			ri = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtill.close(pstmt, conn);
		}
		return ri;

	}

	//답변 전 reply 리스트 변경
	public int setReply(int group, int step) {		
		int ri = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "update board set step = step + 1 where `group` = ? and step > ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, group);
			pstmt.setInt(2, step);
			ri = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtill.close(pstmt, conn);
		}
		return ri;

	}

	//idx값 가져오기
	public int getIdx() {
		int idx = 0 ;
		String sql = "select max(idx)+1 as idx from board";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				idx = rs.getInt("idx");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtill.close(rs, pstmt, conn);
		}

		return idx;
	}

	//전체 게시물 값 가져오기
	public int getCount() {
		int count = 0 ;
		String sql = "select count(idx) as count from board";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				count = rs.getInt("count");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtill.close(rs, pstmt, conn);
		}

		return count;
	}

	// 검색 페이지 전체 게시물 값 가져오기
	public int getSearchCount(String option, String word) {
		int count = 0 ;
		String sql = "select count(idx) as count from board where "+option+" like ?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+word+"%");
			rs = pstmt.executeQuery();

			if(rs.next()) {
				count = rs.getInt("count");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtill.close(rs, pstmt, conn);
		}

		return count;
	}

//	// 파일추가 글목록 전체 가저오기
//		public ArrayList<BoardFileDto> getBoardFileAll(int pageNum, int pageList) {
//			ArrayList<BoardFileDto> boards = new ArrayList<BoardFileDto>();
//			BoardFileDto board = null;
//
//			String sql = " select * from board order by `group` desc, step asc ";
//			sql += " limit ?,? ";
//
//			try {
//				conn = getConnection();
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setInt(1,pageList*(pageNum-1) );
//				pstmt.setInt(2, pageList);
//				rs = pstmt.executeQuery();
//				while(rs.next()) {
//					int idx = rs.getInt("idx");
//					String name = rs.getString("name");
//					String email = rs.getString("email");
//					String homepage = rs.getString("homepage");
//					String title = rs.getString("title");
//					String content = rs.getString("content");
//					String pw = rs.getString("pw");
//					int hit = rs.getInt("hit");
//					int group = rs.getInt("group");
//					int step = rs.getInt("step");
//					int indent = rs.getInt("indent");
//					String regdate = rs.getString("regdate");
//					String filename = rs.getString("filename");
//
//					board = new BoardFileDto(idx, name, email, homepage, title, content, pw, hit, regdate, group, step, indent, filename);
//					boards.add(board);
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} finally {
//				jdbcUtill.close(rs, pstmt, conn);
//			}
//			return boards;
//		}
		
	
}
