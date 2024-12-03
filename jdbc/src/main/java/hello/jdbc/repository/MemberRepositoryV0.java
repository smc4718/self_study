package hello.jdbc.repository;

import hello.jdbc.connection.DBConnectionUtil;
import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;

/**
 * JDBC - DriverManager 사용
 */
@Slf4j
public class MemberRepositoryV0 {

    public Member save(Member member) throws SQLException {
        String sql = "insert into member(member_id, money) values (?, ?)";

        Connection con = null;
        PreparedStatement pstmt = null; //PreparedStatement 는 파라미터를 바인딩 할 수 있는 것.

        con = getConnection();
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, member.getMemberId());
            pstmt.setInt(2, member.getMoney());
            pstmt.executeUpdate(); //executeUpdate();을 실행하면, 위에 pstmt로 담은 것들이 실제 DB에 실행되게 된다.
            return member;
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally {
            close(con, pstmt, null);
        }
    }

    private void close(Connection con, Statement stmt, ResultSet rs) { //statement는 sql을 그대로 넣는 것)
    //사용한 자원들은 다 닫아야 한다. 외부 리소스이기 때문에 닫아주지 않으면 연결이 계속 유지되는 문제가 발생함.
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                log.info("error", e);   //닫을 때 예외가 터지는 거면 할 수 있는 게 없어서 그냥 로그정도만 남기는 것.
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                log.info("error", e);   //닫을 때 예외가 터지는 거면 할 수 있는 게 없어서 그냥 로그정도만 남기는 것.
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                log.info("error", e);   //닫을 때 예외가 터지는 거면 할 수 있는 게 없어서 그냥 로그정도만 남기는 것.
            }
        }
    }

    private static Connection getConnection() {
        return DBConnectionUtil.getConnection();
    }


}
