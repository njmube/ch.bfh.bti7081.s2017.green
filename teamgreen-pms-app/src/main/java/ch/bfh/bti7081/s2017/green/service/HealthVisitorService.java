package ch.bfh.bti7081.s2017.green.service;

import ch.bfh.bti7081.s2017.green.bean.HealthVisitorBean;
import ch.bfh.bti7081.s2017.green.domain.HealthVisitor;

import java.util.Set;

public interface HealthVisitorService {

    Set<HealthVisitorBean> getAll();

    HealthVisitorBean getOne(long healthVisitorId);

    Set<HealthVisitorBean> find(String lastName);

    long save(HealthVisitorBean healthVisitor);

    void delete(HealthVisitorBean healthVisitor);

}