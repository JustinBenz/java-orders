package com.lambdaschool.javaorders.repositories;

import com.lambdaschool.javaorders.models.Customer;
import com.lambdaschool.javaorders.views.CustomerOrderNum;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomersRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByCustnameContainingIgnoringCase(String subname);

    @Query(value = " SELECT c.custname, count(o.ordnum) AS orderCount " +
            " FROM customers c LEFT JOIN orders " +
            " ON c.custcode = o.custcode " +
            " GROUP BY c.custname " +
            " ORDER BY count(o.ordnum)", nativeQuery = true)
    List<CustomerOrderNum> getCustomerOrdNums();
}
