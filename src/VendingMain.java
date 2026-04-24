import db.DBConnect;
import dto.MemberDto;
import repository.*;
import service.*;
import state.VendingState;
import utilities.Utilities;
import view.AdminView;
import view.UserView;

import java.sql.Connection;
import java.util.Scanner;

public class VendingMain {
    public static Utilities utilities = new Utilities();

    public static void main(String[] args) {
        Connection conn = DBConnect.getConnection();
        Scanner sc = new Scanner(System.in);
        VendingState state = new VendingState(conn);
        DrinkRepository drinkRepo = new DrinkRepositoryImpl(state);
        MemberRepository memberRepo = new MemberRepositoryImpl(state);
        SalesRepository salesRepo = new SalesRepositoryImpl(state);
        DrinkService drinkServ = new DrinkServiceImpl(drinkRepo);
        MemberService memberServ = new MemberServiceImpl(memberRepo);
        SalesService salesServ = new SalesServiceImpl(salesRepo);
        UserView userView = new UserView(drinkServ, memberServ, salesServ);
        AdminView adminView = new AdminView(drinkServ, memberServ, salesServ);

        int ans = 0;
        int ans2 = 0;
        int[] loginResult = null;


        while (true) {
            ans = userView.start();
            switch (ans) {
                case 1 -> userView.register();
                case 2 -> {
                    loginResult = userView.login();
                    if (loginResult[1] == 1) {
                        System.out.println("관리자 모드로 진입하시겠습니까? 1.네 2.아니오");
                        ans2 = utilities.chooseMenu(2);
                        if (ans2 == 1) {
                            AdminView.menu(loginResult[0]);
                        } else {
                            UserView.menu(loginResult[0]);
                        }
                    } else if (loginResult[0] == 0) {
                        System.out.println("Id 혹은 비밀번호가 존재하지 않거나 틀렸습니다.");
                    } else {
                        UserView.menu(loginResult[0]);
                    }
                }
                case 3 -> {
                    System.out.println("자판기를 종료합니다. \n또 이용해주세요!");
                    DBConnect.closeConnection();
                    return;
                }
            }
        }
    }
}
