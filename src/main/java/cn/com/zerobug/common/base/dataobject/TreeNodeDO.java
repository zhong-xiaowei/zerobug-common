package cn.com.zerobug.common.base.dataobject;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhongxiaowei
 * @date 2022/3/26
 */
@Data
public class TreeNodeDO<T> extends TenantDO {

    /**
     * label
     */
    private String  label;
    /**
     * parent node id
     */
    private Long    parentId;
    /**
     * node order
     */
    private Integer sort;
    /**
     * node level
     */
    private Integer level;
    /**
     * children node
     */
    private List<T> children;

    /**
     * Build tree by level and loops
     * This algorithm is twice as fast as recursion
     *
     * @param treeNodes tree nodes
     * @param <E>       tree node type
     * @return tree
     */
    public static <E extends TreeNodeDO> List<E> buildTree(List<E> treeNodes) {
        if (treeNodes == null) {
            return Collections.emptyList();
        }
        // Get the deepest level
        Integer deep   = treeNodes.stream().max(Comparator.comparing(TreeNodeDO::getLevel)).get().getLevel();
        List<E> result = new ArrayList<>();
        List<E> pn     = null, tn;
        for (int i = 1; i <= deep; i++) {
            tn = new ArrayList<>();
            final int level = i;
            treeNodes.stream().filter(node -> node.getLevel().equals(level)).forEach(tn::add);
            insertToParent(tn, pn);
            pn = tn;
            // This top-level node can only be obtained of the first time
            if (result.isEmpty()) {
                result.addAll(tn);
            }
        }
        return result;
    }

    /**
     * Insert to parent
     *
     * @param cn children
     * @param pn parent
     */
    public static void insertToParent(List<? extends TreeNodeDO> cn, List<? extends TreeNodeDO> pn) {
        if (pn == null) {
            return;
        }
        // Iterate over all the parent nodes
        // Place the child nodes of the parent node
        pn.stream().forEach(node -> {
                    List<? extends TreeNodeDO> collect = cn.stream().filter(c -> c.getParentId().equals(node.getId())).collect(Collectors.toList());
                    node.setChildren(collect.isEmpty() ? null : collect);
                }
        );
    }
}
