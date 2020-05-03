
public  class se1_223Entwicklung implements se1_223{

	public String[][] abhaeng;
	public String[] sequence;
			
	
	public se1_223Entwicklung(String[][] depend0) {
		this.abhaeng = depend0 ;
	
	}


	@Override
	public boolean isWellSoreted(String[] sequence) {
		this.sequence=sequence;	
		if(abhaeng == null) {
			return true;
		}
		String[] gelesen = new String[sequence.length];
		
			for (int j = 0; j < sequence.length ; j++) {
				for(int h = 0 ; h < gelesen.length ; h++) {
					if(sequence[j].equals(gelesen[h])) {
						return false;
					}}
				for (int i = 0; i < abhaeng.length ; i++) {
					if(abhaeng[i][1].equals(sequence[j])) {			
					for (int k = 0; k < sequence.length ; k++)	{
					if ( abhaeng[i][0].equals(gelesen[k])) {
						
						break;
					}
					else if(k==sequence.length-1) {
						return false;
					}
					}
				}	gelesen[j] = sequence[j];
			}
				}
			
			return true;
	}


	

	
	

}
	
	
