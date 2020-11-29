package playground;

/**
 * @author KIYOTA, Takeshi
 */
public class Test {

    public static void main(String[] args) {
        var s1 = new String("空条");
        var s2 = new String("空条");
        var s3 = s2;
        System.out.println(s1 == s2);
        System.out.println(s2 == s3);

        var a1 = new Person("空条承太郎");
        var a2 = new Person("東方仗助");
        var a3 = new Person(args[0]);
        System.out.println(a1);
        System.out.println(a1.equals(a2));
        System.out.println(a2.equals(a3));
        System.out.println(a2 == a3);
    }

    static  class Person {

        final String name;

        Person(String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object object) {
            if (object instanceof Person) {
                Person person = (Person) object;
                if (person.getName().equals(this.name)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public String toString() {
            return  name;
        }
    }
}
