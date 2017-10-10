package data_structure.BinaryTree;

public class BinaryNode<T extends Comparable> {
    public T value;
    public BinaryNode<T> left;
    public BinaryNode<T> right;


    public BinaryNode(T element){
    	      this(element,null,null);
       }
    public BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right){
    	       this.value =element;
    	       this.left=left;
    	       this.right=right;
       }
       
}
