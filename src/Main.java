

public class Main {

    public static void main(String[] args) {

        LinkedList list = new LinkedList(10);
        list.append(5);
        list.append(8);
        list.append(3);
        list.append(12);
        list.append(7);
        list.append(1);
        list.show();

        System.out.println("\n" + "\n");

        list.partitionList(7);
        list.show();






    }

}