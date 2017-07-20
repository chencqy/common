package stringReplace;

/**
 * Created by Richard Chen on 2017/5/8.
 * 4：字符串替换
 */
public class StringReplace {
    public String replaceSpace(StringBuffer str){
        int spaceNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' '){
                spaceNum++;
            }
        }
        int indexOld = str.length() - 1;
        int newLength = str.length() + spaceNum * 2;
        int indexNew = newLength - 1;
        str.setLength(newLength);//这里一定不能忘
        for (; indexOld >= 0; --indexOld){
            if (str.charAt(indexOld) == ' '){
                str.setCharAt(indexNew--,'0');
                str.setCharAt(indexNew--,'2');
                str.setCharAt(indexNew--,'%');
            }else {
                str.setCharAt(indexNew--,str.charAt(indexOld));
            }
        }
        return str.toString();
    }
    public static void main(String[] args) {
        System.out.println(new StringReplace().replaceSpace(new StringBuffer("Hello World")));
    }
}
