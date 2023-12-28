package com.api.rest.repository;

import com.api.rest.model.Empleado;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class EmpleadoRepository {

    private List<Empleado> empleados = new ArrayList<>();
    public void createEmpleados(){
        empleados.addAll(List.of(
                new Empleado(1, "Dylan","Vallejo",25, 1000, "dylan@gmail.com", 1, 12341234),
                new Empleado(2, "Jonathan","Sanchez",28, 2000, "jh@gmail.com", 1, 12341234),
                new Empleado(3, "Brayam","Chuchuca",25, 3000, "br@gmail.com", 3, 1234221),
                new Empleado(4, "Brayan","Cuenca",29, 4000, "brm@gmail.com", 6, 23444123)
        ));
    }

    public EmpleadoRepository(){
        createEmpleados();
    }


    public Empleado save(Empleado empleado){
        Empleado empleadoNuevo = new Empleado();

        empleadoNuevo.setId(empleado.getId());
        empleadoNuevo.setNombre(empleado.getNombre());
        empleadoNuevo.setApellido(empleado.getApellido());
        empleadoNuevo.setEdad(empleado.getEdad());
        empleadoNuevo.setSueldo(empleado.getSueldo());
        empleadoNuevo.setEmail(empleado.getEmail());
        empleadoNuevo.setAnios_experiencia(empleado.getAnios_experiencia());
        empleadoNuevo.setTelefono(empleado.getTelefono());

        empleados.add(empleadoNuevo);
        return empleadoNuevo;
    }

    public List<Empleado> getAllEmpleados(){
        return empleados;
    }


    public Empleado actualizar(Empleado empleado){


        int idPos = 0;
        int id = 0;


        for(int i =0; i <empleados.size(); i++){
            if (empleados.get(i).getId() == empleado.getId()){
                id = empleado.getId();
                idPos = i;
                break;
            }
        }

        Empleado empleadoActualizado = new Empleado();
        empleadoActualizado.setId(id);
        empleadoActualizado.setNombre(empleado.getNombre());
        empleadoActualizado.setApellido(empleado.getApellido());
        empleadoActualizado.setEdad(empleado.getEdad());
        empleadoActualizado.setSueldo(empleado.getSueldo());
        empleadoActualizado.setEmail(empleado.getEmail());
        empleadoActualizado.setAnios_experiencia(empleado.getAnios_experiencia());
        empleadoActualizado.setTelefono(empleado.getTelefono());

        empleados.set(idPos, empleadoActualizado);

        return empleadoActualizado;
    }


    public String eliminarEmpleado(int id){
        empleados.removeIf(x ->x.getId() == id);
        return null;
    }


    public Empleado listarEmpleadoPorEmail(String email){

        return empleados.stream()
                .filter(x-> x.getEmail().startsWith(email))
                .findFirst()
                .orElse(null);

    }

    public Empleado listarEmpleadoPorId(int id){
        for(int i = 0; i < empleados.size(); i++){
            if(empleados.get(i).getId() == id ){
                return empleados.get(i);
            }
        }
        return null;
    }


    public List<Empleado> listarEmpleadosPorSueldo(int sueldo){
        return empleados.stream()
                .filter(x -> x.getSueldo() >= sueldo)
                .collect(Collectors.toList());
    }

    public List<Empleado> listarEmpleadosPorExperiencia(int anios){
        return empleados.stream()
                .filter(x-> x.getAnios_experiencia() >= anios)
                .collect(Collectors.toList());
    }

}
