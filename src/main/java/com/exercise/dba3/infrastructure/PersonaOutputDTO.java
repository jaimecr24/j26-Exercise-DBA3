package com.exercise.dba3.infrastructure;

import java.util.Date;

public record PersonaOutputDTO(
        String id_persona,
        String user,
        //String password,
        String name,
        String surname,
        String company_email,
        String personal_email,
        String city,
        Boolean active,
        Date created_date,
        String imagen_url,
        String termination_date
){}
