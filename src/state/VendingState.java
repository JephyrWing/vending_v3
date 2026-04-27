package state;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class VendingState {
    private final Connection conn;
    String drinkInsert = "INSERT INTO vending_menu(name, price, stock) VALUES (?,?,?)";
    String memberInsert = "INSERT INTO member(user_id, name, balance, is_admin) VALUES (?,?,?,?)";
    String memberinfoInsert = "INSERT INTO member(user_id, password, name, tel, balance, card_num, is_admin) VALUES (?,?,?,?,?,?,?)";
    String salesInsert = "INSERT INTO sales(member_id, menu_id, price, sold_at) VALUES (?,?,?,?)";

    String drinkUpdate = "UPDATE vending_menu SET name = ?, price = ?, stock = ? WHERE id = ?";
    String memberUpdate = "UPDATE member SET user_id = ?, name = ?, balance = ?, is_admin = ? WHERE id = ?";
    String memberInfoUpdate = "UPDATE member SET user_id = ?, password = ?, name = ?, tel = ?, balance = ?, card_num = ?, is_admin = ? WHERE id = ?";
    String salesUpdate = "UPDATE sales SET member_id = ?, menu_id = ?, price = ?, sold_at = ? WHERE id = ?";

    public VendingState(Connection conn) {
        this.conn = conn;
    }


    //메서드
    public int insertData(DrinkDto dto) {
        int result = 0;
        try {
            PreparedStatement psmt = null;
            psmt = conn.prepareStatement(drinkInsert);
            psmt.setString(1, dto.getName());
            psmt.setInt(2, dto.getPrice());
            psmt.setInt(3, dto.getStock());
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
            PreparedStatement psmt = null;
            psmt = conn.prepareStatement(memberInsert);
            psmt.setString(1, dto.getUserId());
            psmt.setString(2, dto.getName());
            psmt.setInt(3, dto.getBalance());
            psmt.setInt(4, dto.getIsAdmin());
            result = psmt.executeUpdate();
            psmt.close();
        } catch (Exception e) {
            System.out.println("INSERT 오류 : " + e.getMessage());
        };
        return result;
    }
    public int insertData(MemberInfoDto dto) {
        int result = 0;
        try {
            PreparedStatement psmt = null;
            psmt = conn.prepareStatement(memberinfoInsert);
            psmt.setString(1, dto.getUserId());
            psmt.setString(2, dto.getPassword());
            psmt.setString(3, dto.getName());
            psmt.setString(4, dto.getTel());
            psmt.setInt(5, dto.getBalance());
            psmt.setString(6, dto.getCard_num());
            psmt.setInt(7, dto.getIsAdmin());
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
            PreparedStatement psmt = null;
            psmt = conn.prepareStatement(salesInsert);
            psmt.setInt(1, dto.getMemberId());
            psmt.setInt(2, dto.getMenuId());
            psmt.setInt(3, dto.getPrice());
            psmt.setString(4, dto.getSoldAt());
            result = psmt.executeUpdate();
            psmt.close();
        } catch (Exception e) {
            System.out.println("INSERT 오류 : " + e.getMessage());
        };
        return result;
    }

    public List<DrinkDto> selectVendingMenu() {
        List<DrinkDto> dtoList = new ArrayList<>();
        // 쿼리 실행 도구
        PreparedStatement psmt = null;
        // 검색 결과 레코드 셋을 담을 통
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM vending_menu";
            psmt = conn.prepareStatement(sql);
            // 실행 0> 결과는 rs가 받는다
            rs = psmt.executeQuery();
            // 받은 결과를 DTO list에 차곡차곡 담는다.
            while (rs.next()) {
                DrinkDto dto = new DrinkDto();
                dto.setId(rs.getInt("id"));
                dto.setName(rs.getString("name"));
                dto.setPrice(rs.getInt("price"));
                dto.setStock(rs.getInt("stock"));
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
                dto.setBalance(rs.getInt("balance"));
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
    public List<SalesDto> selectSales() {
        List<SalesDto> dtoList = new ArrayList<>();
        // 쿼리 실행 도구
        PreparedStatement psmt = null;
        // 검색 결과 레코드 셋을 담을 통
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM sales";
            psmt = conn.prepareStatement(sql);
            // 실행 0> 결과는 rs가 받는다
            rs = psmt.executeQuery();
            // 받은 결과를 DTO list에 차곡차곡 담는다.
            while (rs.next()) {
                SalesDto dto = new SalesDto();
                dto.setId(rs.getInt("id"));
                dto.setMember_id(rs.getInt("member_id"));
                dto.setMenu_id(rs.getInt("menu_id"));
                dto.setPrice(rs.getInt("price"));
                dto.setSold_at(rs.getString("sold_at"));
                dtoList.add(dto);
            }
            psmt.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("Find All Error : " + e.getMessage());
        }
        return dtoList;
    }

    public int updateData(DrinkDto dto) {
        int result = 0;
        try {
            PreparedStatement psmt = null;
            psmt = conn.prepareStatement(drinkUpdate);
            psmt.setString(1, dto.getName());
            psmt.setInt(2, dto.getPrice());
            psmt.setInt(3, dto.getStock());
            psmt.setInt(4, dto.getId());

            result = psmt.executeUpdate();
            psmt.close();
        } catch (Exception e) {
            System.out.println("UPDATE 오류 : " + e.getMessage());
        };
        return result;
    }
    public int updateData(MemberDto dto) {
        int result = 0;
        try {
            PreparedStatement psmt = null;
            psmt = conn.prepareStatement(memberUpdate);
            psmt.setString(1, dto.getUserId());
            psmt.setString(2, dto.getName());
            psmt.setInt(3, dto.getBalance());
            psmt.setInt(4, dto.getIsAdmin());
            psmt.setInt(5, dto.getId());
            result = psmt.executeUpdate();
            psmt.close();
        } catch (Exception e) {
            System.out.println("UPDATE 오류 : " + e.getMessage());
        };
        return result;
    }

    public List<MemberDto> login(String user_id, String pass) {
        List<MemberInfoDto> list = selectMemberInfo();
        List<MemberDto> list2 = selectMember();
        List<MemberDto> result = new ArrayList<>();
        MemberDto dto;

        for (MemberInfoDto i : list) {
            if (i.getUserId().equals(user_id)) {
                if (i.getPassword().equals(pass)) {
                    for (MemberDto j : list2) {
                        if (j.getUserId().equals(user_id)) {
                            dto = j;
                            result.add(dto);
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
