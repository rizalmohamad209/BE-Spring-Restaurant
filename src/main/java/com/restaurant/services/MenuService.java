package com.restaurant.services;


import com.restaurant.entity.Menu;
import com.restaurant.exception.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MenuService {
    Menu Post(Menu body);
    List<Menu> Get();
    Menu Get(Integer id)throws ResourceNotFoundException;
    Menu Put(Menu body, Integer id) throws ResourceNotFoundException;
    String Delete(Integer id);
    List<Menu>GetMenuBySearch(String search);
}
