package com.example.demo.syntax;

import org.junit.jupiter.api.Test;

public class RegexTest {
    @Test
    public void test00() {
//        String r = "(a|b)*a(a|b)(a|b)(a|b)(a|b)";
//        String s = "bbbbbbbba";   // NO
//        String s = "bbbabbbb";    // YES
        // =============================
        String r = "([a-z])*spb([a-z])*";
//        String s = "raspberry";   // YES
//        String s = "crispbread";  // YES
//        String s = "subspace";    // NO
        String s = "subspecies";    // NO
        // ========================
        if (s.matches(r)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
