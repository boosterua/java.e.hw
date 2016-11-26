

public class LinkedList {

    public Item first;
    public Item last;

    public void insertFirst(Object elem){
        Item newItem = new Item(elem);
        newItem.next = this.first;
        newItem.prev = null;
        this.first = newItem;
    }
    
    public void insertLast(Object elem){
        Item newItem = new Item(elem);
        newItem.next = null;
        newItem.prev = this.last;
        this.last = newItem;
    }
    
    public Item popFirst(){
        Item popped = this.first;
        if (popped == null)
            return null;
        this.first = popped.next;
        popped.next.prev = null;
        return popped;
    }

    public Item popLast(){
        Item popped = this.last;
        if (popped == null)
            return null;
        this.last = popped.prev;
        popped.prev.next = null;
        return popped;
    }

    public void printList(){
        Item elem = this.last;
        while (elem!=null) {
            System.out.println(elem.getItem());
            elem = elem.prev;
        }
    }

    public void printReverseList(){
        Item elem = this.first;
        while (elem!=null) {
            System.out.println(elem.getItem());
            elem = elem.next;
        }
    }
    
    
    class Item {
        Object element;
        Item next = null;
        Item prev = null;
        
        public Item(Object o){
            this.element = o;
        }

        public Object getItem(){
            return this.element;
        }
    }    
}

    

    

