package com.project.mymusic.model;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Playlist {
@Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String name;
 private String description;
@ManyToMany()
 private List<Music> musics = new ArrayList<>();
public Playlist(String name, String description, List<Music> musics) {
 super();
 this.name = name;
 this.description = description;
 this.musics = musics;
 }
public Long getId() {
 return id;
 }
public void setId(Long id) {
 this.id = id;
 }
public String getName() {
 return name;
 }
public void setName(String name) {
 this.name = name;
 }
public String getDescription() {
 return description;
 }
public void setDescription(String description) {
 this.description = description;
 }
public List<Music> getMusics() {
 return musics;
 }
public void setMusics(List<Music> musics) {
 this.musics = musics;
 }
}