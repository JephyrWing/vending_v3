package view;

import service.DrinkService;
import service.MemberService;
import service.SalesService;

public class UserView {
    private final DrinkService drinkServ;
    private final MemberService memberServ;
    private final SalesService salesServ;

    public UserView(DrinkService drinkServ, MemberService memberServ, SalesService salesServ) {
        this.drinkServ = drinkServ;
        this.memberServ = memberServ;
        this.salesServ = salesServ;
    }
}
