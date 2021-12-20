
package Reto2_web.servicios;

import Reto2_web.modelo.Supplements;
import Reto2_web.repositorio.SupplementsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 *
 * @author LUIS JULIAN ORTIZ HEREDIA
 */
@Service
public class SupplementsService {

    @Autowired
    private SupplementsRepository supplementsRepository;

    public List<Supplements> getAll() {
        return supplementsRepository.getAll();
    }

    public Optional<Supplements> getClothe(String reference) {
        return supplementsRepository.getClothe(reference);
    }

    public Supplements create(Supplements accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return supplementsRepository.create(accesory);
        }
    }

    public Supplements update(Supplements accesory) {

        if (accesory.getReference() != null) {
            Optional<Supplements> accesoryDb = supplementsRepository.getClothe(accesory.getReference());
            if (!accesoryDb.isEmpty()) {
                
                if (accesory.getBrand()!= null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }
                
                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }
                
                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                supplementsRepository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getClothe(reference).map(accesory -> {
            supplementsRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
     public List<Supplements> fintByPrice(double price){
        return supplementsRepository.fintByPrice(price);
    }   
     
    public List<Supplements> findByDescriptionContainingIgnoreCase(String description){
        return supplementsRepository.findByDescriptionContainingIgnoreCase(description);
    }   

}


