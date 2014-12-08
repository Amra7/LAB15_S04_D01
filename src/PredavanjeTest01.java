import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PredavanjeTest01 {
	public static void main(String[] args) {

		FileWriter fw;
		try {
			fw = new FileWriter(new File("test.nesto drugo"));
			fw.append("Evo jedan red!");
			fw.append('\n');
			fw.flush();
			fw.append("Drugi red \n!");
			fw.append('\n');
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
