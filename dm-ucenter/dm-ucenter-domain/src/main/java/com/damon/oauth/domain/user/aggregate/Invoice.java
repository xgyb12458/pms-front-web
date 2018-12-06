package com.damon.oauth.domain.user.aggregate;

import lombok.Builder;
import lombok.Getter;

/**
 * 发票信息
 * @author Damon S.
 */
@Getter
@Builder
public class Invoice {
    private final InvoiceId invoiceId;
}
