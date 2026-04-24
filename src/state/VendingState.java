package state;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

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

    public int insertData(DrinkDto dto) {
        int result = 0;
        try {
            PreparedStatement psmt = psmtmaker(dto, drinkInsert);
            result = psmt.executeUpdate();
            psmt.close();
        } catch (Exception e) {
            System.out.println("INSERT 오류 : " + e.getMessage());
        };
        return result;
    }

    public int insertData(MemberDto dto) {
        int result = 0;
        try {
            PreparedStatement psmt = psmtmaker(dto, memberInsert);
            result = psmt.executeUpdate();
            psmt.close();
        } catch (Exception e) {
            System.out.println("INSERT 오류 : " + e.getMessage());
        };
        return result;
    }

    public int insertData(SalesDto dto) {
        int result = 0;
        try {
            PreparedStatement psmt = psmtmaker(dto, salesInsert);
            result = psmt.executeUpdate();
            psmt.close();
        } catch (Exception e) {
            System.out.println("INSERT 오류 : " + e.getMessage());
        };
        return result;
    }

    public List<MemberInfoDto> selectMemberInfo() {
        List<MemberInfoDto> dtoList = new ArrayList<>();
        // 쿼리 실행 도구
        PreparedStatement psmt = null;
        // 검색 결과 레코드 셋을 담을 통
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM member";
            psmt = conn.prepareStatement(sql);
            // 실행 0> 결과는 rs가 받는다
            rs = psmt.executeQuery();
            // 받은 결과를 DTO list에 차곡차곡 담는다.
            while (rs.next()) {
                MemberInfoDto dto = new MemberInfoDto();
                dto.setId(rs.getInt("id"));
                dto.setUserId(rs.getString("user_id"));
                dto.setPassword(rs.getString("password"));
                dto.setName(rs.getString("name"));
                dto.setTel(rs.getString("tel"));
                dto.setBalance(rs.getInt("balance"));
                dto.setCardNum(rs.getString("card_num"));
                dto.setIsAdmin(rs.getInt("is_admin"));
                dtoList.add(dto);
            }
            psmt.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("Find All Error : " + e.getMessage());
        }
        return dtoList;
    }
    public List<MemberDto> selectMember() {
        List<MemberDto> dtoList = new ArrayList<>();
        // 쿼리 실행 도구
        PreparedStatement psmt = null;
        // 검색 결과 레코드 셋을 담을 통
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM member";
            psmt = conn.prepareStatement(sql);
            // 실행 0> 결과는 rs가 받는다
            rs = psmt.executeQuery();
            // 받은 결과를 DTO list에 차곡차곡 담는다.
            while (rs.next()) {
                MemberDto dto = new MemberDto();
                dto.setId(rs.getInt("id"));
                dto.setUserId(rs.getString("user_id"));
                dto.setName(rs.getString("name"));
                dto.setIsAdmin(rs.getInt("is_admin"));
                dtoList.add(dto);
            }
            psmt.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("Find All Error : " + e.getMessage());
        }
        return dtoList;
    }

    public List<MemberDto> login(String user_id, String pass) {
        List<MemberInfoDto> list = selectMemberInfo();
        List<MemberDto> list2 = selectMember();
        List<MemberDto> result = new ArrayList<>();
        MemberInfoDto dto;
        MemberDto dto2;

        for (MemberInfoDto i : list) {
            if (i.getUserId() == user_id) {
                dto = i;
                if (dto.passCompare(pass)) {
                    for (MemberDto j : list2) {
                        if (i.getUserId() == user_id) {
                            dto2 = j;
                            result.add(dto2);
                            break;
                        }
                    }
                }
                break;
            }
        }
        return result;
    }
}
