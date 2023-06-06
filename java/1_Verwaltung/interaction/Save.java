package interaction;

import java.io.*;
import java.util.Scanner;

public class Save{
	private final String sourceFile;
	private String[] dataFiles;

	public Save(String file){
		//save path
		this.sourceFile = file;
		File source = new File(sourceFile);
		retrieve();
		try {
			if(!source.exists()) {
				source.getParentFile().mkdirs();
				source.createNewFile();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void retrieve() {
		Scanner scan;
		try {
			scan = new Scanner(new FileInputStream(sourceFile));
			int lines, count = 0;
			lines = scan.nextInt();
			dataFiles = new String[lines];
			
			while(scan.hasNextLine()){
				if(count < lines)
					dataFiles[count++] = scan.next();
				else
					dataFiles[increase()]=scan.next();
				
			}
	
			if(count > lines){
				//TODO doesn't match
			} else if (count < lines){
				//TODO doesn't match
			}
			
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String[] retrieve(String file) {
		Scanner scan;
		String data[] = null;
		try {
			scan = new Scanner(new FileInputStream(sourceFile));
			
			while(scan.hasNextLine()){
				increase(data);
				data[data.length - 1] = scan.nextLine();
				
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	//TODO Meta Data for objcts
	//Adding new Object to Files
	//Adding a new type of Object
	//Creating a new File
	public void add(String file, Object... input) throws IOException{
		
		FileOutputStream fos = new FileOutputStream(file);
		boolean newFile = true;
		
		if(file.equals(sourceFile))
			return;
		for(String files : dataFiles) {	
			if(files.equals(file))
				newFile = false;
		}
		//Create a new Save-File for new Object
		if(newFile) {
			dataFiles[increase()] = file;
			
			File create = new File(file);
			if(!create.exists()) {
				create.getParentFile().mkdirs();
				create.createNewFile();
			}
		
			write(new FileOutputStream(sourceFile), dataFiles);
		}
		//Save object in file
		write(fos, input);
		fos.close();
	}
	private int increase(){
		String[] temp = new String[dataFiles.length + 1];
		for(int i = 0; i < dataFiles.length; i++){
			temp[i] = dataFiles[i];
		}
		dataFiles = temp;

		return dataFiles.length - 1;
	}
	private String[] increase(String[] tmp){
		if(tmp == null)
			return new String[1];
		
		String[] temp = new String[tmp.length + 1];
		for(int i = 0; i < tmp.length; i++){
			temp[i] = tmp[i];
		}

		return temp;
	}
/*	private Object[] increase(Object[] tmp){
		if(tmp == null)
			return new Object[1];
		
		Object[] temp = new Object[tmp.length + 1];
		for(int i = 0; i < tmp.length; i++){
			temp[i] = tmp[i];
		}

		return temp;
	}*/
		
	private void write(FileOutputStream fos, String... files){
		
		PrintStream ps = new PrintStream(fos); 

		for(int i = 0; i < files.length; i++)
			ps.println(files[i]);

		ps.close();
	}
	private void write(FileOutputStream fos, Object... data) throws IOException{
		
		ObjectOutputStream oos = new ObjectOutputStream(fos); 

		for(Object object : data)
			oos.writeObject(object);

		oos.close();
	}

	public Object[] getData(String file, int count){
		ObjectInputStream ois;
		Object[] objects = new Object[count];
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
		
			for(int i = 0; i < count; i++){
				objects[i] = ois.readObject();
			}
	
			ois.close();
			return objects;
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public String[] getDataFiles() {
		return dataFiles;
	}
/*	public void setDataFiles(String[] dataFiles) {
		this.dataFiles = dataFiles;
		//TODO Replace dataFiles
	}
	*/
}
