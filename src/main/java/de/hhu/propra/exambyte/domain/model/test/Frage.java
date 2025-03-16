package de.hhu.propra.exambyte.domain.model.test;

import java.util.HashMap;

public record Frage<Antwort extends HashMap>(FragenType type, int punkte, String titel, String aufgabenstellung, Antwort antworten) {
}

// TODO Eigene Datenstruktur für Antwort finden (ggf. als Interface implementieren?) --> Validierung!!!!!!