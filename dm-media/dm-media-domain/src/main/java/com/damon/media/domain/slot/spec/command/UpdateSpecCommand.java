package com.damon.media.domain.slot.spec.command;

import com.damon.media.domain.slot.spec.aggregate.SpecId;
import lombok.Builder;
import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Damon S.
 */
@Getter
@Builder
public class UpdateSpecCommand {
    @TargetAggregateIdentifier
    private final SpecId specId;
    private final Integer width;
    private final Integer height;
    private final String imageType;
    private final Integer imageSize;
    private final List<Long> layoutIds;
    private final String snapshot;
    private final Integer frameCount;
    private final String lookAndFeel;
    private final Long updatedBy;
    private final Timestamp updatedAt;
}
