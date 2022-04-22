package aptech.t2008m.spingboot.manage;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ManageService {
    @Autowired
    private ManageRepository manageRepository;

    public List<Manage> findAll(){return manageRepository.findAll();}

    public Optional<Manage> findById(int id) {
        return manageRepository.findById((id));
    }

    public Manage save(Manage manage) {
        return manageRepository.save(manage);
    }

    public void deleteById(int id) {
        manageRepository.deleteById((id));
    }
}
