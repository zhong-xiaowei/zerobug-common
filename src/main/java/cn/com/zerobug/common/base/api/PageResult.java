package cn.com.zerobug.common.base.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.List;

/**
 * 分页封装返回对象
 *
 * @author zhongxiaowei
 * @date 2022/3/9
 */
@Data
public class PageResult<T> {

    /**
     * 总条数
     */
    private long    totalRows   = 0L;
    /**
     * 总页数
     */
    private long    totalPages  = 1L;
    /**
     * 当前页
     */
    private long    currentPage = 1L;
    /**
     * 每页条数
     */
    private long    pageSize    = 10L;
    /**
     * 是否有上一页
     */
    private boolean hasPrevious = false;
    /**
     * 是否有下一页
     */
    private boolean hasNext     = false;
    /**
     * 数据行
     */
    private List<T> rows;

    public PageResult() {
    }

    public PageResult(long totalRows, long totalPages, long currentPage, long pageSize, boolean hasPrevious, boolean hasNext, List<T> rows) {
        this.totalRows = totalRows;
        this.totalPages = totalPages;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.hasPrevious = hasPrevious;
        this.hasNext = hasNext;
        this.rows = rows;
    }

    /**
     * Accept Page{@link Page} for conversion to PageResult
     *
     * @param page mybatis-plus page {@link Page}
     * @param <T>  data type of page
     * @return PageResult object {@link PageResult}
     */
    public static <T> PageResult<T> accept(Page<T> page) {
        return accept(page.getTotal(), page.getPages(), page.getCurrent(), page.getSize(), page.hasPrevious(), page.hasNext(), page.getRecords());
    }

    /**
     * Accepts the specified parameter and converts it to PageResult
     *
     * @param totalRows   total rows
     * @param currentPage current page
     * @param pageSize    page size
     * @param rows        data rows
     * @param <T>         data type of page
     * @return PageResult object {@link PageResult}
     */
    public static <T> PageResult<T> accept(long totalRows, long currentPage, long pageSize, List<T> rows) {
        long    totalPages  = totalRows % pageSize == 0 ? totalRows / pageSize : totalRows / pageSize + 1;
        boolean hasPrevious = currentPage > 1;
        boolean hasNext     = currentPage < totalPages;
        return accept(totalRows, totalPages, currentPage, pageSize, hasPrevious, hasNext, rows);
    }

    /**
     * Accepts the specified parameter and converts it to PageResult
     *
     * @param totalRows   total rows
     * @param totalPages  total pages
     * @param currentPage current page
     * @param pageSize    page size
     * @param hasPrevious has previous page
     * @param hasNext     has next page
     * @param rows        data rows
     * @param <T>         data type of page
     * @return PageResult object {@link PageResult}
     */
    public static <T> PageResult<T> accept(long totalRows, long totalPages, long currentPage, long pageSize, boolean hasPrevious, boolean hasNext, List<T> rows) {
        return new PageResult<>(totalRows, totalPages, currentPage, pageSize, hasPrevious, hasNext, rows);
    }

}
