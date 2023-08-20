package io.edpn.backend.trade.adapter.persistence.entity.mapper;

import io.edpn.backend.trade.adapter.persistence.entity.MybatisLocateCommodityEntity;
import io.edpn.backend.trade.adapter.persistence.entity.MybatisStationEntity;
import io.edpn.backend.trade.adapter.persistence.entity.MybatisSystemEntity;
import io.edpn.backend.trade.adapter.persistence.entity.MybatisValidatedCommodityEntity;
import io.edpn.backend.trade.application.domain.LocateCommodity;
import io.edpn.backend.trade.application.dto.persistence.entity.LocateCommodityEntity;
import io.edpn.backend.trade.application.dto.persistence.entity.mapper.LocateCommodityEntityMapper;
import io.edpn.backend.trade.application.dto.persistence.entity.mapper.StationEntityMapper;
import io.edpn.backend.trade.application.dto.persistence.entity.mapper.SystemEntityMapper;
import io.edpn.backend.trade.application.dto.persistence.entity.mapper.ValidatedCommodityEntityMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MybatisLocateCommodityEntityMapper implements LocateCommodityEntityMapper<MybatisLocateCommodityEntity> {
    
    private final ValidatedCommodityEntityMapper<MybatisValidatedCommodityEntity> validatedCommodityEntityMapper;
    private final SystemEntityMapper<MybatisSystemEntity> systemEntityMapper;
    private final StationEntityMapper<MybatisStationEntity> stationEntityMapper;

    
    @Override
    public LocateCommodity map(LocateCommodityEntity locateCommodityEntity) {
        return new LocateCommodity(
                locateCommodityEntity.getPricesUpdatedAt(),
                validatedCommodityEntityMapper.map(locateCommodityEntity.getValidatedCommodity()),
                stationEntityMapper.map(locateCommodityEntity.getStation()),
                systemEntityMapper.map(locateCommodityEntity.getSystem()),
                locateCommodityEntity.getSupply(),
                locateCommodityEntity.getDemand(),
                locateCommodityEntity.getBuyPrice(),
                locateCommodityEntity.getSellPrice(),
                locateCommodityEntity.getDistance()
        );
    }
    
    @Override
    public MybatisLocateCommodityEntity map(LocateCommodity locateCommodity) {
        return MybatisLocateCommodityEntity.builder()
                .pricesUpdatedAt(locateCommodity.getPriceUpdatedAt())
                .validatedCommodity(validatedCommodityEntityMapper.map(locateCommodity.getValidatedCommodity()))
                .station(stationEntityMapper.map(locateCommodity.getStation()))
                .system(systemEntityMapper.map(locateCommodity.getSystem()))
                .supply(locateCommodity.getSupply())
                .demand(locateCommodity.getDemand())
                .buyPrice(locateCommodity.getBuyPrice())
                .sellPrice(locateCommodity.getSellPrice())
                .distance(locateCommodity.getDistance())
                .build();
    }
}
