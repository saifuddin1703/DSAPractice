package leetcode;

public class mergeKSortedLinkedList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp1 = l1, temp2 = l2,l3 = null, temp3 = null;


        if(l1==null && l2 == null) return l3;
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        while(temp1!=null&&temp2!=null){
            if(temp1.val<temp2.val)
            {
                if(l3 == null ) {
                    temp3 = temp1;
                    l3 = temp3;
                }
                else{
                    temp3.next = temp1;
                    temp3 = temp3.next;
                }
                temp1 = temp1.next;
            }
            else{
                if(l3 == null ) {
                    temp3 = temp2;
                    l3 = temp3;
                }
                else{
                    temp3.next = temp2;
                    temp3 = temp3.next;
                }
                temp2 = temp2.next;

            }
        }

        if(temp1!=null)
            temp3.next = temp1;

        if(temp2!=null)
            temp3.next = temp2;

        return l3;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n==0) return null;
        ListNode prev = lists[0];
        for (int i =1; i<n; i++){
            ListNode current = lists[i];
            prev = mergeTwoLists(prev,current);
        }
        return prev;
    }
}
