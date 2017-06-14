package ch.bfh.bti7081.s2017.green.service.appointmentState;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.AppointmentStateTypeBean;
import ch.bfh.bti7081.s2017.green.service.AppointmentService;
import ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentDetail.AppointmentDetailPresenter;
import com.vaadin.ui.Notification;


/**
 * This Class represents the State of a confirmed Appointment
 * @author schms27
 */
public class AppointmentStateConfirmed extends AppointmentState {

    @Override
    public void afterStateSet(AppointmentBean appointmentBean, AppointmentBean oldAppointment, AppointmentDetailPresenter presenter) {
        presenter.updateStateButtons(true,"Finish Appointment",true,"Cancel Appointment");
    }

    @Override
    public void onStateSet(AppointmentBean appointmentBean, AppointmentService service, AppointmentBean oldAppointment) {
       Notification.show("State Confirmed has been set");
    }

    @Override
    public void confirm(AppointmentBean appointmentBean, AppointmentDetailPresenter presenter) {
        //Get new AppointmentStateTypeBean 'FINISHED'
        AppointmentStateTypeBean type = presenter.getAppointmentStateTypeBean(5);
        type.setAppointmentState(new AppointmentStateFinished());
        appointmentBean.setAppointmentStateType(type);
    }

    @Override
    public void remove(AppointmentBean appointmentBean, AppointmentDetailPresenter presenter) {
        //Get new AppointmentStateTypeBean 'CANCELLED'
        AppointmentStateTypeBean type = presenter.getAppointmentStateTypeBean(3);
        type.setAppointmentState(new AppointmentStateCancelled());
        appointmentBean.setAppointmentStateType(type);
    }
}
