package main;

import java.time.LocalDate;
import utils.DateConverter;

public class Main {
    
    public static void main(String[] args){
    
        System.out.println("-----------------------------------------------");
        System.out.println("Today: " + DateConverter.today("dd/MM/yyyy"));
        System.out.println("-----------------------------------------------");   
        
        System.out.println("Working with Local Date:");
        LocalDate localDate = LocalDate.of(2024, 6, 15);
        System.out.println("Local Date: " + localDate);
        System.out.println("Formatted Local Date: " + DateConverter.format(localDate, "dd/MM/yyyy"));
        java.util.Date utilDate2 = DateConverter.transformToUtilDate(localDate);
        java.sql.Date sqlDate2 = DateConverter.transformToSqlDate(localDate);
        System.out.println("From Local Date to Util Date: " + utilDate2);
        System.out.println("From Local Date to Sql Date: " + sqlDate2);
        LocalDate localDate2 = DateConverter.todayToLocalDate();
        System.out.println("Today (Local Date): " + localDate2);
        LocalDate localDate3 = DateConverter.transformToLocalDate("15/12/2023", "dd/MM/yyyy");
        System.out.println("From String to Local Date: " + localDate3);
        System.out.println("-----------------------------------------------");
        
        System.out.println("Working with Sql Date:");
        // Milissegundos desde 1 de janeiro de 1970
        java.sql.Date sqlDate = new java.sql.Date(1718852400000L);
        System.out.println("Sql Date: " + sqlDate);
        System.out.println("Formatted Sql Date: " + DateConverter.format(sqlDate, "dd/MM/yyyy"));
        java.util.Date utilDate3 = DateConverter.transformToUtilDate(sqlDate);
        LocalDate locaDate4 = DateConverter.transformToLocalDate(sqlDate);       
        System.out.println("From Sql Date to Util Date: " + utilDate3);
        System.out.println("From Sql Date to Local Date: " + locaDate4);
        java.sql.Date sqlDate3 = DateConverter.todayToDateSql();
        System.out.println("Today (Sql Date): " + sqlDate3);
        java.sql.Date sqlDate4 = DateConverter.transformToSqlDate("20/12/2023", "dd/MM/yyyy");
        System.out.println("From String to Sql Date: " + sqlDate4);
        System.out.println("-----------------------------------------------");       
        
        System.out.println("Working with Util Date:");
        // Milissegundos desde 1 de janeiro de 1970
        java.util.Date utilDate = new java.util.Date(1719284400000L);
        System.out.println("Util Date: " + utilDate);
        System.out.println("Formatted Util Date: " + DateConverter.format(utilDate, "dd/MM/yyyy"));
        java.sql.Date sqlDate5 = DateConverter.transformToSqlDate(utilDate);
        LocalDate locaDate5 = DateConverter.transformToLocalDate(utilDate);       
        System.out.println("From Util Date to Sql Date: " + sqlDate5);
        System.out.println("From Util Date to Local Date: " + locaDate5);
        java.util.Date utilDate4 = DateConverter.todayToDateUtil();
        System.out.println("Today (Util Date): " + utilDate4);
        java.util.Date utilDate5 = DateConverter.transformToUtilDate("25/12/2023", "dd/MM/yyyy");
        System.out.println("From String to Util Date: " + utilDate5);
        System.out.println("-----------------------------------------------");

    }

}
