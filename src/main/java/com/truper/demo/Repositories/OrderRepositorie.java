package com.truper.demo.Repositories;

import com.truper.demo.Dto.OrderDTO;
import com.truper.demo.Model.OrdenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepositorie extends CrudRepository<OrdenEntity, Long>, JpaRepository <OrdenEntity, Long> {
}
