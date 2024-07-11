import java.util.Scanner;

class person {
    String name;
    String gender;
    int age;

    public person(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public void show() {
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Age: " + age);
    }

}

interface patientinfo {
    void setpatient(String pid, String disease);

    void displaypatient();
}

interface docinfo {
    void setdoc(String did, String specialty);

    void displaydoc();
}

class patient extends person implements patientinfo {
    String pid;
    String disease;
    String address;

    public patient(String name, String gender, int age, String address) {
        super(name, gender, age);
        this.address = address;
    }

    public void setpatient(String pid, String disease) {
        this.pid = pid;
        this.disease = disease;
    }

    public void displaypatient() {
        super.show();
        System.out.println("Address: " + address);
        System.out.println("Patient Id: " + pid);
        System.out.println("Disease: " + disease);
    }
}

class doc extends person implements docinfo {
    String did;
    String speciality;

    public doc(String name, String gender, int age) {
        super(name, gender, age);
    }

    public void setdoc(String did, String speciality) {
        this.did = did;
        this.speciality = speciality;
    }

    public void displaydoc() {
        super.show();
        System.out.println("Doctor Id: " + did);
        System.out.println("Speciality: " + speciality);
    }
}

public class ClinicManagement {
    static final int max_count = 50; // maximum patient and doctor count
    static patient p[] = new patient[max_count];
    static doc d[] = new doc[max_count];
    static int pcount, dcount = 0; // patient and doc count
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println();
            System.out.println("CLinic Management System!!");
            System.out.println();
            System.out.println("1. Add a patient ");
            System.out.println("2. Add a doctor ");
            System.out.println("3. Show patient details ");
            System.out.println("4. Show doctor details ");
            System.out.println("5. Exit Program");
            System.out.println();
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addpatient();
                    System.out.println();
                    break;
                case 2:
                    adddoctor();
                    System.out.println();
                    break;
                case 3:
                    showpatient();
                    System.out.println();
                    break;
                case 4:
                    showdoctor();
                    System.out.println();
                    break;
                case 5:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice, choose again!!");

            }
        }

    }

    public static void addpatient() {
        if (pcount >= max_count) {
            System.out.println("No more space for patient");
            return;
        }

        System.out.println("Fill patient details now:- ");

        System.out.println("Enter name: ");
        String name = sc.next();
        System.out.println("Enter age: ");
        int age = sc.nextInt();
        System.out.println("Enter gender: ");
        String gender = sc.next();
        System.out.println("Enter address: ");
        String address = sc.next();
        System.out.println("Enter patientId: ");
        String pid = sc.next();
        System.out.println("Enter disease: ");
        String disease = sc.next();

        patient pobj = new patient(name, gender, age, address);
        pobj.setpatient(pid, disease);
        p[pcount++] = pobj;
        System.out.println("Patient added successfully!");
        System.out.println();
    }

    public static void adddoctor() {
        if (dcount >= max_count) {
            System.out.println("No more space for doctors unfortunely!");
            return;
        }

        System.out.println("Fill doctor details now:- ");

        System.out.println("Enter name: ");
        String name = sc.next();
        System.out.println("Enter age: ");
        int age = sc.nextInt();
        System.out.println("Enter gender: ");
        String gender = sc.next();
        System.out.println("Enter docId: ");
        String did = sc.next();
        System.out.println("Enter speciality: ");
        String speciality = sc.next();

        doc dobj = new doc(name, gender, age);
        dobj.setdoc(did, speciality);
        d[dcount++] = dobj;
        System.out.println("Doctor added successfully! Congratulations on your new journey!!");
        System.out.println();
    }

    public static void showpatient() {
        if (pcount == 0) {
            System.out.println("No patients found!");
            return;
        }

        System.out.println("Patient Details:- ");
        System.out.println();
        for (int i = 0; i < pcount; i++) {
            p[i].displaypatient();
            System.out.println();
        }
    }

    public static void showdoctor() {
        if (dcount == 0) {
            System.out.println("No doctors found!");
            return;
        }

        System.out.println("Doctor Details:- ");
        System.out.println();
        for (int i = 0; i < dcount; i++) {
            d[i].displaydoc();
            System.out.println();
        }
    }
}
