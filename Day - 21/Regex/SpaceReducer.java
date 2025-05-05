public class SpaceReducer {
    public static void main(String[] args) {
        String text = "This    is  an   example     with    multiple   spaces.";
        String result = text.replaceAll("\\s{2,}", " ");
        System.out.println(result);
    }
}
d