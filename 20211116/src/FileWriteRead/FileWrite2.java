package FileWriteRead;

import java.io.FileWriter;
import java.io.IOException;

public class FileWrite2 {

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("output1.txt", true); // true ������ �߰� �ǰ� �ȳ����� �����ߴٰ� ���Ӱ� ����
		for (int i = 11; i<= 20; i++) {
			fw.write(i+ " ��° �Դϴ�. \n");
		}
		fw.close();
	}

}
