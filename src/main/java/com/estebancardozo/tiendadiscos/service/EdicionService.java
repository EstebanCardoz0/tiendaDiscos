package com.estebancardozo.tiendadiscos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.estebancardozo.tiendadiscos.entity.Edicion;
import com.estebancardozo.tiendadiscos.repository.EdicionRepository;

@Service 
public class EdicionService {


    private final EdicionRepository edicionRepo;

    public EdicionService (EdicionRepository edicionRepository){
        this.edicionRepo=edicionRepository;
    }

    public List <Edicion> findAll(){
        
    }
    
}
