package lgbt.switchboard;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.ReflectiveAccess;

@Introspected
@ReflectiveAccess
@Publishable(messageKey = "test_message", schemaVersion = 1)
class TestingMessage extends Message {

  private static final String MESSAGE_TYPE = "test_message";

  public TestingMessage() {
    super(MESSAGE_TYPE, 1);
  }

}
