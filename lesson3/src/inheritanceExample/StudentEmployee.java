package inheritanceExample;

public class StudentEmployee extends  Person{
        double rateOfPayPerHour;
        String employeeId;

        public StudentEmployee(String firstName, String lastName, double rateOfPayPerHour, String studentId, String employeeId ){
            super(firstName, lastName);
            this.rateOfPayPerHour = rateOfPayPerHour;
            this.employeeId = employeeId;
        }

        public String getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId() {
            this.employeeId = employeeId;
        }

        @Override
        public String toString() {
            return super.toString() + employeeId;
        }
}
