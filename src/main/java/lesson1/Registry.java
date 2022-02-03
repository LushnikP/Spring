package lesson1;

import java.util.Random;

public class Registry{
    private IDoctor doctor;
    private Archive archive;
    private Person person;

    public void getTherapistInfo(){
        System.out.println(doctor.cabinet() + "\n" + doctor.weekdays());
    }

    public void checkPatient(){
        archive.getPatientInfo(person);
    }

    public void setDoctor(IDoctor doctor) {
        this.doctor = doctor;
    }

    public void setArchive(Archive archive) {
        this.archive = archive;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
