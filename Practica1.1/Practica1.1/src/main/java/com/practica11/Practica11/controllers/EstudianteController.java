package com.practica11.Practica11.controllers;


import com.practica11.Practica11.models.Estudiante;
import com.practica11.Practica11.services.EstudianteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {
    @Autowired
    private EstudianteServices estudianteServices;

    @GetMapping
    public ArrayList<Estudiante> getEstudiantes() {
        return this.estudianteServices.getEstudiantes();
    }

    @PostMapping
    public Estudiante guardarEstudiante(@RequestBody Estudiante estudiante) {
        return this.estudianteServices.guardarEstudiante(estudiante);
    }

    @GetMapping(path = "/{cedula}")
    public Optional<Estudiante> getByCedula(@PathVariable("cedula") String cedula) {
        return this.estudianteServices.getByCedula(cedula);
    }

    @PutMapping(path = "/{cedula}")
    public Estudiante editarEstudiante(@RequestBody Estudiante request, String cedula) {
        return this.editarEstudiante(request, cedula);
    }

    @DeleteMapping(path = "/{cedula}")
    public String delete(@PathVariable("cedula") String cedula) {
        boolean ok = this.estudianteServices.delete(cedula);

        if(ok){
            return "Estudiante con cedula" + cedula + "eliminado";
        } else {
            return "Error al eliminar";
        }

    }

}









