package io.edpn.backend.trade.application.domain.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
public class FindSystemFilter {
    private String name;
    private Boolean hasEliteId;
    private Boolean hasCoordinates;
}
