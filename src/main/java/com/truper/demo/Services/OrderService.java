package com.truper.demo.Services;

import com.truper.demo.Component.OrdenComponent;
import com.truper.demo.Dto.OrderDTO;
import com.truper.demo.Exception.OrdersException;
import com.truper.demo.Model.OrdenEntity;
import com.truper.demo.Repositories.OrderRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private final OrderRepositorie orderRepositorie;

    private final OrdenComponent ordenComponent;

    public OrderService(OrderRepositorie orderRepositorie, OrdenComponent ordenComponent) {
        this.orderRepositorie = orderRepositorie;
        this.ordenComponent = ordenComponent;
    }

    public String generateOrder(OrderDTO ordenDto){
        OrdenEntity order = ordenComponent.toEntity(ordenDto);
        orderRepositorie.save(order);
        return "Orden Registrada con exito";
    }

    public String updateOrder(OrderDTO ordenDto, Long id){
        OrdenEntity nuevaOrden = orderRepositorie.findById(id).get();
        nuevaOrden.setCodigo(ordenDto.getCodigo());
        nuevaOrden.setDescripcion(ordenDto.getDescripcion());
        nuevaOrden.setCodigo(ordenDto.getCodigo());
        orderRepositorie.save(nuevaOrden);
        return "Orden Actualizada con Exito";
    }

    public OrderDTO searchOrder(Long id) throws OrdersException {
        final Optional<OrdenEntity> ordenENcontrada = orderRepositorie.findById(id);
        if(ordenENcontrada.isEmpty()) {
            throw new OrdersException(404, "Orden con el id" +id +"no encontrado");
        }
        final OrdenEntity orden = ordenENcontrada.get();
        return new OrderDTO(orden.getId(), orden.getEstatus(), orden.getDescripcion(), orden.getCodigo());

    }

    public String updateStatus(OrderDTO orden, Long id) throws OrdersException {
        OrdenEntity nuevoStatus = orderRepositorie.findById(id).get();
        nuevoStatus.setEstatus(orden.getEstatus());
        orderRepositorie.save(nuevoStatus);
        return "Estatus actualizado";
    }
}
