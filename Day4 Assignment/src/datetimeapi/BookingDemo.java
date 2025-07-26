package datetimeapi;
import java.time.*;

public class BookingDemo {
    public static void main(String[] args) {
        LocalDate checkIn = LocalDate.of(2024, 7, 1);
        LocalDate checkOut = LocalDate.of(2024, 7, 5);
        Period stay = Period.between(checkIn, checkOut);
        System.out.println("Stay Duration: " + stay.getDays() + " days");
    }
}