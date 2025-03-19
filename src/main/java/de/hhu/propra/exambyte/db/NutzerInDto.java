package de.hhu.propra.exambyte.db;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("nutzer_in")
public record NutzerInDto(@Id Integer id, Integer githubId, String username) {
}