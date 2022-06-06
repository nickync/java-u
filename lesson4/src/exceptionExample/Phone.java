package exceptionExample;

public class Phone {
    String phoneType;
    String phoneNumber;

    public Phone (String phoneType, String phoneNumber) {
        if (phoneNumber == null || phoneType == null) {
            throw new IllegalArgumentException("The type and number cannot be null");
        }
        this.phoneNumber = phoneNumber;
        this.phoneType = phoneType;
    }

    public String getPhoneType(){
        return phoneType;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneType = phoneType;
    }

    @Override
    public String toString(){
        return phoneType + " " + phoneNumber;
    }
}
