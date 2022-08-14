package TvShows.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import TvShows.Models.TvShowModel;

public interface TvShowRepository extends CrudRepository<TvShowModel, Long> {

	List<TvShowModel> findAll();
}
