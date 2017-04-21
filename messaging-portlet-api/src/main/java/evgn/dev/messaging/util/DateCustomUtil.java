package evgn.dev.messaging.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by evgndev on 26.10.16.
 */
public class DateCustomUtil {
    private static final Log LOG = LogFactoryUtil.getLog(DateCustomUtil.class);

    public static final String PATTERN = "dd.MM.yyyy";
    public static final String PATTERN_TIME = "dd.MM.yyyy HH:mm";
    public static final String PATTERN_DB = "yyyy-MM-dd";

    public static int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    /**
     * @return DateFormat with pattern "dd.MM.yyyy"
     */
    public static DateFormat getViewDateFormat() {
        return new SimpleDateFormat(PATTERN);
    }

    /**
     * @return DateFormat with pattern "dd.MM.yyyy HH:mm"
     */
    public static DateFormat getViewDateFormatWithTime() {
        return new SimpleDateFormat(PATTERN_TIME);
    }

    /**
     * @return DateFormat with pattern "yyyy-MM-dd"
     */
    public static DateFormat getDBDateFormat() {
        return new SimpleDateFormat(PATTERN_DB);
    }

    /**
     * @return "dd.MM.yyyy"
     */
    public static String toViewFormatDate(Date date) {
        return toStringDateOrEmpty(date, getViewDateFormat());
    }

    /**
     * @return "dd.MM.yyyy HH:mm"
     */
    public static String toViewFormatDateWithTime(Date date) {
        return toStringDateOrEmpty(date, getViewDateFormatWithTime());
    }

    /**
     * @return "yyyy-MM-dd"
     */
    public static String toDBDate(Date date) {
        DateFormat dbDateFormat = getDBDateFormat();
        return dbDateFormat.format(date);
    }

    /**
     * "dd.MM.yyyy" to "yyyy-MM-dd"
     *
     * @param dateStr dd.MM.yyyy
     */
    public static String toDBDate(String dateStr) {
        try {
            Date date = getViewDateFormat().parse(dateStr);
            return getDBDateFormat().format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String toStringDateOrEmpty(Date date, DateFormat dateFormat) {
        if (date != null && dateFormat != null) {
            return dateFormat.format(date);
        }
        return "";
    }

    public static String toSecondsString(Date date) {
        return String.valueOf(toSecondsLong(date));
    }

    public static long toSecondsLong(Date date) {
        return date.getTime() / 1000;
    }
}
