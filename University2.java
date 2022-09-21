import java.util.ArrayList;

class University2 {
    long UniArea= 7460; // used to do inheritance

    public University2() {

    } //default constructor

    class DepartmentArea extends University2{
        long DeptArea;
        long RemainingArea=7400;

        DepartmentArea(String uname, String[] dname, String[] sname, String[] fname) {
            super(uname, dname, sname, fname);
        } //default  constructor

        public DepartmentArea() {
            super();
        }

        public long getAreaDept(){
            return (DeptArea=(UniArea-RemainingArea));
        }
    } //end of deptArea class

    public void main(String[] args) {
        // inherit
        DepartmentArea DA= new DepartmentArea();
        System.out.println(DA.getAreaDept());
    }
    String uname;
    ArrayList<Students> studentslist = new ArrayList<Students>();
    ArrayList<Departments> deptlist = new ArrayList<Departments>();
    ArrayList<Faculty> faclist = new ArrayList<Faculty>();

    University2(String uname, String[] dname, String[] sname,String[] fname) {
        this.uname = uname;
        for (int i = 0; i < dname.length; i++)
            deptlist.add(new Departments(dname[i]));

        for (int j = 0; j < sname.length; j++)
            studentslist.add(new Students(sname[j]));

        for (int k = 0; k < fname.length; k++)
            faclist.add(new Faculty(fname[k]));
    }// constrctor

    //methods
    Departments getDepartment(String dname) {
        for (int i = 0; i < deptlist.size(); i++) {
            if (deptlist.get(i).dname.equals(dname)) {
                return deptlist.get(i);
            }
        }
        return null;
    }
    void printfaculty(){

        for (int k = 0; k < faclist.size(); k++) {
            System.out.println(faclist.get(k).fname);
        }
    }

    Students getStudent(String sname) {
        for (int j = 0; j < studentslist.size(); j++) {
            if (studentslist.get(j).sname.equals(sname)) {
                return studentslist.get(j);
            }
        }
        return null;
    }
    Faculty getFaculty(String fname) {
        for (int k = 0; k < faclist.size(); k++) {
            if (faclist.get(k).fname.equals(fname)) {
                return faclist.get(k);
            }
        }
        return null;
    }

    //aggregated  classes
    class Faculty{
        String fname;
        Departments fdept;
        Faculty(String fname) {
            this.fname=fname;
        }
        void display() {
            System.out.println("employee name is  " + fname);
            System.out.println("department name is " + fdept.dname);
        }
    }

    class Students {
        String sname;
        Departments sdept;

        Students(String sname) {
            this.sname = sname;
        }


        void display() {
            System.out.println("student name is " + sname);
            System.out.println("department name is " + sdept.dname);
        }
    }
    // composed class
    class Departments {
        String dname;
        ArrayList<Students> studentsenroll = new ArrayList<Students>();
        ArrayList<Faculty> facenroll = new ArrayList<Faculty>();

        Departments(String dname) {
            this.dname = dname;
        }

        void display() {
            System.out.println("dept is:" + dname);
            for (int i = 0; i < studentsenroll.size(); i++) {
                System.out.println("students in dept are: " + studentsenroll.get(i).sname);
            }
            for (int k = 0; k < facenroll.size(); k++) {
                System.out.println("Fac: in dept are: " + facenroll.get(k).fname);
            }
        }
    }


    public void enrollsIn(Departments d, Students s,Faculty f) {
        s.sdept=d;
        f.fdept=d;
        d.studentsenroll.add(s);
        d.facenroll.add(f);
    }
    void displaystudents(Departments d) {

        d.display();

    }
}
class Demo{
    public static void main(String[] args) {


        String[] sname={"Ali","Ahsan","mohsin","zakir"};

        String[] depts={"SW","TL","CS"};

        String[] fname = {"ahad","meer","hamza"};
        University2 muet=new University2("Muet",depts,sname,fname);
        muet.printfaculty();
        muet.getFaculty("ahad");
        muet.enrollsIn(muet.getDepartment("SW"),muet.getStudent("Ali"),muet.getFaculty("ahad"));
        muet.enrollsIn(muet.getDepartment("CS"),muet.getStudent("mohsin"),muet.getFaculty("meer"));
        muet.enrollsIn(muet.getDepartment("TL"),muet.getStudent("zakir"),muet.getFaculty("hamza"));
        muet.enrollsIn(muet.getDepartment("SW"),muet.getStudent("Ahsan"),muet.getFaculty("ahad"));
        muet.displaystudents(muet.getDepartment("SW"));
        muet.displaystudents(muet.getDepartment("CS"));
        muet.displaystudents(muet.getDepartment("TL"));


    }
}

