package cn.menghan.tool.tree.util;

import cn.menghan.tool.tree.pojo.TreeNode;
import lombok.experimental.UtilityClass;

import java.util.LinkedList;
import java.util.List;

/**
 * 树节点信息工具类
 *
 * @author by liu.hongda
 * @date 2019/12/31 11:50
 */
@UtilityClass
public class TreeChildNode {

    /**
     * 获取子节点的ID的LIST
     *
     * @param treeNodes 整棵树
     * @param root      根节点
     * @param <T>       继承树的list的类
     * @return id的集合
     */
    public <T extends TreeNode> List<String> getChildIdByParentId(List<T> treeNodes, String root) {
        List<T> build = TreeBuilder.build(treeNodes, root);
        List<String> list = new LinkedList<>();
        build.forEach(d -> {
            List<String> child = new LinkedList<>();
            String code = d.getId();
            list.add(code);
            List<TreeNode> children = d.getChildren();
            if (null != children) {
                List<String> childList = getChild(children, child);
                child.addAll(childList);
            }
            list.addAll(child);
        });
        return list;
    }

    /**
     * 递归子节点
     *
     * @param data 单个子节点
     * @param list 新节点
     * @return 当前子节点的所有子节点id
     */
    private List<String> getChild(List<TreeNode> data, List<String> list) {
        data.forEach(d -> {
            String code = d.getId();
            list.add(code);
            List<TreeNode> children = d.getChildren();
            if (null != children) {
                getChild(children, list);
            }
        });
        return list;
    }

}
