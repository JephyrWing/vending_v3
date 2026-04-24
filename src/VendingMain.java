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

        String test1 = sc.next();
        boolean test2 = utilities.Luhn_Validation(test1);
        System.out.println(test2);

        MemberDto memberDto = null;
        while (true) {
            ans = userView.start();
            switch (ans) {
                case 1 -> userView.register();
                case 2 -> {
                    memberDto = userView.login();
                    if (memberDto.getIsAdmin() == 1) {
                        System.out.println("관리자 모드로 진입하시겠습니까? 1.네 2.아니오");
                        ans2 = utilities.chooseMenu(2);
                        if (ans2 == 1) {
                            AdminView.menu();
                        } else {
                            UserView.menu();
                        }
                    } else {
                        UserView.menu();
                    }
                }
                case 3 -> {
                    return;
                }
            }
        }
    }
}
