package stmall.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import stmall.config.kafka.KafkaProcessor;
import stmall.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OderPlaced'"
    )
    public void wheneverOderPlaced_StartShipping(
        @Payload OderPlaced oderPlaced
    ) {
        OderPlaced event = oderPlaced;
        System.out.println(
            "\n\n##### listener StartShipping : " + oderPlaced + "\n\n"
        );

        // Comments //
        //1.send to payload to CJ Logis
        // 2.고객에게 배송시작 알림
        // 3.우리 장부에도 키핑
        // 4. 머머머머

        // Sample Logic //
        Delivery.startShipping(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
