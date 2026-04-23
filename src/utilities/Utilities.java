package utilities;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Utilities {
    Scanner sc = new Scanner(System.in);

    public int chooseMenu() {
        int menunum = 0;
        while (true) {
            try {
                System.out.println("\n번호를 골라주세요.");
                menunum = sc.nextInt();
                break;

            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 숫자만 입력해주세요.");
                sc.next();
            }
        }
        return menunum;
    }

    public int insertCoin() {
        int tempcoin = 0;
        while (true) {
            try {
                System.out.println("\n금액을 투입해주세요.");
                tempcoin = sc.nextInt();
                break;

            } catch (InputMismatchException e) { // 에러가 발생하면 이쪽으로 빠짐
                System.out.println("잘못된 입력입니다. 숫자만 입력해주세요.");
                sc.next();
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
        return String.format("%d/%d/%d %d:%d:%d", curyear, curmonth, curday, curhour, curmin, cursec);
    }

    public void creLine() {
        System.out.println("=========================================================================================================");
    }
}
