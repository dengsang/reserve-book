package com.library.reserve_book;

import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import static java.lang.System.in;

@SpringBootApplication
public class ReserveBookApplication {

	private String Reg_no;
	private String book;
	private String date;

	public ReserveBookApplication(){
	}
	public ReserveBookApplication(String Reg_no, String book,String date){
		this.Reg_no = Reg_no;
		this.book = book;
		this.date = date;
	}

	@Override
	public String toString() {
		return "ReserveBook [Reg no=" + Reg_no + ", booK=" + book + ", DATE=" + date + "]";
	}

	public static void main(String[] args) throws IOException, JSONException {

		System.out.println("Please enter your Reg No:");
		System.out.println("\nEnter Book No:");
		System.out.println("\nEnter Date");

		Scanner scanner = new Scanner( System.in);


		String Reg_no = scanner.nextLine();
		String book = scanner.nextLine();
		String date =scanner.nextLine ();


		System.out.println("Reg_no:"+Reg_no + ", booK:" + book + ", DATE:" +date);

		String inputs = Reg_no + "," + book + ","  + date;
		System.out.println ( inputs );


		BufferedReader buffReader = new BufferedReader(new InputStreamReader ( in, "utf-8"), 8);
		StringBuilder sBuilder = new StringBuilder();
		String line = "";
		while ((line = buffReader.readLine()) != null) {
			sBuilder.append(line + "\n");
		}
		//inputs = sBuilder.toString();

		try {
			inputs = (buffReader.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


//Parse the JSON data present in the string format
			JSONParser parse = new JSONParser();
//Type caste the parsed json data in json object
			JSONObject jobj = ( JSONObject ) parse.parse ();
//Store the JSON object in JSON array as objects (For level 1 array element i.e Results)
			JSONArray jsonarr_1 = ( JSONArray ) jobj.get (inputs);

			for (int i = 0; i < jsonarr_1.length (); i++) {
				//Store the JSON objects in an array

				JSONObject jsonobj_1 = ( JSONObject ) jsonarr_1.get ( i );
				System.out.println ( "Elements under results array" );
				System.out.println ( "\nReg_no: " + jsonobj_1.get ( "Reg_no" ) );
				System.out.println ( "\nbook: " + jsonobj_1.get ( "booK" ) );
				System.out.println ( "date: " + jsonobj_1.get ( "DATE" ) );

			}

		SpringApplication.run(ReserveBookApplication.class, args);
	}

}
