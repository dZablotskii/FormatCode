import java.io.*;
class Main{
	public static void main(String[]args)throws IOException{
		Reader r = new Reader();
		Format format = new Format();
		Writer w = new Writer();
		ExceptionBrackets e = new ExceptionBrackets();
		w.ini();
		r.ini();
		char c = 'a';
		String s="";
		while(c!='`'){
			c = r.readFile();
			s = format.check(c);
			if(c!='`'){
				w.writeFile(s);
			}			
		}
		int count = format.getSpaces();
		s = e.checkBrackets(count);
		w.writeFile(s);
		w.closeWrite();
	}
}
