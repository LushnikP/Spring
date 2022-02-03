package lesson1;

public class Plan {
    public String getCabinet(IDoctor doctor) {
        if(doctor instanceof Therapist) return doctor + " в кабинете 519";
        else return doctor + " в кабинете 520";
    }
}
