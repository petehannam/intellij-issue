package lgbt.switchboard;

import static org.assertj.core.api.Assertions.assertThat;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

@MicronautTest
public class SimpleTest {

  @Test
  public void testSimpleTest() {
    assertThat(true).isTrue();
  }

}
