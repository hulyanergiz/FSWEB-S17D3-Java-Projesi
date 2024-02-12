package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Koala;
import com.workintech.zoo.validation.ZooValidation;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/koalas")
public class KoalaController {
    private Map<Integer, Koala> koalas;

    @PostConstruct
    public void init(){
        koalas=new HashMap<>();
    }

    @GetMapping
    public List<Koala> getKoalas(){
        return new ArrayList<>(koalas.values());
    }
    @GetMapping("/{id}")
    public Koala getKoalaById(@PathVariable Integer id){
        ZooValidation.isIdValid(id);
        ZooValidation.checkIsKoalaExist(koalas,id,true);
        return koalas.get(id);
    }
    @PostMapping
    public Koala addKoalaToList(@RequestBody Koala koala){
        ZooValidation.checkIsKoalaExist(koalas, koala.getId(), false);
        koalas.put(koala.getId(), koala);
        return koalas.get(koala.getId());
    }
    @PutMapping("/{id}")
    public Koala updateKoala(@PathVariable Integer id,Koala koala){
        ZooValidation.isIdValid(id);
        ZooValidation.checkIsKoalaExist(koalas,id,true);
        koalas.put(id,koala);
        return koalas.get(id);
    }
    @DeleteMapping("/{id}")
    public Koala deleteKoala(@PathVariable Integer id){
        ZooValidation.isIdValid(id);
        ZooValidation.checkIsKoalaExist(koalas,id,true);
        Koala deletedKoala=koalas.get(id);
        koalas.remove(id);
        return deletedKoala;
    }

}
