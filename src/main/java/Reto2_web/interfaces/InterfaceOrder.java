package Reto2_web.interfaces;

import Reto2_web.modelo.Order;
import java.util.List;
import java.util.Optional;
//import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
//import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author LUIS JULIAN ORTIZ HEREDIA
 */
public interface InterfaceOrder extends MongoRepository<Order, Integer> {
   //List<Order> findBySalesManZone(String zone);
    
      //Retorna las ordenes de pedido que coincidad con la zona recibida como parametro
    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String zone);
    
    //Retorna las ordenes x estado
    @Query("{status: ?0}")
    List<Order> findByStatus(final String status);
    
    //Para seleccionar la orden con el id maximo
    Optional<Order> findTopByOrderByIdDesc();
   
   
}
