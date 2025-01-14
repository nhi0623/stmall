package stmall.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import stmall.domain.*;
import stmall.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class StockDecrease extends AbstractEvent {

    private Long id;
    private String productname;

    public StockDecrease(Inventory aggregate) {
        super(aggregate);
    }

    public StockDecrease() {
        super();
    }
}
//>>> DDD / Domain Event
