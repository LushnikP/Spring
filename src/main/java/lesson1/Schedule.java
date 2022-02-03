package lesson1;

public class Schedule {

    public String getWeekday(IDoctor doctor) {
        if(doctor instanceof Therapist) return doctor + " работает по будням.";
        else return doctor + " работает по выходным.";
    }
}
