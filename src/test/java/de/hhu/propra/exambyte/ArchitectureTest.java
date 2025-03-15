package de.hhu.propra.exambyte;

import static com.tngtech.archunit.library.Architectures.onionArchitecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArchitectureTest {

    // Ein ArchUnit-Test definiert zunächst eine Regel in Form einer Instanz von ArchRule und wendet dann diese Regel auf die ausgewählten Klassen an.
// Mit JUnit5 müssen wir nur die Klassen-Selektion als Annotation an die Testklasse schreiben und die Regeln aufschreiben.

    private final JavaClasses klassen =
            new ClassFileImporter().importPackagesOf(ExamBytePrototype1Application.class);

    @Test
    @DisplayName("Die Exambyte Anwendung hat eine Onion Architektur")
    public void rule1() throws Exception {
        ArchRule rule = onionArchitecture()
                .domainModels("de.hhu.propra.exambyte.domain.model..")
                .domainServices("de.hhu.propra.exambyte.domain.services..")
                .applicationServices("de.hhu.propra.exambyte.application.services..")
                .adapter("web", "de.hhu.propra.exambyte.web")
                .adapter("db", "de.hhu.propra.exambyte.db");
        rule.check(klassen);
    }
}



