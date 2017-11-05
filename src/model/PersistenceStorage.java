package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * This class purpose is to handle the persistence storage.
 * @author 
 */
public class PersistenceStorage {
	private String fileName;
	
	public PersistenceStorage(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * Method to save an objects as a file in the file system. 
	 * @param o
	 * @return	True if nothing unexpected happened.
	 * 			False otherwise.
	 */
	public boolean save(Object o) {
		try {
			File file = new File("./", fileName);
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(o);
			oos.close();
		} catch (NullPointerException e) {
			e.printStackTrace();
			return false;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SecurityException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * Method to load a file containing an object.
	 * @return	The object that was loaded from the file.
	 */
	public Object load() {
		File file = new File("./", fileName);
		Object o = null;
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			o = ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return o;
	}
	
	/**
	 * Method to test if a file with name stored in variable fileName 
	 * exists in the file system.
	 * @return	True if the file exists.
	 * 			False otherwise.
	 */
	public boolean existsFile() {
		return new File("./", fileName).isFile();
	}
}
