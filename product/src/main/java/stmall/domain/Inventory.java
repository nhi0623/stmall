package stmall.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import stmall.ProductApplication;

@Entity
@Table(name = "Inventory_table")
@Data
//<<< DDD / Aggregate Root
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productName;

    private String stock;

    public static InventoryRepository repository() {
        InventoryRepository inventoryRepository = ProductApplication.applicationContext.getBean(
            InventoryRepository.class
        );
        return inventoryRepository;
    }

    //<<< Clean Arch / Port Method
    public static void decreseStock(OderPlaced oderPlaced) {
        //implement business logic here:

        /** Example 1:  new item 
        Inventory inventory = new Inventory();
        repository().save(inventory);

        StockDecrease stockDecrease = new StockDecrease(inventory);
        stockDecrease.publishAfterCommit();
        SoldOut soldOut = new SoldOut(inventory);
        soldOut.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        // if oderPlaced.pgId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<, Object> orderMap = mapper.convertValue(oderPlaced.getPgId(), Map.class);

        repository().findById(oderPlaced.get???()).ifPresent(inventory->{
            
            inventory // do something
            repository().save(inventory);

            StockDecrease stockDecrease = new StockDecrease(inventory);
            stockDecrease.publishAfterCommit();
            SoldOut soldOut = new SoldOut(inventory);
            soldOut.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
