package com.project.mymusic.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.mymusic.model.Music;
import com.project.mymusic.repository.MusicRepository;

@Service
public class MusicService {
	@Autowired
	private MusicRepository repo;

	public List<Music> searchAll() {
		return this.repo.findAll();
	}

	public Music findById(Long id) {
		Optional<Music> obj = this.repo.findById(id);
		return obj.orElseThrow();
	}

	public Music create(Music obj) {
		return this.repo.save(obj);
	}

	
	public Music update(Long id, Music obj) {
		this.findById(id);
		return this.repo.save(obj);
	}

	public boolean delete(Long id) {
		
	
		this.repo.deleteById(id);
	
	boolean exists = this.repo.existsById(id);
	return !exists;
	}
}
