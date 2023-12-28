package com.api.rest.controller;


import com.api.rest.model.Empleado;
import com.api.rest.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping
    public  Empleado guardarEmpleado(@RequestBody Empleado empleado){
        return empleadoService.guardarEmpleado(empleado);
    }

    @GetMapping
    public List<Empleado> listarEmpleados(){
        return empleadoService.buscarTodosLosEmpleados();
    }

    @PutMapping
    public Empleado actualizarEmpleado(@RequestBody Empleado empleado){
        return empleadoService.actualizarEmpleado(empleado);
    }

    @DeleteMapping("/{id}")
    public String eliminarEmpleado(@PathVariable int id){
        return empleadoService.eliminarEmpleado(id);
    }

    @GetMapping("/email/{email}")
    public Empleado obtenerEmpleadoPorEmail(@PathVariable String email){
        return empleadoService.getEmpleadoPorEmail(email);
    }

    @GetMapping("/id/{id}")
    public Empleado obtenerEmpleadoPorId(@PathVariable int id){
        return empleadoService.getEmpleadoPorId(id);
    }


    @GetMapping("/sueldo/{sueldo}")
    public List<Empleado> obtenerEmpleadosPorSueldo(@PathVariable int sueldo){
        return empleadoService.obtenerEmpleadosPorSueldo(sueldo);

    }

    @GetMapping("/experiencia/{xp}")
    public List<Empleado> obtenerEmpleadosPorXp(@PathVariable int xp){
        return empleadoService.obtenerEmpledosPorExperiencia(xp);
    }


}
