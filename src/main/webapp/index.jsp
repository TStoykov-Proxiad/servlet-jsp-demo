<html>
<body>
	<p>The application is up and running</p>
	<p>Test some available demos</p>
	<ul>
		<li><a href="/say-hello">Say hello from a servlet</a></li>
		<li><a href="/say-hello-through-jsp">Say hello from a jsp</a></li>
		<li>
			<a href="/say-hello-my-way?name=Major Tom">Say hello my way</a> -
			The code behind this link is expected to be implemented by you :-)</br>
			The rendered string has to be composed of 2 parameters:
			<ul><li>greeting that has to be set in the web.xml as init-param</li>
			<li>name that has to be passed with the URL (seer the URL)</li></ul>
			and look like this - [greeting], [name]
		</li>
		<li>
			<a href="/say-hello-my-way-through-jsp?name=Major Tom">Say hello my way</a> -
			The code behind this link is expected to be implemented by you :-)</br>
			The task is the same as the above one, but a JSP has to be used to render the greeting
		</li>
		<li>
			<a href="/count-my-requests-this-link">My requests for this link count</a> -
			The code behind this link is expected to be implemented by you :-)</br>
			Every time you click on this link you have to see as output how many times 
			you've clicked the link (Hint: HttpSession)
		</li>
		<li>
			<a href="/count-my-requests">My requests count</a> -
			The code behind this link is expected to be implemented by you :-)</br>
			Every time you click on this link you have to see as output how many times 
			you've clicked the link (Hint: HttpSession)
		</li>
		<li>
			<a href="/count-all-requess">All requests count</a> -
			The code behind this link is expected to be implemented by you :-)</br>
			Open few different browsers and click this (or other) link(s). The output of
			this link has to show the count of all requests made on all links and all
			browsers (Hint: HttpSession) 
		</li>
	</ul>
</body>
</html>
