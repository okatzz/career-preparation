class class5_8{
	public void drawHorizontalLine(byte[] screen, int width, int x1, int x2, int y){
		int height=screen.length*8/width;
		int first_full_byte=width/8*y+x1/8+1;
		int last_full_byte=width/8*y+x2/8-1;
		for(int i=first_full_byte; i<=last_full_byte; i++){
			screen[i]=(byte)0xff;
		}
		int x1_offset=x1%8;
		int x2_offset=x2%8;
		if((first_full_byte-1)!=(last_full_byte+1)){
			screen[first_full_byte-1]|=(byte)(0xff>>x1_offset);
			screen[last_full_byte+1]|=(byte)~(0xff>>x2_offset+1);
		}else{
			screen[first_full_byte-1]|=(byte)((0xff>>x1_offset)&~(0xff>>x2_offset+1));
		}
	}
}