package com.restaurant.services;

import com.restaurant.entity.Kategori;
import com.restaurant.entity.Menu;
import com.restaurant.exception.ResourceNotFoundException;
import com.restaurant.repository.KategoriRepository;
import com.restaurant.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService{
    @Autowired
    private final MenuRepository menuRepository;
    private final KategoriRepository kategoriRepository;

    public MenuServiceImpl(MenuRepository menuRepository, KategoriRepository kategoriRepository) {
        this.menuRepository = menuRepository;
        this.kategoriRepository = kategoriRepository;
    }

    @Override
    public Menu Post(Menu body) {
        Optional<Kategori> optionalKategori = kategoriRepository.findById(body.getKategori().getId_kategori());
        body.setKategori(optionalKategori.get());
        return menuRepository.save(body);
    }

    @Override
    public List<Menu> Get() {
        return menuRepository.findAll();
    }

    @Override
    public Menu Get(Integer id)throws ResourceNotFoundException {
        return menuRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Couldn't find id menu with  id:"+id));
    }
    @Override
    public String Delete(Integer id) {
        menuRepository.deleteById(id);
        return "Menu with id "+id+ " Has Been Deleted";
    }

    @Override
    public List<Menu> GetMenuBySearch(String search) {
        return menuRepository.searchMenu(search);
    }

    @Override
    public Menu Put(Menu body, Integer id) throws ResourceNotFoundException {
        Menu menuOptional = menuRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Couldn't find id menu with id : "+id));

        Optional<Kategori> optionalKategori= kategoriRepository.findById(body.getKategori().getId_kategori());

        menuOptional.setKategori(optionalKategori.get());
        menuOptional.setHarga_menu(body.getHarga_menu());
        menuOptional.setNama_menu(body.getNama_menu());
        menuOptional.setStock_menu(body.getStock_menu());
        menuOptional.setVariasi(body.getVariasi());
        return menuRepository.save(menuOptional);
    }


}


