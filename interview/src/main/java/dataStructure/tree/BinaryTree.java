package dataStructure.tree;

import java.util.Stack;

/**
 * 二叉搜索树
 * Created by conglin.liu on 2017/8/10.
 * 要删除节点是父节点的
 * 删除节点的字树
 */
public class BinaryTree {
    private Node root;  //根节点

    public BinaryTree() {
        root = null;
    }

    /**
     * 按关键字查找节点
     * @param key
     * @return
     */
    public Node find(int key) {
        //从根节点开始
        Node cur = root;
        if (cur == null) {
            return null;
        }

        while (cur.age != key) {
            if (key < cur.age ) { //左边
                cur = cur.leftChild;
            } else {//右边
                cur = cur.rightChild;
            }

            if (cur == null) {//没有找到结果
                return null;
            }
        }
        System.out.println(cur.display());
        return cur;
    }

    /**
     *插入新节点
     * @param node
     */
    public void insert(Node node) {
        if(root == null) {
            root = node;
            return;
        }else{
            Node cur = root;
            while(true) {
                if (node.age < cur.age) {  //左字树, 找到插入节点的父节点
                     if (cur.leftChild == null) {
                        cur.leftChild = node;
                        return;
                    }
                    cur = cur.leftChild;

                }else {
                    if(cur.rightChild == null) { //右子树, 找到插入节点的父节点
                        cur.rightChild = node;
                        return;
                    }
                    cur = cur.rightChild;
                }
            }
        }

    }

    /**
     * 删除指定节点
     * @param node
     * @return
     */
    public boolean delete(Node node){
        if(root == null) {
            return false;
        }
        Boolean isLeftChild  = true;//要删除的节点是否为父节点左子节点
        Node cur = root; //要删除的节点
        Node parent = null;//要删除节点的父节点

        //确定目标节点和它的父节点
       while(node.age != cur.age) {
           parent = cur;
           if(node.age < cur.age) {//要删除节点是左子节点
                cur = cur.leftChild;
           }else{   //要删除节点是右子节点
               isLeftChild = false;
               cur = cur.rightChild;
           }

           if(cur == null) { //没找到要删除节点
               return false;
           }
       }

        //删除节点是叶子节点
        if(cur.leftChild==null && cur.rightChild==null) {
            if (cur == root) {
                root = null;
            }else if (isLeftChild) {
                parent.leftChild = null;
            }else{
                parent.rightChild = null;
            }
        }else  if(cur.leftChild == null) {//删除节点只有一个右子节点
            if(cur == root) {
                root = cur.rightChild;
            }else if(isLeftChild) {
                parent.leftChild = cur.rightChild;
            }else{
                parent.rightChild = cur.rightChild;
            }
        } else if(cur.rightChild == null) {//删除节点只有一个左子节点
            if(cur == root) {
                root = cur.leftChild;
            }else if(isLeftChild) {
                parent.leftChild = cur.leftChild;
            }else{
                parent.rightChild = cur.leftChild;
            }
        }else{ //删除节点有两个子节点

            //找到后继节点
            Node successor = cur.rightChild;     //最终的值是后继节点
            Node successorParent = null;          //最终的值是后继节点的父节点
            if(successor.leftChild != null) {
                successorParent = successor;
                successor = successor.leftChild;
            }
            //后继节点是右子节点, 右子节点没有左字树
            if(successorParent == null) {
                if(cur == root) {
                    root = successor;
                    root.leftChild = cur.leftChild;
                }else if (isLeftChild) {
                    parent.leftChild = successor;
                    successor.leftChild = cur.leftChild;
                }else{
                    parent.rightChild = successor;
                }
            }else { //后继节点不是右子节点, 右子节点有左字树
                successorParent.leftChild = successor.rightChild; //维护后继节点的父节点
                successor.rightChild = cur.rightChild; //维护删除节点的右子节点
                if(cur == root) {
                    root = successor;
                    root.leftChild = cur.leftChild;
                }else if (isLeftChild) {
                    parent.leftChild = successor;
                    successor.leftChild = cur.leftChild;
                }else{
                    parent.rightChild = successor;
                    successor.leftChild = cur.leftChild;
                }
            }

        }
        return true;
    }
// 递归遍历
    //前序遍历
    public void preorder(Node currentRoot) {
        if(currentRoot != null) {
            System.out.println(currentRoot.age + "\t");
            preorder(currentRoot.leftChild);
            preorder(currentRoot.rightChild);
        }
    }

    //中续遍历
    public void inorder(Node currentRoot) {
        if(currentRoot != null) {
            inorder(currentRoot.leftChild);
            System.out.println(currentRoot.age + "\t");
            inorder(currentRoot.rightChild);
        }
    }

    //后续遍历
    public void postorder(Node currentRoot){
        if(currentRoot != null){
            postorder(currentRoot.leftChild);
            postorder(currentRoot.rightChild);
            System.out.print(currentRoot.age+"\t");
        }
    }

    //非递归遍历  https://www.bbsmax.com/A/qVdeyavMdP/

    /** 非递归实现前序遍历 */
    public  void iterativePreorder(Node p) {
       Stack<Node> stack = new Stack<>();
       if(p != null ) {
           stack.push(p);
           while(!stack.isEmpty()) {
                p = stack.pop();
               System.out.println(p.age);
               if(p.rightChild != null) {
                   stack.push(p.rightChild);
               }
               if(p.leftChild != null) {
                   stack.push(p.leftChild);
               }
           }
       }
    }


      //中序遍历
      public void iterativeInOrder(Node pNode) {
          Stack<Node> stack = new Stack<>();
          if(pNode == null)
              return ;

          while(!stack.isEmpty()|| pNode != null){
              while(pNode!=null){  //找到左叶节点
                  stack.push(pNode);
                  pNode = pNode.leftChild;
              }
              pNode = stack.pop();
              System.out.println(pNode.age);
              pNode = pNode.rightChild;
          }
      }

      //后续遍历 : 双栈法
      public void iterativePostOrder(Node node) {
          if(node == null)
              return ;
          Stack<Node> stack1 = new Stack<>();
          Stack<Node> stack2 = new Stack<>();//辅助栈
          stack1.push(node);

          //stack1弹出的元素，压入stack2，在将该元素的左右节点压入stack1
          while(!stack1.isEmpty()) {
              node = stack1.pop();
              stack2.push(node);
              if(node.rightChild!= null){
                  stack1.push(node.rightChild);
              }
              if(node.leftChild != null) {
                  stack1.push(node.leftChild);
              }
          }

          //stack2弹出的即是后序遍历的顺序
          while(!stack2.isEmpty()) {
              node = stack2.pop();
              System.out.println(node.age);
          }
      }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node n1 = new Node(20,"20");
        Node n2 = new Node(10,"10");
        Node n3 = new Node(30 ,"30");

        tree.insert(n1);
        tree.insert(n2);
        tree.insert(n3);

//      tree.find(30);

//            System.out.println(tree.root);
//            tree.delete(n2);
//            System.out.println(tree.root);

//            tree.preorder(n1);
//            tree.inorder(n1);
//            tree.postorder(n1);

        tree.iterativePreorder(n1);
//        tree.iterativeInOrder(n1);
//        tree.iterativePostOrder(n1);
    }
}