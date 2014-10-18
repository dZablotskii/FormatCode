/**
*Reading Data (one character).
*/
import java.io.*;
class Reader{
	private static BufferedReader br;
	private static int code;
	public static void ini()throws IOException{
		br= new BufferedReader(new FileReader("t.txt"));
	}
	public static char readFile() throws IOException {
		code = br.read();
		char c;
		if(code!=-1){
			c = (char)code;
		}
		else{
			c = '`';
		}
		return c;
	}
}
