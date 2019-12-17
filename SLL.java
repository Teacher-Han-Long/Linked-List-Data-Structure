class SLL {
	
	/* LIST NODE */
	private static class ListNode {
		private ListNode next;
		private int data;
		public ListNode( int data ) {
			this.data = data;
			this.next = null;
		}
	}
	
	/* METHODS */
	
	//prints a linked list
	public void displayList( ListNode head ) {
		if (head == null) {
			System.out.println("Head is null. Can't display Linked List.");
			return;
		}
		
		ListNode curr = head;
		while (curr != null) {
			System.out.printf("[%s]-->", curr.data);
			curr = curr.next;
		}
		System.out.printf("[%s]%n", curr);
		System.out.println();
	}
	
	//returns the length of a linked list
	public int getListLength(ListNode head) {
		if (head == null) return 0;
		ListNode curr = head;
		int count = 0;
		while (curr != null) {
			count++;
			curr = curr.next;
		}
		return count;
	}
	
	//inserts a node as new head
	public ListNode insertAtBeg(ListNode head, int data) {
		ListNode newNode = new ListNode(data);
		if (head == null) {
			head = newNode;
			return head;
		}
		newNode.next = head;
		head = newNode;
		return head;
	}
	
	//appends a new list node
	public ListNode insertAtEnd(ListNode head, int data) {
		ListNode newNode = new ListNode(data);
		if (head == null) {
			head = newNode;
			return head;
		}
		ListNode curr = head;
		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next = newNode;
		return head;
	}
	
	//inserts a new node after a given node
	public void insertAfterNode(ListNode prev, int data) {
		if (prev == null) {
			System.out.printf("%s does not exist. Bad data!", prev);
			return;
		}
		ListNode newNode = new ListNode(data);
		newNode.next = prev.next;
		prev.next = newNode;
	}
	
	//inserts a node at a given position
	public ListNode insertAtPosition(ListNode head, int data, int pos) {
		ListNode newNode  = new ListNode(data);
		if (head == null) {
			head = newNode;
			return head;
		}
		int len = getListLength(head);
		if (pos < 1 || pos > len + 1) {
			System.out.printf("%d is an invalid position.", pos);
			return head;
		}
		
		if (pos == 1) {
			newNode.next = head;
			head = newNode;
			return head;
		} else {
			ListNode prev = head;
			int count = 1;
			while ( count < pos -1) {
				prev = prev.next;
				count++;
			}
			ListNode curr = prev.next;
			newNode.next = curr;
			prev.next = newNode;
			return head;
		}
	}
	
	/*TODO: fix -  RETURN FIRST NODE*/
	public ListNode removeFirst(ListNode head) {
		if (head == null) return head;
		ListNode temp = head;
		head = head.next;
		temp.next = null;
		return head;
	}
	
	//delete the last node of a list
	public ListNode removeLast(ListNode head) {
		if (head == null) return head;
		ListNode prev = null;
		ListNode last = head;
		while (last.next != null) {
			prev = last;
			last = last.next;
		}
		prev.next = null;
		return last;
	}
	
	//deletes a node at a given position
	public ListNode removeAtPosition(ListNode head, int pos) {
		int len = getListLength(head);
		if (pos < 1 || pos > len) {
			System.out.printf("Invalid position. There are only %d elements.%n%n", len);
			return head;
		}
		if (pos == 1) {
			ListNode temp = head;
			head = head.next;
			temp.next = null;
			return temp;
		} else {
			ListNode prev = head;
			int count = 1;
			while (count < pos - 1) {
				prev = prev.next;
				count++;
			}
			ListNode curr = prev.next;
			prev.next = curr.next;
			curr.next = null;
			return curr;
		}
	}
	
	
	/* MAIN METHOD */
	
	public static void main(String[] args) {
		//create Linked List
		//assign next nodes
		ListNode head = new ListNode(0);
		ListNode first = new ListNode(1);
		ListNode third = new ListNode(3);
		head.next = first;
		first.next = third;
		//create a singly linked list object
		//display the list
		SLL sll = new SLL();
		sll.displayList(head);
		//get the length of the list
		int len = sll.getListLength(head);
		System.out.printf("Length:  There are %d nodes in the list. %n%n", len);
		//insert a node at the beginning
		head = sll.insertAtBeg(head, -1);
		sll.displayList(head);
		//insert a node at the end 
		head = sll.insertAtEnd(head, 5);
		sll.displayList(head);
		//insert a new node after a given node
		sll.insertAfterNode(first, 2);
		sll.displayList(head);
		System.out.printf("The length is now %d.%n%n", sll.getListLength(head));
		//insert after a given position
		head = sll.insertAtPosition(head, 4, 6);
		sll.displayList(head);
		//remove first element
		head = sll.removeFirst(head);
		sll.displayList(head);
		//remove last node
		ListNode last = sll.removeLast(head);
		System.out.println("At \"last\" : " + last.data);
		sll.displayList(head);
		//remove a node at given position
		ListNode fourthNode = sll.removeAtPosition(head, 4);
		System.out.println(fourthNode.data);
		sll.displayList(head);
		System.out.println();
	}
}