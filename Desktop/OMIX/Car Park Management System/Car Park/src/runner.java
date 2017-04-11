import java.util.Scanner;

public class runner {

	public static void main(String[] args) {

		WestminsterCarParkManager obj = new WestminsterCarParkManager();
		Scanner sc = new Scanner(System.in);
		String in = "";
		do {
			System.out.println();
			System.out.println("============================================================================");
			System.out.println("|                      Westminster Car park Management System              |");
			System.out.println("=============================================================================");
			System.out.println();
			System.out.print("A   Add a Vehicle\n");
			System.out.print("D   Delete a Vehicle\n");
			System.out.print("P   Print a Parked vehicle list\n");
			System.out.print("S   Print the Percentages\n");
			System.out.print("M   Print Maximium & Newest Vehicle\n");
			System.out.print("H   Print History\n");
			System.out.print("Q   Quit\n\n");
			System.out.print("Enter the Input : ");
			in = sc.next();

		} while (!(in.equalsIgnoreCase("A") || in.equalsIgnoreCase("D") || in.equalsIgnoreCase("P")
				|| in.equalsIgnoreCase("S") || in.equalsIgnoreCase("M") || in.equalsIgnoreCase("H")));
		in = in.toLowerCase();
		switch (in) {
		case "a":
			obj.addVehicle();
			main(args);
			break;
		case "d":
			obj.deleteVehicle();
			main(args);
			break;
		case "p":
			obj.List();
			main(args);
			break;
		case "s":
			obj.Stat();
			main(args);
			break;
		case "m":
			obj.MaxANDMin();
			main(args);
			break;
		case "h":
			obj.History();
			main(args);
			break;
		case "Q":
			break;
		}
		sc.close();
	}

}
