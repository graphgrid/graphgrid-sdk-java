package com.graphgrid.sdk.ml.model.transformation;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonAutoDetect
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class TransformationOption
{

    private int batchSize = 1000;
    private boolean parallel = true;
    private int retries = 0;
    private boolean iterateList = true;
    private int concurrency = 50;
}
