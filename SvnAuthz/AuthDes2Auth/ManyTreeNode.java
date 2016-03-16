package SvnAuthz.AuthDes2Auth;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by user on 2016/3/7.
 */
public class ManyTreeNode
{
    /** 树节点*/
    private TreeNode data;
    /** 子树集合*/
    private List<ManyTreeNode> childList;

    public boolean MTreeNodeSL_Eq(TreeNode node) {
          return data.TreeNodeSL_Eq(node);
    }

    public void MRemove_Dup() {
        for (int i = 0; i < childList.size(); i++) {
            TreeNode tmp = childList.get(i).getData();
            //System.out.println(tmp.getNodeId()+tmp.getParentId());
            int j = i + 1;
            while (j < childList.size()) {

                TreeNode tmp2 = childList.get(j).getData();
                if (tmp.getParentId().equals(tmp2.getParentId()) && tmp.getNodeId().equals(tmp2.getNodeId())) {
                    childList.remove(j);
                    //System.out.println(tmp2.getParentId()+','+tmp.getParentId());
                    //System.out.println(tmp2.getNodeId()+','+tmp.getNodeId());
                } else {
                    j++;
                }

            }
        }
    }

    /**
     * 构造函数
     *
     * @param data 树节点
     *
     */
    public ManyTreeNode(TreeNode data)
    {
        this.data = data;
        this.childList = new ArrayList<ManyTreeNode>();
    }

    /**
     * 构造函数
     *
     * @param data 树节点
     * @param childList 子树集合
     */
    public ManyTreeNode(TreeNode data, List<ManyTreeNode> childList)
    {
        this.data = data;
        this.childList = childList;
    }

    public TreeNode getData() {
        return data;
    }

    public void setData(TreeNode data) {
        this.data = data;
    }

    public List<ManyTreeNode> getChildList() {
        return childList;
    }

    public void setChildList(List<ManyTreeNode> childList) {
        this.childList = childList;
    }

}