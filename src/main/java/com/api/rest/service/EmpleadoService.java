package com.api.rest.service;


import com.api.rest.model.Empleado;
import com.api.rest.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;


    public Empleado guardarEmpleado(Empleado empleado){
        return empleadoRepository.save(empleado);
    }


    public List<Empleado> buscarTodosLosEmpleados(){
        return empleadoRepository.getAllEmpleados();
    }

    public Empleado actualizarEmpleado( Empleado empleado){
        return empleadoRepository.actualizar(empleado);
    }

    public String eliminarEmpleado(int id){
        empleadoRepository.eliminarEmpleado(id);
        return "empleado " + id + " eliminado";
    }

    public Empleado getEmpleadoPorEmail(String email){
        return empleadoRepository.listarEmpleadoPorEmail(email);
    }

    public Empleado getEmpleadoPorId(int id){
        return empleadoRepository.listarEmpleadoPorId(id);
    }

    public List<Empleado> obtenerEmpleadosPorSueldo(int sueldo){
        return empleadoRepository.listarEmpleadosPorSueldo(sueldo);

    }

    public List<Empleado> obtenerEmpledosPorExperiencia(int xp){
        return empleadoRepository.listarEmpleadosPorExperiencia(xp);
    }

}
