package io.edpn.backend.modulith.commodityfinder.application.dto.persistence;

import io.edpn.backend.modulith.commodityfinder.domain.entity.LandingPadSize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StationEntity {

    private UUID id;
    private Long marketId;
    private String name;
    private SystemEntity system;
    private boolean planetary;
    private boolean requireOdyssey;
    private boolean fleetCarrier;
    private LandingPadSize maxLandingPadSize;
    private LocalDateTime marketUpdatedAt;
    private Map<CommodityEntity, MarketDatumEntity> commodityMarketData;

}
