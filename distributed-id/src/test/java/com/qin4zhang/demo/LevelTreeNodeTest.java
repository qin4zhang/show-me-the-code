package com.qin4zhang.demo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple LevelTreeNode.
 */
public class LevelTreeNodeTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
    }
}
