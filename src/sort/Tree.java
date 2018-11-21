package sort;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    private String jsonTreeStr = "[{\"id\": 1,\"code\": \"FLOW_NODE_1\",\"name\": \"环节A\",\"children\": [{\"id\": 2,\"code\": \"RULE_NODE_1\",\"name\": \"规则A\"}, {\"id\": 3,\"code\": \"RULE_NODE_2\",\"name\": \"规则B\"}, {\"id\": 4,\"code\": \"PARALLEL_NODE_2\",\"name\": \"并行节点\",\"children\": [{\"id\": 5,\"code\": \"RULE_NODE_3\",\"name\": \"规则C1\"}, {\"id\": 6,\"code\": \"RULE_COLLECTION_1\",\"name\": \"规则集1\",\"children\": [{\"id\": 7,\"code\": \"RULE_NODE_4\",\"name\": \"规则C21\"}, {\"id\": 8,\"code\": \"RULE_NODE_5\",\"name\": \"规则C22\"}]}]}, {\"id\": 9,\"code\": \"MUTUAL_NODE_1\",\"name\": \"互斥节点\",\"children\": [{\"id\": 10,\"code\": \"RULE_NODE_6\",\"name\": \"规则D1\"}, {\"id\": 11,\"code\": \"RULE_NODE_7\",\"name\": \"规则D2\"}]}]}, {\"id\": 12,\"code\": \"FLOW_NODE_2\",\"name\": \"环节B\"}]";

    private List<TreeNode> treeNodes = new ArrayList<>();

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.buildTree(tree.jsonTreeStr);
        System.out.println("=============测试Tree是否生成==================");
        System.out.println("treeNodes Size ：" + tree.treeNodes.size());
        TreeNode nodeList = tree.treeNodes.get(1);
        tree.printTree(nodeList);
        System.out.println("=============测试Tree生成成功==================");

        TreeNode treeNode = tree.searchNodeById(6, tree.treeNodes);
        System.out.println("=============根据Id查询Tree的节点==================");
        tree.printTree(treeNode);
        System.out.println("=============根据Id查询Tree的节点完毕==================");

        tree.updateNode(6, tree.treeNodes);
        TreeNode treeNode1 = tree.searchNodeById(6, tree.treeNodes);
        System.out.println("=============根据Id修改Tree的节点==================");
        tree.printTree(treeNode1);
        System.out.println("=============根据Id修改Tree的节点==================");

    }


    private TreeNode searchNodeById(int id, List<TreeNode> rootNodes) {
        for (TreeNode treeNode : rootNodes) {
            if (treeNode.id == id) {
                return treeNode;
            } else {
                List<TreeNode> children = treeNode.children;
                if (children != null) {
                    return searchNodeById(id, children);
                }
            }
        }
        return null;
    }

    private void updateNode(int id, List<TreeNode> rootNodes) {
        TreeNode treeNode = searchNodeById(id, rootNodes);
        if (treeNode != null)
            treeNode.isSelected = true;
    }

    private void buildTree(String jsonTreeStr) {
        JSONArray jsonArray = JSONArray.parseArray(jsonTreeStr);
        parseJSONArray(jsonArray, treeNodes);
    }

    private void parseJSONArray(JSONArray jsonArray, List<TreeNode> treeNodes) {
        int size = jsonArray.size();
        for (int i = 0; i < size; i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);

            TreeNode rootNode = new TreeNode();
            int id = jsonObject.getInteger("id");
            rootNode.id = id;
            String code = jsonObject.getString("code");
            rootNode.code = code;
            String name = jsonObject.getString("name");
            rootNode.name = name;
            rootNode.isSelected = false;
            JSONArray jsonArrayChildren = jsonObject.getJSONArray("children");

            System.out.println("============开始构建Tree===================");
            printTree(rootNode);
            System.out.println("============开始构建Tree===================");

            if (jsonArrayChildren != null) {
                List<TreeNode> treeNodeList = new ArrayList<>();
                rootNode.children = treeNodeList;
                parseJSONArray(jsonArrayChildren, treeNodeList);
            }
            treeNodes.add(rootNode);
        }
    }

    private void printTree(TreeNode nodeList) {
        System.out.println("id：" + nodeList.id);
        System.out.println("code：" + nodeList.code);
        System.out.println("isSelected：" + nodeList.isSelected);
        System.out.println("name：" + nodeList.name);
        System.out.println("children：" + nodeList.children);
        List<TreeNode> treeNode = nodeList.children;
        if (treeNode != null) {
            for (TreeNode node : treeNode) {
                printTree(node);
            }
        }
    }


    public class TreeNode {
        int id;
        String code;
        String name;
        boolean isSelected;
        List<TreeNode> children;

        public TreeNode() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<TreeNode> getChildren() {
            return children;
        }

        public void setChildren(List<TreeNode> children) {
            this.children = children;
        }

        public boolean isSelected() {
            return isSelected;
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
        }
    }


}
