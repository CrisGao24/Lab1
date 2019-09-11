package lab1;

public class MessageQueue {

  public MessageQueue(int capacity)

     {
        elements = new Message[capacity];
        count = 0;
        head = 0;
        tail = 0;
     }

     public Message remove(){
           assert count > 0 : "Empty Queue"; 
           Message r = elements[head];
           head = (head + 1) % elements.length;
           count--;
           return r;
     }

     public void add(Message aMessage)
     {
           if(isFull())
           {               
                  Message[] new_elements = new Message[count+1];
                  int i,j,n;
                  for(i=head,j=0,n=0;n<count;i=(i+1)%elements.length,j++,n++)
                  {
                         new_elements[j] = elements[i];
                  }

                  new_elements[count] = aMessage;
                  elements = new Message[new_elements.length];
                  elements = new_elements;
                  tail = (count+1)%elements.length;
                  head = 0;
                  count++;
           }else {
                  elements[tail] = aMessage;
                  tail = (tail + 1) % elements.length;
                 count++;

           }

     }

     public int size()

     {
  return count;
     }

     public boolean isFull()

     {
  return count == elements.length;
     }

     public Message peek() {
           assert count > 0 : "Empty Queue"; 
           return elements[head];
     }

     private Message[] elements;
     private int head;
     private int tail;
     private int count;

     public static void main(String args[])

     {

           MessageQueue queue = new MessageQueue(2);
           queue.add(new Message("Queue"));
           System.out.println(queue.remove().getText());
           queue.add(new Message("is greater than the original size of message queue"));
           while(queue.size() > 0)

                  System.out.println(queue.remove().getText());}}

     

