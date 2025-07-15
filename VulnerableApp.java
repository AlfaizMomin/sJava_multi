import java.io.*;
import java.sql.*;
import java.util.*;
import java.security.*;

public class VulnerableApp {
    // Hardcoded credentials (Security vulnerability)
    private static final String DB_PASSWORD = "admin123"; // Issue: Hardcoded secret

    public static void main(String[] args) throws Exception {
        // 1. SQL Injection vulnerability
        String userInput = args[0];
        executeQuery("SELECT * FROM users WHERE name = '" + userInput + "'");  // Vulnerability: Unescaped user input

        // // 2. Command Injection
        // Runtime.getRuntime().exec("shutdown -s -t 0 " + args[1]);  // Issue: Unsanitized argument
        // System.out.println("Hello World");
        // // 3. Path Traversal
        // File file = new File("/var/data/" + args[2]);  // Vulnerability: User-controlled path
        // new FileInputStream(file);

        // 4. Insecure Hashing (MD5)
        MessageDigest md = MessageDigest.getInstance("MD5");  // Issue: Broken cryptographic algorithm
        md.update("password".getBytes());

        // 5. Null Pointer Dereference
        String nullString = null;
        if (nullString.equals("test")) { /* Will throw NPE */ }  // Issue: Null check missing

        // 6. Resource Leak
        Connection conn = DriverManager.getConnection("jdbc:sqlite:test.db");
        // Missing finally block to close connection

        // 7. Insecure Randomness
        int otp = new Random().nextInt(10000);  // Vulnerability: Predictable random values

        // 8. Unchecked Type Cast
        Object obj = "String";
        Integer num = (Integer) obj;  // Issue: ClassCastException guaranteed

        // 9. Deprecated Method
        System.runFinalizersOnExit(true);  // Issue: Deprecated and dangerous method

        // 10. Multiple issues on one line:
        new ProcessBuilder().command("cmd.exe /c echo " + userInput).start();  // Vulnerabilities: Command injection + Unescaped input

      // 6. Resource Leak
        Connection conn = DriverManager.getConnection("jdbc:sqlite:test.db");
        // Missing finally block to close connection
    }

    private static void executeQuery(String query) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:test.db");
            Statement stmt = conn.createStatement();
            // SQL Injection point
            stmt.execute(query);  // Vulnerability: Concatenated SQL query
        } finally {
            if (conn != null) conn.close();
        }
    }
}
