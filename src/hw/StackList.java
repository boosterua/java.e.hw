package hw;

public class StackList {
    public Employee first;

    public void push(long emId, String emName){
        Employee newEmp = new Employee(emId, emName);
        newEmp.next = this.first;
        this.first = newEmp;
    }
    
    public Employee pop(){
        Employee fired = this.first;
        if (fired == null)
            return null;
        this.first = fired.next;
        return fired;        
    }

    public void printReverseList(){
        Employee empl = this.first;
        while (empl!=null) {
            System.out.println(empl.getNameAndId());
            empl = empl.next;
        }
    }
}

    
class Employee {
        long emId;
        String emName;
        Employee next = null;
        
        public Employee(long emId, String emName){
            this.emId = emId;
            this.emName = emName;
        }

        public String getNameAndId(){
            return String.format("%s : %s", emName, emId);
        }
    }