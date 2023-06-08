package interaction;

import java.io.*;
import java.util.Scanner;

import medium.*;

public class Save{
	private final String path;
	private final String sourceFile;
	private final String meta;
	private int[] counter;
	private String[] dataFiles;

	public Save(String path, String file, String meta){
		this.path = path;
		this.sourceFile = file;
		File source = new File(this.path + sourceFile);
		File metaFile = new File(this.path + meta);
		this.meta = meta;
		
		try {
			if(!source.exists()) {
				if(!path.equals("") && path != null)
					source.getParentFile().mkdir();
				source.createNewFile();
				//metaFile.mkdirs();
				metaFile.createNewFile();
			}else
				retrieve();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void retrieve() {
		Scanner scan;
		try {
			scan = new Scanner(new FileInputStream(path + sourceFile));
			int count = 0;
			if(!scan.hasNextLine()) {
				System.out.println("FIles are empty");
				return;
			}
			
			while(scan.hasNextLine()){
				dataFiles = increase(dataFiles);
				dataFiles[dataFiles.length - 1] = scan.nextLine();
			}
			counter = new int[dataFiles.length];
			retrieveMeta();
			
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void retrieveMeta() {
		Scanner scan;
		try {
			scan = new Scanner(new FileInputStream(path + meta));
			int i = 0;
			while(scan.hasNextLine()){
				counter[i]=Integer.parseInt(scan.nextLine());
				i++;
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
			scan = new Scanner(new FileInputStream(path + sourceFile));
			
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
	public void add(String file, Stack/*Object...*/ input) throws IOException{
		
		FileOutputStream fos = new FileOutputStream(path + file);
		
		if(file.equals(sourceFile)) {
			fos.close();
			return;
		}
		
		//Create a new Save-File for new Object
		int c = this.identify(file);
		if(c == -1) {
			dataFiles = increase(dataFiles);
			dataFiles[dataFiles.length - 1] = file;
			
			File create = new File(path + file);
			if(!create.exists()) {
				create.getParentFile().mkdirs();
				create.createNewFile();
			}
			
			write(new FileOutputStream(path + sourceFile), dataFiles);
			counter = this.increase(counter);
			counter[counter.length - 1] = input.getStack().length;
		} else
			counter[c] = input.getStack().length;
		this.writeMeta();
		//Save object in file
		write(fos, input);
		fos.close();
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
	private int[] increase(int[] tmp){
		if(tmp == null)
			return new int[1];
		
		int[] temp = new int[tmp.length + 1];
		for(int i = 0; i < tmp.length; i++){
			temp[i] = tmp[i];
		}
		return temp;
	}
	private void writeMeta() throws FileNotFoundException {
		PrintStream ps = new PrintStream(new FileOutputStream(path + meta)); 
		
		for(int i = 0; i < counter.length; i++)
			ps.println(counter[i]);

		ps.close();
	}
	private void write(FileOutputStream fos, String... files){
		PrintStream ps = new PrintStream(fos); 

		for(int i = 0; i < files.length; i++)
			ps.println(files[i]);

		ps.close();
	}
	private void write(FileOutputStream fos, Object data) throws IOException{
		
		ObjectOutputStream oos = new ObjectOutputStream(fos); 

		//for(Object object : data)
			oos.writeObject(/*object)*/data);

		oos.close();
	}

	public Object/*[]*/ getData(String file, int count){
		ObjectInputStream ois;
		Object/*[]*/ objects = new Object()/*[count]*/;
		try {
			ois = new ObjectInputStream(new FileInputStream(path + file));
		
			for(int i = 0; i < counter[count]; i++){
				objects/*[i]*/ = ois.readObject();
			}
			ois.close();
			return objects;
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public int identify(String file) {
		if(dataFiles == null)
			return -1;
		
		for(int i = 0; i < dataFiles.length; i++) {
			if(file.equals(dataFiles[i]))
				return i;
		}
		return -1;
	}
	public String[] getDataFiles() {
		return dataFiles;
	}
/*	public void setDataFiles(String[] dataFiles) {
		this.dataFiles = dataFiles;
		//TODO Replace dataFiles
	}
	*/

	public int[] getCounter() {
		return counter;
	}
	
}
