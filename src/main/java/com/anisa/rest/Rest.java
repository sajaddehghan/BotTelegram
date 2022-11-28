package com.anisa.rest;


import com.anisa.Car;
import com.anisa.TileProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class Rest {
    public static final String SERVER_URI = "http://localhost:8080";

    public Set<TileProduct> SearchCarpet(){
        RestTemplate restTemplate = new RestTemplate();
        List<TileProduct> tiles = (List<TileProduct>) restTemplate.getForObject(SERVER_URI+"/telegram-bot", List.class);
        Set<TileProduct> tileProductSet=new HashSet<TileProduct>(tiles);
        for (TileProduct tile:tileProductSet) {
            System.out.println(tile.getClass().getName());
        }
        System.out.println();
        return tileProductSet;
    }
}
