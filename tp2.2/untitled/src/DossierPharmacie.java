import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class DossierPharmacie {
    private String nom;
    private HashMap<String, Patient> patients;
    public DossierPharmacie(String n) {
        nom = n;
        patients = new HashMap<>();
    }

    void nouveauPatient(String nom, String[] ord) {
        nom = nom.toLowerCase();
        if (!patients.containsKey(nom)) {
            Patient nouveau = new Patient(nom);
            for (String m : ord) {
                nouveau.ajoutMedicament(m);
            }
            patients.put(nom, nouveau);
        }
    }
    public boolean ajoutMedicament(String nom, String m) {
        nom = nom.toLowerCase();
        if (patients.containsKey(nom)) {
            patients.get(nom).ajoutMedicament(m);
            return true;
        }
        return false;
    }
    public void affichePatient(String nom) {
        nom = nom.toLowerCase();
        if (patients.containsKey(nom)) {
            patients.get(nom).affiche();
        } else {
            System.out.println("Patient " + nom + " n'existe pas.");
        }
    }
    public void affiche() {
        System.out.println("Pharmacie: " + nom);
        for (Map.Entry<String, Patient> entry : patients.entrySet()) {
            entry.getValue().affiche();
        }
    }
    public Collection<String> affichePatientAvecMedicament(String m) {
        Collection<String> result = new HashSet<>();
        for (Map.Entry<String, Patient> entry : patients.entrySet()) {
            if (entry.getValue().contientMedicament(m)) {
                result.add(entry.getValue().getNom());
            }
        }
        return result;
    }
}
