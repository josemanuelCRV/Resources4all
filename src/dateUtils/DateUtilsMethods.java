package dateUtils;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateUtilsMethods {

	
	private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private static final DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy/MM/dd'T'HH:mm:ss.SSS");
    private static final DecimalFormat DF = new DecimalFormat("000");
    
	public static void main(String[] args) {

        long timeUS = System.currentTimeMillis();
        System.out.println("System.currentTimeMillis:\n " + timeUS + "\n");
        System.out.println("-----------------------------------------------\n");
		
        
		Date date = new Date();
		System.out.println("Date:\n " + date + "\n");
		System.out.println("Date Millis:\n " + date.getTime() + "\n");
        System.out.println("Date formatted:\n " + sdf.format(date) + "\n");
        System.out.println("-----------------------------------------------\n");
                    
        
        Calendar cal = Calendar.getInstance();
        System.out.println("Calendar - getTime():\n " + cal.getTime() + "\n");
        System.out.println("Calendar formatted2 - getTime():\n " + sdf2.format(cal.getTime()) + "\n");
        System.out.println("Calendar TimeInMillis - getTimeInMillis():\n " + cal.getTimeInMillis() + "\n");
        System.out.println("Calendar DisplayName - getTimeZone().getDisplayName():\n " + cal.getTimeZone().getDisplayName() + "\n");
        System.out.println("Calendar TimeZone ID - getTimeZone().getID():\n " + cal.getTimeZone().getID() + "\n");
        System.out.println("Calendar TimeZone ID - cal.ZONE_OFFSET:\n " + Calendar.ZONE_OFFSET + "\n");
        System.out.println("Calendar - getTimeZone().getID():\n " + cal.getTimeZone().getID() + "\n");
        System.out.println("Calendar - getTimeZone().getOffset(timeUS):\n " + cal.getTimeZone().getOffset(timeUS) + "\n");
        System.out.println("-----------------------------------------------\n");

        
        Date time2 = cal.getTime();
        System.out.println("Date<-Cal:\n " + time2 + "\n");
        System.out.println("-----------------------------------------------\n");
        
        
        LocalDateTime now = LocalDateTime.now();
        System.out.println("LocalDateTime - now.atOffset(ZoneOffset.UTC):\n " + now.atOffset(ZoneOffset.UTC) + "\n");
        System.out.println("LocalDateTime - now.atZone(ZoneId.of(\"UTC\")):\n " + now.atZone(ZoneId.of("UTC")) + "\n");
        System.out.println("LocalDateTime:\n " + now + "\n");
        System.out.println("LocalDateTime formatted:\n " + dtf.format(now) + "\n");
        System.out.println("-----------------------------------------------\n");
        
        
        LocalDate localDate = LocalDate.now();
        System.out.println("LocalDate:\n " + localDate + "\n");
        System.out.println("LocalDate formatted:\n " + DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate));
        System.out.println("-----------------------------------------------\n");
                       
	}


}
