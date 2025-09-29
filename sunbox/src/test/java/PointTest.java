import Aniskina_Daria.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {
    @Test
    public void testDistance() {
        Point p1 = new Point(1,2);
        Point p2 = new Point(5,9);
        Assert.assertEquals(p1.distance(p2), 8.06225774829855);
    }
}
