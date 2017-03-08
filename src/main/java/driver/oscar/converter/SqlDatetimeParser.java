package driver.oscar.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SqlDatetimeParser
{
    private static java.sql.Timestamp stringConvertSqlTimestamp(String date) throws ParseException
    {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        java.util.Date startDate = df.parse(date);
        java.sql.Timestamp timestamp = new java.sql.Timestamp(startDate.getTime());
        return timestamp;
    }
}
