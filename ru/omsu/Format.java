package ru.omsu;
public class Format {
	private static int spaces=0;
	private static boolean comment = false;
	public String check(char prev,char c,char post){
		String result="";
		if(c==';'){
			String sp="";
			for(int i=1;i<=spaces;i++){
				sp=sp+" ";
			}
			result=result+c+"\n"+sp;
		} else if(c=='{'){
			String sp="";
			spaces = spaces+8;
			for(int i=1;i<=spaces;i++){
				sp=sp+" ";
			}
			result=result+c+"\n"+sp;
		} else if (c=='}'){
			String sp="";
			spaces = spaces - 8;
			for(int i=1;i<=spaces;i++){
				sp=sp+" ";
			}
			result=result+"\n"+sp+c;
		}else if((c=='=')||(c=='+')||(c=='-')){
				result=result+" "+c+" ";	
			}
		   else if(c=='\n'){
			result = result;
		} else if((prev=='/')&(c=='*')){
			comment = true;
			result = result+c+'\n';
		}else if((comment==true)&(c=='*')){
			result = result+'\n'+c;
		}else if((prev=='*')&(c=='/')){
			String spc="";
			for(int i=1;i<=spaces;i++){
				spc=spc+" ";
			}
			result = result+c+'\n'+'\n'+spc;
			comment = false;
		}else if((c=='/')&(post=='*')) {
			result = result+'\n'+c;
		}else if(c=='\t'){
			result = result;
		}else if((c==' ')&&(prev==' ')){
			result = result;
		}else {
			result = result+c;
		}
		
		return result;
	}
	public int getSpaces(){
		return spaces;
	}
}
