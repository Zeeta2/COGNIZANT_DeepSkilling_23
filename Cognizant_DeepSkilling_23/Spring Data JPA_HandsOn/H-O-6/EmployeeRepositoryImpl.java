package com.cognizant.ormlearn.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> searchEmployees(double salary, boolean permanent) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Employee> criteriaQuery =
                criteriaBuilder.createQuery(Employee.class);

        Root<Employee> root = criteriaQuery.from(Employee.class);

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(
                criteriaBuilder.greaterThanOrEqualTo(
                        root.get("salary"),
                        salary));

        predicates.add(
                criteriaBuilder.equal(
                        root.get("permanent"),
                        permanent));

        criteriaQuery.select(root)
                     .where(predicates.toArray(new Predicate[0]));

        TypedQuery<Employee> query =
                entityManager.createQuery(criteriaQuery);

        return query.getResultList();
    }
}