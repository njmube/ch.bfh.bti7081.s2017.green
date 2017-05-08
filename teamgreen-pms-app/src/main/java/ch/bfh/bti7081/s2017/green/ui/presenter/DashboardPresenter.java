package ch.bfh.bti7081.s2017.green.ui.presenter;

import ch.bfh.bti7081.s2017.green.ui.model.Dashboard;
import ch.bfh.bti7081.s2017.green.ui.view.component.myDay.MyDayView;
import ch.bfh.bti7081.s2017.green.ui.view.component.myDay.MyDayViewListener;
import org.springframework.beans.factory.annotation.Autowired;

public class DashboardPresenter implements MyDayViewListener {

    Dashboard dashboard;

    MyDayView dashboardView;

    @Autowired
    public DashboardPresenter(Dashboard dashboard, MyDayView dashboardView) {
        this.dashboard = dashboard;
        this.dashboardView = dashboardView;

        dashboardView.addListener(this);

    }

    @Override
    public void doSearch() {

    }

    @Override
    public void setAlarm() {

    }

    @Override
    public void showPatientDetails() {

    }

    @Override
    public void showMedication() {

    }
}
