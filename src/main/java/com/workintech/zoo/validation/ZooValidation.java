package com.workintech.zoo.validation;

import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.entity.Koala;
import com.workintech.zoo.exceptions.ZooException;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class ZooValidation {
    public static void isIdValid(Integer id){
        if(id==null||id<0){
            throw new ZooException("Id cannot be null or less than zero. Id: "+id, HttpStatus.BAD_REQUEST);
        }
    }

    public static void checkIsKoalaExist(Map<Integer, Koala> koalas, Integer id, boolean isExist){
        if(isExist){
            if (!koalas.containsKey(id)) {

                throw new ZooException("Koala with id "+id+" is not exist",HttpStatus.NOT_FOUND);
            }
        }else if(koalas.containsKey(id)){
            throw new ZooException("Koala with id "+id+" is already exist",HttpStatus.BAD_REQUEST);
        }
    }
    public static void checkIsKangarooExist(Map<Integer, Kangaroo> kangaroos, Integer id, boolean isExist){
        if(isExist){
            if (!kangaroos.containsKey(id)) {

                throw new ZooException("Kangaroo with id "+id+" is not exist",HttpStatus.NOT_FOUND);
            }
            }else if(kangaroos.containsKey(id)){
            throw new ZooException("Kangaroo with id "+id+" is already exist",HttpStatus.BAD_REQUEST);
        }
    }


}
