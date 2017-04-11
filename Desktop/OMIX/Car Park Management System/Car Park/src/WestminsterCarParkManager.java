
import java.util.ArrayList;
import java.util.Scanner;

public class WestminsterCarParkManager implements carParkManager {

	private static int carCount = 0;
	private static int vanCount = 0;
	private static int bikeCount = 0;
	static ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	Scanner sc = new Scanner(System.in);

	public void addVehicle() {
		Cars objCar = new Cars();
		Vans objVan = new Vans();
		Motorbikes objBike = new Motorbikes();

		String input = "";
		do {
			System.out.print("What is the Vehicle type (Car/Van/Bike) ? :");
			input = sc.next();
			input = input.toLowerCase();
		} while (!(input.equalsIgnoreCase("car") || input.equalsIgnoreCase("van") || input.equalsIgnoreCase("bike")));

		if ((carCount + (vanCount * 2) + bikeCount) < 20) {
			switch (input) {
			case "car":
				carCount++;
				objCar.setType("CAR");
				System.out.print("What is the Id Plate number? ");
				objCar.setIdPlate(sc.next());
				System.out.print("What is the Brand of the Car ?");
				objCar.setBrand(sc.next());
				System.out.print("Date of the entry?");
				objCar.setEntryDate(sc.next());
				System.out.print("Time of the entry?");
				objCar.setEntryTime(sc.next());
				System.out.print("How many Doors?");
				objCar.setNoOfDoors(sc.next());
				System.out.print("What is the colour of the car?");
				objCar.setColor(sc.next());
				vehicles.add(objCar);
				break;
			case "van":
				if ((carCount + (vanCount * 2) + bikeCount) < 19) {
					vanCount++;
					objVan.setType("VAN");
					System.out.print("What is the Id Plate number? ");
					objVan.setIdPlate(sc.next());
					System.out.print("What is the Brand of the Van ?");
					objVan.setBrand(sc.next());
					System.out.print("Date of the entry?");
					objVan.setEntryDate(sc.next());
					System.out.print("Time of the entry?");
					objVan.setEntryTime(sc.next());
					System.out.print("What is the Cargo volume of the van?");
					objVan.setCargoVolume(sc.next());
					vehicles.add(objVan);
					break;
				} else {
					System.out.println("Your vehicle cannot afford a slot in the park");
				}
			case "bike":
				bikeCount++;
				objBike.setType("BIKE");
				System.out.print("What is the Id Plate number? ");
				objBike.setIdPlate(sc.next());
				System.out.print("What is the Brand of the bike ?");
				objBike.setBrand(sc.next());
				System.out.print("Date of the entry?");
				objBike.setEntryDate(sc.next());
				System.out.print("Time of the entry?");
				objBike.setEntryTime(sc.next());
				System.out.print("Engine Size of the bike?");
				objBike.setEngineSize(sc.next());
				vehicles.add(objBike);
				break;
			}
		}
	}

	public void deleteVehicle() {
		System.out.print("What is the id plate of the vehicle to be removed?");
		String search = sc.next();
		int index = -1;
		for (int x = 0; x < vehicles.size(); x++) {
			if (vehicles.get(x).getIpPlate().equalsIgnoreCase(search)) {
				index = x;
				break;
			}
		}
		if (index != -1) {
			System.out.print("What is the leaving Date (year-month-date ) ? ");
			vehicles.get(index).setLeaveDate(sc.next());
			System.out.print("What is the leaving Time (Hour : Minute ) ? ");
			vehicles.get(index).setLeaveTime(sc.next());
			System.out.println("......................................................................");
			System.out.println("A Vehicle has being Removed from the System \n");
			System.out.println("\tId Plate : " + vehicles.get(index).getIpPlate());
			System.out.println("\tBrand : " + vehicles.get(index).getBrand());
			System.out.println("\tEntry Time : " + vehicles.get(index).getEntryDate() + " @ "
					+ vehicles.get(index).getEntryTime());
			System.out.println("\tLeave Time : " + vehicles.get(index).getLeaveDate() + " @ "
					+ vehicles.get(index).getLeaveTime());
			System.out.println("\tThe Total Price for the Paking is : " + vehicles.get(index).totalPay());
			vehicles.remove(index);
			System.out.println("........................................................................");

		} else {
			System.out.println("No such vehicle Found");
		}
	}

	public void List() {
		if (vehicles.size() > 0) {
			for (Vehicle rot : vehicles) {
				System.out.println("................................................................");
				System.out.println("Id plate : " + rot.getIpPlate());
				System.out.println("Type : " + rot.type);
				System.out.println("Brand : " + rot.brand);
				System.out.println("Entry Time : " + rot.getEntryDate() + " at " + rot.getEntryTime());
				System.out.println("................................................................");
			}

		} else {
			System.out.println("No Vehicles right availble at the car park");
		}
	}

	public void MaxANDMin() {
		if (vehicles.size() > 0) {
			int maxIndex = -1;
			int max = 0;
			for (int x = 0; x < vehicles.size(); x++) {
				if (vehicles.get(x).totalTime() > max) {
					maxIndex = x;
					max = vehicles.get(x).totalTime();
				}
			}
			if (maxIndex != -1) {
				System.out.println("................................................................");
				System.out.println("Max Time Parked Car : ");
				System.out.println("\t\tId Plate : " + vehicles.get(maxIndex).getIpPlate());
				System.out.println("\tBrand : " + vehicles.get(maxIndex).getBrand());
				System.out.println("\tEntry Time : " + vehicles.get(maxIndex).getEntryDate() + " @ "
						+ vehicles.get(maxIndex).getEntryTime());
				System.out.println("................................................................");
			} else {
				System.out.println("No Vehicles right availble at the car park");
			}
			System.out.println("................................................................");
			System.out.println("Last Entered Car : ");
			System.out.println("\t\tId Plate : " + vehicles.get((vehicles.size() - 1)).getIpPlate());
			System.out.println("\tBrand : " + vehicles.get((vehicles.size() - 1)).getBrand());
			System.out.println("\tEntry Time : " + vehicles.get((vehicles.size() - 1)).getEntryDate() + " @ "
					+ vehicles.get((vehicles.size() - 1)).getEntryTime());
			System.out.println("................................................................");
		} else {
			System.out.println("No Vehicles right availble at the car park");
		}

	}

	public void Stat() {
		System.out.println("/t/tStatistics \n");
		System.out.println("................................................................");
		System.out.println("Cars : " + ((carCount * 1.00 / (carCount + vanCount + bikeCount)) * 100) + "    Van : "
				+ ((vanCount * 1.00 / (carCount + vanCount + bikeCount)) * 100) + "    Bike : "
				+ ((bikeCount / (carCount + vanCount + bikeCount)) * 100));
		System.out.println("................................................................");
	}

	@Override
	public void History() {
		// TODO Auto-generated method stub

	}

}
