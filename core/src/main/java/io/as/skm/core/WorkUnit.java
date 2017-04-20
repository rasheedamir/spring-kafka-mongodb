package io.as.skm.core;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value /* to generate equals, hashCode, getters & toString ( immutable ) */
@NoArgsConstructor(force = true, access = AccessLevel.PACKAGE) /* just for dehydration! as default ctor is used to create object & then fields are set using refection! */
@JsonDeserialize(builder = WorkUnit.Builder.class)
public class WorkUnit
{
    private final String id;
    private final String definition;

    @lombok.Builder(builderClassName = "Builder", builderMethodName = "newBuilder", toBuilder = true)
    private WorkUnit(String id, String definition)
    {
        this.id = id;
        this.definition = definition;
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder
    {
    }
}