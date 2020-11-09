import java.util.*;

class Element {
    int frequency;
    int sequence;
    int num;

    public Element(int num, int frequency, int sequence) {
        this.num = num;
        this.frequency = frequency;
        this.sequence = sequence;
    }
}

class ElementComparator implements Comparator<Element> {
    public int compare(Element e1, Element e2) {
        return e1.frequency == e2.frequency ? e2.sequence-e1.sequence : e2.frequency-e1.frequency;
    }
}

class FrequencyStack {

    int sequence = 0;
    Queue<Element> queue = new PriorityQueue<>(new ElementComparator());
    Map<Integer, Integer> map = new HashMap<>();

    public void push(int num) {
        // TODO: Write your code here
        map.put(num, map.getOrDefault(num, 0)+1);
        queue.add(new Element(num, map.get(num), sequence++));
    }

    public int pop() {
        // TODO: Write your code here
        int num = queue.poll().num;
        if (map.get(num) > 1) map.put(num, map.get(num)-1);
        else map.remove(num);
        return num;
    }

    public static void main(String[] args) {
        FrequencyStack frequencyStack = new FrequencyStack();
        frequencyStack.push(1);
        frequencyStack.push(2);
        frequencyStack.push(3);
        frequencyStack.push(2);
        frequencyStack.push(1);
        frequencyStack.push(2);
        frequencyStack.push(5);
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
    }
}
