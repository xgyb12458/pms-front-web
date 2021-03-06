package com.damon.media.api.dto.req.app;

import com.damon.media.api.dto.req.PageableReqDTO;
import com.damon.media.shared.enums.MediaSource;
import com.damon.media.shared.enums.MediaType;
import com.damon.shared.enums.AuditStatus;
import com.damon.shared.enums.OSCategory;
import com.damon.shared.enums.SwitchState;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/***
 * 查询媒体应用请求
 * @author Damon S.
 */
@ToString
@Data
@ApiModel(value = "查询媒体应用请求参数")
public final class QueryAppReqDTO extends PageableReqDTO implements Serializable {
    private static final long serialVersionUID = 62477146660833254L;

    @ApiModelProperty(name = "name", value = "应用名称")
    private String name;

    @ApiModelProperty(name = "os", value = "应用的操作系统平台")
    private OSCategory os;

    @ApiModelProperty(name = "type", value = "应用类型")
    private MediaType type;

    @ApiModelProperty(name = "source", value = "媒体归属(ASSET|ALIEN)")
    private MediaSource source;

    @ApiModelProperty(name = "status", value = "审核状态")
    private AuditStatus status;

    @ApiModelProperty(name = "state", value = "启停状态(ON|OFF)")
    private SwitchState state;

    @ApiModelProperty(name = "industry", value = "所属行业")
    private String industry;

    @ApiModelProperty(name = "userId", value = "应用所属用户")
    private Long userId;
}
