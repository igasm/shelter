package com.igasm.shelter.springConfig;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomLocalDateDeserializer extends StdDeserializer<LocalDate>{

  private static DateTimeFormatter formatter =
      DateTimeFormatter.ofPattern("yyyy-MM-dd");

  public CustomLocalDateDeserializer(){
    this(null);
  }

  protected CustomLocalDateDeserializer(Class <?> vc) {
    super(vc);
  }

  @Override
  public LocalDate deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    String date = jsonParser.getText();
    return LocalDate.from(formatter.parse(date));
  }

}
