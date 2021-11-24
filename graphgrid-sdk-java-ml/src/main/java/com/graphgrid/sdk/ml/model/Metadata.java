package com.graphgrid.sdk.ml.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonAutoDetect
@JsonInclude( JsonInclude.Include.NON_NULL )
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Metadata
{

    private String description;
    private String createdAt;
    private String updatedAt;
}
