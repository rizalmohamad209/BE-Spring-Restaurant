package com.restaurant.services;


import com.restaurant.entity.Kategori;
import com.restaurant.exception.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface KategoriService{
    Kategori Post(Kategori body);
    Kategori Put(Integer id, Kategori body) throws ResourceNotFoundException;
    List<Kategori> Get();
    String Delete(Integer id);
    Kategori Get(Integer id) throws ResourceNotFoundException;
}
