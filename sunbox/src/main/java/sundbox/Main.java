package sundbox;
public class Main {
    public static void main(String[] args) {
        int x =0;
        Point p1 = new Point(1, 2);
        Point p2 = new Point(5,9);
        System.out.println( distance(p1, p2));

        Point point = new Point(1,2);
        System.out.println(point.distance(new Point(5,9)));
    }
public static double distance(Point p1, Point p2) {
        double dx = p1.x - p2.x;
        double dy = p1.y - p2.y;
        return Math.sqrt(dx * dx + dy * dy);
}
}