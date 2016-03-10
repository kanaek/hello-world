package AuthDes2Auth;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Created by user on 2016/3/7.
 */
public class ManyNodeTree
{
    /** 树根*/
    public ManyTreeNode root;

    /**
     * 构造函数
     */
    public ManyNodeTree()
    {
        root = new ManyTreeNode(new TreeNode("/"));
    }

    public void Add_child(List<String> dir) {
        ManyTreeNode tmpTreeNod = root;
        List<ManyTreeNode> tmpList = root.getChildList();
        int i = 1;
        int flag  = 0 ;
        while (i<dir.size()) {

            tmpTreeNod = new ManyTreeNode(new TreeNode(dir.get(i),dir.get(i-1)));
           // System.out.println(tmpList.size());

            for (int j=0; j<tmpList.size(); j++) {
                if (tmpTreeNod.getData().TreeNodeSL_Eq(tmpList.get(j).getData())) {
                    flag = 1;
                    tmpTreeNod = tmpList.get(j);
                    break;
                }
            }
            if (flag == 0) {
                //System.out.println("h");
                //System.out.println(tmpTreeNod.getData().getNodeId()+','+tmpTreeNod.getData().getParentId());
                tmpList.add(tmpTreeNod);
                System.out.println(tmpList.size());
                //System.out.println(tmpList.get(0).getData().getNodeId());
            }
                tmpList = tmpTreeNod.getChildList();

            flag = 0;
            i++;
        }

       // System.out.println(root.getData().getNodeId()+','+root.getChildList().get(0).getData().getNodeId());
       // System.out.println(root.getChildList().get(0).getChildList().get(0).getData().getNodeId());

    }
    /**
     * 生成一颗多叉树，根节点为root
     *
     * @param treeNodes 生成多叉树的节点集合
     * @return ManyNodeTree
     */
    public ManyNodeTree createTree(List<TreeNode> treeNodes)
    {
        if(treeNodes == null || treeNodes.size() < 0)
            return null;

        ManyNodeTree manyNodeTree =  new ManyNodeTree();

        //将所有节点添加到多叉树中
        for(TreeNode treeNode : treeNodes)
        {
            if(treeNode.getParentId().equals("/"))
            {
                //向根添加一个节点
                String tmpParent = treeNode.getParentId();

                manyNodeTree.getRoot().getChildList().add(new ManyTreeNode(treeNode));
            }
            else
            {
                addChild(manyNodeTree.getRoot(), treeNode);
            }
        }

        return manyNodeTree;
    }

    /**
     * 向指定多叉树节点添加子节点
     *
     * @param manyTreeNode 多叉树节点
     * @param child 节点
     */
    public void addChild(ManyTreeNode manyTreeNode, TreeNode child)
    {
        for(ManyTreeNode item : manyTreeNode.getChildList())
        {
            if(item.getData().getNodeId().equals(child.getParentId()))
            {
                //找到对应的父亲
                item.getChildList().add(new ManyTreeNode(child));
                break;
            }
            else
            {
                if(item.getChildList() != null && item.getChildList().size() > 0)
                {
                    addChild(item, child);
                }
            }
        }
    }

    /**
     * 遍历多叉树
     *
     * @param manyTreeNode 多叉树节点
     * @return
     */
    public String iteratorTree(ManyTreeNode manyTreeNode)
    {
        System.out.println("-----------------------");
        StringBuilder buffer = new StringBuilder();
        buffer.append("\n");

        if(manyTreeNode != null)
        {
            for (ManyTreeNode index : manyTreeNode.getChildList())
            {
                buffer.append(index.getData().getNodeId()+ ",");

                if (index.getChildList() != null && index.getChildList().size() > 0 )
                {
                    buffer.append(iteratorTree(index));
                }
            }
        }

        buffer.append("\n");

        return buffer.toString();
    }

    public ManyTreeNode getRoot() {
        return root;
    }

    public void setRoot(ManyTreeNode root) {
        this.root = root;
    }

    public static void main(String[] args) {
        List<TreeNode> treeNodes = new ArrayList<TreeNode>();
        ManyNodeTree tree = new ManyNodeTree();
        List<String> list = new ArrayList<String>();
        list.add("/");
        list.add("trunk");
        list.add("doc");
        List<String> list1 = new ArrayList<String>();
        list1.add("/");
        list1.add("trunk");
        list1.add("doc");
        list1.add("hello");
        tree.Add_child(list);
        tree.Add_child(list1);

        System.out.println(tree.iteratorTree(tree.getRoot()));
    }

}