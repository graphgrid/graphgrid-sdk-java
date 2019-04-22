package com.graphgrid.sdk.ml.model.dataframe;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;
import javax.validation.constraints.NotBlank;

import com.graphgrid.sdk.ml.constant.DataStructureType;

@JsonAutoDetect
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class ColumnSchema
{
    @NotBlank
    private String name;
    @NotBlank
    private String type;
    private String struct = DataStructureType.BASIC;

    public ColumnSchema( @NotBlank String name, @NotBlank String type, String struct )
    {
        this.name = name;
        this.type = type;
        this.struct = Optional.ofNullable( struct ).orElse( DataStructureType.BASIC );
    }
}
