package view;

import service.DrinkService;
import service.MemberService;
import service.SalesService;

import java.util.Scanner;

public class AdminView {
    private final DrinkService drinkServ;
    private final MemberService memberServ;
    private final SalesService salesServ;

    public AdminView(DrinkService drinkServ, MemberService memberServ, SalesService salesServ) {
        this.drinkServ = drinkServ;
        this.memberServ = memberServ;
        this.salesServ = salesServ;
    }

    public static void menu() {
    }
}
