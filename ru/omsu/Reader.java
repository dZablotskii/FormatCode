/**
*Reading Data (one character).
*/
package ru.omsu;

import java.io.*;
public class Reader{
	private static BufferedReader br;
	private static int code;
	public static void ini()throws IOException{
		br= new BufferedReader(new FileReader("WrongCode.txt"));
	}
	public static char read() throws IOException {
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
