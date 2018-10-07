package Tech_Question;

public class suffix {
	public static int method(int n)
    {
        int result = 0;
        n <<= 1;
        while (n > 0) {
            result += (n / 2) % 2;
        }
        return result;
    }
	public static void main(String[] args) {
		String a = null;
	    String b = "xyz";
	    String c = a+b;
	    System.out.println(method(13977));
	}

}
