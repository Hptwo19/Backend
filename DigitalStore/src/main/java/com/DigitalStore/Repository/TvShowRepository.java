package com.DigitalStore.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.DigitalStore.Model.TvShowCollection;

@Repository
public interface TvShowRepository extends MongoRepository<TvShowCollection, String> {
	public List<TvShowCollection> findByName(String name);
	public List<TvShowCollection> findAllByIsFeatured(int isFeatured);
	public void deleteByName(String name);
	public Optional<TvShowCollection> getTvShowById(String id);
}
