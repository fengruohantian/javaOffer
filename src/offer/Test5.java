package offer;

public class Test5 {

    public static void main(String[] args) {
        String s = "We are happy.";
        StringBuilder ss = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' '){
                ss.append("%20");
            }else{
                ss.append(c);
            }
        }
        System.out.println(ss.toString());
    }
}
