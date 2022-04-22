package aptech.t2008m.spingboot.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping (path = "/api/v1/manages")

public class ManageApi {

    @Autowired
    ManageRepository manageRepository;


    @RequestMapping(method = RequestMethod.GET)
    public List<Manage> findAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit){
        return manageRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Manage save(@RequestBody Manage manage){
        manageRepository.save(manage);
        return manage;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Manage finById(@PathVariable int id){
        return manageRepository.findById(id).get();

    }
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public Manage update(@PathVariable int id, @RequestBody Manage updateProduct){
        Manage existing = manageRepository.findById(id).get();
        existing.setTitle(updateProduct.getTitle());
        existing.setImage(updateProduct.getImage());
        existing.setContent(updateProduct.getContent());
        existing.setCategory(updateProduct.getCategory());
        manageRepository.save(existing);
        return updateProduct ;
    }
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public boolean delete(@PathVariable int id) {
        manageRepository.deleteById(id);
        return true;
    }
}
