import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distFromOrigin() {
        // ignoring sqrt
        return (x * x) + (y * y);
    }
}

class KClosestPointsToOrigin {

    public static List<Point> findClosestPoints(Point[] points, int k) {
        ArrayList<Point> result = new ArrayList<>();
        // TODO: Write your code here
        if (points.length <= k) {
            for (int i = 0; i < points.length; i++) result.add(points[i]);
            return result;
        }
        Queue<Point> queue = new PriorityQueue<Point>((a,b) -> b.distFromOrigin()-a.distFromOrigin());
        for (int i = 0; i < k; i++) {
            queue.add(points[i]);
        }
        for (int i = k; i < points.length; i++) {
            if (points[i].distFromOrigin() < queue.peek().distFromOrigin()) {
                queue.poll();
                queue.add(points[i]);
            }
        }
        for (int i = 0; i < k; i++) result.add(queue.poll());
        return result;
    }

    public static void main(String[] args) {
        Point[] points = new Point[] { new Point(1, 3), new Point(3, 4), new Point(2, -1) };
        List<Point> result = KClosestPointsToOrigin.findClosestPoints(points, 2);
        System.out.print("Here are the k points closest the origin: ");
        for (Point p : result)
            System.out.print("[" + p.x + " , " + p.y + "] ");
    }
}
