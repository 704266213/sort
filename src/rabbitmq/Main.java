package rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Main {

    public static void main(String[] args) throws IOException, TimeoutException {

        System.out.println("=========开始创建生产者===============");
        MQProducer producer = new MQProducer();
        producer.startProducer();
        System.out.println("=========创建生产者完毕===============");


        System.out.println("=========消费者开始消费===============");
        MQConsumer mqConsumer = new MQConsumer();
        mqConsumer.startConsumer();
        System.out.println("=========消费者消费完毕===============");

    }
}
