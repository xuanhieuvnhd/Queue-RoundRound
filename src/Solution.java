public class Solution {
    //Cấu trúc của một nút
    static class Node{
        int data;
        Node link;
    }
    static class Queue{
        Node front;
        Node rear;
    }
    //Phương thức tạo hàm vòng tròn
    static void enQueue(Queue queue, int value)
    {
        Node temp = new Node();
        temp.data = value;
        if (queue.front == null)
            queue.front = temp;
        else
            queue.rear.link = temp;

        queue.rear = temp;
        queue.rear.link = queue.front;
    }
    //Phương thức xoá phần tử khỏi hàng đợi
    static int deQueue(Queue queue){
        if (queue.front == null){
            System.out.println("Hang doi trong");
            return Integer.MIN_VALUE;
        }
        int value;//Giá trị được chỉ định
        if (queue.front == queue.rear){
            value = queue.front.data;
            queue.front = null;
            queue.rear = null;
        }else {
            Node temp = queue.front;
            value = temp.data;
            queue.front = queue.front.link;
            queue.rear.link = queue.front;
        }
        return value;
    }
    //Phương thức hiển thị các phần tử hàng đợi hình tròn
    static void displayQueue(Queue queue){
        Node temp = queue.front;
        System.out.println("\nCac phan tu co trong hang doi la: ");
        while (temp.link != queue.front) {
            System.out.printf("%d ", temp.data);
            temp = temp.link;
        }
        System.out.printf("%d", temp.data);
    }

    public static void main(String[] args) {
        //Tạo một hàng đợi và khởi tạo phía trước và phía sau
        Queue queue = new Queue();
        queue.front = queue.rear = null;
        //Chèn các phần tử vào hàng đợi hình tròn
        enQueue(queue,12);
        enQueue(queue,20);
        enQueue(queue,10);
        //Hiển thị các phần tử có trong hàng đợi
        displayQueue(queue);
        //Xoá các phần tử trong hàng đợi hình tròn
        System.out.printf("\nXoa gia tri: %d",deQueue(queue));
        System.out.printf("\nXoa gia tri: %d",deQueue(queue));
        //Các phần tử còn lại trong hàng đợi
        displayQueue(queue);
        enQueue(queue,6);
        enQueue(queue,18);
        displayQueue(queue);
    }
}
