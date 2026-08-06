package com.jdbc;

import java.util.Scanner;

import com.jdbc.dao.AppointmentDAO;
import com.jdbc.dao.BatchDAO;
import com.jdbc.dao.BillingDAO;
import com.jdbc.dao.DepartmentDAO;
import com.jdbc.dao.DoctorDAO;
import com.jdbc.dao.MetadataDAO;
import com.jdbc.dao.PatientDAO;
import com.jdbc.dao.ProcedureDAO;
import com.jdbc.dao.TransactionDAO;
import com.jdbc.dao.VisitDAO;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		PatientDAO patientDAO = new PatientDAO();
		DoctorDAO doctorDAO = new DoctorDAO();
		AppointmentDAO appointmentDAO = new AppointmentDAO();
		VisitDAO visitDAO = new VisitDAO();
		BillingDAO billingDAO = new BillingDAO();
		DepartmentDAO departmentDAO = new DepartmentDAO();

		ProcedureDAO procedureDAO = new ProcedureDAO();
		BatchDAO batchDAO = new BatchDAO();
		TransactionDAO transactionDAO = new TransactionDAO();
		MetadataDAO metadataDAO = new MetadataDAO();

		int choice;

		do {

			System.out.println("\n========== HEALTH CLINIC APP ==========");
			System.out.println("1. Patient Operations");
			System.out.println("2. Doctor Operations");
			System.out.println("3. Appointment Operations");
			System.out.println("4. Visit Operations");
			System.out.println("5. Billing Operations");
			System.out.println("6. Department Operations");
			System.out.println("7. Exit");

			System.out.print("\nEnter Choice : ");
			choice = sc.nextInt();

			switch (choice) {

			case 1:
				patientMenu(patientDAO, sc);
				break;

			case 2:
				doctorMenu(doctorDAO, sc);
				break;

			case 3:
				appointmentMenu(appointmentDAO, sc);
				break;

			case 4:
				visitMenu(visitDAO, sc);
				break;

			case 5:
				billingMenu(billingDAO, sc);
				break;

			case 6:
				departmentMenu(departmentDAO, sc);
				break;

			case 7:
				break;

			default:
				System.out.println("Invalid Choice!");
			}

		} while (choice != 7);

		sc.close();
	}

//	 ========================= PATIENT MENU =========================

	private static void patientMenu(PatientDAO dao, Scanner sc) {

		int choice;

		do {

			System.out.println("\n------ PATIENT MENU ------");
			System.out.println("1. Add Patient");
			System.out.println("2. View Patients");
			System.out.println("3. Update Patient");
			System.out.println("4. Delete Patient");
			System.out.println("5. Search Patient");
			System.out.println("6. Back");

			System.out.print("Enter Choice : ");
			choice = sc.nextInt();

			switch (choice) {

			case 1:
				dao.addPatient();
				break;
			case 2:
				dao.viewPatients();
				break;
			case 3:
				dao.updatePatient();
				break;
			case 4:
				dao.deletePatient();
				break;
			case 5:
				dao.searchPatient();
				break;

			case 6:
				break;

			default:
				System.out.println("Invalid Choice!");
			}

		} while (choice != 6);
	}

//	 ========================= DOCTOR MENU =========================

	private static void doctorMenu(DoctorDAO dao, Scanner sc) {

		int choice;

		do {

			System.out.println("\n------ DOCTOR MENU ------");
			System.out.println("1. Add Doctor");
			System.out.println("2. View Doctors");
			System.out.println("3. Update Doctor");
			System.out.println("4. Delete Doctor");
			System.out.println("5. Search Doctor");
			System.out.println("6. Back");

			System.out.print("Enter Choice : ");
			choice = sc.nextInt();

			switch (choice) {

			case 1:
				dao.addDoctor();
				break;
			case 2:
				dao.viewDoctors();
				break;
			case 3:
				dao.updateDoctor();
				break;
			case 4:
				dao.deleteDoctor();
				break;
			case 5:
				dao.searchDoctor();
				break;

			case 6:
				break;

			default:
				System.out.println("Invalid Choice!");
			}

		} while (choice != 6);
	}

//	 ========================= APPOINTMENT =========================

	public static void appointmentMenu(AppointmentDAO dao, Scanner sc) {

		int choice;

		do {

			System.out.println("\n------ APPOINTMENT MENU ------");
			System.out.println("1. Book Appointment");
			System.out.println("2. View Appointments");
			System.out.println("3. Update Appointment");
			System.out.println("4. Cancel Appointment");
			System.out.println("5. Search Appointment");
			System.out.println("6. Back");

			System.out.print("Enter Choice : ");
			choice = sc.nextInt();

			switch (choice) {

			case 1:
				dao.bookAppointment();
				break;
			case 2:
				dao.viewAppointments();
				break;
			case 3:
				dao.updateAppointment();
				break;
			case 4:
				dao.cancelAppointment();
				break;
			case 5:
				dao.searchAppointment();
				break;

			case 6:
				break;

			default:
				System.out.println("Invalid Choice!");
			}

		} while (choice != 6);
	}

//	 ========================= VISIT =========================

	public static void visitMenu(VisitDAO dao, Scanner sc) {

		int choice;

		do {

			System.out.println("\n------ VISIT MENU ------");
			System.out.println("1. Add Visit");
			System.out.println("2. View Visits");
			System.out.println("3. Update Visit");
			System.out.println("4. Delete Visit");
			System.out.println("5. Search Visit");
			System.out.println("6. Back");
			System.out.print("Enter Choice: ");

			choice = sc.nextInt();

			switch (choice) {

			case 1:
				dao.addVisit();
				break;
			case 2:
				dao.viewVisits();
				break;
			case 3:
				dao.updateVisit();
				break;
			case 4:
				dao.deleteVisit();
				break;
			case 5:
				dao.searchVisit();
				break;

			case 6:
				break;

			default:
				System.out.println("Invalid Choice!");
			}

		} while (choice != 6);
	}

//	 ========================= BILLING =========================

	public static void billingMenu(BillingDAO dao, Scanner sc) {

		int choice;

		do {

			System.out.println("\n------ BILLING MENU ------");
			System.out.println("1. Add Bill");
			System.out.println("2. View Bills");
			System.out.println("3. Update Bill");
			System.out.println("4. Delete Bill");
			System.out.println("5. Search Bill");
			System.out.println("6. Back");
			System.out.print("Enter Choice: ");
			choice = sc.nextInt();

			switch (choice) {

			case 1:
				dao.addBill();
				break;
			case 2:
				dao.viewBills();
				break;
			case 3:
				dao.updateBill();
				break;
			case 4:
				dao.deleteBill();
				break;
			case 5:
				dao.searchBill();
				break;

			case 6:
				break;

			default:
				System.out.println("Invalid Choice!");
			}

		} while (choice != 6);
	}

//	 ========================= DEPARTMENT =========================

	public static void departmentMenu(DepartmentDAO dao, Scanner sc) {

		int choice;

		do {

			System.out.println("1. Add Department");
			System.out.println("2. View Departments");
			System.out.println("3. Update Department");
			System.out.println("4. Delete Department");
			System.out.println("5. Search Department");
			System.out.println("6. Back");

			System.out.println("Enter choice: ");
			choice = sc.nextInt();

			switch (choice) {

			case 1:
				dao.addDepartment();
				break;

			case 2:
				dao.viewDepartments();
				break;

			case 3:
				dao.updateDepartment();
				break;

			case 4:
				dao.deleteDepartment();
				break;

			case 5:
				dao.searchDepartment();
				break;

			case 6:
				break;

			default:
				System.out.println("Invalid Choice!");
			}

		} while (choice != 6);
	}

	/*
	 * // ========================= STORED PROCEDURES =========================
	 * 
	 * public static void procedureMenu(ProcedureDAO dao, Scanner sc) {
	 * 
	 * int choice;
	 * 
	 * do {
	 * 
	 * System.out.println("\n------ STORED PROCEDURE MENU ------");
	 * System.out.println("1. Register Patient");
	 * System.out.println("2. Total Revenue");
	 * System.out.println("3. Doctor Appointment Count");
	 * System.out.println("4. View Patients"); System.out.println("5. Back");
	 * System.out.print("Enter Choice: ");
	 * 
	 * choice = sc.nextInt();
	 * 
	 * switch (choice) {
	 * 
	 * case 1: dao.registerPatient(); break; case 2: dao.totalRevenue(); break; case
	 * 3: dao.doctorAppointmentCount(); break; case 4: dao.getAllPatients(); break;
	 * 
	 * case 5: break;
	 * 
	 * default: System.out.println("Invalid Choice!"); }
	 * 
	 * } while (choice != 5); }
	 * 
	 * // ========================= BATCH =========================
	 * 
	 * public static void batchMenu(BatchDAO dao, Scanner sc) {
	 * 
	 * int choice;
	 * 
	 * do {
	 * 
	 * System.out.println("\n------ BATCH MENU ------");
	 * System.out.println("1. Batch Insert Patients");
	 * System.out.println("2. Back"); System.out.print("Enter Choice: ");
	 * 
	 * choice = sc.nextInt();
	 * 
	 * switch (choice) {
	 * 
	 * case 1: dao.batchInsertPatients(); break;
	 * 
	 * case 2: break;
	 * 
	 * default: System.out.println("Invalid Choice!"); }
	 * 
	 * } while (choice != 2); }
	 * 
	 * // ========================= TRANSACTION =========================
	 * 
	 * public static void transactionMenu(TransactionDAO dao, Scanner sc) {
	 * 
	 * int choice;
	 * 
	 * do {
	 * 
	 * System.out.println("\n------ TRANSACTION MENU ------");
	 * System.out.println("1. Create Visit and Bill");
	 * System.out.println("2. Back"); System.out.print("Enter Choice: ");
	 * 
	 * choice = sc.nextInt();
	 * 
	 * switch (choice) {
	 * 
	 * case 1: dao.createVisitAndBill(); break;
	 * 
	 * case 2: break;
	 * 
	 * default: System.out.println("Invalid Choice!"); }
	 * 
	 * } while (choice != 2); }
	 * 
	 * // ========================= METADATA =========================
	 * 
	 * public static void metadataMenu(MetadataDAO dao, Scanner sc) {
	 * 
	 * int choice;
	 * 
	 * do {
	 * 
	 * System.out.println("\n------ METADATA MENU ------");
	 * System.out.println("1. Show Patient Metadata");
	 * System.out.println("2. Back"); System.out.print("Enter Choice: ");
	 * 
	 * choice = sc.nextInt();
	 * 
	 * switch (choice) {
	 * 
	 * case 1: dao.showPatientMetadata(); break;
	 * 
	 * case 2: break;
	 * 
	 * default: System.out.println("Invalid Choice!"); }
	 * 
	 * } while (choice != 2); }
	 */

}