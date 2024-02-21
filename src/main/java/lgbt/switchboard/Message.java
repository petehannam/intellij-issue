package lgbt.switchboard;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.ReflectiveAccess;

@Introspected
@ReflectiveAccess
@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {

  @JsonProperty
  protected final String messageType;

  @JsonProperty
  protected final int schemaVersion;

  protected Message(String messageType, int schemaVersion) {
    super();
    this.messageType = messageType;
    this.schemaVersion = schemaVersion;
  }

  public final String getMessageType() {
    return messageType;
  }

  public int getSchemaVersion() {
    return schemaVersion;
  }

  @Introspected
  @ReflectiveAccess
  public static final class Placeholder extends Message {

    @JsonCreator
    public Placeholder(@JsonProperty("messageType") String messageType, @JsonProperty("schemaVersion") int schemaVersion) {
      super(messageType, schemaVersion);
    }

  }

}
