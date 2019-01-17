package com.damon.bank.api.dto.req.trade;

import com.damon.bank.shared.enums.PayChannel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 提交订单参数
 * @author Damon S.
 */
@Data
@ApiModel(value = "提交订单参数")
public class SubmitOrderReqDTO implements Serializable {
    private static final Long serialVersionUID = 1L;

    @NotNull(message = "配送地址不能为空")
    @ApiModelProperty(name = "addressId", value = "配送地址", required = true)
    private Long addressId;

    @NotNull(message = "订单商品SKU不能为空")
    @ApiModelProperty(name = "skus", value = "订单商品SKU", required = true)
    private List<SubmitSkuReqDTO> skus;

    @ApiModelProperty(name = "message", value = "买家留言")
    private String message;

    @ApiModelProperty(name = "invoiceId", value = "发票信息")
    private Long invoiceId;

    @ApiModelProperty(name = "integration", value = "德分抵扣")
    @Min(0L)
    private Long integration;

    @ApiModelProperty(name = "commission", value = "收益抵扣")
    @Min(0L)
    private Long commission;

    @ApiModelProperty(name = "couponIds", value = "使用优惠券")
    private List<Long> couponIds;

    @NotNull(message = "支付渠道不能为空")
    @ApiModelProperty(name = "payChannel", value = "支付渠道", required = true)
    private PayChannel payChannel;


    /**
     * 提交订单商品SKU
     * @author Damon S.
     */
    @Data
    @ToString
    @ApiModel(value = "提交订单商品SKU")
    public static class SubmitSkuReqDTO implements Serializable {
        private static final Long serialVersionUID = 1L;

        @ApiModelProperty(name = "cid", value = "购物车项Id")
        private Long cid;

        @ApiModelProperty(name = "skuid", value = "商品SkuId")
        private Long skuid;

        @ApiModelProperty(name = "qty", value = "购买数量")
        private Integer qty;

        @ApiModelProperty(name = "pid", value = "活动编号")
        private Long pid;
    }
}
