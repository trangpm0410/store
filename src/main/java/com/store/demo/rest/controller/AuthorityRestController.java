package com.store.demo.rest.controller;

import com.store.demo.entity.Authority;
import com.store.demo.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/authorities")
public class AuthorityRestController {

    @Autowired
    AuthorityService authorityService;

//    @GetMapping
//    public List<Authority> findAll(@RequestParam("admin") Optional<Boolean> admin){
//        if(admin.orElse(false)){
//            return authorityService.findAuthoritiesOfAdministrators();
//        }
//        return authorityService.findAll();
//    }

    @GetMapping
    public List<Authority> find(@RequestParam("admin") Optional<Boolean> admin) {
        if (admin.orElse(false)) {
            return authorityService.findAuthoritiesOfAdministrators();
        }
        return authorityService.findAll();
    }

    @PostMapping
    public Authority post(@RequestBody Authority authority){
        return authorityService.store(authority);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        authorityService.deleteById(id);
    }

}
