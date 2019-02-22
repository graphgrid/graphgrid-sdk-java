package com.graphgrid.sdk.core.model;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonAutoDetect
@JsonIgnoreProperties( ignoreUnknown = true )
public class GetTokenResponse extends GraphGridServiceResponse
{

    @JsonProperty( value = "access_token" )
    private String accessToken;
    @JsonProperty( value = "token_type" )
    private String tokenType;
    @JsonProperty( value = "refresh_token" )
    private String refreshToken;
    @JsonProperty( value = "expires_in" )
    private String expiresIn;
    private String scope;
    private String createdAt;
    private String email;
    private String firstName;
    private String lastName;
    private String name;

    public String getAccessToken()
    {
        return accessToken;
    }

    public void setAccessToken( String accessToken )
    {
        this.accessToken = accessToken;
    }

    public String getTokenType()
    {
        return tokenType;
    }

    public void setTokenType( String tokenType )
    {
        this.tokenType = tokenType;
    }

    public String getRefreshToken()
    {
        return refreshToken;
    }

    public void setRefreshToken( String refreshToken )
    {
        this.refreshToken = refreshToken;
    }

    public String getExpiresIn()
    {
        return expiresIn;
    }

    public void setExpiresIn( String expiresIn )
    {
        this.expiresIn = expiresIn;
    }

    public String getScope()
    {
        return scope;
    }

    public void setScope( String scope )
    {
        this.scope = scope;
    }

    public String getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt( String createdAt )
    {
        this.createdAt = createdAt;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName( String firstName )
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName( String lastName )
    {
        this.lastName = lastName;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }


    @Override
    public String toString()
    {
        return new ToStringBuilder( this ).appendSuper( super.toString() ).append( "accessToken", accessToken ).append( "tokenType", tokenType )
                .append( "refreshToken", refreshToken ).append( "expiresIn", expiresIn ).append( "scope", scope ).append( "createdAt", createdAt )
                .append( "email", email ).append( "firstName", firstName ).append( "lastName", lastName ).append( "name", name ).toString();
    }
}
