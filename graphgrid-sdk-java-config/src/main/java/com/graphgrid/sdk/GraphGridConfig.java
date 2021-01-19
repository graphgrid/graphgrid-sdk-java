package com.graphgrid.sdk;

import com.graphgrid.sdk.model.UpdateConfigValueRequest;
import com.graphgrid.sdk.model.UpdateConfigValueResponse;

public interface GraphGridConfig
{
    UpdateConfigValueResponse updateConfigValue( UpdateConfigValueRequest request );
}
