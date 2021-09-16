package com.shouvit.assignments.assignment17;

class InvalidDateException extends Exception {

}

class InvalidInputException extends Exception {

}

public class Main {
    static int dayNumber(int month, int year) {

        int t[] = { 0, 3, 2, 5, 0, 3,
                5, 1, 4, 6, 2, 4 };
        year -= (month < 3) ? 1 : 0;
        return (year + year / 4
                - year / 100
                + year / 400
                + t[month - 1] + 1)
                % 7;
    }

    static int numberOfDays(int monthNumber, int year) {
        // January
        if (monthNumber == 0)
            return (31);

        // February
        if (monthNumber == 1) {
            // If the year is leap then Feb
            // has 29 days
            if (year % 400 == 0
                    || (year % 4 == 0
                    && year % 100 != 0))
                return (29);
            else
                return (28);
        }

        // March
        if (monthNumber == 2)
            return (31);

        // April
        if (monthNumber == 3)
            return (30);

        // May
        if (monthNumber == 4)
            return (31);

        // June
        if (monthNumber == 5)
            return (30);

        // July
        if (monthNumber == 6)
            return (31);

        // August
        if (monthNumber == 7)
            return (31);

        // September
        if (monthNumber == 8)
            return (30);

        // October
        if (monthNumber == 9)
            return (31);

        // November
        if (monthNumber == 10)
            return (30);

        // December
        return (31);
    }

    static void calendar(String s) throws InvalidDateException, InvalidInputException {
        int index = s.indexOf("-");
        if(s.length() != 7 || index != 4) throw new InvalidInputException();
        int year = Integer.parseInt(s.substring(0, index));
        int month = Integer.parseInt(s.substring(index + 1));
        if(month > 12) throw new InvalidDateException();
        int curr = dayNumber(month, year);
        int days = numberOfDays(month - 1, year);
        System.out.printf("  Sun  Mon  Tue  Wed  Thu  Fri  Sat\n");
        int k;
        for (k = 0; k < curr; k++) System.out.printf("     ");

        for (int j = 1; j <= days; j++) {
            System.out.printf("%5d", j);
            if (++k > 6) {
                k = 0;
                System.out.printf("\n");
            }
        }
        if (k != 0) System.out.printf("\n");
    }

    public static void main(String[] args) {
        try {
            calendar("2018-04");
        } catch(InvalidDateException e) {
            System.out.println("Invalid Date!");
        } catch(InvalidInputException e) {
            System.out.println("Invalid Input!");
        }
    }
}
