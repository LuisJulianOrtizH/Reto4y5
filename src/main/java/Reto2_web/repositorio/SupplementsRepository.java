
package Reto2_web.repositorio;


import Reto2_web.interfaces.InterfaceSupplements;
import Reto2_web.modelo.Supplements;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author LUIS JULIAN ORTIZ HEREDIA
 */
@Repository
public class SupplementsRepository {
    @Autowired
    private InterfaceSupplements repository;

    public List<Supplements> getAll() {
        return repository.findAll();
    }

    public Optional<Supplements> getClothe(String reference) {
        return repository.findById(reference);
    }

    
    public Supplements create(Supplements clothe) {
        return repository.save(clothe);
    }

    public void update(Supplements clothe) {
        repository.save(clothe);
    }
    
    public void delete(Supplements clothe) {
        repository.delete(clothe);
    }
    
    public List<Supplements> fintByPrice(double price){
        return repository.findByPrice(price);
    } 
    
    public List<Supplements> findByDescriptionContainingIgnoreCase(String description){
        return repository.findByDescriptionContainingIgnoreCase(description);
    } 
    
}
