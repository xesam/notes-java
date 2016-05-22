package dev.xesam.javalang.util;

import java.util.Calendar;

/**
 * Created by xe on 14-9-17.
 */
public class CalendarNote {
    public static void main(String[] args) {
        CalendarNote calendarNote = new CalendarNote();
        DayOfWeek dayOfWeek = calendarNote.new DayOfWeek();
        dayOfWeek.testDayOfWeek();
    }

    public class DayOfWeek {
        private int getInnerDescIndex(int dayOfWeek) {
            switch (dayOfWeek) {
                case Calendar.SUNDAY:
                    return 0;
                case Calendar.MONDAY:
                    return 1;
                case Calendar.TUESDAY:
                    return 2;
                case Calendar.WEDNESDAY:
                    return 3;
                case Calendar.THURSDAY:
                    return 4;
                case Calendar.FRIDAY:
                    return 5;
                case Calendar.SATURDAY:
                    return 6;
                default:
                    throw new RuntimeException("getDescIndex");
            }
        }

        private final String[] innerDesc = new String[]{"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};

        private String getInnerDescDesc(int descIndex) {
            return innerDesc[descIndex];
        }

        private void testDayOfWeek() {
            Calendar calendar = Calendar.getInstance();
            int[] weekdayInner = new int[]{Calendar.SUNDAY, Calendar.MONDAY, Calendar.THURSDAY, Calendar.WEDNESDAY, Calendar.TUESDAY, Calendar.FRIDAY, Calendar.SATURDAY};
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            System.out.println(getInnerDescDesc(getInnerDescIndex(dayOfWeek)));

        }
    }
}
