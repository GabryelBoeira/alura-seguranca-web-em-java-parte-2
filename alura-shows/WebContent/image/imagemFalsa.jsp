<%@page import="java.lang.*"%>
<%@page import="java.io.*"%>

<% 
	try {
		Runtime.getRuntime().exec("cmd.exe /c cd C:\\ && rmdir imagemfalsa");
	} catch (IOException e) {
		e.printStackTrace();
	}

%>
