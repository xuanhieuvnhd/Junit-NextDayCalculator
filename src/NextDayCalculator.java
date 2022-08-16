public class NextDayCalculator {
    public static final int firstDayOfMonth = 1;

    public static String nextDayCalculator(int inputDay, int inputMonth, int inputYear){
        int outputDay = inputDay;
        int outputMonth = inputMonth;
        int outputYear = inputYear;

        if (inputDay == getLastOfMonth(inputMonth, inputYear)){
            if (inputMonth == 12){
                outputDay = firstDayOfMonth;
                outputMonth = 1;
                outputYear ++;
            }
            else {
                outputDay = firstDayOfMonth;
                outputMonth ++;
            }
        }
        else outputDay ++;

        return outputDay + "-" + outputMonth + "-" + outputYear;
    }

    private static int getLastOfMonth(int inputMonth, int inputYear) {
        switch (inputMonth){
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return isLeapYear(inputYear)? 29: 28;

        }
        return 31;
    }

    private static boolean isLeapYear (int inputYear){
        if(inputYear % 4 == 0){
            if (inputYear % 100 == 0){
                if (inputYear % 400 == 0){
                    return true;
                }
                else return false;
            }
            else return true;
        }
        else return false;
    }
}

