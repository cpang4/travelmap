import java.io.*;
import java.util.*;

public class Formatter {
	
	public static void main(String[] args){

		Scanner scan = new Scanner(System.in);
		String title = "", mtype = "", link = "", caption = "", isDoneInput = "", overallDoneInput = "", c1, c2, coord;
		boolean isDone = false, overallDone = false;
		int count = 0;
		try {
			PrintWriter pw = new PrintWriter(new File("output.txt"));

			while (!overallDone){
				title = "";
				mtype = "";
				link = "";
				caption = "";
				isDoneInput = "";
				overallDoneInput = "";
				pw.println("{");
				pw.println("\t\"type\": \"Feature\",");
				pw.println("\t\"properties\": {");
				while (title.equals("")){
					System.out.print("Title: ");
					title = scan.nextLine();
				}
				pw.println("\t\t\"title\": \"" + title + "\",");
				pw.println("\t\t\"marker-color\": \"#3c4e5a\",");
				while (mtype.equals("")){
					System.out.print("Marker type: ");
					mtype = scan.nextLine();
				}
				pw.println("\t\t\"marker-symbol\": \"" + mtype +"\",");
				pw.print("\t\t\"images\": [");
				count = 0;
				isDone = false;
				while (!isDone){
					link = "";
					caption = "";
					if (count == 0){
						while (link.equals("")){
							System.out.print("Image link: ");
							link = scan.nextLine();
						}
						while (caption.equals("")){
							System.out.print("Caption: ");
							caption = scan.nextLine();
						}
						System.out.print("Done with images? (y/n): ");
						isDoneInput = scan.nextLine();
						if (isDoneInput.equals("y")){
							pw.print("[\"" + link + "\", \"" + caption + "\"]");
							isDone = true;
						}
						else{
							pw.println("[\"" + link + "\", \"" + caption + "\"],");
						}
					}
					else {
						while (link.equals("")){
							System.out.print("Image link: ");
							link = scan.nextLine();
						}
						while (caption.equals("")){
							System.out.print("Enter caption: ");
							caption = scan.nextLine();
						}
						System.out.print("Done with images? (y/n): ");
						isDoneInput = scan.nextLine();
						if (isDoneInput.equals("y")){
							pw.print("\t\t[\"" + link + "\", \"" + caption + "\"]");
							isDone = true;
						}
						else{
							pw.println("\t\t[\"" + link + "\", \"" + caption + "\"],");
						}
					}
					count++;
				}
				pw.println("]");
				pw.println("\t},");
				pw.println("\t\"geometry\": {");
				pw.println("\t\t\"type\": \"Point\",");
				System.out.print("Coordinates in form of lat,long : ");
				coord = scan.nextLine();
				c1 = coord.split(",")[1];
				c2 = coord.split(",")[0];
				pw.println("\t\t\"coordinates\": [" + c1 + "," + c2 + "]");
				pw.println("\t}");
				pw.println("},");

				System.out.print("Done adding markers? Type \"done\": ");
				overallDoneInput = scan.nextLine();
				if (overallDoneInput.equals("done")){
					overallDone = true;
				}
			}
			pw.close();
		}
		catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }


	}
}
