package cn.com.zerobug.common.base.api;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * 分页查询对象
 *
 * @author zhongxiaowei
 * @date 2022/3/11
 */
@Data
public class PageQuery<T> implements Serializable {

    private static final long serialVersionUID = -360794336490556591L;

    private static final Integer DEFAULT_CURRENT_PAGE = 1;
    private static final Integer DEFAULT_PAGE_SIZE    = 10;

    /**
     * 当前页码
     */
    private Integer currentPage = DEFAULT_CURRENT_PAGE;
    /**
     * 每页条数
     */
    private Integer pageSize    = DEFAULT_PAGE_SIZE;
    /**
     * 参数对象
     */
    private T       paramEntity;

    public <T> Page<T> buildPage() {
        return buildPage(null);
    }

    public <T> Page<T> buildPage(List<OrderItem> orderItems) {
        Page<T> page = Page.of(this.getCurrentPage(), this.getPageSize());
        Optional.ofNullable(orderItems).ifPresent(orders -> page.addOrder(orders));
        return page;
    }

}
