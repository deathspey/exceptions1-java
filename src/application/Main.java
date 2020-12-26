package application;

import model.entites.Resevertion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        if(!checkOut.after(checkIn)){
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }
        else {
            Resevertion resevertion = new Resevertion(number,checkIn,checkOut);
            System.out.println("Reservention: "+resevertion);

            System.out.println();
            System.out.println("Enter data to update the reservetion: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());



                String error = resevertion.updateDates(checkIn,checkOut);
                if(error != null) {

                    System.out.println("Error in reservention: " + error);
                }
                else{
                    System.out.println("Reservention: " + resevertion);
                }

        }

        sc.close();
    }

}
