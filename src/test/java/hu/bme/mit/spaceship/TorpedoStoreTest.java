
package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Egy torpedó sikeres kilövése
        TorpedoStore store = new TorpedoStore(1, 0.0);

        boolean result = store.fire(1);

        assertTrue(result);
        assertEquals(0, store.getTorpedoCount());
        assertTrue(store.isEmpty());
    }

    @Test
    void fire_Multiple_Success() {
        // Több torpedó sikeres kilövése
        TorpedoStore store = new TorpedoStore(5, 0.0);

        boolean result = store.fire(3);

        assertTrue(result);
        assertEquals(2, store.getTorpedoCount());
        assertFalse(store.isEmpty());
    }

    @Test
    void fire_NotEnoughTorpedoes() {
        // Nincs elegendő torpedó
        TorpedoStore store = new TorpedoStore(2, 0.0);

        assertThrows(IllegalArgumentException.class, () -> {
            store.fire(3);
        });

        assertEquals(2, store.getTorpedoCount());
    }

    @Test
    void fire_ZeroTorpedoes() {
        // Nulla torpedó kilövése
        TorpedoStore store = new TorpedoStore(5, 0.0);

        assertThrows(IllegalArgumentException.class, () -> {
            store.fire(0);
        });

        assertEquals(5, store.getTorpedoCount());
    }

    @Test
    void fire_Failure() {
        // Sikertelen kilövés
        TorpedoStore store = new TorpedoStore(5, 1.0);

        boolean result = store.fire(1);

        assertFalse(result);
        assertEquals(5, store.getTorpedoCount());
    }

    @Test
    void isEmpty_InitiallyEmpty() {
        // Kezdetben üres tároló
        TorpedoStore store = new TorpedoStore(0);

        assertTrue(store.isEmpty());
        assertEquals(0, store.getTorpedoCount());
    }

    @Test
    void isEmpty_NotEmpty() {
        // Nem üres tároló
        TorpedoStore store = new TorpedoStore(4);

        assertFalse(store.isEmpty());
        assertEquals(4, store.getTorpedoCount());
    }
}

