

public class DoublyLinkedList {
    private DLink head;
    private int size;

    public DoublyLinkedList(){
        this.head = null;
        this.size = 0;
    }

    public void insertAtFirst(String data){
        if(head == null ){
            head = new DLink(null, data, null);
        }
        else{
            DLink newLink = new DLink(null, data, head);
            head.previous = newLink;
            head = newLink;
        }
        size++;
    }

    public void deleteFirst(){
        if(head == null){
            return;
        }
        head = head.next;
        head.previous = null;
        size--;
        
    }

    public void insertAtLast(String data){
        if(head == null){
            head = new DLink(null, data, null);
        }
        else{
            DLink currentLink = head;
            while(currentLink.next != null){
                currentLink = currentLink.next;
            }
            DLink newLink = new DLink(currentLink, data, null);
            currentLink.next = newLink;
        }
        size++;
    }


    public void deleteLast(){
        if(head == null){
            return;
        }
        if(head.next == null){
            head = null;
            size--;
            return;
        }
        DLink currentLink = head;
        while(currentLink.next.next != null){
            currentLink = currentLink.next;
        }
        currentLink.next = null;
        size--;
    }



    public void insertAt(String data, int index){
        if(head == null){
            return;
        }
        if(index < 1 || index > size){
           return; 
        }

        DLink currentLink = head;
        int i = 1;
        while(i < index){
            currentLink = currentLink.next;
            i++;
        }

        if(currentLink.previous == null){
            DLink newLink = new DLink(null, data, currentLink);
            currentLink.previous = newLink;
            head = newLink;
        }
        else{
            DLink newLink = new DLink(currentLink.previous, data, currentLink);
            currentLink.previous.next = newLink;
            currentLink.previous = newLink;
        }
        size++;
    }


    public void deleteAt( int index){
        if(head == null){
            return;
        }
        if(index < 1 || index > size){
            return; 
         }

        DLink currentLink = head;
        int i = 1;
        while(i < index){
            currentLink = currentLink.next;
            i++;
        }
        if(currentLink.next == null){
            currentLink.previous.next = null;
        }
        else if(currentLink.previous == null){
            currentLink = currentLink.next;
            currentLink.previous = null;
            head = currentLink;
        }
        else{
            currentLink.previous.next = currentLink.next;
            currentLink.next.previous = currentLink.previous;
        }
        size--;
    }


    public void recursiveInsertAfter(DLink currentLink ,String insertAfter, String data){
        if(head == null){
            return;
        }

        if(currentLink.data.equals(insertAfter)){
            DLink newNode = new DLink(data);
            if(currentLink.next != null){
                currentLink.next.previous = newNode;
                newNode.next = currentLink.next;
            }
            currentLink.next = newNode;
            newNode.previous = currentLink;
        }
        else{
            recursiveInsertAfter(currentLink.next, insertAfter, data);
        }
    }

    public void display(){

        DLink currentLink = head;
        while(currentLink != null){
            System.out.println(currentLink.data());
            currentLink = currentLink.next;
            // System.out.println("size is " +size);
            System.out.println("\t|");
            System.out.println("\t|");
            System.out.println("\t\\/");
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAtFirst("Kofi Boakye");
        dll.insertAtLast("Simon Opoku");
        dll.insertAtLast("Benjamin Osei");
        dll.insertAtLast("Fredrick Ansong");
        
        dll.display();
        System.out.println("—————————————-");
        dll.deleteAt(2);
        dll.display();
        
       

    }
}
