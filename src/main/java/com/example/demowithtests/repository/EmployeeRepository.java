package com.example.demowithtests.repository;

import com.example.demowithtests.domain.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByName(String name);

    @NotNull
    Page<Employee> findAll(Pageable pageable);

    Page<Employee> findByCountryContaining(String country, Pageable pageable);

    //-- Мої методи --\\

    @Query(value = "select * from users join addresses on users.id = addresses.employee_id " +
            "where users.gender = :gender and addresses.country = :country", nativeQuery = true)
    List<Employee> findByGender(String gender, String country);

    @Query("select e from Employee e join e.addresses a where a.addressHasActive = true and a.country = :country")
    Page<Employee> findAllWhereIsActiveAddressByCountry(String country, Pageable pageable);

    List<Employee> queryEmployeeByIsVisibleIsNull();

    @Query(value = "select max(id) from users", nativeQuery = true)
    Integer findMaxEmployeeId();

}
