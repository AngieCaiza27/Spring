package com.practica11.Practica11.repositories;

import com.practica11.Practica11.models.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// Clase que permite hacer consultas a una base de datos
@Repository
public interface IEstudianteRepository extends JpaRepository<Estudiante,String> {


}
