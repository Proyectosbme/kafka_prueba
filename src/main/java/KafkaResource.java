import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/kafka")
public class KafkaResource {
    @ConfigProperty(name = "kafka.bootstrap.servers")
    String bootstrapServers;

    @POST
    public Response enviarMensaje(String mensaje) {
        Properties props = new Properties();
        props.put("bootstrap.servers", bootstrapServers);
        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", StringSerializer.class.getName());
        
        Producer<String, String> producer = new KafkaProducer<>(props);
        producer.send(new ProducerRecord<>("turno-solicitado", mensaje));
        producer.close();
        return Response.ok("Mensaje enviado a Kafka: " + mensaje).build();
    }
}
