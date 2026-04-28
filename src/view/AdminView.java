package view;

import service.DrinkService;
import service.MemberService;
import service.SalesService;
import state.MemberDto;
import utilities.Utilities;

import java.util.List;

public class AdminView {
    private final DrinkService drinkServ;
    private final MemberService memberServ;
    private final SalesService salesServ;
    Utilities utilities = new Utilities();

    public AdminView(DrinkService drinkServ, MemberService memberServ, SalesService salesServ) {
        this.drinkServ = drinkServ;
        this.memberServ = memberServ;
        this.salesServ = salesServ;
    }

    public void menu(int id) {
        List<MemberDto> list;
        MemberDto dto;
        int ans = 0;
        while (true) {
            list = memberServ.getById(id);
            dto = list.get(0);
            utilities.creLine();
            System.out.println(" 관리자 메뉴");
            utilities.creLine();
            System.out.println("""
                    1. 자판기 관리
                    2. 회원 관리
                    3. 판매 관리
                    4. 로그아웃
                    >
                    """);
            ans = utilities.chooseMenu(4);
            switch (ans) {
                case 1 -> menuManage();
                case 2 -> memberManage();
                case 3 -> salesManage();
                case 4 -> {
                    return;
                }
            }
        }
    }

    private void menuManage() {
        System.out.println("자판기 관리");
        System.out.println("""
                1. 메뉴 추가
                2. 메뉴 수정
                3. 메뉴 삭제
                4. 전체 조회
                """);
    }

    private void memberManage() {
        System.out.println("회원 관리");
        System.out.println("""
                1. 회원 추가
                2. 회원 수정
                3. 회원 삭제
                4. 전체 조회
                """);
    }

    private void salesManage() {
        System.out.println("판매 관리");
        System.out.println("""
                1. 제품별 판매 현황
                2. 회원별 판매 현황
                """);
    }
}
