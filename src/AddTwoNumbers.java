public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode l3 = result;
        int carryOver = 0;
        while (l1 != null || l2 != null) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sum = l1Val + l2Val + carryOver;
            carryOver = sum / 10;
            int lastDigit = sum % 10;
            l3.next = new ListNode(lastDigit);
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
            l3 = l3.next;
        }
        if (carryOver > 0) {
            l3.next = new ListNode(carryOver);
        }

        return result.next;
    }

    public static void main(String args[]) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
//        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9)));
//        ListNode l2 = new ListNode(9, new ListNode(9));
        System.out.println(addTwoNumbers(l1, l2));
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        String result = String.valueOf(val);
        ListNode l = next;
        while (l != null) {
            result += l.val;
            l = l.next;
        }
        return result;
    }
}