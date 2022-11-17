package com.machinevc.coreapi.domain;

import com.machinevc.coreapi.domain.errors.AttributeTypeParseException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Entity // make this class a persistable entity using JPA
@NoArgsConstructor
@AllArgsConstructor
@Data // for getter and setters, but also toString equals hashcode and requiredArgsConstructor
@Table(name = "vc_attributes")
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // To not pass the id, on both POST and the import.sql init script
    @Column(name="att_id")
    private Integer id;

    @NonNull
    @Column(name="att_name")
    private String name;

    @NonNull
    @Column(name="att_value_type")
    private AttributeTypes valueType;

    @NonNull
    @Column(name="att_value")
    private String value;

    //Warning: the use of this method can throw, it needs to be handled when using it!
    public void validate() throws AttributeTypeParseException {
        switch (getValueType()) {
            case TEXT -> { /* do nothing as it's the more generic type, everything is already stored as TEXT */ }
            case NUMBER -> validateNumber();
            case BOOLEAN -> validateBoolean();
            case DATE -> validateDate();
        }
    }

    private void validateNumber() throws AttributeTypeParseException {
        try {
            Double.parseDouble(value);
        }
        catch (NumberFormatException e) {
            throw new AttributeTypeParseException(
                    String.format("Should be of type NUMBER, but found '%s' instead.")
            );
        }
    }

    private void validateBoolean() throws AttributeTypeParseException {
        if (!value.equals("0") && !value.equals("1"))
            throw new AttributeTypeParseException(
                    String.format("Should be of type BOOLEAN (0 or 1), but found %s instead.", value)
            );
    }

    private void validateDate() throws AttributeTypeParseException {
        try {
            DateTimeFormatter.ofPattern("yyyy-MM-dd").parse(value);
        }
        catch (DateTimeParseException e) {
            throw new AttributeTypeParseException(
                    String.format("Should be of type DATE (yyyy-MM-dd), but found %s instead.", value)
            );
        }
    }
}
