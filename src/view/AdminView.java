package view;

import service.DrinkService;
import service.MemberService;
import service.SalesService;
import state.DrinkDto;
import state.MemberDto;
import utilities.Utilities;

import java.util.List;
import java.util.Scanner;

public class AdminView {
    private final DrinkService drinkServ;
    private final MemberService memberServ;
    private final SalesService salesServ;
    Utilities utilities = new Utilities();
    Scanner sc = new Scanner(System.in);

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
        int ans = 0;
        System.out.println("""
                1. 메뉴 추가
                2. 메뉴 수정
                3. 메뉴 삭제
                4. 전체 조회
                """);
        ans = utilities.chooseMenu(4);
        switch (ans) {
            case 1 -> {
                System.out.println("메뉴 추가");
                String name;
                System.out.println("추가하실 메뉴의 이름을 입력해 주세요.");
                name = sc.next();
                int price;
                while (true) {
                    try {
                        System.out.println(name + "의 가격을 입력해 주세요.");
                        price = sc.nextInt();
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                int stock;
                while (true) {
                    try {
                        System.out.println(name + "의 재고 수량을 입력해 주세요.");
                        stock = sc.nextInt();
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                int result = drinkServ.insert(name, price, stock);
                if (result != 0) {
                    System.out.println("메뉴 추가가 완료되었습니다!");
                    System.out.println("메뉴 이름 : " + name + ", 가격 : " + price + ", 수량 : " + stock);
                }
            }
            case 2 -> {
                System.out.println("메뉴 수정");
                int id = utilities.chooseMenu(drinkServ.getIds());
                DrinkDto dto = drinkServ.getById(id);
                String name = dto.getName();
                int price = dto.getPrice();
                int stock = dto.getStock();
                System.out.println("메뉴 이름 : " + name + ", 가격 : " + price + ", 수량 : " + stock);
                System.out.println("음료를 변경하시겠습니까? (1. 예  2. 아니오)");
                int ans2 = utilities.chooseMenu(2);
                if (ans2 == 1) {
                    System.out.println("변경하실 메뉴의 이름을 입력해 주세요.");
                    name = sc.next();
                }
                System.out.println(name + "의 가격을 변경하시겠습니까? (1. 예  2. 아니오)");
                ans2 = utilities.chooseMenu(2);
                if (ans2 == 1) {
                    while (true) {
                        try {
                            System.out.println(name + "의 가격을 입력해 주세요.");
                            price = sc.nextInt();
                            break;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
                System.out.println(name + "의 재고 수량을 변경하시겠습니까? (1. 예  2. 아니오)");
                ans2 = utilities.chooseMenu(2);
                if (ans2 == 1) {
                    while (true) {
                        try {
                            System.out.println(name + "의 재고 수량을 입력해 주세요.");
                            stock = sc.nextInt();
                            break;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
                int result = drinkServ.update(id, name, price, stock);
                if (result != 0) {
                    System.out.println("메뉴 수정이 완료되었습니다!");
                    System.out.println("메뉴 이름 : " + name + ", 가격 : " + price + ", 수량 : " + stock);
                }
            }
            case 3 -> {
                System.out.println("메뉴 삭제");
                int id = utilities.chooseMenu(drinkServ.getIds());
                DrinkDto dto = drinkServ.getById(id);
                System.out.println("정말로 " + dto.getName() + " 메뉴를 삭제하시겠습니까? (1. 예  2. 아니오)");
                int ans2 = utilities.chooseMenu(2);
                if (ans2 == 1) {
                    int result = drinkServ.delete(id);
                    if (result != 0) {
                        System.out.println("삭제가 완료되었습니다.");
                    }
                }
            }
            case 4 -> {
                List<DrinkDto> list = drinkServ.getAll();
                System.out.println("ID\t| 제품명\t\t|  가격\t\t|  재고");
                System.out.println("----------------------------------");
                list.forEach(x-> {
                    if (x.getStock() == 0) {
                        System.out.println(String.format("%d\t| %-6s\t|  %-5d원\t|  %d개 (품절)", x.getId(), x.getName(), x.getPrice(), x.getStock()));
                    } else {
                        System.out.println(String.format("%d\t| %-6s\t|  %-5d원\t|  %d개", x.getId(), x.getName(), x.getPrice(), x.getStock()));
                    }
                });
            }
        }
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
