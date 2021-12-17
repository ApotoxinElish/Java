package comp2011.ass1;

/**
 * @author yixin cao (October 6, 2020)
 * <p>
 * A simulation of the triage of the Queen Elizabeth Hospital.
 * Each patient has been assigned a urgent level.
 * <p>
 * In this version, the {@code leave} method uses O(1) time.
 */

public class ElizabethV2 {
    private Patient[] patients;

    // a new patient (with a urgent level already assigned) enters the storage.
    public void enter(Patient patient) {  // running time O(n)
        if (!patient.urgence.equals("Urgent")
                && !patient.urgence.equals("Semi-Urgent")
                && !patient.urgence.equals("Non-Urgent")) {  // input check
            System.out.println(patient.name + "'s urgent level is wrong!");
            return;
        }

        if (patients == null) {  // no patient in list
            patients = new Patient[1];
            patients[0] = patient;
            return;
        }

        // the list is sorted by urgent level and coming order
        // the first one to leave (with highest level in list) is the last element of list
        int index = 0;  // to record the position to add

        if (!patient.urgence.equals("Non-Urgent")) {  // if level is Non-Urgent, just add it to the first of list
            for (int i = 0; i < patients.length; i++) {  // find the appropriate position
                if (patient.urgence.equals(patients[i].urgence) // find the first one has same urgent level
                        || patients[i].urgence.equals("Urgent")) {  // no same level, so just add before "Urgent"
                    index = i;  // record the position
                    break;  // end loop
                }

                if (i == patients.length - 1) {  // no same urgent and no "Urgent"
                    index = patients.length;  // add it to the end of list
                }
            }
        }

        Patient[] previousPatients = patients;  // copy the previous list
        patients = new Patient[patients.length + 1];  // enlarge the list of patients
        System.arraycopy(previousPatients, 0, patients, 0, index);  // the patients before the position
        System.arraycopy(previousPatients, index, patients, index + 1, previousPatients.length - index);
        patients[index] = patient;  // add it
    }

    // returns the one with the highest urgent level, 
    // and if there are more than one patient of the highest urgent level, then first come first serve.
    public Patient leave() {  // running time O(1)
        if (patients == null || patients.length == 0) {  // no patients in list
            System.out.println("There are no patients to leave!");
            return null;
        }

        Patient[] previousPatients = patients;  // copy the previous list
        patients = new Patient[patients.length - 1];  // narrow the list of patients
        System.arraycopy(previousPatients, 0, patients, 0, patients.length);  // unchanged

        return previousPatients[patients.length];  // just get the last patient in previous list
    }

    public static void main(String[] args) {
        ElizabethV2 e = new ElizabethV2();
        e.enter (new Patient("Peppa", "Semi-Urgent"));
        e.enter(new Patient("Teddy", "Urgent"));
        e.enter(new Patient("Mickey", "Semi-Urgent"));
        e.enter(new Patient("Winnie", "Non-Urgent"));
        e.enter(new Patient("Cheung", "Semi-Urgent"));
        e.enter(new Patient("Teddy", "Urgent"));
        System.out.println(e.leave());
        System.out.println(e.leave());
        e.enter(new Patient("Mickey", "Semi-Urgent"));
        e.enter(new Patient("Winnie", "Non-Urgent"));
        e.enter(new Patient("Cheung", "Semi-Urgent"));
        e.enter(new Patient("Kay", "Semi-Urgent"));
        e.enter(new Patient("Joey", "Urgent"));
        e.enter(new Patient("Jennifer", "Urgent"));
        System.out.println(e.leave());
        System.out.println(e.leave());
        System.out.println(e.leave());
    }
}
