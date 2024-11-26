package com.practica11.Practica11.services;

import com.practica11.Practica11.models.Estudiante;
import com.practica11.Practica11.repositories.IEstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EstudianteServices {

    @Autowired//inyecion de dependencias
    IEstudianteRepository estudianteRepository;

    public ArrayList<Estudiante> getEstudiantes(){
        return (ArrayList<Estudiante>) estudianteRepository.findAll();
    }

    public Estudiante guardarEstudiante(Estudiante estudiante){
        return estudianteRepository.save(estudiante);
    }

    public Optional<Estudiante> getByCedula(String cedula){
        //puede devolver algo o un null
        return estudianteRepository.findById(cedula);
    }

    public Estudiante editarEstudiante(Estudiante request, String cedula){
        Estudiante est= estudianteRepository.findById(cedula).get();
        est.setNombre(request.getNombre());
        est.setApellido(request.getApellido());
        est.setDireccion(request.getDireccion());
        est.setTelefono(request.getTelefono());

        return est;
    }

    public Boolean delete(String cedula){
        try {
            estudianteRepository.deleteById(cedula);
            return true;

        }catch (Exception e){
            return false;
        }
    }





}
