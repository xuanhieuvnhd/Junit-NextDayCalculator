public class NextDayCalculator {
    public static final String CONCATENATION = "/";
    public static final String FIRSTOFMONTH = "1";
    public static final String FIRSTOFYEAR = "1";

    public static String getNextDay(int dayTest, int monthTest, int yearTest) {
        String result;
        int lastOfMonth = getLastOfMonth(monthTest, yearTest);
        if (dayTest == lastOfMonth) {
            result = FIRSTOFMONTH + CONCATENATION + (++monthTest) + CONCATENATION + yearTest;
        } else {
            result = ++dayTest + CONCATENATION + monthTest + CONCATENATION + yearTest;
        }
        return result;
    }

    public static String getNextMonth(int dayTest,int monthTest, int yearTest) {
        String result;
        int lastOfMonth = getLastOfMonth(monthTest, yearTest);
        if (monthTest==12 && dayTest == getLastOfMonth(monthTest, yearTest)){
            result = FIRSTOFMONTH + CONCATENATION + FIRSTOFYEAR + CONCATENATION + (++yearTest);
        }else {
            result = ++dayTest + CONCATENATION + monthTest + CONCATENATION + yearTest;
        }
        return result;
    }

    private static boolean checkLeafYear(int yearTest) {
        if (yearTest % 4 == 0) {
            if (yearTest % 100 == 0) {
                return yearTest % 400 == 0;
            } else
                return true;
        } else {
            return false;
        }
    }

    private static int getLastOfMonth(int monthTest, int yearTest) {
        int lastOfMonth = 0;
        switch (monthTest) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                lastOfMonth = 31;
                break;
            case 2:
                if (checkLeafYear(yearTest)){
                    lastOfMonth = 29;
                }else {
                    lastOfMonth = 28;
                }
                break;
            default:
                lastOfMonth = 30;
        }
        return lastOfMonth;
    }
}

