package com.truper.demo.Component;

import com.truper.demo.Dto.OrderDTO;
import com.truper.demo.Model.OrdenEntity;
import org.springframework.stereotype.Component;

@Component
public class OrdenComponent {

    public OrdenEntity toEntity(OrderDTO orderDTO){
        return OrdenEntity.builder()
                .id(orderDTO.getId())
                .estatus(orderDTO.getEstatus())
                .descripcion(orderDTO.getDescripcion())
                .codigo(orderDTO.getCodigo())
                .build();
    }
}
