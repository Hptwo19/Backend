package com.DigitalStore.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.DigitalStore.Model.Customer;
import com.DigitalStore.Model.MoviesCollection;
import com.DigitalStore.Model.TvShowCollection;
import com.DigitalStore.Repository.CustomerRepository;
import com.DigitalStore.Repository.MoviesRepository;
import com.DigitalStore.Repository.TvShowRepository;

@RestController
@CrossOrigin(origins = "*")
public class Controller {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	MoviesRepository moviesRepository;

	@Autowired
	TvShowRepository tvShowRepository;
	
	
	@PostMapping("/signIn")
	public String signIn(@ModelAttribute String data)
	{
		return "suceess!!";
		
	}
	
	

	@RequestMapping(value = "/customers/{firstName}", method = RequestMethod.GET)
	public Map<String, Object> getCustomers(@PathVariable String firstName) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<Customer> customersList = null;
		customersList = customerRepository.findByFirstName(firstName);

		if (!customersList.isEmpty()) {
			map.put("customersList", customersList);
		} else {
			map.put("Error", "No records are found!");
		}

		return map;
	}

	// insert customer

	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json")
	public Map<String, Object> registerCustomer(@RequestBody String reqData) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			JSONObject jsonObject = new JSONObject(reqData);

			String email = jsonObject.getString("email");
			String firstName = jsonObject.getString("firstName");
			String lastName = jsonObject.getString("lastName");
			String password = jsonObject.getString("password");

			Customer customer = new Customer();
			customer.setEmail(email);
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setPassword(password);

			customerRepository.save(customer);
			map.put("success", "customer saved successfully!");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	// insert movies

	@RequestMapping(value = "/insertMovies", method = RequestMethod.POST, produces = "application/json")
	@CrossOrigin
	public Map<String, Object> insertMovies(@RequestBody String reqData) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			JSONObject jsonObject = new JSONObject(reqData);

			String name = jsonObject.getString("name");
			String Price = jsonObject.getString("Price");
			String rent = jsonObject.getString("rent");
			String Description = jsonObject.getString("Description");
			String image_path = jsonObject.getString("image_path");
			String cover_path = jsonObject.getString("cover_path");
			String purchase = jsonObject.getString("purchase");
			String isFeatured = jsonObject.getString("isFeatured");

			MoviesCollection moviesCollection = new MoviesCollection();

			moviesCollection.setName(name);
			moviesCollection.setPrice(Price);
			moviesCollection.setRent(rent);
			moviesCollection.setdescription(Description);
			moviesCollection.setImage_path(image_path);
			moviesCollection.setCover_path(cover_path);
			moviesCollection.setPurchase(purchase);
			moviesCollection.setIsFeatured(isFeatured);

			moviesRepository.save(moviesCollection);
			map.put("success", "Movie saved successfully!");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	// insert tvshows

	@RequestMapping(value = "/insertTvShow", method = RequestMethod.POST, produces = "application/json")
	@CrossOrigin
	public Map<String, Object> insertTvShow(@RequestBody String reqData) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			JSONObject jsonObject = new JSONObject(reqData);

			String name = jsonObject.getString("name");
			String price = jsonObject.getString("price");
			String rent = jsonObject.getString("rent");
			String description = jsonObject.getString("description");
			String image_path = jsonObject.getString("image_path");
			String cover_path = jsonObject.getString("cover_path");
			String buy = jsonObject.getString("buy");
			String isFeatured = jsonObject.getString("isFeatured");

			TvShowCollection tvShow = new TvShowCollection();

			tvShow.setName(name);
			tvShow.setPrice(price);
			tvShow.setRent(rent);
			tvShow.setDescription(description);
			tvShow.setImage_path(image_path);
			tvShow.setCover_path(cover_path);
			tvShow.setBuy(buy);
			tvShow.setIsFeatured(isFeatured);

			tvShowRepository.save(tvShow);
			map.put("success", "Tv show saved successfully!");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	// retrieves all movies

	@RequestMapping(value = "/retrieveAllMovies", method = RequestMethod.GET)
	public Map<String, Object> retrieveAllMovies() {
		Map<String, Object> map = new HashMap<String, Object>();

		List<MoviesCollection> movies = null;
		movies = moviesRepository.findAll();

		if (!movies.isEmpty()) {
			map.put("Movies", movies);
		} else {
			map.put("Error", "No movies found!");
		}
		return map;
	}

	// retrieves all Tv shows

	@RequestMapping(value = "/retrieveAllTvShows", method = RequestMethod.GET)
	public Map<String, Object> retrieveAllTvShows() {
		Map<String, Object> map = new HashMap<String, Object>();

		List<TvShowCollection> tvShows = null;
		tvShows = tvShowRepository.findAll();

		if (!tvShows.isEmpty()) {
			map.put("TvShows", tvShows);
		} else {
			map.put("Error", "No Tv shows found!");
		}
		return map;
	}

	// retrieves movie with name
	@RequestMapping(value="/getMovie/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getMovieById(@PathVariable String id) {
		 Optional<MoviesCollection>  list = moviesRepository.getMoviesById(id);
	return ResponseEntity.ok().body(list);	
	}
	
	@RequestMapping(value="/getTvShow/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getTvShowById(@PathVariable String id) {
		 Optional<TvShowCollection>  list = tvShowRepository.getTvShowById(id);
	return ResponseEntity.ok().body(list);	
	}

 /*	@RequestMapping(value = "/getMovie/{name}", method = RequestMethod.GET)
	public Map<String, Object> getMovie(@PathVariable String name) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<MoviesCollection> movie = null;
		movie = moviesRepository.findByName(name);

		if (!movie.isEmpty()) {
			map.put("Movies", movie);
		} else {
			map.put("Error", "No movies found!");
		}
		return map;
	}  

	// retrieves Tv show with name

	@RequestMapping(value = "/getTvShow/{name}", method = RequestMethod.GET)
	public Map<String, Object> getTvShow(@PathVariable String name) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<TvShowCollection> tvShow = null;
		tvShow = tvShowRepository.findByName(name);

		if (!tvShow.isEmpty()) {
			map.put("TvShow", tvShow);
		} else {
			map.put("Error", "No Tv show found!");
		}
		return map;
	}
*/
	// get all featured movies with query string

	@RequestMapping(value = "/getFeaturedMovie", method = RequestMethod.GET)
	public Map<String, Object> getFeaturedMovie() {
		Map<String, Object> map = new HashMap<String, Object>();

		List<MoviesCollection> featuredMovies = null;
		featuredMovies = moviesRepository.findAllByIsFeature(1);

		if (!featuredMovies.isEmpty()) {
			map.put("FeaturedMovies", featuredMovies);
		} else {
			map.put("Error", "No Tv show found!");
		}
		return map;
	}

	// get all featured tv shows with query string

	@RequestMapping(value = "/getFeaturedTvShows", method = RequestMethod.GET)
	public Map<String, Object> getFeaturedTvShow() {
		Map<String, Object> map = new HashMap<String, Object>();

		List<TvShowCollection> featuredTvShows = null;
		featuredTvShows = tvShowRepository.findAllByIsFeatured(1);

		if (!featuredTvShows.isEmpty()) {
			map.put("FeaturedTvShows", featuredTvShows);
		} else {
			map.put("Error", "No Tv show found!");
		}
		return map;
	}

	// delete movie

	@DeleteMapping(value = "/deleteMovie/{name}")
	public Map<String, Object> deleteMovieByName(@PathVariable String name) {
		Map<String, Object> map = new HashMap<>();
		this.moviesRepository.deleteByName(name);
		map.put("Success", "Record deleted successfully!");
		return map;
	}

	
	// delete tvshow

	@DeleteMapping(value = "/deleteTvShow/{name}")
	public Map<String, Object> deleteTvShowByName(@PathVariable String name) {
		Map<String, Object> map = new HashMap<>();
		this.tvShowRepository.deleteByName(name);
		map.put("Success", "Record deleted successfully!");
		return map;
	}

}
