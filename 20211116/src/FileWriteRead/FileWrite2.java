package FileWriteRead;

import java.io.FileWriter;
import java.io.IOException;

public class FileWrite2 {

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("output1.txt", true); // true 넣으면 추가 되고 안넣으면 리셋했다가 새롭게 저장
		for (int i = 11; i<= 20; i++) {
			fw.write(i+ " 번째 입니다. \n");
		}
		fw.close();
	}

}
