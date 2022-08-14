package TvShows.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TvShows.Models.TvShowModel;
import TvShows.Repositories.TvShowRepository;

@Service
public class TvShowService {

	@Autowired
	private TvShowRepository tvShowRepo;
	
	// find show by ID
	public TvShowModel findById( Long id ) {
		Optional<TvShowModel> showResult = tvShowRepo.findById(id);
		if(showResult.isPresent()) {
			return showResult.get();
		}
		return null;
	}
	
	// Get all show
	public List<TvShowModel> getAllShows(){
		return tvShowRepo.findAll();
	}
	
	
	// create new show entry
	public TvShowModel createShow(TvShowModel newCreatedShow) {
		return tvShowRepo.save(newCreatedShow);
	}
	
	
	// Update show entry
	public TvShowModel updateShow(TvShowModel updatedShow) {
		return tvShowRepo.save(updatedShow);
	}
	
	
	// Delete show by id
	public void deleteShow(Long id) {
		tvShowRepo.deleteById(id);
	}
	
		
	// Show details
	public TvShowModel showDetails(Long id) {
		return tvShowRepo.findById(id).orElse(null);
	}

}
