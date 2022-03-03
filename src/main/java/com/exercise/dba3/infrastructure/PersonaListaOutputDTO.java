package com.exercise.dba3.infrastructure;

import java.util.List;

public record PersonaListaOutputDTO(
        long total_items,
        List<PersonaOutputDTO> items
) {
}
