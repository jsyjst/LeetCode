package hard;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/07
 *     desc   :
 * </pre>
 */
public class SafetyTest {
    public static void main(String[] args) {
        int i = 0;
        try {
            while (true) {
                if(i==3) break;
                throw new Exception();
            }
        } catch (Exception e) {
            i++;
            System.out.println(i + "捕获到异常");
        } finally {
            System.out.println(i + "的finally被执行");
        }
    }
}
