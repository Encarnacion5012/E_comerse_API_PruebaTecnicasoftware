package com.pruebaTecnica.TodoCode.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CrudServicesInterface <Entidad,ID, RegistroDTO, ActualizacionDTO, EntidadDetallada>{

    Entidad registrar(RegistroDTO datos);
    Entidad actualizar(ActualizacionDTO datos, ID id);
    void eliminar(ID id);
    Entidad buscarPorId(ID id);
    Page<EntidadDetallada> listarTodos(Pageable pageable);


}

