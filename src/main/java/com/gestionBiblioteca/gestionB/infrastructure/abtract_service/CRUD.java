package com.gestionBiblioteca.gestionB.infrastructure.abtract_service;

import com.gestionBiblioteca.gestionB.utils.enums.SortType;
import org.springframework.data.domain.Page;

public interface CRUD <RQ, RS, ID>{

    public RS create(RQ request);

    public RS get(ID id);

    public RS update(RQ request, ID id);

    public void delete(ID id);

    public Page<RS> getAll(int page, int size, SortType sortType);

}