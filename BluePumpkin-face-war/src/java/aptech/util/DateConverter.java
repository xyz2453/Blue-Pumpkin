/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author NguyenDucHuy
 */
public class DateConverter {
    public DateConverter() {
    
    }

    public String getSimpleDateString(Date date) {
        SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
        return parser.format(date);
    }
    
    public String getSimpleDateWithTime(Date date) {
        SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        return parser.format(date);
    }
    
    public Date addMidNight(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        
        return cal.getTime();
    }
}
