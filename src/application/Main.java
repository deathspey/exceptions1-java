package application;

import model.entites.Resevertion;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            System.out.print("Room number: ");
            int number = sc.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());


            Resevertion resevertion = new Resevertion(number, checkIn, checkOut);
            System.out.println("Reservention: " + resevertion);

            System.out.println();
            System.out.println("Enter data to update the reservetion: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());


            resevertion.updateDates(checkIn, checkOut);

            System.out.println("Reservention: " + resevertion);
        }
        catch (ParseException e ){
            System.out.println("Invalid date format");
        }
        catch (DomainException e ){
            System.out.println("Error in reservetion: "+e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Unexpected error");
        }

        sc.close();
    }

}
