package com.restaurant.controller;

import com.restaurant.entity.Menu;
import com.restaurant.exception.ResourceNotFoundException;
import com.restaurant.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class MenuController {
    @Autowired
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping("/menu")
    public Menu Post(@RequestBody Menu body){
        return menuService.Post(body);
    }

    @GetMapping("/menu")
    public List<Menu> Get(@RequestParam(value = "search", required = false) String search){
        if(search.isEmpty()){
            return  menuService.Get();
        }else{
            return  menuService.GetMenuBySearch(search);
        }
    }

    @GetMapping("/menu/{id}")
    public Menu Get(@PathVariable Integer id) throws ResourceNotFoundException {
        return menuService.Get(id);
    }

    @DeleteMapping("/menu/{id}")
    public String Delete(@PathVariable Integer id){
        return menuService.Delete(id);
    }


    @PutMapping("/menu/{id}")
    public Menu Put(@PathVariable Integer id,@RequestBody Menu body) throws ResourceNotFoundException{
        return menuService.Put(body, id);


    }
}
