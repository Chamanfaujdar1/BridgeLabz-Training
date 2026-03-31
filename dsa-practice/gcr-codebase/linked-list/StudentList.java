public class StudentList {

    static class Node {
        int roll,age;
        String name,grade;
        Node next;

        Node(int roll,String name,int age,String grade){
            this.roll=roll;
            this.name=name;
            this.age=age;
            this.grade=grade;
            this.next=null;
        }
    }

    Node head;

    void addEnd(int r,String n,int a,String g){
        Node nn=new Node(r,n,a,g);
        if(head==null){
            head=nn;
            return;
        }
        Node t=head;
        while(t.next!=null)
            t=t.next;
        t.next=nn;
    }

    void delete(int roll){
        if(head==null) return;
        if(head.roll==roll){
            head=head.next;
            return;
        }
        Node p=head;
        while(p.next!=null && p.next.roll!=roll)
            p=p.next;
        if(p.next!=null)
            p.next=p.next.next;
    }

    void updateGrade(int roll,String g){
        Node t=head;
        while(t!=null){
            if(t.roll==roll){
                t.grade=g;
                return;
            }
            t=t.next;
        }
    }

    void search(int roll){
        Node t=head;
        while(t!=null){
            if(t.roll==roll){
                System.out.println(t.roll+" "+t.name+" "+t.grade);
                return;
            }
            t=t.next;
        }
        System.out.println("Student not found");
    }

    void display(){
        Node t=head;
        while(t!=null){
            System.out.println(t.roll+" "+t.name+" "+t.grade);
            t=t.next;
        }
    }

    public static void main(String[] args){
        StudentList s=new StudentList();
        s.addEnd(1,"Amit",20,"A");
        s.addEnd(2,"Ravi",21,"B");
        s.display();
        s.updateGrade(2,"A");
        s.search(2);
        s.delete(1);
        s.display();
    }
}