package com.graphgrid.sdk;

import com.graphgrid.sdk.core.model.GraphGridServiceRequest;
import com.graphgrid.sdk.core.security.NoTokenRequest;
import com.graphgrid.sdk.core.utils.RequestUrlBuilderFactory;
import com.graphgrid.sdk.core.utils.UrlBuilder;
import com.graphgrid.sdk.model.FindFileRequest;
import org.junit.Test;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UrlRequestBuilderTest
{

    @Test
    public void buildUrl1()
    {
        final URL url = new UrlBuilder( "http://localhost/gg.file.com" ).addPathVariable( "grn:file:123" ).buildUrl();
        assertEquals( url.toString(), "http://localhost/gg.file.com/grn:file:123" );
    }

    @Test
    public void buildUrl2()
    {
        final URL url = new UrlBuilder( "http://localhost/gg.file.com" ).withServiceEndpoint( "upload" ).addPathVariable( "grn:file:123" ).buildUrl();
        assertEquals( url.toString(), "http://localhost/gg.file.com/upload/grn:file:123" );
    }

    @Test
    public void buildUrl3()
    {
        final FindFileRequest request = new FindFileRequest( "grn:file:123" ).withAuthMethod( new NoTokenRequest() );
        final URL url = new UrlBuilder( "http://localhost/gg.file.com" ).withBaseUrl( "http://localhost/gg.file.com" ).addPathVariable( request.getGrn() )
                .addPathVariable( "grn:gg:org:213" ).buildUrl();
        assertEquals( url.toString(), "http://localhost/gg.file.com/grn:file:123/grn:gg:org:213" );
    }

    @Test
    public void buildUrl3b()
    {
        final FindFileRequest request = new FindFileRequest( "grn:file:123" ).withAuthMethod( new NoTokenRequest() );
        ;
        final URL url = new UrlBuilder( "http://localhost/gg.file.com" ).withBaseUrl( "http://localhost/gg.file.com" ).addPathVariable( request.getGrn() )
                .addPathVariable( "grn:gg:org:213" ).addQueryParam( "k1", "", false ).buildUrl();
        assertEquals( url.toString(), "http://localhost/gg.file.com/grn:file:123/grn:gg:org:213" );
    }


    @Test
    public void buildUrl4()
    {
        final FindFileRequest request = new FindFileRequest( "" ).withAuthMethod( new NoTokenRequest() );
        ;
        final URL url = new UrlBuilder( "http://localhost/gg.file.com" ).withBaseUrl( "http://localhost/gg.file.com" ).addQueryParam( "k1", "v1" ).buildUrl();
        assertEquals( url.toString(), "http://localhost/gg.file.com?k1=v1" );
    }

    @Test
    public void buildUrl5()
    {
        final URL url = new UrlBuilder( "http://localhost/gg.file.com" ).withBaseUrl( "http://localhost/gg.file.com" ).addQueryParam( "k1", "v1" )
                .addQueryParam( "k2", "v2" ).buildUrl();
        assertEquals( url.toString(), "http://localhost/gg.file.com?k1=v1&k2=v2" );
    }

    @Test
    public void buildUrl6()
    {
        final URL url = new UrlBuilder( "http://localhost/gg.file.com" ).withBaseUrl( "http://localhost/gg.file.com" ).addQueryParam( "k1", "v1" )
                .addQueryParam( "k2", Collections.singletonList( "v21" ) ).buildUrl();
        assertEquals( url.toString(), "http://localhost/gg.file.com?k1=v1&k2=v21" );
    }

    @Test
    public void buildUrl7()
    {
        final URL url =
                new UrlBuilder( "http://localhost/gg.file.com" ).addQueryParam( "k1", "v1" ).addQueryParam( "k2", Arrays.asList( "v21", "v22" ) ).buildUrl();
        assertEquals( url.toString(), "http://localhost/gg.file.com?k1=v1&k2=v21,v22" );
    }

    @Test
    public void buildWithFactory()
    {
        final RequestUrlBuilderFactory urlBuilder = new RequestUrlBuilderFactory( "http://localhost/gg.file.com" );
        final URL url = urlBuilder.create().withServiceEndpoint( "billing" ).buildUrl();
        assertEquals( url.toString(), "http://localhost/gg.file.com/billing" );

    }

    @Test
    public void buildWithFactory2()
    {
        final RequestUrlBuilderFactory urlBuilder = new RequestUrlBuilderFactory( "http://localhost/gg.file.com" );
        final URL url = urlBuilder.create().withServiceEndpoint( "billing" ).buildUrl();
        assertEquals( url.toString(), "http://localhost/gg.file.com/billing" );
    }

    @Test
    public void buildWithFactory3() throws Exception
    {
        final FindFileRequest request = new FindFileRequest( "" ).withAuthMethod( new NoTokenRequest() );
        ;
        final RequestUrlBuilderFactory urlBuilder = new RequestUrlBuilderFactory( "http://localhost/gg.file.com" );
        final GraphGridServiceRequest requestWithUrl = urlBuilder.create( request ).withServiceEndpoint( "billing" ).buildRequestWithUrl();
        assertEquals( requestWithUrl.getEndpoint().toString(), "http://localhost/gg.file.com/billing" );
    }


    @Test
    public void buildWithFactory4() throws Exception
    {
        final FindFileRequest request = new FindFileRequest( "" ).withAuthMethod( new NoTokenRequest() );
        ;
        final RequestUrlBuilderFactory urlBuilder = new RequestUrlBuilderFactory( "http://localhost/gg.file.com" );
        final GraphGridServiceRequest requestWithUrl =
                urlBuilder.create( request ).withServiceEndpoint( "billing" ).addPathVariable( "delete" ).buildRequestWithUrl();
        assertEquals( requestWithUrl.getEndpoint().toString(), "http://localhost/gg.file.com/billing/delete" );
    }

    @Test( expected = com.graphgrid.sdk.core.exception.GraphGridSdkInvalidArgumentException.class )
    public void buildWithFactory5()
    {
        final RequestUrlBuilderFactory urlBuilder = new RequestUrlBuilderFactory( null );
        final URL url = urlBuilder.create().withServiceEndpoint( "billing" ).buildUrl();
    }

    @Test( expected = com.graphgrid.sdk.core.exception.GraphGridSdkInvalidArgumentException.class )
    public void buildWithFactory6()
    {
        final RequestUrlBuilderFactory urlBuilder = new RequestUrlBuilderFactory( "http://localhost:8080" );
        final URL url = urlBuilder.create().withServiceEndpoint( "go" ).addPathVariable( null ).buildUrl();
        assertEquals( url.toString(), "http://localhost:8080/go" );
    }

    @Test
    public void buildWithFactory6b()
    {
        final RequestUrlBuilderFactory urlBuilder = new RequestUrlBuilderFactory( "http://localhost:8080" );
        final URL url = urlBuilder.create().withServiceEndpoint( "go" ).addPathVariable( null, false ).buildUrl();
        assertEquals( url.toString(), "http://localhost:8080/go" );
    }

    @Test( expected = com.graphgrid.sdk.core.exception.GraphGridSdkInvalidArgumentException.class )
    public void buildWithFactory7()
    {
        List<String> p = new ArrayList<>();
        p.add( null );
        final RequestUrlBuilderFactory urlBuilder = new RequestUrlBuilderFactory( "http://localhost:8080" );
        final URL url = urlBuilder.create().withServiceEndpoint( "go" ).withPathVariables( p ).buildUrl();
        assertEquals( url.toString(), "http://localhost:8080/go/null" );
    }

    @Test
    public void buildWithFactory7b()
    {
        List<String> p = new ArrayList<>();
        p.add( null );
        final RequestUrlBuilderFactory urlBuilder = new RequestUrlBuilderFactory( "http://localhost:8080" );
        final URL url = urlBuilder.create().withServiceEndpoint( "go" ).withPathVariables( p, false ).buildUrl();
        assertEquals( url.toString(), "http://localhost:8080/go/null" );
    }

    @Test( expected = com.graphgrid.sdk.core.exception.GraphGridSdkInvalidArgumentException.class )
    public void buildWithFactory8()
    {
        List<String> p = new ArrayList<>();
        p.add( "" );
        p.add( null );

        final RequestUrlBuilderFactory urlBuilder = new RequestUrlBuilderFactory( "http://localhost:8080" );
        final URL url = urlBuilder.create().withServiceEndpoint( "go" ).withPathVariables( p ).buildUrl();
        assertEquals( url.toString(), "http://localhost:8080/go" );
    }

    @Test
    public void buildWithFactory8b()
    {
        final RequestUrlBuilderFactory urlBuilder = new RequestUrlBuilderFactory( "http://localhost:8080" );
        final URL url = urlBuilder.create().withServiceEndpoint( "go" ).addQueryParam( "k1", "", false ).buildUrl();
        assertEquals( url.toString(), "http://localhost:8080/go" );
    }

    @Test
    public void buildWithFactory8c()
    {
        final RequestUrlBuilderFactory urlBuilder = new RequestUrlBuilderFactory( "http://localhost:8080" );
        final URL url = urlBuilder.create().withServiceEndpoint( "go" ).addQueryParam( "k1", "", true ).buildUrl();
        assertEquals( url.toString(), "http://localhost:8080/go?k1=" );
    }

    @Test
    public void buildWithFactory8d()
    {
        final RequestUrlBuilderFactory urlBuilder = new RequestUrlBuilderFactory( "http://localhost:8080" );
        final URL url = urlBuilder.create().withServiceEndpoint( "go" ).addQueryParam( "k1", "v1", false ).buildUrl();
        assertEquals( url.toString(), "http://localhost:8080/go?k1=v1" );
    }
}
