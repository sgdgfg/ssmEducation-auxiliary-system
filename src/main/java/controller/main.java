package controller;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
 public class main {
   public static void main(String[] qa) {

 System.currentTimeMillis() ;

/*       id.deleteCharAt(0); id.deleteCharAt(0); id.deleteCharAt(0);*/
       StringBuffer  id=new StringBuffer ( String.valueOf(System.currentTimeMillis()));

       id.deleteCharAt(0); id.deleteCharAt(0); id.deleteCharAt(0);
       System.out.println(id.toString());
       LocalDate date=LocalDate.now();
       LocalTime time=LocalTime.now();
       System.out.println(date.toString()+"                   "+time.toString());

   }
 }

//   ff[i][j]=ff[i-1][j] 1/i  + ff[i-1][j-1] 1/i+ ff[i-1][j-2]
