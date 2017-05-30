package ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentState;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;

/**
 * Interface for Handling the Appointment State Events
 * @author schms27
 */
public interface AppointmentStateEventHandler {

    //Event to get called when the State on the appointment has been set/changed
    void onStateSet(AppointmentBean appointmentBean);
}
