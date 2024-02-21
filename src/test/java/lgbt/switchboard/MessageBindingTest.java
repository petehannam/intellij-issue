package lgbt.switchboard;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.context.BeanContext;
import io.micronaut.inject.BeanDefinition;
import io.micronaut.inject.qualifiers.Qualifiers;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import java.util.Collection;
import org.junit.jupiter.api.Test;

@MicronautTest(rebuildContext = true)
public class MessageBindingTest {

  @Inject
  BeanContext beanContext;

  @Inject
  ObjectMapper objectMapper;

  @Test
//  @Property(name = "MessageBindingTest", value = "yes") - TODO - fix this
  public void testBindMessageType() throws JsonProcessingException {
    beanContext.refresh();
    Collection<BeanDefinition<?>> definitions = beanContext.getBeanDefinitions(Qualifiers.byStereotype(Publishable.class));

    assertThat(definitions).hasSize(1); // TODO - should be 5

    TestingMessage from = new TestingMessage();
    assertThat(objectMapper.writeValueAsString(from)).isEqualTo("{\"messageType\":\"test_message\",\"schemaVersion\":1}");
    TestingMessage to = objectMapper.readValue("{\"messageType\":\"test_message\",\"schemaVersion\":1}", TestingMessage.class);
    assertThat(to.messageType).isEqualTo("test_message");
    assertThat(to.schemaVersion).isEqualTo(1);
  }

}
