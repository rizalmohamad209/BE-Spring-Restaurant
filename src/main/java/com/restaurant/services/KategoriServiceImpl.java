package com.restaurant.services;

import com.restaurant.entity.Kategori;
import com.restaurant.exception.ResourceNotFoundException;
import com.restaurant.repository.KategoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KategoriServiceImpl implements KategoriService{
    @Autowired
    private final KategoriRepository kategoriRepo;

    public KategoriServiceImpl(KategoriRepository kategoriRepo) {
        this.kategoriRepo = kategoriRepo;
    }

    @Override
    public Kategori Post(Kategori body) {
        kategoriRepo.save(body);
        return  body;
    }

    @Override
    public Kategori Put(Integer id, Kategori body) throws ResourceNotFoundException{
        Kategori optional = kategoriRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Coildn't find a kategori with id:"+ id));
        optional.setNama_kategori(body.getNama_kategori());


        return kategoriRepo.save(optional);
    }

    @Override
    public List<Kategori> Get() {
        return kategoriRepo.findAll();
    }

    @Override
    public String Delete(Integer id) {
        kategoriRepo.deleteById(id);
        return "Kategori id "+ id+" has been deleted";
    }

    @Override
    public Kategori Get(Integer id) throws ResourceNotFoundException {
        return  kategoriRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Couldn't find kategori with id: "+id));
    }
}
