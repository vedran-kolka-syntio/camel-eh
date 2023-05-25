package kolka.camel.eventhubs;

import org.apache.camel.component.kafka.serde.KafkaHeaderDeserializer;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class StringKafkaHeaderDeserializer implements KafkaHeaderDeserializer {

    private Charset charset = StandardCharsets.UTF_8;

    public StringKafkaHeaderDeserializer() {}

    public StringKafkaHeaderDeserializer(Charset charset) {
        this.charset = charset;
    }

    @Override
    public Object deserialize(String key, byte[] value) {
        if (value == null) {
            return null;
        }

        return new String(value, charset);
    }

    public void setCharset(Charset charset) {
        this.charset = charset;
    }
}
