class ExceptionBrackets{
	public String checkBrackets(int count){
		String s = "";
		if (count > 0){
			s="\n //Error! The code need "+Integer.toString(count/8)+" '}' bracket(s)";
		}
		else if (count < 0 ){
			s="\n //Error! The code need "+Integer.toString((count/8)*(-1))+" '{' bracket(s)";
		}
		return s;
	}
}
