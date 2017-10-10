package data_structure.List;

public class ListNode {
	
	public ListNode nextNode;
	public int value;
	
	public ListNode(int e){
		this(e,null);
	}
	
    public ListNode(int e, ListNode n){
    	this.value =e;
    	this.nextNode=n;
    }

}

