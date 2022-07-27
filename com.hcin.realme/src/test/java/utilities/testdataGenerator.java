package utilities;

import java.io.IOException;
import java.util.Random;

public class testdataGenerator {
	
	public final String ALPHABET_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public final int NUMERICS = 123456789;

	public String generateRandomChars(String candidateType, int length) {

		String candidateChars = "";
		if (candidateType == "a") {
			candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		}
		if (candidateType == "i") {
			candidateChars = "0123456789";
		}
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(candidateChars.charAt(random.nextInt(candidateChars
					.length())));
		}
		return sb.toString();
	}

	public String generateMobNum() throws IOException {

		String mobNum = "6" + generateRandomChars("i", 9);
		System.out.println("Mobile Number : " + mobNum);
		return mobNum;

	}

	public String generatePANno() throws IOException {

		String panCardNo = generateRandomChars("a", 3) + "P" + generateRandomChars("a", 1) + generateRandomChars("i", 4) + generateRandomChars("a", 1);
		System.out.println("PAN Number : " + panCardNo);
		return panCardNo;

	}
	
	public String generateDrivingLicense() throws IOException {

		String drivingLicenseNo = "UP-8020" + generateRandomChars("i", 9);
		System.out.println("DL Number : " + drivingLicenseNo);
		return drivingLicenseNo;

	}

	public String generatePassportNo() throws IOException {

		String passportNo = "N" + generateRandomChars("i", 7);
		System.out.println("passport Number : " + passportNo);
		return passportNo;

	}
	
	public static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public static String createRandomDate(int startYear, int endYear) {
        int day = createRandomIntBetween(1, 28);
        String dd=intToString(day, 2);
        int month = createRandomIntBetween(1, 12);
        String mm=intToString(month, 2);
        int year = createRandomIntBetween(startYear, endYear);
        String dob = dd + "/" + mm + "/" + year;
        //System.out.println(dob);
        return dob;
    }
    
    static String intToString(int num, int digits) {
        StringBuffer s = new StringBuffer(digits);
        int zeroes = digits - (int) (Math.log(num) / Math.log(10)) - 1; 
        for (int i = 0; i < zeroes; i++) {
            s.append(0);
        }
        return s.append(num).toString();
    }
    
	public String generateDOB() throws IOException {

            String randomDate = createRandomDate(1958, 2002);
            System.out.println("DOB is :"+randomDate);
		    return randomDate;
	}


}
