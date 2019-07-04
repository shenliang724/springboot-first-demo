package com.oyo.shen.web;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class curdtestcontroller {

    String person ;

    @PostMapping("/add")
    public  String add(String name){

           person = name;

           return  "helllo.".concat(person);

       }


    @DeleteMapping("/delete")
    public  int delete(){

        person = null;

        return  1;

    }

    @GetMapping("/search" )
    public String search(){


        return  person;

    }

    @RequestMapping("/search")
    public String replace(){


        return  person;

    }

}
