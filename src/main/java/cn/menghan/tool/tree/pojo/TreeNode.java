package cn.menghan.tool.tree.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by liu.hongda
 * @date 2019/12/31 11:40
 */
@Data
public class TreeNode {

    private String id;

    private String parentId;

    private List<TreeNode> children = new ArrayList<>();

    public void add(TreeNode node) {
        children.add(node);
    }
}
