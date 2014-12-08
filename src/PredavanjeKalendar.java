/*
 * Kalnedar gregroijanski
 * "P","U", "S","C","P","S","N"
 */
public class PredavanjeKalendar {
	public static void main(String[] args) {
		System.out.println("Unesi godinu: ");
		int godina = TextIO.getInt();
		System.out.println("Unesi prvi dan: ");
		int prviDanUGodini =TextIO.getInt();
		String []mjeseci = new String [] { "Januar","Februar","Mart","April","Maj","Juni","Juli","August","Septemebar","Oktobar","Novembar","Decembar"};
		

		int[] brDanaPoMjesecima = new int[] { 31, 28, 31, 30, 31, 30, 31, 31,
				30, 31, 30, 31 };
		if (godinaJePrestupna(godina)) {
			brDanaPoMjesecima[1] = 29;
		}
		for (int i = 0; i < 12; i++){
			System.out.println(ispisiMjesec(mjeseci[i], brDanaPoMjesecima[i],
					                                                        vratiPrviDanuMjesecu(i, prviDanUGodini, brDanaPoMjesecima), 
					                                                                                                                   1));
		}
//		System.out.println(ispisiMjesec("Neki mjesec", 28, 5, 1));

	}

	public static boolean godinaJePrestupna(int godina) {
		if (godina % 400 == 0) { // ako je godina prestupna dijeljiva je sa 400
			return true;
		}
		if (godina % 100 == 0) { // ako nije godina prestupna dijeljiva je sa
									// 100
			return false; // ako nije godina djeljiva sa 100 a nije sa 400 onda
							// nije prestupna
		}
		if (godina % 4 == 0) { // ako je godina prestupna dijeljiva je sa 4
			return true;
		}
		return false;
	}

	public static String ispisiMjesec(String nazivMjeseca, int brDanaUMjesecu,
			int prviDanUMjesecu, int prviDan, String... dani) {
		if (dani.length != 7) {
			dani = new String[] { "pon", "uto", "sri", "cet", "pet", "sub",
					"ned" };
		}
		String str = String.format("%-28s", nazivMjeseca) + "\n";
		int idx = prviDan - 1;
		do {
			str += String.format("%4s", dani[idx]);
			idx++;
			idx %= 7;

		} while (idx != prviDan - 1);
		str += "\n";
		int slobodnihMjesta = (prviDanUMjesecu - prviDan + 7) % 7;

		for (idx = 0; idx < slobodnihMjesta; idx++) {
			str += String.format("%4s", "");
		}
		while (idx < brDanaUMjesecu + slobodnihMjesta) {
			str += String.format("%4s", (idx - slobodnihMjesta + 1));
			idx++;

			if (idx % 7 == 0) {

				str += "\n";
			}
		}

		return str;

	}

	public static int vratiPrviDanuMjesecu(int mjesec, int prviDanUGodini,
			int[] brojDanaPoMjesecima) {

		int prviDanUMjesecu = 0;
		for (int i = 0; i < mjesec; i++) {
			prviDanUMjesecu += brojDanaPoMjesecima[i];
		}
		prviDanUMjesecu %=7;
		if(prviDanUMjesecu ==0){
			prviDanUMjesecu = 7;
			
		}

		return prviDanUMjesecu;
	}
}
