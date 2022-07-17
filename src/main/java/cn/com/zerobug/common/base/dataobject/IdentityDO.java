package cn.com.zerobug.common.base.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 所有类型数据全部使用Long类型作为主键，防止数据库字段类型不匹配
 * 如果需要使用自增主键，请使用@TableId(type = IdType.AUTO)
 * 如果不支持自增主键，那么使用雪花算法作为主键类型 ，请使用@TableId(type = IdType.ASSIGN_ID)
 *
 * @author zhongxiaowei
 * @date 2022/3/12
 */
@Data
@ToString
public class IdentityDO implements Serializable {

    public static final String ID_FIELD = "id";

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    @NotNull(message = "id不能为空", groups = BaseDO.UpdateGroup.class)
    private Long id;

}
