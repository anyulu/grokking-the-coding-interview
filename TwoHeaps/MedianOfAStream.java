import java.util.*;

class MedianOfAStream {
    List<Integer> list = new ArrayList<>();

    public void MedianOfAStream() {
        list = new ArrayList<>();
    }

    public void insertNum(int num) {
        // TODO: Write your code here
        list.add(num);
        Collections.sort(list);
    }

    public double findMedian() {
        // TODO: Write your code here
        int size = list.size();
        if (size % 2 == 1) return (double) list.get(size/2);
        else return (double) (list.get(size/2) + list.get(size/2-1))/2;
    }

    public static void main(String[] args) {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }
}
