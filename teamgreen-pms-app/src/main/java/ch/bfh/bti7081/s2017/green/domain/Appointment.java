package ch.bfh.bti7081.s2017.green.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Appointment extends BaseEntity implements AppointmentEventHandler{

    private AppointmentState appointmentState;
    private LocalDateTime time;

    @ManyToOne
    @JoinColumn(name = "healthVisitorId")
    private HealthVisitor healthVisitor;

    @ManyToOne
    @JoinColumn(name = "patientId")
    private Patient patient;


    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public HealthVisitor getHealthVisitor() {
        return healthVisitor;
    }

    public void setHealthVisitor(HealthVisitor healthVisitor) {
        this.healthVisitor = healthVisitor;
        if (!healthVisitor.getAppointments().contains(this)) {
            healthVisitor.getAppointments().add(this);
        }
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
        if (!patient.getAppointments().contains(this)) {
            patient.getAppointments().add(this);
        }
    }

    public void setState(AppointmentState state){
        this.appointmentState = state;
    }

    @Override
    public void handleStateAction(Appointment appointment) {

    }
}
