import java.util.Collection;

public class main {
    public static void main(String[] args) {
        DossierPharmacie pharmacie = new DossierPharmacie("Pharmacie Centrale");
        pharmacie.nouveauPatient("Ahmed", new String[]{"Aspirine"});
        pharmacie.nouveauPatient("Amine", new String[]{"Aspirine"});
        pharmacie.ajoutMedicament("Alice", "Doliprane");
        pharmacie.ajoutMedicament("Bob", "med5");
        pharmacie.affichePatient("Ahmed");
        pharmacie.affichePatient("Bob");
        pharmacie.affiche();
        Collection<String> patientsAvecMedicament = pharmacie.affichePatientAvecMedicament("Aspirine");
        System.out.println("Patients ayant pris Aspirine : " + patientsAvecMedicament);

}}