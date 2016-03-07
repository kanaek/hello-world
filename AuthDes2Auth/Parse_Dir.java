package AuthDes2Auth;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by user on 2016/3/7.
 */
public class Parse_Dir {

    private List<TreeNode> treeNodes;
    private ManyNodeTree tree ;

    public List<TreeNode> getTreeNodes() {
        return treeNodes;
    }

    public void setTreeNodes(List<TreeNode> treeNodes) {
        this.treeNodes = treeNodes;
    }



    public Parse_Dir() {
        treeNodes = new ArrayList<TreeNode>();
        tree = new ManyNodeTree();
    }

    public void parse_line(String line){

        int countSlash = 0;
        int lastSlash = 0;
        line = line.replaceAll(" ","");
        int i = 0;
        String tmp2,tmp=null;
        while (i<line.length()) {
           if(line.charAt(i) =='/' ) {
               countSlash++;

               if (countSlash==2) {
                   tmp = line.substring(1,i);
                   System.out.println(tmp+",/");
                   lastSlash = i;
                   tree.addChild(new );
                   add_child(tmp,"/");
               } else if (countSlash>2){
                   tmp2= tmp;
                   tmp = line.substring(lastSlash+1,i);
                   System.out.println(tmp2+','+tmp);
                   add_child(tmp,tmp2);
                   lastSlash = i;

               }
               lastSlash = i;

           }

            if (i==line.length()-1){
                if (countSlash==1) {
                    System.out.println(line.substring(lastSlash+1,i+1)+','+'/');
                    add_child(line.substring(lastSlash+1,i+1),"/");
                    break;
                }
                else if (countSlash>=2 && line.charAt(i) !='/') {

                    tmp2=tmp;
                    tmp =  line.substring(lastSlash+1,i+1);
                    System.out.println(tmp+','+tmp2);
                    add_child(tmp, tmp2);
                }
           }
           i++;
        }
        //System.out.println(line);
    }

    public void add_child(String child, String father) {
        treeNodes.add(new TreeNode(child, father));
    }

    public void delete_Dup() {
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
            System.out.println(tmp4.getNodeId()+','+tmp4.getParentId());
        }
    }

    public static void main(String[] args) {
        Parse_Dir parse = new Parse_Dir();
        /*
        parse.parse_line("/trunk/doc/ppp/10.项目周报" );
        parse.parse_line("/trunk/doc/09.会议纪要");
        parse.parse_line("/trunk/doc/08.部署");
        parse.parse_line("/trunk/doc/04.数据导入");
        parse.parse_line("/trunk/doc/00.项目计划");
        parse.parse_line("/trunk/doc/00.项目计划");
        */
        parse.parse_line("/dddd/dddd/dddd/");
        System.out.println();
        parse.delete_Dup();
    }
}
