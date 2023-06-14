package io.edpn.backend.commodityfinder.application.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.edpn.backend.commodityfinder.domain.model.RequestDataMessage;
import io.edpn.backend.commodityfinder.domain.model.Station;
import io.edpn.backend.commodityfinder.domain.repository.RequestDataMessageRepository;
import io.edpn.backend.commodityfinder.domain.service.RequestDataService;
import io.edpn.backend.messageprocessorlib.application.dto.eddn.data.StationDataRequest;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class RequestStationArrivalDistanceService implements RequestDataService<Station> {

    private final RequestDataMessageRepository requestDataMessageRepository;
    private final ObjectMapper objectMapper;

    @Override
    public boolean isApplicable(Station station) {
        return Objects.isNull(station.getArrivalDistance());
    }

    @Override
    public void request(Station station) {
        StationDataRequest stationDataRequest = new StationDataRequest();
        stationDataRequest.setStationName(station.getName());
        stationDataRequest.setSystemName(station.getSystem().getName());

        JsonNode jsonNode = objectMapper.valueToTree(stationDataRequest);

        RequestDataMessage requestDataMessage = RequestDataMessage.builder()
                .topic("stationArrivalDistanceDataRequest")
                .message(jsonNode)
                .build();

        requestDataMessageRepository.sendToKafka(requestDataMessage);
    }
}
