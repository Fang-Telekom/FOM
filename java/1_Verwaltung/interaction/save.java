package interaction;

import java.io.*

public class safe{
	private final String file[];
	private String data[];
	private Object objects[][];

	public safe(String file){
		this.file = file;
		for(int i = 0; i < file.length(); i++)
			File file = new File(file);
		if(file.exists())
			retrieve()
		else{
			file.getParentsFile.mkdirs();
			file.createNewFile();
		}
	}

	public void add(String input...){
		String newData;

		//TODO Process input
		data[increase()] = newData;

		write();
	}
	private int increase(){
		String temp[] = new String[data.length() + 1];
		for(int i = 0; i < data.length(); i++){
			temp = data[i];
		}
		temp[data.length()] = newData;
		data = temp;

		return data.length();
	}
		
	private void write(´String file){
		FileOutputStream fos = new FileOutputStream(file);
		PrintStream ps = new PrintStream(fos);
		ObjectOutputStream oos = new ObjectOutputStream(fos); 

		for(int i = 0; i < data.length(); i++)
			ps.println(data[i]);

		fos.close();
		ps.close();
	}
	public void retrieve(){
		FileOutputStream fis = new FileInputStream(file);
		Scanner scan = new Scanner(fis);
		String raw;
		int lines, count = 0;
		
		lines = scan.nextInt();
		data = new String[rows];
		data[0] = lines + "";
		while(scan.hasNextLine()){
			if(count < lines)
				data[++count] = scan.next();
			else
				data[increase()]=scan.next();
			
		}

		if(count > lines){
			//TODO doesn't match
		} else if (count < lines){
			//TODO doesn't match
		}
	
		fis.close();
		scan.close();
	}

}
