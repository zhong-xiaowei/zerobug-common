package cn.com.zerobug.common.base.dataobject;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.ToString;

import javax.validation.groups.Default;
import java.util.Date;

/**
 * @author zhongxiaowei
 * @date 2022/3/12
 */
@Data
@ToString(callSuper = true)
public class BaseDO extends IdentityDO {
    private static final long serialVersionUID = 1L;

    public final static String CREATE_BY_FIELD   = "createBy";
    public final static String CREATE_TIME_FIELD = "createTime";
    public final static String UPDATE_BY_FIELD   = "updateBy";
    public final static String UPDATE_TIME_FIELD = "updateTime";
    public final static String IS_DELETE         = "isDelete";

    /**
     * 创建人 ID
     */
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private Long createBy;
    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 修改人 ID
     */
    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    private Long updateBy;
    /**
     * 修改时间
     */
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Date updateTime;

    /**
     * 逻辑删除 0-未删除 1-删除
     */
    @TableLogic(value = "0", delval = "1")
    private Integer isDelete;


    public interface CreateGroup extends Default {
    }

    public interface DeleteGroup extends Default {
    }

    public interface UpdateGroup extends Default {
    }


}
