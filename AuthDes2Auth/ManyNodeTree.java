package AuthDes2Auth;
import org.jetbrains.annotations.NotNull;
import org.tmatesoft.svn.core.io.ISVNEditor;

import java.io.OutputStreamWriter;
import java.util.*;

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

    public boolean add_ChildAuth(List<String> dir, String role, String auth) {
        ManyTreeNode tmpTreeNod = root;
        List<ManyTreeNode> tmpList = root.getChildList();
        int i = 1;
        int flag = 0;

        if (auth.equals("") || auth == null) return false;

        root.getData().getRoleautmap().put(role,"r");

        while (i<dir.size()) {
            for (int j=0; j<tmpList.size(); j++) {
                if (tmpList.get(j).getData().getNodeId().equals(dir.get(i)) && tmpList.get(j).getData().getParentId().equals(dir.get(i-1)))   {

                    flag = 1;
                    tmpTreeNod = tmpList.get(j);
                    if (i <dir.size()-1)
                    tmpTreeNod.getData().getRoleautmap().put(role,"r");
                    else if (i == dir.size()-1) tmpTreeNod.getData().getRoleautmap().put(role,auth);
                    break;
                }
            }
            if (flag ==0) {
                return false;
            } else {
                flag = 0;
                tmpList = tmpTreeNod.getChildList();
                i++;
            }
        }
        return true;
    }



    public boolean Search_child(List<String> dir) {
        ManyTreeNode tmpTreeNod = root;
        List<ManyTreeNode> tmpList = root.getChildList();
        int i = 1;
        int flag = 0;

        while (i<dir.size()) {
            //tmpTreeNod = new ManyTreeNode(new TreeNode(dir.get(i),dir.get(i-1)));
            for (int j=0; j<tmpList.size(); j++) {
                if (tmpList.get(j).getData().getNodeId().equals(dir.get(i)) && tmpList.get(j).getData().getParentId().equals(dir.get(i-1)))   {

                    flag = 1;
                    tmpTreeNod = tmpList.get(j);
                    break;
                }
            }
            if (flag ==0) {
               return false;
            } else {
                flag = 0;
                tmpList = tmpTreeNod.getChildList();
                i++;
            }
        }
        return true;
    }

    public void Add_child(List<String> dir) {
        ManyTreeNode tmpTreeNod = root;
        List<ManyTreeNode> tmpList = root.getChildList();
        int i = 1;
        int flag  = 0 ;
        while (i<dir.size()) {

            //tmpTreeNod = new ManyTreeNode(new TreeNode(dir.get(i),dir.get(i-1)));
            //System.out.println("h");

            for (int j=0; j<tmpList.size(); j++) {
                if (tmpList.get(j).getData().getNodeId().equals(dir.get(i)) && tmpList.get(j).getData().getParentId().equals(dir.get(i-1))) {
                    flag = 1;
                    tmpTreeNod = tmpList.get(j);
                    break;
                }
            }
            if (flag == 0) {
                //System.out.println("h");
                //System.out.println(tmpTreeNod.getData().getNodeId());
                tmpTreeNod = new ManyTreeNode(new TreeNode(dir.get(i),dir.get(i-1)));
                tmpList.add(tmpTreeNod);
                //System.out.println(tmpList.get(0).getData().getNodeId());
            }
                tmpList = tmpTreeNod.getChildList();

            flag = 0;
            i++;
        }

    }

    /**
     * 遍历多叉树
     *
     * @param manyTreeNode 多叉树节点
     * @return
     */
    public void iteratorCreateDir(ManyTreeNode manyTreeNode, ISVNEditor editor) throws Exception {
          if (manyTreeNode !=null) {
              for (ManyTreeNode index : manyTreeNode.getChildList())
              {
                  try {
                      editor.addDir(index.getData().getNodeId(),null,-1);
                  }
                  catch (Exception e) {

                  }
                  if (index.getChildList() != null && index.getChildList().size() > 0 )
                  {
                      iteratorCreateDir(index,editor);
                  }
                  editor.closeDir();
              }
          }
    }

    public void iteratorTreeAuth(ManyTreeNode manyTreeNode,OutputStreamWriter out, String current_dir, String prj) throws Exception {
        String temp = current_dir;
        out.write("\r\n");
        if (manyTreeNode.getData().getNodeId().equals("/")){
            System.out.println("hele");
            out.write('['+prj+"/]\r\n");
            for (Map.Entry<String, String> entry : manyTreeNode.getData().getRoleautmap().entrySet()) {

                String key = entry.getKey();

                String value = entry.getValue();

                System.out.println("key=" + key + " value=" + value);
                out.write("@"+key+"="+value+"\r\n");
            }
            out.write("\r\n");
        }

         if (manyTreeNode !=null) {

            //System.out.println(manyTreeNode.getData().getNodeId());
            for (ManyTreeNode index : manyTreeNode.getChildList()) {
                current_dir = temp+index.getData().getNodeId()+'/';
                System.out.println(current_dir);
                out.write('['+prj+current_dir+"]\r\n");
                for (Map.Entry<String, String> entry : index.getData().getRoleautmap().entrySet()) {

                    String key = entry.getKey().toString();

                    String value = entry.getValue().toString();

                    System.out.println("key=" + key + " value=" + value);
                    out.write("@"+key+"="+value+"\r\n");
                }
                out.write("\r\n");

                if (index.getChildList() != null && index.getChildList().size() > 0) {
                    iteratorTreeAuth(index, out, current_dir,prj);
                }
            }
        System.out.println("hh:"+manyTreeNode.getData().getNodeId());
        }
        out.write("\r\n");


    }

    public String iteratorTree(ManyTreeNode manyTreeNode) {
        StringBuilder buffer = new StringBuilder();
        buffer.append("\n");

        if (manyTreeNode != null) {
            for (ManyTreeNode index : manyTreeNode.getChildList()) {
                buffer.append(index.getData().getNodeId() + ",");

                if (index.getChildList() != null && index.getChildList().size() > 0) {
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
        treeNodes.add(new TreeNode("系统权限管理", "/"));
        treeNodes.add(new TreeNode("用户管理", "系统权限管理"));

        treeNodes.add(new TreeNode("角色管理", "系统权限管理"));
        treeNodes.add(new TreeNode("角色管理", "系统权限管理"));
        treeNodes.add(new TreeNode("角色管理", "系统权限管理"));
        /*
        treeNodes.add(new TreeNode("组管理", "系统权限管理"));
        treeNodes.add(new TreeNode("用户菜单管理", "系统权限管理"));
        treeNodes.add(new TreeNode("角色菜单管理", "系统权限管理"));
        treeNodes.add(new TreeNode("用户权限管理", "系统权限管理"));
        treeNodes.add(new TreeNode("站内信", "root"));
        treeNodes.add(new TreeNode("写信", "站内信"));
        treeNodes.add(new TreeNode("收信", "站内信"));
        treeNodes.add(new TreeNode("草稿", "站内信"));
        */

        for (int i = 0; i < treeNodes.size(); i++) {
            TreeNode tmp = treeNodes.get(i);
            //System.out.println(tmp.getNodeId()+tmp.getParentId());
            int j = i + 1;
            while (j < treeNodes.size()) {

                TreeNode tmp2 = treeNodes.get(j);
                if (tmp.getParentId().equals(tmp2.getParentId()) && tmp.getNodeId().equals(tmp2.getNodeId())) {
                    treeNodes.remove(j);
                    //System.out.println(tmp2.getParentId()+','+tmp.getParentId());
                    //System.out.println(tmp2.getNodeId()+','+tmp.getNodeId());
                } else {
                    j++;
                }

            }
        }
        Iterator<TreeNode> iter = treeNodes.iterator();
        while (iter.hasNext()) {
            TreeNode tmp4 = iter.next();
            // System.out.println(tmp4.getNodeId()+','+tmp4.getParentId());
        }


        ManyNodeTree tree = new ManyNodeTree();

       // System.out.println(tree.iteratorTree(tree.createTree(treeNodes).getRoot()));
    }

}