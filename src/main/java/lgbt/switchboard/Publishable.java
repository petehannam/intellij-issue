package lgbt.switchboard;

import io.micronaut.context.annotation.Bean;

@Bean
public @interface Publishable {

  String messageKey();

  int schemaVersion();

}
