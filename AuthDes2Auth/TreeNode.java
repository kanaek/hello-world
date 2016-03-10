package AuthDes2Auth;

/**
 * Created by user on 2016/3/7.
 */
public class TreeNode
{
    /** 节点Id*/
    private String nodeId;
    /** 父节点Id*/
    private String parentId;
    /** 文本内容*/
    private String text;

    /**
     * 构造函数
     *
     * @param nodeId 节点Id
     */
    public TreeNode(String nodeId)
    {
        this.nodeId = nodeId;
    }

    /**
     * 构造函数
     *
     * @param nodeId 节点Id
     * @param parentId 父节点Id
     */
    public TreeNode(String nodeId, String parentId)
    {
        this.nodeId = nodeId;
        this.parentId = parentId;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean TreeNodeSL_Eq( TreeNode node2) {
        if (nodeId.equals(node2.getNodeId()) && nodeId.equals(node2.getParentId())) {
            return true;
        }  else return false;
    }

    public static void main(String[] args) {
        TreeNode test = new TreeNode("2","2");
        TreeNode test2 = new TreeNode("2","2");
        System.out.println(test.TreeNodeSL_Eq(test2));
    }

}