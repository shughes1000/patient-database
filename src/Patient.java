enum InsuranceType{
    PRIVATE,
    GOVERNMENT}
enum PatientType{
    PEDIATRIC,
    ADULT,
    GERIATRIC}
enum AllergyType {
    FOOD,
    MEDICATION,
    SEASONAL,
    NONE,
    OTHER
}
enum IllType {
    DIABETES,
    CHD,
    ASTHMA,
    NONE,
    OTHER
}


class MedicalConditions {
    String Physician;
    String PhysicianPhone;
    AllergyType Allergies;
    IllType Illnesses;

    public MedicalConditions() {
    }

    public String getPhysician() {
        return Physician;
    }

    public String getPhysicianPhone() {
        return PhysicianPhone;
    }

    public AllergyType getAllergies() {
        return Allergies;
    }

    public IllType getIllnesses() {
        return Illnesses;
    }

    public void updatePhysician(String newPhysician) {
        Physician = newPhysician;
    }

    public void updatePhysicianPhone(String newPhysicianPhone) {
        PhysicianPhone = newPhysicianPhone;
    }

    public void updateAllergies(String newAllergies) {
        if (newAllergies.equals("FOOD")) {
            Allergies = AllergyType.FOOD;
        } else if (newAllergies.equals("MEDICATION")) {
            Allergies = AllergyType.MEDICATION;
        } else if (newAllergies.equals("SEASONAL")) {
            Allergies = AllergyType.SEASONAL;
        } else if (newAllergies.equals("NONE")) {
            Allergies = AllergyType.NONE;
        } else if (newAllergies.equals("OTHER")) {
            Allergies = AllergyType.OTHER;
        }
    }


    public void updateIllnesses(String newIllnesses) {
        if (newIllnesses.equals("DIABETES")) {
            Illnesses = IllType.DIABETES;
        } else if (newIllnesses.equals("CHD")) {
            Illnesses = IllType.CHD;
        } if (newIllnesses.equals("ASTHMA")) {
            Illnesses = IllType.ASTHMA;
        } if (newIllnesses.equals("NONE")) {
            Illnesses = IllType.NONE;
        } if (newIllnesses.equals("OTHER")) {
            Illnesses = IllType.OTHER;
        }
    }
}

class Patient {
    String First;
    String Last;
    String Address;
    String Phone;
    String Birthday;
    InsuranceType Insurance; // enumerated type
    Float Copay;
    PatientType Type; // enumerated

    MedicalConditions MC = new MedicalConditions();

    public Patient(String initialFirst, String initialLast, String initialAddress, String initialPhone, String initialBirthday, String initialInsurance, Float initialCopay, String initialType, String initialPhysician, String initialPhysicianPhone, String initialAllergies, String initialIllnesses) {
        First = initialFirst;
        Last = initialLast;
        Address = initialAddress;
        Phone = initialPhone;
        Birthday = initialBirthday;
        if (initialInsurance.equals("PRIVATE")) {
            Insurance = InsuranceType.PRIVATE;
        } else if (initialInsurance.equals("GOVERNMENT")) {
            Insurance = InsuranceType.GOVERNMENT;
        }
        Copay = initialCopay;
        if (initialType.equals("PEDIATRIC")) {
            Type = PatientType.PEDIATRIC;
        } else if (initialType.equals("ADULT")) {
            Type = PatientType.ADULT;
        } else if (initialType.equals("GERIATRIC")) {
            Type = PatientType.GERIATRIC;
        }

        // also add info for medical conditions
        MC.updatePhysician(initialPhysician);
        MC.updatePhysicianPhone(initialPhysicianPhone);
        MC.updateAllergies(initialAllergies);
        MC.updateIllnesses(initialIllnesses);
    }

    public String getFirst(){
        return First;}

    public String getLast(){
        return Last;}

    public String getAddress(){
        return Address;}

    public String getPhone(){
        return Phone;}

    public String getBirthday(){
        return Birthday;}

    public InsuranceType getInsurance(){
        return Insurance;}

    public Float getCopay(){
        return Copay;}

    public PatientType getType(){
        return Type;}

    public void updateFirst(String newFirst){
        First = newFirst;}

    public void updateLast(String newLast){
        Last = newLast;}

    public void updateAddress(String newAddress){
        Address = newAddress;}

    public void updatePhone(String newPhone){
        Phone = newPhone;}

    public void updateBirthday(String newBirthday){
        Birthday = newBirthday;}

    public void updateInsurance(String newInsurance) {
        if (newInsurance.equals("PRIVATE")) {
            Insurance = InsuranceType.PRIVATE;
        } else if (newInsurance.equals("GOVERNMENT")) {
            Insurance = InsuranceType.GOVERNMENT;
        }
    }

    public void updateCopay(Float newCopay){
        Copay = newCopay;}

    public void updateType(String newType) {
        if (newType.equals("PEDIATRIC")) {
            Type = PatientType.PEDIATRIC;
        } else if (newType.equals("ADULT")) {
            Type = PatientType.ADULT;
        } else if (newType.equals("GERIATRIC")) {
            Type = PatientType.GERIATRIC;
        }
    }


        public void printPatient(){
        System.out.println("Name: " + First + " " + Last);
        System.out.println("Address: " + Address);
        System.out.println("Phone Number: " + Phone);
        System.out.println("Date of Birth: " + Birthday);
        System.out.println("Insurance: " + Insurance);
        System.out.println("Copay: " + Copay);
        System.out.println("Patient Type: " + Type);
        System.out.println("Physician: " + MC.getPhysician());
        System.out.println("Physician Phone Number: " + MC.getPhysicianPhone());
        System.out.println("Allergies: " + MC.getAllergies());
        System.out.println("Illnesses: " + MC.getIllnesses());

    }

}
