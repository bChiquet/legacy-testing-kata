package com.arolla.legacy.testing.quotebot;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class AdSpaceTest {
    @Test
    public void testName() {
        Collection<String> adSpaces = new AdSpace().getAdSpaces_(() -> asList("TechBlog", "NotATechBlog"));
        assertThat(adSpaces).containsOnly("TechBlog", "NotATechBlog");
    }

    @Test
    public void testName2() {
        Collection<String> adSpaces = new AdSpace().getAdSpaces_(() -> Collections.<String>emptyList());
        assertThat(adSpaces).isEmpty();
    }
}