package hard._010;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/05/05
 *     desc   :
 * </pre>
 */
public class Test {
    public static void main(String[] args){
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder p = stringBuilder;
        stringBuilder.append("Jiance");
        System.out.println(stringBuilder.insert(4,"xie"));
        System.out.println(p.insert(5,"wen"));
    }
}
