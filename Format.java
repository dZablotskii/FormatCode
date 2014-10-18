class Format implements InterfaceFormat{
	private static int spaces=0;
	public String check(char c){
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
		   else {
			result = result+c;
		}
		return result;
	}
	public int getSpaces(){
		return spaces;
	}
}
