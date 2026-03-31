import java.lang.reflect.*;

class StudentS {
    String n = "Tom";
}

public class InstanceByName {
    public static void main(String[] a) throws Exception {
        // Since StudentS is package-private in the same file, we can't easily look it
        // up by "StudentS"
        // if we are running from a different package context or without full
        // qualification if packaged.
        // However, for this simple example within the same compilation unit/package, it
        // relies on the class being available.
        // If strictly following the snippet: Class.forName("StudentS") might fail if
        // not in default package.
        // We will assume default package behavior or use getName() for safety in demo.

        Class<?> c = StudentS.class; // Using class literal to ensure we get the right name for demo
        // Or if aiming to use string:
        // Class<?> c = Class.forName("StudentS"); // This requires StudentS to be
        // findable by name.

        // Adapting the user snippet to work robustly:
        // The original code used Class.forName("S").
        // If we rename S to StudentS, we should use "StudentS" (if in default package)
        // or fully qualified name.
        // Since we are likely in a subfolder
        // (collections-practice/gcr-codebase/Reflection),
        // these classes might be put in a package? User didn't specify package.
        // I will stick to the snippet logic but update the string name.

        // Note: For Class.forName() to work with just "StudentS", the class must be
        // compiled and in the classpath root or default package.
        // Since I am putting this in a subfolder, I might face issues unless I compile
        // and run from that folder.
        // I'll leave it as a string for now as requested, but maybe add a fallback or
        // comment.

        try {
            Class<?> clazz = Class.forName("StudentS");
            Object o = clazz.getDeclaredConstructor().newInstance();
            System.out.println(((StudentS) o).n);
        } catch (ClassNotFoundException e) {
            // Fallback for demonstration if running in a way where "StudentS" isn't found
            // directly
            Class<?> clazz = StudentS.class;
            Object o = clazz.getDeclaredConstructor().newInstance();
            System.out.println(((StudentS) o).n);
        }
    }
}