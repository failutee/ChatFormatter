package com.eternalcode.formatter.legacy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LegacyTest {

    @Test
    void decolor() {
        assertEquals("&c SIEMA & test&a!", Legacy.clearSection("§c SIEMA § test§a!"));
    }

    @Test
    void shadow() {
        assertShadow("&7", "<ampersand>7");
        assertShadow("&2 siema &l siema", "<ampersand>2 siema <ampersand>l siema");
        assertShadow("&2 siema &l &5yo&&8", "<ampersand>2 siema <ampersand>l <ampersand>5yo&<ampersand>8");
        assertShadow("&&7", "&<ampersand>7");
        assertShadow("&#c", "<ampersand>#c");
        assertShadow("<ampersand>7", "&7", "<ampersand>7");
        assertShadow("<ampersand>&7", "<ampersand><ampersand>7");
        assertShadow("<ampersand><ampersand>&7", "<ampersand><ampersand><ampersand>7");
    }

    private void assertShadow(String input, String output, String expectedShadowed) {
        String shadowed = Legacy.ampersandToPlaceholder(input);
        String deshadowed = Legacy.placeholderToAmpersand(shadowed);

        assertEquals(expectedShadowed, shadowed);
        assertEquals(output, deshadowed);
    }

    private void assertShadow(String input, String expectedShadowed) {
        String shadowed = Legacy.ampersandToPlaceholder(input);
        String deshadowed = Legacy.placeholderToAmpersand(shadowed);

        assertEquals(expectedShadowed, shadowed);
        assertEquals(input, deshadowed);
    }

}
