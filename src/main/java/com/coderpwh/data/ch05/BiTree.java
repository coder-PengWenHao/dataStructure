package com.coderpwh.data.ch05;

import com.coderpwh.data.ch03.LinkStack;

public class BiTree {


    private BiTreeNode root;


    public BiTree() {
        this.root = null;
    }


    public BiTree(BiTreeNode root) {
        this.root = root;
    }

    /***
     *   从根部遍历二叉树，递归方式，现在左树后右树
     * @param T
     */
    public void preRootTraverse(BiTreeNode T) {

        if (T != null) {
            System.out.println(T.data);
            preRootTraverse(T.lchild);
            preRootTraverse(T.rchild);
        }
    }


    /***
     *
     *  从中根遍历，递归方式实现(先左树，后右树)
     *
     * @param T
     */
    public void intRootTraverse(BiTreeNode T) {

        if (T != null) {
            intRootTraverse(T.lchild);
            System.out.println(T.data);
            intRootTraverse(T.rchild);
        }
    }


    /***
     *   从后根遍历，递归方式实现
     *
     * @param T
     */
    public void postRootTraverse(BiTreeNode T) {
        if (T != null) {
            postRootTraverse(T.lchild);
            postRootTraverse(T.rchild);
            System.out.println(T.data);
        }

    }


    /***
     *  非递归方式，从根部开始遍历
     *
     *
     */
    public void preRootTraverse() {

        try {
            BiTreeNode T = root;

            if (T != null) {
                LinkStack S = new LinkStack();
                S.push(T);
                while (!S.isEmpty()) {
                    T = (BiTreeNode) S.pop();
                    System.out.println(T.data);
                    while (T != null) {
                        if (T.lchild != null) {
                            System.out.println(T.lchild.data);
                        }
                        if (T.rchild != null) {
                            S.push(T.rchild);
                        }
                        T = T.lchild;
                    }

                }

            }
        } catch (Exception e) {
            e.getMessage();
        }
    }


    /****
     *
     *  非递归方式,从中根开始遍历实现
     *
     *
     *
     */
    public void intRootTraverse() {
        try {
            BiTreeNode T = root;
            if (T != null) {
                LinkStack S = new LinkStack();
                S.push(T);
                while (!S.isEmpty()) {
                    while (S.peek() != null) {
                        S.push(((BiTreeNode) S.peek()).lchild);
                    }
                    S.pop();
                    if (!S.isEmpty()) {
                        T = (BiTreeNode) S.pop();
                        System.out.println(T.data);
                        S.push(T.rchild);
                    }
                }
            }

        } catch (Exception e) {
            e.getMessage();
        }
    }


    /***
     *
     *  非递归方式，从后根方式遍历实现
     *
     *
     *
     */
    public void postRootTraverse() {
        try {
            BiTreeNode T = root;
            if (T != null) {
                LinkStack S = new LinkStack();
                S.push(T);
                Boolean flag;
                BiTreeNode p = null;

                while (!S.isEmpty()) {
                    while (S.peek() != null) {
                        S.push(((BiTreeNode) S.peek()).lchild);
                    }
                    S.pop();
                    while (!S.isEmpty()) {
                        T = (BiTreeNode) S.peek();
                        if (T.rchild == null || T.rchild == p) {
                            System.out.println(T.data);
                            S.pop();
                            p = T;
                            flag = true;
                        } else {
                            S.push(T.rchild);
                            flag = false;
                        }
                        if (!flag) {
                            break;
                        }
                    }

                }
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }


}
