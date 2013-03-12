# HTML5CorsFilter example #

This project is a simple example to enable our WebApp to be called by Ajax in Cross-Domain context.

We use the HTML5 Cors definition to enable that.

Here an example of call:
<pre>
&lt;!DOCTYPE html&gt;
&lt;html lang=&quot;en&quot;&gt;
	&lt;head&gt;
		&lt;title&gt;Web services App&lt;/title&gt;
		&lt;meta name=&quot;viewport&quot; content=&quot;width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no&quot;&gt;
		&lt;meta charset=&quot;utf-8&quot;&gt;
		
		&lt;script type=&quot;text/javascript&quot; charset=&quot;utf-8&quot; src=&quot;./resources/jquery-1.8.2.min.js&quot;&gt;&lt;/script&gt;
		&lt;script type=&quot;text/javascript&quot; charset=&quot;utf-8&quot;&gt;
			window.jQuery &amp;&amp; (function($){
				$(document).ready(function(){
					$(&quot;#call-rest-service&quot;).on(&quot;click&quot;, function(event){
						event.preventDefault();
						
						$.ajax(
							&quot;http://localhost:8082/sample-backend/rest/service&quot;, // Not the same domain ! We are on http://localhost:8080 !
							{
								&quot;async&quot;: true,
								&quot;contentType&quot;: &quot;application/json&quot;,
								&quot;dataType&quot;: &quot;json&quot;,
								&quot;error&quot;: function(jqXHR, textStatus, errorThrown){
									alert(&quot;an error occured&quot;);
								},
								&quot;processData&quot;: false,
								&quot;success&quot;: function(data, textStatus, jqXHR) {
									alert(data);
								},
								&quot;timeout&quot;: 60 * 1000,
								&quot;type&quot;: &quot;GET&quot;
							}
						);
					});
				});				
			})(jQuery);
		&lt;/script&gt;
	&lt;/head&gt;
	
	&lt;body&gt;
		&lt;h1&gt;The REST Web services are deployed !&lt;/h1&gt;
		
		&lt;hr /&gt;
		&lt;br /&gt;
		&lt;h3&gt;Button for test&lt;/h3&gt;
		&lt;button id=&quot;call-rest-service&quot;&gt;Call rest service&lt;/button&gt;
	&lt;/body&gt;
&lt;/html&gt;
</pre>

Et directement, le code d'exemple:
<pre>
package com.objetdirect.html5corsfilter.example.filters;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

public class HTML5CorsFilter extends GenericFilterBean {
    private static final Logger logger = Logger.getLogger( HTML5CorsFilter.class.getName() );
 
    /**
     * {@inheritDoc}
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
 
        logger.log( Level.INFO, &quot;HTML5CorsFilter add HTML5 CORS Headers&quot; );
 
        HttpServletResponse res = (HttpServletResponse) response;
        res.addHeader(&quot;Access-Control-Allow-Origin&quot;, &quot;*&quot;);
        res.addHeader(&quot;Access-Control-Allow-Methods&quot;, &quot;GET, POST, DELETE, PUT&quot;);
        res.addHeader(&quot;Access-Control-Allow-Headers&quot;, &quot;Content-Type&quot;);
        chain.doFilter(request, response);
    }
}
</pre>

### The MIT License

Copyright (c) <2013> <Objet Direct>

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in
 all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 THE SOFTWARE.
