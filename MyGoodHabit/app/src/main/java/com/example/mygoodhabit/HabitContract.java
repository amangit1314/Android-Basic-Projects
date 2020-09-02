package com.example.mygoodhabit;

import android.provider.BaseColumns;

public class HabitContract {
    private HabitContract() {}

    public static final class HabitDbEntry implements BaseColumns{

        public final static String TABLE_NAME = "my_habits";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_HABIT_SPORT = "activity";
        public final static String COLUMN_HABIT_HOURS = "hours";
        public final static String COLUMN_HABIT_DATE = "date";
    }
}
