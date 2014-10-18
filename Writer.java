/**
*OutPut of Data.
*/
import java.io.*;
class Writer{
	private static BufferedWriter bw;
	public static void ini()throws IOException{
		bw= new BufferedWriter(new FileWriter("TrueCode.txt"));
	}
	public void writeFile(String s)throws IOException{
		try{
			bw.write(s);
		}
		catch(Exception e){

		}
	}
	public void closeWrite()throws IOException{
		bw.close();
	}
}
