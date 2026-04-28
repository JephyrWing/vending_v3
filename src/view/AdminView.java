package view;

import service.DrinkService;
import service.MemberService;
import service.SalesService;
import state.DrinkDto;
import state.MemberDto;
import state.MemberInfoDto;
import state.SummaryDto;
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
                list.forEach(x -> {
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
        int ans = utilities.chooseMenu(4);
        switch (ans) {
            case 1 -> {
                System.out.println("회원 추가");
                String user_id = "";
                while (true) {
                    System.out.println("사용하실 ID를 입력해주세요");
                    user_id = sc.next();
                    if (memberServ.checkUserId(user_id)) {
                        System.out.println("사용 가능한 아이디 입니다.");
                        break;
                    } else {
                        System.out.println("사용 불가능한 아이디 입니다.");
                    }
                }
                String pass = "";
                String passConfirm = "";
                while (true) {
                    System.out.println("사용하실 비밀번호를 입력해주세요.");
                    pass = sc.next();
                    System.out.println("비밀번호를 다시 입력해주세요.");
                    passConfirm = sc.next();
                    if (memberServ.checkPass(pass, passConfirm)) {
                        System.out.println("비밀번호가 설정되었습니다.");
                        break;
                    } else {
                        System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
                    }
                }
                System.out.println("이름을 입력해주세요.");
                String name = sc.next();

                String tel = "";
                while (true) {
                    System.out.println("전화번호를 입력해주세요 (XXX-XXXX-XXXX의 양식으로 입력)");
                    tel = sc.next();
                    if (memberServ.checkTel(tel)) {
                        System.out.println("전화번호가 등록되었습니다.");
                        break;
                    } else {
                        System.out.println("양식에 맞춰 입력해주세요.");
                    }
                }
                String card_num = "";
                while (true) {
                    System.out.println("카드번호를 입력해주세요 (숫자만 입력)");
                    card_num = sc.next();
                    if (memberServ.checkCard(card_num)) {
                        System.out.println("카드가 등록되었습니다.");
                        break;
                    }
                }
                int result = memberServ.register(user_id, pass, name, tel, card_num);
                if (result == 0) {
                    System.out.println("회원추가에 실패하였습니다.");
                } else {
                    System.out.println("회원이 추가 되었습니다.");
                }
            }
            case 2 -> {
                System.out.println("회원 수정");
                // 관리자도 password, card_num 조회 불가. 새로 세팅만 가능, USER ID는 변경 불가.
                int id = utilities.chooseMenu(memberServ.getIds());
                MemberInfoDto dto = (memberServ.getInfoById(id)).get(0);
                String userid = dto.getUserId();
                String password = "변경 없음";
                String passConfirm;
                String name = dto.getName();
                String tel = dto.getTel();
                int balance = dto.getBalance();
                String cardnum = "변경 없음";
                int isadmin = dto.getIsAdmin();

                System.out.println(dto.toString());

                System.out.println("비밀번호를 변경하시겠습니까? (1. 예  2. 아니오)");
                int ans2 = utilities.chooseMenu(2);
                if (ans2 == 1) {
                    while (true) {
                        System.out.println("변경하실 비밀번호를 입력해 주세요.");
                        password = sc.next();
                        System.out.println("비밀번호를 다시 입력해주세요.");
                        passConfirm = sc.next();
                        if (memberServ.checkPass(password, passConfirm)) {
                            System.out.println("비밀번호가 설정되었습니다.");
                            break;
                        } else {
                            System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
                        }
                    }
                }

                System.out.println("이름을 변경하시겠습니까? (1. 예  2. 아니오)");
                ans2 = utilities.chooseMenu(2);
                if (ans2 == 1) {
                    name = sc.next();
                }

                System.out.println("전화번호를 변경하시겠습니까? (1. 예  2. 아니오)");
                ans2 = utilities.chooseMenu(2);
                if (ans2 == 1) {
                    while (true) {
                        System.out.println("전화번호를 입력해주세요 (XXX-XXXX-XXXX의 양식으로 입력)");
                        tel = sc.next();
                        if (memberServ.checkTel(tel)) {
                            System.out.println("전화번호가 등록되었습니다.");
                            break;
                        } else {
                            System.out.println("양식에 맞춰 입력해주세요.");
                        }
                    }
                }
                System.out.println("잔액을 변경하시겠습니까? (1. 예  2. 아니오)");
                ans2 = utilities.chooseMenu(2);
                if (ans2 == 1) {
                    while (true) {
                        try {
                            System.out.println("설정할 잔액을 입력해주세요.");
                            balance = sc.nextInt();
                            break;
                        } catch (Exception e) {
                            System.out.println("잘못된 입력입니다. 숫자만 입력해주세요.");
                        }
                    }
                }
                System.out.println("카드번호를 변경하시겠습니까? (1. 예  2. 아니오)");
                ans2 = utilities.chooseMenu(2);
                if (ans2 == 1) {
                    while (true) {
                        System.out.println("카드번호를 입력해주세요 (숫자만 입력)");
                        cardnum = sc.next();
                        if (memberServ.checkCard(cardnum)) {
                            System.out.println("카드가 등록되었습니다.");
                            break;
                        }
                    }
                }
                System.out.println("관리자 여부를 변경하시겠습니까? (1. 예  2. 아니오)");
                ans2 = utilities.chooseMenu(2);
                if (ans2 == 1) {
                    while (true) {
                        try {
                            System.out.println("설정값을 선택해주세요. ( 0 : 일반 유저 || 1 : 관리자)");
                            isadmin = sc.nextInt();
                            if (isadmin == 0 || isadmin == 1) {
                                break;
                            } else {
                                System.out.println("0 과 1 중에 선택해주세요.");
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
                System.out.println("이 내용이 맞습니까? (USER ID, 비밀번호, 이름, 전화번호, 잔액, 카드번호, 관리자 여부)");
                System.out.println(userid + "," + password + "," + name + "," + tel + "," + balance + "," + cardnum + "," + isadmin);
                System.out.println("1. 예  2. 아니오");
                ans2 = utilities.chooseMenu(2);
                if (ans2 == 1) {
                    int result = memberServ.update(id, password, name, tel, balance, cardnum, isadmin);
                    if (result != 0) {
                        System.out.println("회원 수정이 완료되었습니다!");
                        System.out.println((memberServ.getInfoById(id)).get(0).toString());
                    }
                }



            }
            case 3 -> {
                System.out.println("회원 삭제");
                int id = utilities.chooseMenu(memberServ.getIds());
                MemberDto dto = (memberServ.getById(id)).get(0);
                System.out.println("정말로 " + dto.getName() + " 유저를 삭제하시겠습니까? (1. 예  2. 아니오)");
                int ans2 = utilities.chooseMenu(2);
                if (ans2 == 1) {
                    int result = memberServ.delete(id);
                    if (result != 0) {
                        System.out.println("삭제가 완료되었습니다.");
                    }
                }
            }
            case 4 -> {
                List<MemberDto> list = memberServ.getAll();
                System.out.println("ID\t|  유저  ID\t\t|  이름\t\t\t|  잔액\t\t|  관리자 여부");
                System.out.println("-----------------------------------------------------------");
                list.forEach(x -> {
                    System.out.println(String.format("%d\t|  %-10s\t|  %-10s\t|  %5d원\t|  %d", x.getId(), x.getUserId(), x.getName(), x.getBalance(), x.getIsAdmin()));
                });
            }
        }
    }

    private void salesManage() {
        System.out.println("판매 관리");
        System.out.println("""
                1. 제품별 판매 현황
                2. 회원별 판매 현황
                """);
        int ans = utilities.chooseMenu(2);
        switch (ans) {
            case 1 -> {
                System.out.println("제품별 판매 현황");
                System.out.println("  제품명\t\t판매수량\t\t판매금액");
                List<DrinkDto> list = salesServ.getSummaryByMenu();
                System.out.println("  -------------------------------");
                for (DrinkDto x : list) {
                    System.out.println(String.format("%5s\t\t%4d개\t   %6d원", x.getName(), x.getStock(), x.getPrice()));
                }
                System.out.println("  -------------------------------");
            }
            case 2 -> {
                System.out.println("회원별 판매 현황");
                System.out.println("  아이디 \t회원명\t 구매금액\t충전잔액");
                System.out.println("  ---------------------------------------");
                List<SummaryDto> list = salesServ.getSummaryByMember();
                for (SummaryDto x : list)
                    System.out.println(String.format("%6s\t%6s\t%6d원\t%6d원", x.getUser_id(), x.getName(), x.getTotalpurchase(), x.getBalance()));
                System.out.println("  ---------------------------------------");
            }
        }
    }
}
