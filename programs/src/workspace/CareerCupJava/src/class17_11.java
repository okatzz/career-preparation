class class17_11{
	public static int rand7(){
		while(true){
			int num = 5*rand5()+rand5();
			if(num<21)
				return num%7;
		}
	}
	
	public static int rand5(){}
}