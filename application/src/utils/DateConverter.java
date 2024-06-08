
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateConverter {
        
    private DateConverter(){
        throw new UnsupportedOperationException("This class cannot be instantiated.");
    }
    
    public static String format(LocalDate date, String pattern){
        java.util.Date utilDate = DateConverter.transformToUtilDate(date);
        SimpleDateFormat desiredPattern = new SimpleDateFormat(pattern);
        String formattedDate = desiredPattern.format(utilDate);
        return formattedDate;
    }
    
    public static String format(java.util.Date date, String pattern){
        SimpleDateFormat desiredPattern = new SimpleDateFormat(pattern);
        String formattedDate = desiredPattern.format(date);
        return formattedDate;
    }
    
    public static String format(java.sql.Date date, String pattern){
        java.util.Date utilDate = DateConverter.transformToUtilDate(date);
        SimpleDateFormat desiredPattern = new SimpleDateFormat(pattern);
        String formattedDate = desiredPattern.format(utilDate);
        return formattedDate;
    }
 
    public static String today(String pattern){
        LocalDate localDate = LocalDate.now();
        return DateConverter.format(localDate, pattern);
    }
    
    public static java.sql.Date todayToDateSql(){
        LocalDate localDate = LocalDate.now();
        return DateConverter.transformToSqlDate(localDate);
    }
    
    public static java.util.Date todayToDateUtil(){
        LocalDate localDate = LocalDate.now();
        return DateConverter.transformToUtilDate(localDate);
    }
    
    public static LocalDate todayToLocalDate(){
        LocalDate localDate = LocalDate.now();
        return localDate;
    }
    
    public static java.sql.Date transformToSqlDate(LocalDate date){
        return java.sql.Date.valueOf(date);
    }
    
    public static java.sql.Date transformToSqlDate(java.util.Date date){
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        return sqlDate;
    }
    
    public static java.sql.Date transformToSqlDate(String date, String pattern){    
        java.util.Date utilDate = transformToUtilDate(date, pattern);
        if(utilDate != null){
            java.sql.Date sqlDate = DateConverter.transformToSqlDate(utilDate);
            return sqlDate;
        }
        else{
            return null;
        }
    }
        
    public static java.util.Date transformToUtilDate(LocalDate date){
        return java.util.Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
    } 
    
    public static java.util.Date transformToUtilDate(java.sql.Date date){
        java.util.Date utilDate = new java.util.Date(date.getTime());
        return utilDate;
    }
    
    public static java.util.Date transformToUtilDate(String date, String pattern){
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        try {
            java.util.Date utilDate = formatter.parse(date);
            return utilDate;
        } catch (ParseException e) {
            return null;
        }
    }
    
    public static LocalDate transformToLocalDate(java.sql.Date date){
        LocalDate localDate = date.toLocalDate();
        return localDate;  
    }
    
    public static LocalDate transformToLocalDate(java.util.Date date){
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate;
    }
    
    public static LocalDate transformToLocalDate(String date, String pattern){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);        
        try {
            LocalDate localDate = LocalDate.parse(date, formatter);
            return localDate;
        } catch (DateTimeParseException e) {
            return null;
        }
    }
    
}