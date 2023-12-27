package com.api.rest.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloController {

    @RequestMapping
    public String mostrarMensaje() {
        return "¡Bienvenido a mi API! ingresa  /suma /resta /multiplicacion o /division seguido de dos cifras  '/10/2' para usar las operaciones matematicas o calcula el numero no decimal mayor con '/mayor'";
    }

    @GetMapping("/hello")
    public String saludar(){
        return "Hola mundo con Spring boot.";
    }

    @GetMapping("/suma/{cifra}/{cifraDos}")
    public String sumar(@PathVariable int cifra, @PathVariable int cifraDos){
        int sumar = cifra + cifraDos;
        String mensaje =  "la resta es :  " + sumar;
        return  mensaje;
    }

    @GetMapping("/resta/{cifra}/{cifraDos}")
    public String resta(@PathVariable int cifra, @PathVariable int cifraDos){
        int resta = cifra - cifraDos;
        String mensaje =  "la resta es :  " + resta;
        return  mensaje;
    }

    @GetMapping("/multiplicacion/{cifra}/{cifraDos}")
    public String multiplicacion(@PathVariable int cifra, @PathVariable int cifraDos){

        int multiplicacion = cifra * cifraDos;
        String mensaje =  "la multiplicacion es :  " + multiplicacion;
        return  mensaje;
    }

    @GetMapping("/division/{cifra}/{cifraDos}")
    public String division(@PathVariable int cifra, @PathVariable int cifraDos){
        int division = cifra / cifraDos;
        String mensaje =  "la division es :  " + division;
        return  mensaje;
    }

    @GetMapping("/mayor/{cifra}/{cifraDos}")
    public String mayor(@PathVariable int cifra, @PathVariable int cifraDos){

        int max = 0;
        max = cifra > cifraDos ? cifra : cifraDos;
        String mensaje =  "la cifra mayor es :  " + max;
        return  mensaje;
    }


}
