package cn.com.zerobug.common.base.dataobject;

import lombok.Data;

/**
 * @author zhongxiaowei
 * @date 2022/4/2
 */
@Data
public class TenantDO extends BaseDO {

    private static final long serialVersionUID = -7530338368407842145L;

    /**
     * 租户编号
     */
    private Long tenantId;

}
