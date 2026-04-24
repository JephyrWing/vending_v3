package utilities;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Utilities {
    Scanner sc = new Scanner(System.in);

    public int chooseMenu(int count) {
        int menunum = 0;
        while (true) {
            try {
                System.out.println("\n번호를 골라주세요.");
                menunum = sc.nextInt();
                if (menunum > count || menunum <= 0) {
                    System.out.println("올바른 번호를 골라주세요.");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 숫자만 입력해주세요.");
            }
        }
        return menunum;
    }

    public int insertCoin() {
        int tempcoin = 0;
        while (true) {
            try {
                System.out.println("\n충전할 금액을 입력해주세요.(천원 단위로만 충전 가능합니다.)");
                tempcoin = sc.nextInt();
                if (tempcoin <= 0 || (tempcoin % 1000) != 0) {
                    System.out.println("올바른 금액을 입력해주세요");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 숫자만 입력해주세요.");
            }
        }
        return tempcoin;
    }

    public String curtime() {
        int curyear = LocalDateTime.now().getYear();
        int curmonth = LocalDateTime.now().getMonthValue();
        int curday = LocalDateTime.now().getDayOfMonth();
        int curhour = LocalDateTime.now().getHour();
        int curmin = LocalDateTime.now().getMinute();
        int cursec = LocalDateTime.now().getSecond();
        return String.format("%d-%d-%d %d:%d:%d", curyear, curmonth, curday, curhour, curmin, cursec);
    }

    public void creLine() {
        System.out.println("=========================================================================================================");
    }

    public boolean Luhn_Validation(String cardnum) {
        int total = 0;
        for (int i = 0; i < cardnum.length(); i += 2) {
            int j = Integer.parseInt(Character.toString(cardnum.charAt(i)));
            if (j * 2 > 9) {
                total += (j * 2 - 9);
            } else {
                total += j;
            }
        }

        boolean result = false;
        if (total % 10 == 0) {
            result = true;
        }

        return result;
    }
}
