package stmall.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import stmall.domain.*;
import stmall.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class OderPlaced extends AbstractEvent {

    private Long id;
    private String userid;
    private String productname;
    private Long productid;
    private Integer qty;
    private String address;

    public OderPlaced(Order aggregate) {
        super(aggregate);
    }

    public OderPlaced() {
        super();
    }
}
//>>> DDD / Domain Event
