import db.DBConnect;
import repository.*;
import service.*;
import utilities.Utilities;
import view.AdminView;
import view.UserView;

import java.sql.Connection;

public class VendingMain {
    public static Utilities utilities = new Utilities();

    public static void main(String[] args) {
        Connection conn = DBConnect.getConnection();
        DrinkRepository drinkRepo = new DrinkRepositoryImpl(conn);
        MemberRepository memberRepo = new MemberRepositoryImpl(conn);
        SalesRepository salesRepo = new SalesRepositoryImpl(conn);
        DrinkService drinkServ = new DrinkServiceImpl(drinkRepo);
        MemberService memberServ = new MemberServiceImpl(memberRepo);
        SalesService salesServ = new SalesServiceImpl(salesRepo);
        UserView userView = new UserView(drinkServ, memberServ, salesServ);
        AdminView adminView = new AdminView(drinkServ, memberServ, salesServ);
    }
}
