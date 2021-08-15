package com.DigitalStore.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.DigitalStore.Model.MoviesCollection;

@Repository
public interface MoviesRepository extends MongoRepository<MoviesCollection, String> {
	public List<MoviesCollection> findByName(String name);
	public List<MoviesCollection> findAllByIsFeature(int featured);
	public void deleteByName(String name);
	public Optional<MoviesCollection> getMoviesById(String id);
}
