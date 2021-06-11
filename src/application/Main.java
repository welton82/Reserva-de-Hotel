package application;

import model.entites.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scan = new Scanner(System.in);
        Reservation reservation = new Reservation();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room Number: ");
        int number =  scan.nextInt();

        System.out.print("Chekin Date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(scan.next());
        System.out.print("ChekOut Date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(scan.next());

        //conferir se a data de saida é posterior a data de entrada
        //caso seja entrará no if
        //a conferência é ada pelo método .ater que é para conferência de datas
        if(!checkOut.after(checkIn)){
            System.out.println("Error in reservation: check-out date must be after check-in date");
        }else{
            reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation");
            System.out.print("Checkin date: (dd/MM/yyyy): ");
            checkIn = sdf.parse(scan.next());
            System.out.print("Checkin date: (dd/MM/yyyy): ");
            checkOut = sdf.parse(scan.next());

            reservation.upDatesDate(checkIn,checkOut);
            System.out.println("Reservation: " + reservation);


        }

    }
}
