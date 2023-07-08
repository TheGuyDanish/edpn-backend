package io.edpn.backend.trade.configuration;

import io.edpn.backend.trade.application.mappers.v1.CommodityMarketInfoResponseMapper;
import io.edpn.backend.trade.application.mappers.v1.LocateCommodityDTOMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("TradeModuleRestMapperConfig")
public class RestMapperConfig {

    @Bean
    public CommodityMarketInfoResponseMapper bestCommodityPriceResponseMapper() {
        return new CommodityMarketInfoResponseMapper();
    }

    @Bean
    public LocateCommodityDTOMapper findCommodityDTOMapper() {
        return new LocateCommodityDTOMapper();
    }
}
