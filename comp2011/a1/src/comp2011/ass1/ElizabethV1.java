package comp2011.ass1;

/**
 * @author yixin cao (October 1, 2020)
 * <p>
 * A simulation of the triage of the Queen Elizabeth Hospital.
 * Each patient has been assigned a urgent level.
 * <p>
 * In this version, the {@code enter} method uses O(1) time.
 */

class Patient {
    String name;
    String urgence;

    Patient(String name, String urgence) {
        this.name = name;
        this.urgence = urgence;
    }

    public String toString() {
        return name + ' ' + urgence;
        // implement this.
    }
}

public class ElizabethV1 {
    private Patient[] patients;

    // a new patient (with a urgent level already assigned) enters the storage.
    public void enter(Patient patient) {  // running time O(1)
        if (!patient.urgence.equals("Urgent")
                && !patient.urgence.equals("Semi-Urgent")
                && !patient.urgence.equals("Non-Urgent")) {  // input check
            System.out.println(patient.name + "'s urgent level is wrong!");
            return;
        }

        if (patients == null) {  // no patients in list
            patients = new Patient[1];
            patients[0] = patient;
            return;
        }

        // the list is only sorted by coming order

        Patient[] previousPatients = patients;  // copy the previous list
        patients = new Patient[patients.length + 1];  // enlarge the list
        System.arraycopy(previousPatients, 0, patients, 0, previousPatients.length);  // unchanged
        patients[patients.length - 1] = patient;  // add it to the end of list
    }

    // returns the one with the highest urgent level, 
    // and if there are more than one patient of the highest urgent level, then first come first serve.
    public Patient leave() {  // running time O(n)

        if (patients == null || patients.length == 0) {  // no patient to leave
            System.out.println("There are no patients to leave!");
            return null;
        }

        int index = 0;
        Patient patientToLeave = patients[0];

        for (int i = 1; i < patients.length; i++) {  // find the correct patient to leave
            if (patientToLeave.urgence.equals("Urgent")) {
                break;
            }
            if (!patientToLeave.urgence.equals(patients[i].urgence) && !patients[i].urgence.equals("Non-Urgent")) {
                patientToLeave = patients[i];
                index = i;
            }
        }

        Patient[] previousPatients = patients;  // copy the previous list
        patients = new Patient[patients.length - 1];  // narrow the list of patients
        System.arraycopy(previousPatients, 0, patients, 0, index);
        System.arraycopy(previousPatients, index + 1, patients, index, patients.length - index);

        return patientToLeave;
    }

    public static void main(String[] args) {
        ElizabethV1 e = new ElizabethV1();
        e.enter (new Patient("Peppa", "Non-Urgent"));
        e.enter(new Patient("Teddy", "Urgent"));
        e.enter(new Patient("Mickey", "Urgent"));
        e.enter(new Patient("Winnie", "Non-Urgent"));
        e.enter(new Patient("Cheung", "Semi-Urgent"));
        e.enter(new Patient("Teddy", "Urgent"));
        System.out.println(e.leave());
        System.out.println(e.leave());
        e.enter(new Patient("Mickey", "Semi-Urgent"));
        e.enter(new Patient("Winnie", "Non-Urgent"));
        e.enter(new Patient("Cheung", "Urgent"));
        e.enter(new Patient("Kay", "Semi-Urgent"));
        e.enter(new Patient("Joey", "Urgent"));
        e.enter(new Patient("Jennifer", "Urgent"));
        System.out.println(e.leave());
        System.out.println(e.leave());
        System.out.println(e.leave());
    }
}
