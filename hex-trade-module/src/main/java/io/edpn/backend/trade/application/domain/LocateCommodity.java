package io.edpn.backend.trade.application.domain;

import java.time.LocalDateTime;

public record LocateCommodity(
        LocalDateTime priceUpdatedAt,
        ValidatedCommodity validatedCommodity,
        Station station,
        System system,
        Long supply,
        Long demand,
        Long buyPrice,
        Long sellPrice,
        Double distance
) {
}
