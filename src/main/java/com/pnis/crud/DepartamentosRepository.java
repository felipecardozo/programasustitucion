package com.pnis.crud;

import org.springframework.data.repository.CrudRepository;

import com.pnis.domain.Departamento;

public interface DepartamentosRepository extends CrudRepository<Departamento, Integer> {

}
