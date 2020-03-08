package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.InflaterInputStream;

public class Animal {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			for (int i = 0; i < 1000; i++) {
				for (int j = 0; j < 4; j++) {
					bf.readLine();
					String Kind = bf.readLine().replace("<KNm>", "").replace("</KNm>", "");
					String animalName = bf.readLine().replace("<kindCd>", "").replace("</kindCd>", "");
					bf.readLine();
					System.out.print("\""+Kind+ "\" : \"" + animalName + "\",");
					System.out.println();
				}
			}
		} catch (Exception e) {
			System.out.println("finish");
		}
	}
}
