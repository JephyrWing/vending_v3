package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private static Connection dbConn;

    // DB 연결
    public static Connection getConnection() {
        if (dbConn == null) {
            try {
                String dbDriver = "com.mysql.cj.jdbc.Driver";
                String dbUrl = "jdbc:mysql://localhost:3306/vending_v3";
                String dbUser = "root";
                String dbPassword = "1111";
                // 드라이버 클래스를 메모리로 가져온다.
                Class.forName(dbDriver);
                //연결 생성
                dbConn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
                System.out.println("DB 연결 성공");
            } catch (ClassNotFoundException e) {
                System.out.println("드라이버가 없음");
                e.printStackTrace(); //DB에서 가져온 오류 출력
            } catch (SQLException e) {
                System.out.println("DB 연결 실패");
                e.printStackTrace();
            }
        }
        return dbConn;
    }

    // DB 종료 시 처리
    public static void closeConnection() {
        if (dbConn != null) {
            try {
                if (!dbConn.isClosed()) {
                    dbConn.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            dbConn = null;
        }
    }
}
