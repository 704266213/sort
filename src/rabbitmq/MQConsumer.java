package rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MQConsumer {

    public final static String QUEUE_NAME = "rabbitMQ";

    public void startConsumer() throws IOException, TimeoutException {
        // 创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();

        //设置RabbitMQ地址
        factory.setHost("localhost");
        factory.setUsername("jaty");
        factory.setPassword("123456");
        factory.setPort(5672);

        //创建一个新的连接
        Connection connection = factory.newConnection();

        //创建一个通道
        Channel channel = connection.createChannel();

        //声明要关注的队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println("Customer Waiting Received messages");

        //每次从队列获取的数量
        channel.basicQos(1);

        //DefaultConsumer类实现了Consumer接口，通过传入一个频道，
        // 告诉服务器我们需要那个频道的消息，如果频道中有消息，就会执行回调函数handleDelivery
        Consumer consumer = new DefaultConsumer(channel) {
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                try {
                    String message = new String(body, "UTF-8");
                    System.out.println("Customer Received '" + message + "'");

                    Thread.sleep(1000); // 暂停1秒钟
                } catch (InterruptedException _ignored) {
                    Thread.currentThread().interrupt();
                    channel.abort();
                } finally {
                    System.out.println("Worker Done");
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };
        //自动回复队列应答 -- RabbitMQ中的消息确认机制
        channel.basicConsume(QUEUE_NAME, false, consumer);
    }

}
