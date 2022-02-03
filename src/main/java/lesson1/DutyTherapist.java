package lesson1;

public class DutyTherapist implements IDoctor{
    private Schedule schedule;
    private Plan plan;

    @Override
    public String weekdays() {
        return schedule.getWeekday(this);
    }

    @Override
    public String cabinet() {
        return plan.getCabinet(this);
    }

    @Override
    public String toString() {
        return "Дежурный терапевт";
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }
}
