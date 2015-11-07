package org.kaikai.ta.jersey.provider;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/**
 * Created by kaicao on 07/11/15.
 */
@Provider
public class ObjectMapperProvider implements ContextResolver<ObjectMapper> {
  private static final ObjectMapper MAPPER = new ObjectMapper();
  static {
    MAPPER.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
    MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }

  @Override
  public ObjectMapper getContext(Class<?> type) {
    return MAPPER;
  }

}
