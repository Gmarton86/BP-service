package stuba.fei.bp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import stuba.fei.bp.entity.Tournaments;
import stuba.fei.bp.entity.repositary.TournamentsRepository;
import stuba.fei.bp.entity.request.TournamentsRequest;

import java.util.List;

@Service
public class TournamentsService {

    private TournamentsRepository tournamentsRepository;

    @Autowired
    public TournamentsService(TournamentsRepository tournamentsRepository) {
        this.tournamentsRepository = tournamentsRepository;
    }

    public Tournaments create(TournamentsRequest request) {
        Tournaments tournaments = new Tournaments();
        tournaments.setID(request.getID());
        tournaments.setName(request.getName());
        tournaments.setTables(request.getTables());
        tournaments.setAdminID(request.getAdminID());
        tournaments.setDate(request.getDate());
        tournaments.setTime(request.getTime());
        tournaments.setPlace(request.getPlace());
        return this.tournamentsRepository.save(tournaments);
    }

    public List<Tournaments> getAll() {
        return this.tournamentsRepository.findAll();
    }

    public void delete(String name) {
        this.tournamentsRepository.customDelete(name);
    }
}
