package com.damon.bank.domain.trade.command;

import com.damon.shared.enums.SwitchState;
import lombok.Builder;
import lombok.Value;

/**
 * @author Damon S.
 */
@Value
@Builder
public class QueryOrderByIdCommand {
    private final String roleId;
    private final String code;
    private final String name;
    private final SwitchState state;
    private final Integer pageSize;
    private final Integer pageIndex;
}
