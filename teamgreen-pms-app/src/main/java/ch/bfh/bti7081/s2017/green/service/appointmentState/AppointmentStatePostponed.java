package ch.bfh.bti7081.s2017.green.service.appointmentState;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.AppointmentStateTypeBean;
import ch.bfh.bti7081.s2017.green.service.AppointmentService;
import ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentDetail.AppointmentDetailPresenter;
import com.vaadin.server.Page;
import com.vaadin.shared.Position;
import com.vaadin.ui.Notification;

/**
 * This Class represents the State of the Appointment, when its date (to, from) has been changed
 * @author schms27
 */
public class AppointmentStatePostponed extends AppointmentState {

    @Override
    public void afterStateSet(AppointmentBean appointmentBean, AppointmentBean oldAppointment, AppointmentDetailPresenter presenter) {
        presenter.updateStateButtons(true,"Confirm Appointment",true,"Cancel Appointment");
    }

    @Override
    public void onStateSet(AppointmentBean appointmentBean, AppointmentService service, AppointmentBean oldAppointment) {
        Notification notif = new Notification(
                "Appointment # " + appointmentBean.getId() + " has been postponed, please confirm new Date"
        );
        notif.setDelayMsec(5000);
        notif.setPosition(Position.BOTTOM_CENTER);
        notif.show(Page.getCurrent());
    }

    @Override
    public void confirm(AppointmentBean appointmentBean, AppointmentDetailPresenter presenter) {
        //Get new AppointmentStateTypeBean 'CONFIRMED'
        AppointmentStateTypeBean type = presenter.getAppointmentStateTypeBean(4);
        type.setAppointmentState(new AppointmentStateConfirmed());
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
