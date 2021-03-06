package utils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import db.entity.StudentInfo;

public class studentsInfoSerializable implements Serializable {
	ArrayList<StudentInfo> studentsInfo;
	int size;


	public ArrayList<StudentInfo> getStudentsInfo() {
		return studentsInfo;
	}

	public void setStudentsInfo(ArrayList<StudentInfo> studentsInfo) {
		this.studentsInfo = studentsInfo;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	private void writeObject(ObjectOutputStream s)
            throws IOException {
        s.writeInt(size);
        for (int i = 0; i < studentsInfo.size(); i++){
        	s.writeObject(studentsInfo.get(i));
        }
    }
	
    @SuppressWarnings("unchecked")
	private void readObject(ObjectInputStream s)
            throws IOException, ClassNotFoundException {
    	studentsInfo = new ArrayList<StudentInfo>();
    	int size = s.readInt();
    	for (int i = 0; i < size; i++){
    		studentsInfo.add((StudentInfo)s.readObject());
    	}
    }

}
