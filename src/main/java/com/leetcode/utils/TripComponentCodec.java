package com.leetcode.utils;

import com.expedia.www.global.insurance.contracts.Flight;
import com.expedia.www.global.insurance.contracts.Hotel;
import com.expedia.www.global.insurance.contracts.LineOfBusiness;
import com.expedia.www.global.insurance.contracts.TripComponent;
import com.expedia.www.global.insurance.contracts.car.CarComponent;
import com.expedia.www.global.insurance.contracts.cruise.CruiseComponent;
import com.expedia.www.global.insurance.contracts.dx.DxComponent;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.rmi.server.ExportException;

@Slf4j
public class TripComponentCodec {
    private static final ObjectMapper DEFAULT_MAPPER = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    private static final String LOB = "lineOfBusiness";

    public static class Deserializer extends StdDeserializer<TripComponent> {
        private static final long serialVersionUID = 9085690346289643491L;
        private ObjectMapper objectMapper;

        public Deserializer(ObjectMapper objectMapper) {
            super(TripComponent.class);
            this.objectMapper = objectMapper;
        }

        @Override
        public TripComponent deserialize(JsonParser parser, DeserializationContext context) throws IOException {
            JsonNode node = parser.getCodec().readTree(parser);
            if (node.hasNonNull(LOB) && node.get(LOB).isTextual()) {
                String lobName = node.get(LOB).asText();
                try {
                    LineOfBusiness lineOfBusiness = LineOfBusiness.valueOf(lobName);
                    try {
                        switch (lineOfBusiness) {
                            case AIR:
                                return objectMapper.convertValue(node, Flight.class);
                            case HOTEL:
                                return objectMapper.convertValue(node, Hotel.class);
                            case CAR:
                                return objectMapper.convertValue(node, CarComponent.class);
                            case LX:
                                return objectMapper.convertValue(node, DxComponent.class);
                            case CRUISE:
                                return objectMapper.convertValue(node, CruiseComponent.class);
                            default:
                                final String error = "Unimplemented trip component LOB: " + lobName;
                                log.error(error);
                        }
                    } catch (IllegalArgumentException e) {
                        final String error = "Malformed trip component: " + node;
                        log.error(error);
                    }
                } catch (IllegalArgumentException e) {
                    final String error = "Invalid trip component LOB: " + lobName;
                    log.error(error);
                }
            } else {
                log.error("Trip component missing lineOfBusiness: " + node);
                /* TODO: If this is an important aspect, then we might need to make it fatal too. */
            }

            return DEFAULT_MAPPER.convertValue(node, TripComponent.class);
        }
    }
}
