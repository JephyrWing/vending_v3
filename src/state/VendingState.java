package state;

import dto.DrinkDto;
import dto.MemberDto;
import dto.SalesDto;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class VendingState {
    private final Connection conn;
    String salesInsert = "INSERT INTO sales(member_id, menu_id, price, sold_at) VALUES (?,?,?,?)";
    String memberInsert = "INSERT INTO member(user_id, name, balance, is_admin) VALUES (?,?,?,?)";
    String drinkInsert = "INSERT INTO vending_menu(name, price, stock) VALUES (?,?,?)";

    public VendingState(Connection conn) {
        this.conn = conn;
    }


    //메서드
    public PreparedStatement psmtmaker(DrinkDto dto, String sql) throws Exception {
        PreparedStatement psmt = null;
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, dto.getName());
        psmt.setInt(2, dto.getPrice());
        psmt.setInt(3, dto.getStock());

        return psmt;
    }

    public PreparedStatement psmtmaker(MemberDto dto, String sql) throws Exception {
        PreparedStatement psmt = null;
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, dto.getUserId());
        psmt.setString(2, dto.getName());
        psmt.setInt(3, dto.getBalance());
        psmt.setInt(4, dto.getIsAdmin());

        return psmt;
    }

    public PreparedStatement psmtmaker(SalesDto dto, String sql) throws Exception {
        PreparedStatement psmt = null;
        psmt = conn.prepareStatement(sql);
        psmt.setInt(1, dto.getMemberId());
        psmt.setInt(2, dto.getMenuId());
        psmt.setInt(3, dto.getPrice());
        psmt.setString(4, dto.getSoldAt());

        return psmt;
    }

    public void insertData(DrinkDto dto) {
        try {
            PreparedStatement psmt = psmtmaker(dto, drinkInsert);
            int result = psmt.executeUpdate();
            if (result == 0) {
                System.out.println(dto.getName() + "저장에 실패하였습니다.");
            } else {
                System.out.println("저장 성공");
            }
            psmt.close();
        } catch (Exception e) {
            System.out.println("INSERT 오류 : " + e.getMessage());
        };
    }

    public void insertData(MemberDto dto) {
        try {
            PreparedStatement psmt = psmtmaker(dto, memberInsert);
            int result = psmt.executeUpdate();
            if (result == 0) {
                System.out.println(dto.getName() + "저장에 실패하였습니다.");
            } else {
                System.out.println("저장 성공");
            }
            psmt.close();
        } catch (Exception e) {
            System.out.println("INSERT 오류 : " + e.getMessage());
        };
    }

    public void insertData(SalesDto dto) {
        try {
            PreparedStatement psmt = psmtmaker(dto, salesInsert);
            int result = psmt.executeUpdate();
            if (result == 0) {
                System.out.println("저장에 실패하였습니다.");
            } else {
                System.out.println("저장 성공");
            }
            psmt.close();
        } catch (Exception e) {
            System.out.println("INSERT 오류 : " + e.getMessage());
        };
    }


}
