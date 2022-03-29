package stuba.fei.bp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stuba.fei.bp.entity.Users;
import stuba.fei.bp.entity.repositary.UsersRepository;
import stuba.fei.bp.entity.request.UsersRequest;

@Service
public class UsersService {

    private UsersRepository repository;

    @Autowired
    public UsersService(UsersRepository repository) {
        this.repository = repository;
    }

    public Users create(UsersRequest request) {
        Users user = new Users();
        user.setID(request.getID());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setTournamentID(request.getTournamentID());
        user.setTrainerUsr(request.getTrainerUsr());
        user.setTrainerPasswd(request.getTrainerPasswd());
        return this.repository.save(user);
    }

    public Users getUserByUsername(String username) {
        Users user = this.repository.findByUsername(username);
        if(user == null){
            return null;
        }
        return user;
    }

    public Users updatePassword(String username, String password) {
        Users user = this.getUserByUsername(username);
        if(user == null){
            return null;
        }
        user.setPassword(password);
        this.repository.save(user);
        return user;
    }

    public Users loginUser(String username, String password) {
        Users user = this.repository.getUserByUsernameAndPassword(username, password);
        return user;
    }

    public Users loginTrainer(String username, String password) {
        Users user = this.repository.getTrainerByUsernameAndPassword(username, password);
        return user;
    }
}
