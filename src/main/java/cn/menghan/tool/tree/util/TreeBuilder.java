package cn.menghan.tool.tree.util;

import cn.menghan.tool.tree.pojo.TreeNode;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

/**
 * 树生成工具类
 * @author by liu.hongda
 * @date 2019/12/31 11:35
 */
@UtilityClass
public class TreeBuilder {

    /**
     * 两层循环实现建树
     *
     * @param treeNodes 传入的树节点列表
     * @param root 根节点位置
     * @return 返回当前树型结构结果
     */
    public <T extends TreeNode> List<T> build(List<T> treeNodes, String root) {
        List<T> trees = new ArrayList<>();
        for (T treeNode : treeNodes) {
            if (root.equals(treeNode.getParentId())) {
                trees.add(treeNode);
            }
            for (T it : treeNodes) {
                if (it.getParentId().equals(treeNode.getId())) {
                    if (treeNode.getChildren() == null) {
                        treeNode.setChildren(new ArrayList<>());
                    }
                    treeNode.add(it);
                }
            }
        }
        return trees;
    }
}
