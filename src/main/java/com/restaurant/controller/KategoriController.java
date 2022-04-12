package com.restaurant.controller;

import com.restaurant.entity.Kategori;
import com.restaurant.exception.ResourceNotFoundException;
import com.restaurant.services.KategoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KategoriController {
    @Autowired
    private final KategoriService kategoriService;

    public KategoriController(KategoriService kategoriService) {
        this.kategoriService = kategoriService;
    }

    @PostMapping("/kategori")
    public Kategori Post(@RequestBody Kategori body){
        return kategoriService.Post(body);
    }

    @GetMapping("/kategori")
    public List<Kategori> Get(){
        return  kategoriService.Get();
    }

    @GetMapping("/kategori/{id}")
    public  Kategori Get(@PathVariable Integer id) throws ResourceNotFoundException{
        return kategoriService.Get(id);
    }

    @DeleteMapping("/kategori/{id}")
    public String Delete(@PathVariable Integer id){
        return kategoriService.Delete(id);
    }

    @PutMapping("/kategori/{id}")
    public Kategori Put(@RequestBody Kategori body, @PathVariable Integer id) throws ResourceNotFoundException{
        return kategoriService.Put(id, body);
    }


}
