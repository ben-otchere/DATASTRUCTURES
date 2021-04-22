
import java.util.*;

class ArrayListClass {

  // arr is the array which stores ArrayList elements
  private int arr[];

  // capacity of the ArrayList
  private int capacity;

  // current is the number of elements present in the ArrayList
  private int current;

  // Default constructor to initialise
  // an initial capacity of 1 element and
  // allocating storage using dynamic allocation
  public ArrayListClass()
  {
    arr = new int[1];
    capacity = 1;
    current = 0;
  }
  public void push(int data)
  {

    if (current == capacity) {
      int temp[] = new int[2 * capacity];

      for (int i = 0; i < capacity; i++)
        temp[i] = arr[i];

      capacity *= 2;
      arr = temp;
    }

    arr[current] = data;
    current++;
  }

  void push(int data, int index)
  {

    if (index == capacity)
      push(data);
    else
      arr[index] = data;
  }

  int get(int index)
  {

    if (index < current)
      return arr[index];

    return -1;
  }


  void pop()
  {
    current--;
  }

  int size()
  {
    return current;
  }

  int getcapacity()
  {
    return capacity;
  }

  void print()
  {
    for (int i = 0; i < current; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

 
  public static void main(String args[])
  {
    ArrayListClass v
      = new ArrayListClass();
    v.push(10);
    v.push(20);
    v.push(30);
    v.push(40);
    v.push(50);

    System.out.println("ArrayList size: "
            + v.size());
    System.out.println(
      "ArrayList capacity: "
      + v.getcapacity());
    System.out.println(
      "ArrayList elements: ");
    v.print();

    v.push(100, 1);

    System.out.println(
      "\nAfter updating 1st index");

    System.out.println(
      "ArrayList elements: ");
    v.print();
    System.out.println(
      "Element at 1st index: "
      + v.get(1));

    v.pop();

    System.out.println(
      "\nAfter deleting the"
      + " last element");

    System.out.println(
      "ArrayList size: "
      + v.size());
    System.out.println(
      "ArrayList capacity: "
      + v.getcapacity());

    System.out.println(
      "ArrayList elements: ");
    v.print();
  }
}
