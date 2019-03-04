package com.graphgrid.sdk.support;

public final class Endpoints
{

    public static final String UPLOAD = "upload";
    public static final String DOWNLOAD = "download";
    public static final String DELETE = "delete";
    public static final String STATUS = "status";
    public static final String CREATE_RELATIONSHIP = "createRelationship";
    public static final String FIND_BY_RESOURCE = "findByResource";
    private static final String FORWARD_SLASH = "/";
    public static final String CREATE_ONLY = UPLOAD + FORWARD_SLASH + "createOnly";


    private Endpoints()
    {
    }
}
