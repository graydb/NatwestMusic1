package com.project.mymusic.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.project.mymusic.model.Music;
import com.project.mymusic.service.MusicService;

@Controller

@RequestMapping("/musics")
public class MusicController {
	@Autowired
	private MusicService service;

	@GetMapping("/readAll")
    public ResponseEntity<List<Music>> getAll() {
        return new ResponseEntity<List<Music>>(this.service.searchAll(), HttpStatus.OK);
        
    }
    
    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Music> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<Music>(this.service.findById(id), HttpStatus.FOUND);
    }
    
    @PostMapping("/create")
    public ResponseEntity<Music> create(@RequestBody Music music) {
        return new ResponseEntity<Music>(this.service.create(music), HttpStatus.CREATED);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Music> update(@PathVariable("id") Long id, @RequestBody Music music) {
        return new ResponseEntity<Music>(this.service.update(id, music), HttpStatus.ACCEPTED);
    }
    
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return new ResponseEntity<Boolean>(this.service.delete(id), HttpStatus.NO_CONTENT);
    }
    
}
 
	
	
	
	
	
	
	
	
	