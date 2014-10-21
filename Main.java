import java.io.*;
import UI.ru.omsu.Reader;
import UI.ru.omsu.Format;
class Main{
	public static void main(String[]args)throws IOException{
		Reader r = new Reader();
		Format format = new Format();
		Writer w = new Writer();
		ExceptionBrackets e = new ExceptionBrackets();
		w.ini();
		r.ini();
		char prev = 'a';
		char post = r.read();
		char c = post;
		String s="";
		while(c!='`'){
			post = r.read();
			s = format.check(prev,c,post);
			if(c!='`'){
				w.writeFile(s);
			}
			prev = c;
			c = post;			
		}
		int count = format.getSpaces();
		s = e.checkBrackets(count);
		w.writeFile(s);
		w.closeWrite();
	}
}
