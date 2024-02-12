package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.validation.ZooValidation;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kangaroos")
public class KangarooController {
    private Map<Integer, Kangaroo> kangaroos;

    @PostConstruct
    public void init(){
        kangaroos=new HashMap<>();
    }
    @GetMapping
    public List<Kangaroo> getKangaroos(){
        return new ArrayList<>(kangaroos.values());
    }
    @GetMapping("/{id}")
    public Kangaroo getKangarooById(@PathVariable Integer id){
        ZooValidation.isIdValid(id);
        ZooValidation.checkIsKangarooExist(kangaroos,id,true);
        return kangaroos.get(id);
    }
    @PostMapping
    public Kangaroo addKangarooToList(@RequestBody Kangaroo kangaroo){
        ZooValidation.checkIsKangarooExist(kangaroos, kangaroo.getId(), false);
        kangaroos.put(kangaroo.getId(),kangaroo);
        return kangaroos.get(kangaroo.getId());
    }
    @PutMapping("/{id}")
    public Kangaroo updateKangaroo(@PathVariable Integer id,@RequestBody Kangaroo kangaroo){
        ZooValidation.isIdValid(id);
        ZooValidation.checkIsKangarooExist(kangaroos,id,true);
        kangaroos.put(id,kangaroo);
        return kangaroos.get(id);
    }
    @DeleteMapping("/{id}")
    public Kangaroo deleteKangaroo(@PathVariable Integer id){
        ZooValidation.isIdValid(id);
        ZooValidation.checkIsKangarooExist(kangaroos, id,true);
        Kangaroo deletedKangaroo=kangaroos.get(id);
        kangaroos.remove(id);
        return deletedKangaroo;
    }

}
