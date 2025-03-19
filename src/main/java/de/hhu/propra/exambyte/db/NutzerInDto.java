package de.hhu.propra.exambyte.db;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Table("nutzer_in")
public record NutzerInDto(@Id Integer id, String username) {
}