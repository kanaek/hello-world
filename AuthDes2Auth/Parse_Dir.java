package AuthDes2Auth;

import java.util.*;

/**
 * Created by user on 2016/3/7.
 */
public class Parse_Dir {

    private List<TreeNode> treeNodes;
    private ManyNodeTree tree ;
    private List<String> dir;
    private Set<String> dir2;

    private List<Dir> dir3;

    public List<Dir> getDir3() {
        return dir3;
    }

    public void setDir3(List<Dir> dir3) {
        this.dir3 = dir3;
    }

    public ManyNodeTree getTree() {
        return tree;
    }

    public void setTree(ManyNodeTree tree) {
        this.tree = tree;
    }

    public List<String> getDir() {
        return dir;
    }

    public void setDir(List<String> dir) {
        this.dir = dir;
    }



    public List<TreeNode> getTreeNodes() {
        return treeNodes;
    }

    public void setTreeNodes(List<TreeNode> treeNodes) {
        this.treeNodes = treeNodes;
    }



    public Parse_Dir() {
        treeNodes = new ArrayList<TreeNode>();
        tree = new ManyNodeTree();
        dir = new ArrayList<String>();
        dir2 = new HashSet<String>();
        dir3 = new ArrayList<Dir>();
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
                  // System.out.println(tmp+",/");
                   lastSlash = i;

                   dir.add("/");
                   dir.add(tmp);
                   dir2.add(line.substring(0,i));
               } else if (countSlash>2){

                   tmp = line.substring(lastSlash+1,i);


                   dir.add(tmp);
                   dir2.add(line.substring(0,i));
                   lastSlash = i;

               }
               lastSlash = i;

           }

            if (i==line.length()-1){
                if (countSlash==1) {
                    //System.out.println(line.substring(lastSlash+1,i+1)+','+'/');

                    dir.add("/");
                    dir.add(line.substring(lastSlash+1,i+1));
                    dir2.add(line.substring(0,i+1));

                    break;
                }
                else if (countSlash>=2 && line.charAt(i) !='/') {

                    tmp =  line.substring(lastSlash+1,i+1);

                    dir.add(tmp);
                    dir2.add(line.substring(0,i+1));
                    //add_child(tmp, tmp2);

                }
           }
           i++;
        }
        //System.out.println(line);
    }

    public void sort_Dir() {
        int count;
        System.out.println("---------------");
        Iterator<String> iter = dir2.iterator();
        //dir.get(0).
        while (iter.hasNext()) {
            String tmp4 = iter.next();
            String tmp5=tmp4;
            count = tmp5.length() - tmp5.replaceAll("/","").length();
            dir3.add(new Dir(tmp4,count));
           // System.out.println(count);


        }
        for (int i = 0; i < dir3.size(); i++)
        {
            for (int j = i; j < dir3.size(); j++)
            {
                if (dir3.get(i).count > dir3.get(j).count)
                {
                    Dir temp = dir3.get(i);
                    dir3.set(i, dir3.get(j));// dir3.get(j);
                    dir3.set(j, temp);
                }
            }
        }

        Iterator<Dir> iter3 = dir3.iterator();
        //System.out.println(dir3.get(1).count);
        while (iter3.hasNext())  {
            System.out.println(iter3.next().dir);
        }
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

        parse.parse_line("/trunk/doc/ppp/10.项目周报" );
        parse.parse_line("/trunk/doc/09.会议纪要");
        parse.parse_line("/trunk/doc/08.部署");
        parse.parse_line("/trunk/doc/04.数据导入");
        parse.parse_line("/trunk/doc/00.项目计划");
        parse.parse_line("/trunk/doc/00.项目计划");
        parse.parse_line("/line2");
        parse.parse_line("/trunk/d/");
        parse.parse_line("/trunk/d");
        parse.parse_line("/trunk/doc/01.用户需求");
        parse.parse_line("/d/d");
        parse.parse_line("/d/d/d");

        parse.sort_Dir();


    }
}
