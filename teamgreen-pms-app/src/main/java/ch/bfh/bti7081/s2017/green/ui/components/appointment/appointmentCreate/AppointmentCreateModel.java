package ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentCreate;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.AppointmentStateTypeBean;
import ch.bfh.bti7081.s2017.green.bean.HealthVisitorBean;
import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import ch.bfh.bti7081.s2017.green.service.AppointmentService;
import ch.bfh.bti7081.s2017.green.service.AppointmentStateTypeService;
import ch.bfh.bti7081.s2017.green.service.HealthVisitorService;
import ch.bfh.bti7081.s2017.green.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;


@Transactional
@Component
public class AppointmentCreateModel {

    private AppointmentService appointmentService;

    private PatientService patientService;

    private AppointmentStateTypeService appointmentStateTypeService;

    private HealthVisitorService healthVisitorService;

    @Autowired
    public AppointmentCreateModel(AppointmentService appointmentService, PatientService patientService, AppointmentStateTypeService appointmentStateTypeService, HealthVisitorService healthVisitorService) {
        this.appointmentService = appointmentService;
        this.patientService = patientService;
        this.appointmentStateTypeService = appointmentStateTypeService;
        this.healthVisitorService = healthVisitorService;
    }


    /**
     * Returns the Appointment which will be displayed
     * @param appId the appointment id
     * @return the found {@link AppointmentBean} or <code>null</code> if appointment could not be found
     */
    public AppointmentBean getAppointment(long appId) {
        return appointmentService.getOne(appId);
    }

    /**
     * Returns all available patients
     * @return the set of patients
     */
    public Set<PatientBean> getAllPatients() {
        return patientService.getAll();
    }

    /**
     * Returns all available appointment state types
     * @return the set of types
     */
    public Set<AppointmentStateTypeBean> getAllAppointmentStateTypes() {
        return appointmentStateTypeService.getAll();
    }

    /**
     * Persists the {@link AppointmentBean}
     * @param appointmentBean the {@link AppointmentBean} to persist
     */
    public void saveAppointment(AppointmentBean appointmentBean) {
        appointmentService.save(appointmentBean);
    }

    /**
     * Returns the HealthVisitor for the given Id
     * @param healthVisitorId
     * @return the found {@link HealthVisitorBean} or <code>null</code> if healthVisitorBean could not be found
     */
    public HealthVisitorBean getHealthVisitor(long healthVisitorId){
        return healthVisitorService.getOne(healthVisitorId);
    }

    /**
     * Returns the AppointmentStateTypeBean for the given Id
     * @param appointmentStateTypeId
     * @return the found {@link AppointmentStateTypeBean} or <code>null</code> if AppointmentStateTypeBean could not be found
     */
    public AppointmentStateTypeBean getAppointmentStateType(long appointmentStateTypeId){
        return appointmentStateTypeService.getOne(appointmentStateTypeId);
    }
}
