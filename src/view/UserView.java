package view;

import service.DrinkService;
import service.MemberService;
import service.SalesService;
import utilities.Utilities;

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

    public static void menu(int id) {
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
        memberServ.register(user_id, pass, name, tel, card_num);
    }

    public int[] login() {
        System.out.println("ID를 입력해주세요");
        String user_id = sc.next();
        System.out.println("비밀번호를 입력해주세요.");
        String pass = sc.next();
        return memberServ.login(user_id, pass);
    }
}
