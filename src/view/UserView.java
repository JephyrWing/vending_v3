package view;

import service.DrinkService;
import service.MemberService;
import service.SalesService;
import state.DrinkDto;
import state.MemberDto;
import utilities.Utilities;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Scanner;

public class UserView {
    private final DrinkService drinkServ;
    private final MemberService memberServ;
    private final SalesService salesServ;
    Utilities utilities = new Utilities();
    Scanner sc = new Scanner(System.in);

    public UserView(DrinkService drinkServ, MemberService memberServ, SalesService salesServ) {
        this.drinkServ = drinkServ;
        this.memberServ = memberServ;
        this.salesServ = salesServ;
    }

    public int start() {
        utilities.creLine();
        System.out.println("자판기에 오신 걸 환영합니다");
        utilities.creLine();
        System.out.println("1. 회원가입\n2. 로그인\n3. 종료\n>");
        int result = utilities.chooseMenu(3);
        return result;
    }

    public void register() {
        utilities.creLine();
        System.out.println("회원가입");
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
            System.out.println("사용하실 비밀번호를 입력해주세요.");
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
            System.out.println("회원가입에 실패하였습니다.");
        } else {
            System.out.println("회원가입 되셨습니다!");
        }
    }

    public int[] login() {
        System.out.println("ID를 입력해주세요");
        String user_id = sc.next();
        System.out.println("비밀번호를 입력해주세요.");
        String pass = sc.next();
        return memberServ.login(user_id, pass);
    }

    public void menu(int id) {
        List<MemberDto> list;
        MemberDto dto;
        while (true) {
            list = memberServ.getById(id);
            dto = list.get(0);
            utilities.creLine();
            System.out.println("안녕하세요, [" + dto.getName() + "]님!\t잔액: [" + dto.getBalance() + "]원");
            utilities.creLine();
            System.out.println("""
                1. 메뉴보기
                2. 음료 구매
                3. 금액 충전
                4. 구매 내역
                5. 로그아웃
                >
                """);
            int ans = utilities.chooseMenu(5);
            switch (ans) {
                case 1 -> showmenu();
                case 2 -> purchase(dto);
                case 3 -> insertCoin(dto.getId());
                case 4 -> saleshistory();
                case 5 -> {
                    System.out.println("로그아웃 합니다.");
                    return;
                }
            }
        }
    }

    public void showmenu() {
        List<DrinkDto> list = drinkServ.getAll();
        System.out.println("ID\t| 제품명\t\t|  가격\t\t|  재고");
        System.out.println("----------------------------------");
        list.forEach(x-> {
            if (x.getStock() == 0) {
                System.out.println(String.format("%d\t| %s\t\t|  %d원\t|  %d개 (품절)", x.getId(), x.getName(), x.getPrice(), x.getStock()));
            } else {
                System.out.println(String.format("%d\t| %s\t\t|  %d원\t|  %d개", x.getId(), x.getName(), x.getPrice(), x.getStock()));
            }
        });
    }

    private void purchase(MemberDto dto) {
        List<DrinkDto> list = drinkServ.getAll();
        showmenu();
        int ans = utilities.chooseMenu(drinkServ.getIds());
        DrinkDto selected = drinkServ.getById(ans);
        if (selected.getStock() == 0) {
            System.out.println("재고가 없습니다.");
        } else if (dto.getBalance() < selected.getPrice()) {
            System.out.println("잔액이 부족합니다.");
        } else {
            int result = salesServ.sell(dto.getId(), ans, selected.getPrice());
            if (result == 0) {
                System.out.println("구매에 실패하였습니다.");
            } else {
                System.out.println(selected.getName() + "이(가) 구매되었습니다!");
                drinkServ.update(selected.getId(), selected.getName(), selected.getPrice(), selected.getStock() - 1);
                int balance = memberServ.charge(dto.getId(), -selected.getPrice());
                System.out.println("잔액은 " + balance + "원 입니다.");
            }
        }
    }

    private void insertCoin(int id) {
        int tempcoin = utilities.insertCoin();
        int balance = memberServ.charge(id, tempcoin);
        System.out.println("충전이 완료되었습니다. 잔액은 " + balance + "원 입니다.");
    }

    private void saleshistory() {
        System.out.println("구매 내역");
    }
}
