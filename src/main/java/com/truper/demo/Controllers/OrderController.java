package com.truper.demo.Controllers;

import com.truper.demo.Dto.OrderDTO;
import com.truper.demo.Model.OrdenEntity;
import com.truper.demo.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/buscar/{id}")
    public ResponseEntity<OrderDTO> buscar(@PathVariable ("id") Long id){
        try {
            return ResponseEntity.ok(this.orderService.searchOrder(id));
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<String> save(@RequestBody OrderDTO orden){
        return ResponseEntity.ok(this.orderService.generateOrder(orden));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String>update(@RequestBody OrderDTO orden,
                                             @PathVariable ("id") Long id){
        return ResponseEntity.ok(this.orderService.updateOrder(orden, id));
    }
    @PutMapping("/actualizar/status/{id}")
    public ResponseEntity<String>updateStatus(@RequestBody OrderDTO orden,
                                                   @PathVariable ("id") Long id) throws com.truper.demo.Exception.Exception {
        return ResponseEntity.ok(this.orderService.updateStatus(orden, id));
    }
}
